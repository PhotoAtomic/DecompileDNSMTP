package com.synametrics.commons.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/* renamed from: com.synametrics.commons.util.e */
/* loaded from: input.jar:com/synametrics/commons/util/e.class */
public final class C0016e {

    /* renamed from: a */
    private List f27a = new ArrayList(20);

    public C0016e(String str, String str2) {
        if (str == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            this.f27a.add(stringTokenizer.nextToken());
        }
    }

    /* renamed from: a */
    public final String m192a(int i) {
        if (i >= this.f27a.size()) {
            return "";
        }
        try {
            return this.f27a.get(i) == null ? "" : (String) this.f27a.get(i);
        } catch (IndexOutOfBoundsException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public final int m193a() {
        return this.f27a.size();
    }
}
