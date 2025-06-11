package com.synametrics.commons.util.logging;

import java.net.InetAddress;
import org.apache.log4j.p010c.C0048b;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/CustomSocketAppender.class */
public class CustomSocketAppender extends C0048b {
    public CustomSocketAppender() {
    }

    public CustomSocketAppender(InetAddress inetAddress, int i) {
        super(inetAddress, i);
    }

    public CustomSocketAppender(String str, int i) {
        super(str, i);
    }

    @Override // org.apache.log4j.p010c.C0048b, org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        super.append(new LoggingEvent(loggingEvent.f293a, new RemoteLogger(), loggingEvent.m16b(), loggingEvent.m13d(), null));
    }
}
