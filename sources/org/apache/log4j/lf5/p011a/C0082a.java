package org.apache.log4j.lf5.p011a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* renamed from: org.apache.log4j.lf5.a.a */
/* loaded from: input.jar:org/apache/log4j/lf5/a/a.class */
public final class C0082a {

    /* renamed from: a */
    private TimeZone f270a = null;

    /* renamed from: b */
    private Locale f271b = null;

    /* renamed from: c */
    private String f272c = null;

    /* renamed from: d */
    private DateFormat f273d = null;

    public C0082a() {
        m23c();
    }

    /* renamed from: a */
    private synchronized TimeZone m25a() {
        return TimeZone.getDefault();
    }

    /* renamed from: b */
    private synchronized Locale m24b() {
        return Locale.getDefault();
    }

    /* renamed from: c */
    private synchronized void m23c() {
        this.f273d = SimpleDateFormat.getDateTimeInstance(0, 0, m24b());
        this.f273d.setTimeZone(m25a());
    }
}
