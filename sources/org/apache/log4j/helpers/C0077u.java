package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.u */
/* loaded from: input.jar:org/apache/log4j/helpers/u.class */
final class C0077u extends AbstractC0072p {

    /* renamed from: b */
    private String f252b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0077u(C0080x c0080x, String str) {
        super(c0080x);
        this.f252b = str;
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        Object m17a = loggingEvent.m17a(this.f252b);
        if (m17a == null) {
            return null;
        }
        return m17a.toString();
    }
}
