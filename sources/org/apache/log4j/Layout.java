package org.apache.log4j;

import org.apache.log4j.spi.InterfaceC0089g;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/Layout.class */
public abstract class Layout implements InterfaceC0089g {
    public static final String LINE_SEP;
    public static final int LINE_SEP_LEN;

    public abstract String format(LoggingEvent loggingEvent);

    public String getContentType() {
        return "text/plain";
    }

    public String getHeader() {
        return null;
    }

    public String getFooter() {
        return null;
    }

    public abstract boolean ignoresThrowable();

    static {
        String property = System.getProperty("line.separator");
        LINE_SEP = property;
        LINE_SEP_LEN = property.length();
    }
}
