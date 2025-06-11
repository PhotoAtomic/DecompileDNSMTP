package com.synametrics.commons.util.p003a;
/* renamed from: com.synametrics.commons.util.a.d */
/* loaded from: input.jar:com/synametrics/commons/util/a/d.class */
public final class C0010d extends AbstractC0009c {

    /* renamed from: a */
    private static C0010d f15a = null;

    /* renamed from: b */
    private static int f16b = 1;

    /* renamed from: c */
    private static int f17c = 5000;

    /* renamed from: d */
    private static int f18d = 1;

    private C0010d() {
        super(f16b, f17c, f18d);
    }

    /* renamed from: c */
    public static C0010d m205c() {
        if (f15a == null) {
            f15a = new C0010d();
        }
        return f15a;
    }

    @Override // com.synametrics.commons.util.p003a.AbstractC0009c
    /* renamed from: a */
    public final Object mo206a() {
        C0007a c0007a = new C0007a();
        c0007a.start();
        return c0007a;
    }
}
