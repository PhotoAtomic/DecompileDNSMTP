package com.synametrics.commons.util.logging;

import java.util.Hashtable;
/* loaded from: input.jar:com/synametrics/commons/util/logging/Sequence.class */
public class Sequence {

    /* renamed from: a */
    private static Hashtable f34a = new Hashtable();

    public static long getNextVal(String str) {
        C0018a c0018a = (C0018a) f34a.get(str);
        C0018a c0018a2 = c0018a;
        if (c0018a == null) {
            c0018a2 = new C0018a();
            f34a.put(str, c0018a2);
        }
        C0018a c0018a3 = c0018a2;
        long j = c0018a3.f39a + 1;
        c0018a3.f39a = j;
        return j;
    }

    public static long getCurVal(String str) {
        C0018a c0018a = (C0018a) f34a.get(str);
        C0018a c0018a2 = c0018a;
        if (c0018a == null) {
            c0018a2 = new C0018a();
            f34a.put(str, c0018a2);
        }
        return c0018a2.f39a;
    }
}
