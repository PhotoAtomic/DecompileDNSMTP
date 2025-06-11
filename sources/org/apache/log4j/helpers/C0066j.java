package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.util.Date;
import org.apache.log4j.spi.LoggingEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.helpers.j */
/* loaded from: input.jar:org/apache/log4j/helpers/j.class */
public final class C0066j extends AbstractC0072p {

    /* renamed from: b */
    private DateFormat f219b;

    /* renamed from: c */
    private Date f220c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0066j(C0080x c0080x, DateFormat dateFormat) {
        super(c0080x);
        this.f220c = new Date();
        this.f219b = dateFormat;
    }

    @Override // org.apache.log4j.helpers.AbstractC0072p
    /* renamed from: a */
    public final String mo28a(LoggingEvent loggingEvent) {
        this.f220c.setTime(loggingEvent.timeStamp);
        String str = null;
        try {
            str = this.f219b.format(this.f220c);
        } catch (Exception e) {
            C0059c.m79b("Error occured while converting date.", e);
        }
        return str;
    }
}
