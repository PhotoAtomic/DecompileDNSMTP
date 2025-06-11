package org.apache.log4j;

import org.apache.log4j.helpers.AbstractC0072p;
import org.apache.log4j.helpers.C0073q;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/PatternLayout.class */
public class PatternLayout extends Layout {
    public static final String DEFAULT_CONVERSION_PATTERN = "%m%n";
    public static final String TTCC_CONVERSION_PATTERN = "%r [%t] %p %c %x - %m%n";
    protected final int BUF_SIZE = 256;
    protected final int MAX_CAPACITY = 1024;

    /* renamed from: a */
    private StringBuffer f121a;

    /* renamed from: b */
    private String f122b;

    /* renamed from: c */
    private AbstractC0072p f123c;

    public PatternLayout() {
        this(DEFAULT_CONVERSION_PATTERN);
    }

    public PatternLayout(String str) {
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.f121a = new StringBuffer(256);
        this.f122b = str;
        this.f123c = createPatternParser(str == null ? DEFAULT_CONVERSION_PATTERN : str).m51a();
    }

    public void setConversionPattern(String str) {
        this.f122b = str;
        this.f123c = createPatternParser(str).m51a();
    }

    public String getConversionPattern() {
        return this.f122b;
    }

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }

    protected C0073q createPatternParser(String str) {
        return new C0073q(str);
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        if (this.f121a.capacity() > 1024) {
            this.f121a = new StringBuffer(256);
        } else {
            this.f121a.setLength(0);
        }
        AbstractC0072p abstractC0072p = this.f123c;
        while (true) {
            AbstractC0072p abstractC0072p2 = abstractC0072p;
            if (abstractC0072p2 == null) {
                return this.f121a.toString();
            }
            abstractC0072p2.mo52a(this.f121a, loggingEvent);
            abstractC0072p = abstractC0072p2.f231a;
        }
    }
}
