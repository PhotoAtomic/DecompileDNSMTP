package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.a */
/* loaded from: input.jar:org/apache/log4j/helpers/a.class */
final class C0057a extends AbstractC0072p {

    /* renamed from: b */
    private String f201b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0057a(String str) {
        this.f201b = str;
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final void mo52a(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        stringBuffer.append(this.f201b);
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        return this.f201b;
    }
}
