package com.synametrics.devnull;
/* renamed from: com.synametrics.devnull.a */
/* loaded from: input.jar:com/synametrics/devnull/a.class */
public final class C0027a implements Comparable {

    /* renamed from: a */
    private String f62a;

    /* renamed from: b */
    private int f63b;

    public C0027a(String str, int i) {
        this.f62a = str;
        this.f63b = i;
    }

    /* renamed from: a */
    public final int m166a() {
        return this.f63b;
    }

    /* renamed from: b */
    public final String m165b() {
        return this.f62a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return ((C0027a) obj).f63b - this.f63b;
    }
}
