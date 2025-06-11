package com.synametrics.devnull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
/* renamed from: com.synametrics.devnull.b */
/* loaded from: input.jar:com/synametrics/devnull/b.class */
public final class C0029b {

    /* renamed from: a */
    private static C0029b f72a = null;

    /* renamed from: b */
    private Hashtable f73b = new Hashtable(5999);

    private C0029b() {
    }

    /* renamed from: a */
    public static C0029b m163a() {
        if (f72a == null) {
            f72a = new C0029b();
        }
        return f72a;
    }

    /* renamed from: a */
    public final void m162a(String str) {
        Integer num = (Integer) this.f73b.get(str);
        if (num == null) {
            this.f73b.put(str, new Integer(1));
            return;
        }
        this.f73b.put(str, new Integer(num.intValue() + 1));
    }

    /* renamed from: b */
    public final List m161b() {
        ArrayList arrayList = new ArrayList(2000);
        Enumeration keys = this.f73b.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            arrayList.add(new C0027a(str, ((Integer) this.f73b.get(str)).intValue()));
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
