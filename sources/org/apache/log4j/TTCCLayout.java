package org.apache.log4j;

import java.util.TimeZone;
import org.apache.log4j.helpers.AbstractC0060d;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/TTCCLayout.class */
public class TTCCLayout extends AbstractC0060d {

    /* renamed from: a */
    private boolean f131a = true;

    /* renamed from: b */
    private boolean f132b = true;

    /* renamed from: c */
    private boolean f133c = true;
    protected final StringBuffer buf = new StringBuffer(256);

    public TTCCLayout() {
        setDateFormat(AbstractC0060d.RELATIVE_TIME_DATE_FORMAT, (TimeZone) null);
    }

    public TTCCLayout(String str) {
        setDateFormat(str);
    }

    public void setThreadPrinting(boolean z) {
        this.f131a = z;
    }

    public boolean getThreadPrinting() {
        return this.f131a;
    }

    public void setCategoryPrefixing(boolean z) {
        this.f132b = z;
    }

    public boolean getCategoryPrefixing() {
        return this.f132b;
    }

    public void setContextPrinting(boolean z) {
        this.f133c = z;
    }

    public boolean getContextPrinting() {
        return this.f133c;
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        String m12e;
        this.buf.setLength(0);
        dateFormat(this.buf, loggingEvent);
        if (this.f131a) {
            this.buf.append('[');
            this.buf.append(loggingEvent.m8i());
            this.buf.append("] ");
        }
        this.buf.append(loggingEvent.m16b().toString());
        this.buf.append(' ');
        if (this.f132b) {
            this.buf.append(loggingEvent.m14c());
            this.buf.append(' ');
        }
        if (this.f133c && (m12e = loggingEvent.m12e()) != null) {
            this.buf.append(m12e);
            this.buf.append(' ');
        }
        this.buf.append("- ");
        this.buf.append(loggingEvent.m10g());
        this.buf.append(Layout.LINE_SEP);
        return this.buf.toString();
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }
}
