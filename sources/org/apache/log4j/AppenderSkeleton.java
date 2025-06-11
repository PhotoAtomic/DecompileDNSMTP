package org.apache.log4j;

import com.synametrics.commons.util.logging.LoggingFW;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0067k;
import org.apache.log4j.spi.AbstractC0092j;
import org.apache.log4j.spi.InterfaceC0087e;
import org.apache.log4j.spi.InterfaceC0089g;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/AppenderSkeleton.class */
public abstract class AppenderSkeleton implements Appender, InterfaceC0089g {
    protected Layout layout;
    protected String name;
    protected Priority threshold;
    protected AbstractC0092j headFilter;
    protected AbstractC0092j tailFilter;
    protected InterfaceC0087e errorHandler = new C0067k();
    protected boolean closed = false;

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
    }

    @Override // org.apache.log4j.Appender
    public void addFilter(AbstractC0092j abstractC0092j) {
        if (this.headFilter == null) {
            this.tailFilter = abstractC0092j;
            this.headFilter = abstractC0092j;
            return;
        }
        this.tailFilter.f303a = abstractC0092j;
        this.tailFilter = abstractC0092j;
    }

    protected abstract void append(LoggingEvent loggingEvent);

    @Override // org.apache.log4j.Appender
    public void clearFilters() {
        this.tailFilter = null;
        this.headFilter = null;
    }

    public void finalize() {
        if (this.closed) {
            return;
        }
        C0059c.m83a(new StringBuffer().append("Finalizing appender named [").append(this.name).append("].").toString());
        close();
    }

    @Override // org.apache.log4j.Appender
    public InterfaceC0087e getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.apache.log4j.Appender
    public AbstractC0092j getFilter() {
        return this.headFilter;
    }

    public final AbstractC0092j getFirstFilter() {
        return this.headFilter;
    }

    @Override // org.apache.log4j.Appender
    public Layout getLayout() {
        return this.layout;
    }

    @Override // org.apache.log4j.Appender
    public final String getName() {
        return this.name;
    }

    public Priority getThreshold() {
        return this.threshold;
    }

    public boolean isAsSevereAsThreshold(Priority priority) {
        return this.threshold == null || priority.isGreaterOrEqual(this.threshold);
    }

    @Override // org.apache.log4j.Appender
    public synchronized void doAppend(LoggingEvent loggingEvent) {
        if (this.closed) {
            C0059c.m80b(new StringBuffer().append("Attempted to append to closed appender named [").append(this.name).append("].").toString());
        } else if (isAsSevereAsThreshold(loggingEvent.m16b())) {
            AbstractC0092j abstractC0092j = this.headFilter;
            while (abstractC0092j != null) {
                switch (abstractC0092j.m1a()) {
                    case -1:
                        return;
                    case LoggingFW.EXIT /* 0 */:
                        abstractC0092j = abstractC0092j.f303a;
                        break;
                    case LoggingFW.ENTER /* 1 */:
                        append(loggingEvent);
                }
            }
            append(loggingEvent);
        }
    }

    @Override // org.apache.log4j.Appender
    public synchronized void setErrorHandler(InterfaceC0087e interfaceC0087e) {
        if (interfaceC0087e == null) {
            C0059c.m78c("You have tried to set a null error-handler.");
        } else {
            this.errorHandler = interfaceC0087e;
        }
    }

    @Override // org.apache.log4j.Appender
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    @Override // org.apache.log4j.Appender
    public void setName(String str) {
        this.name = str;
    }

    public void setThreshold(Priority priority) {
        this.threshold = priority;
    }
}
