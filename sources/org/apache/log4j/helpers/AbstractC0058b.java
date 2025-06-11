package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.b */
/* loaded from: input.jar:org/apache/log4j/helpers/b.class */
abstract class AbstractC0058b extends AbstractC0072p {

    /* renamed from: b */
    private int f202b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0058b(C0080x c0080x, int i) {
        super(c0080x);
        this.f202b = i;
    }

    /* renamed from: b */
    abstract String mo27b(LoggingEvent loggingEvent);

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        String mo27b = mo27b(loggingEvent);
        if (this.f202b <= 0) {
            return mo27b;
        }
        int length = mo27b.length();
        int i = length - 1;
        for (int i2 = this.f202b; i2 > 0; i2--) {
            int lastIndexOf = mo27b.lastIndexOf(46, i - 1);
            i = lastIndexOf;
            if (lastIndexOf == -1) {
                return mo27b;
            }
        }
        return mo27b.substring(i + 1, length);
    }
}
