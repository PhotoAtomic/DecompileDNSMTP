package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.helpers.n */
/* loaded from: input.jar:org/apache/log4j/helpers/n.class */
public final class C0070n extends AbstractC0072p {

    /* renamed from: b */
    private int f230b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0070n(C0080x c0080x, int i) {
        super(c0080x);
        this.f230b = i;
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        switch (this.f230b) {
            case 2000:
                return Long.toString(loggingEvent.timeStamp - LoggingEvent.m9h());
            case 2001:
                return loggingEvent.m8i();
            case 2002:
                return loggingEvent.m16b().toString();
            case 2003:
                return loggingEvent.m12e();
            case 2004:
                return loggingEvent.m10g();
            default:
                return null;
        }
    }
}
