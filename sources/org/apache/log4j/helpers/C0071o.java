package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.helpers.o */
/* loaded from: input.jar:org/apache/log4j/helpers/o.class */
public final class C0071o extends AbstractC0058b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0071o(C0073q c0073q, C0080x c0080x, int i) {
        super(c0080x, i);
    }

    @Override // org.apache.log4j.helpers.AbstractC0058b
    /* renamed from: b */
    final String mo27b(LoggingEvent loggingEvent) {
        return loggingEvent.m14c();
    }
}
