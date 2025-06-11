package com.synametrics.commons.util.p003a;
/* renamed from: com.synametrics.commons.util.a.e */
/* loaded from: input.jar:com/synametrics/commons/util/a/e.class */
public final class C0011e implements Comparable {

    /* renamed from: a */
    public boolean f19a;

    /* renamed from: b */
    public Object f20b;

    /* renamed from: c */
    public long f21c;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        if (obj instanceof C0011e) {
            return (int) (this.f21c - ((C0011e) obj).f21c);
        }
        return 0;
    }
}
