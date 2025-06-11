package com.synametrics.commons.util;

import java.util.Hashtable;
/* renamed from: com.synametrics.commons.util.f */
/* loaded from: input.jar:com/synametrics/commons/util/f.class */
public final class C0017f {

    /* renamed from: a */
    private static C0017f f28a = null;

    /* renamed from: b */
    private Hashtable f29b = new Hashtable(599);

    private C0017f() {
    }

    /* renamed from: a */
    public static C0017f m191a() {
        if (f28a == null) {
            f28a = new C0017f();
        }
        return f28a;
    }

    /* renamed from: a */
    public final String m189a(String str, boolean z) {
        long j;
        if (str == null) {
            return "";
        }
        C0006a c0006a = new C0006a(this);
        c0006a.f8a = System.currentTimeMillis();
        j = c0006a.f8a;
        String str2 = String.valueOf(j) + "-" + C0015d.m202a(0, 100000);
        this.f29b.put(str2, c0006a);
        return str2;
    }

    /* renamed from: a */
    public final void m190a(String str) {
        if (str == null) {
            return;
        }
        this.f29b.remove(str);
    }
}
