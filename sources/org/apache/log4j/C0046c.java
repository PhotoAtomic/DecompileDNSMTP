package org.apache.log4j;
/* renamed from: org.apache.log4j.c */
/* loaded from: input.jar:org/apache/log4j/c.class */
class C0046c {

    /* renamed from: a */
    private String f149a;

    /* renamed from: b */
    private int f150b;

    /* renamed from: c */
    private static Class f151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0046c(String str) {
        this.f149a = str.intern();
        this.f150b = str.hashCode();
    }

    public final int hashCode() {
        return this.f150b;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (f151c == null) {
                cls = m110a("org.apache.log4j.c");
                f151c = cls;
            } else {
                cls = f151c;
            }
            return cls == obj.getClass() && this.f149a == ((C0046c) obj).f149a;
        }
        return false;
    }

    /* renamed from: a */
    private static Class m110a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
