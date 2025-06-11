package org.apache.log4j;

import java.io.OutputStreamWriter;
import org.apache.log4j.helpers.C0059c;
/* loaded from: input.jar:org/apache/log4j/ConsoleAppender.class */
public class ConsoleAppender extends WriterAppender {
    public static final String SYSTEM_OUT = "System.out";
    public static final String SYSTEM_ERR = "System.err";
    protected String target;

    public ConsoleAppender() {
        this.target = SYSTEM_OUT;
    }

    public ConsoleAppender(Layout layout) {
        this(layout, SYSTEM_OUT);
    }

    public ConsoleAppender(Layout layout, String str) {
        this.target = SYSTEM_OUT;
        this.layout = layout;
        if (SYSTEM_OUT.equals(str)) {
            setWriter(new OutputStreamWriter(System.out));
        } else if (SYSTEM_ERR.equalsIgnoreCase(str)) {
            setWriter(new OutputStreamWriter(System.err));
        } else {
            m139a(str);
        }
    }

    public void setTarget(String str) {
        String trim = str.trim();
        if (SYSTEM_OUT.equalsIgnoreCase(trim)) {
            this.target = SYSTEM_OUT;
        } else if (SYSTEM_ERR.equalsIgnoreCase(trim)) {
            this.target = SYSTEM_ERR;
        } else {
            m139a(str);
        }
    }

    public String getTarget() {
        return this.target;
    }

    /* renamed from: a */
    private static void m139a(String str) {
        C0059c.m78c(new StringBuffer().append("[").append(str).append("] should be System.out or System.err.").toString());
        C0059c.m78c("Using previously set target, System.out by default.");
    }

    @Override // org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
        if (this.target.equals(SYSTEM_OUT)) {
            setWriter(new OutputStreamWriter(System.out));
        } else {
            setWriter(new OutputStreamWriter(System.err));
        }
    }

    @Override // org.apache.log4j.WriterAppender
    protected final void closeWriter() {
    }
}
