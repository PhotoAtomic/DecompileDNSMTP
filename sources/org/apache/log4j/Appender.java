package org.apache.log4j;

import org.apache.log4j.spi.AbstractC0092j;
import org.apache.log4j.spi.InterfaceC0087e;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/Appender.class */
public interface Appender {
    void addFilter(AbstractC0092j abstractC0092j);

    AbstractC0092j getFilter();

    void clearFilters();

    void close();

    void doAppend(LoggingEvent loggingEvent);

    String getName();

    void setErrorHandler(InterfaceC0087e interfaceC0087e);

    InterfaceC0087e getErrorHandler();

    void setLayout(Layout layout);

    Layout getLayout();

    void setName(String str);

    boolean requiresLayout();
}
