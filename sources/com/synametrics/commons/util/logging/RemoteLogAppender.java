package com.synametrics.commons.util.logging;

import com.synametrics.commons.util.C0015d;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/RemoteLogAppender.class */
public class RemoteLogAppender extends AppenderSkeleton {

    /* renamed from: a */
    private RemoteViewer f33a;

    public RemoteLogAppender(RemoteViewer remoteViewer) {
        this.f33a = remoteViewer;
    }

    @Override // org.apache.log4j.AppenderSkeleton
    protected void append(LoggingEvent loggingEvent) {
        try {
            this.f33a.receiveLogMessage(String.valueOf(loggingEvent.m16b().toString()) + ": " + C0015d.m201a(LoggingEvent.m9h()) + " - " + loggingEvent.m13d().toString(), loggingEvent.m14c(), loggingEvent.m16b().toInt());
        } catch (Exception unused) {
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    @Override // org.apache.log4j.Appender
    public void close() {
    }
}
