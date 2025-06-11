package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/SimpleLayout.class */
public class SimpleLayout extends Layout {

    /* renamed from: a */
    private StringBuffer f130a = new StringBuffer((int) AsyncAppender.DEFAULT_BUFFER_SIZE);

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        this.f130a.setLength(0);
        this.f130a.append(loggingEvent.m16b().toString());
        this.f130a.append(" - ");
        this.f130a.append(loggingEvent.m10g());
        this.f130a.append(Layout.LINE_SEP);
        return this.f130a.toString();
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }
}
