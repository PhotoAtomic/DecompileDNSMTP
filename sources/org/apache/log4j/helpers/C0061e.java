package org.apache.log4j.helpers;

import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.helpers.e */
/* loaded from: input.jar:org/apache/log4j/helpers/e.class */
public final class C0061e extends AbstractC0072p {

    /* renamed from: b */
    private int f207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0061e(C0073q c0073q, C0080x c0080x, int i) {
        super(c0080x);
        this.f207b = i;
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        LocationInfo m18a = loggingEvent.m18a();
        switch (this.f207b) {
            case 1000:
                return m18a.fullInfo;
            case 1001:
                return m18a.m19d();
            case 1002:
            default:
                return null;
            case 1003:
                return m18a.m20c();
            case 1004:
                return m18a.m21b();
        }
    }
}
