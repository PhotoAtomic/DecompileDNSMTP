package org.apache.log4j;
/* renamed from: org.apache.log4j.d */
/* loaded from: input.jar:org/apache/log4j/d.class */
final class C0055d {

    /* renamed from: a */
    String f195a;

    /* renamed from: b */
    String f196b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0055d(String str, C0055d c0055d) {
        this.f196b = str;
        if (c0055d != null) {
            this.f195a = new StringBuffer().append(c0055d.f195a).append(' ').append(str).toString();
        } else {
            this.f195a = str;
        }
    }
}
