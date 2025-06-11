package com.synametrics.commons.util.net.p005a.p006a;

import com.synametrics.commons.util.C0015d;
import com.synametrics.commons.util.logging.LoggingFW;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.synametrics.commons.util.net.a.a.g */
/* loaded from: input.jar:com/synametrics/commons/util/net/a/a/g.class */
public final class C0026g {

    /* renamed from: a */
    private List f59a = new ArrayList(10);

    /* renamed from: b */
    private static C0026g f60b = null;

    /* renamed from: a */
    public final void m169a(InterfaceC0022c interfaceC0022c) {
        this.f59a.add(interfaceC0022c);
    }

    /* renamed from: a */
    public static C0026g m170a() {
        if (f60b == null) {
            f60b = new C0026g();
        }
        return f60b;
    }

    /* renamed from: a */
    public final void m168a(String str) {
        String str2 = String.valueOf(C0015d.m201a(System.currentTimeMillis())) + " - " + str;
        for (int i = 0; i < this.f59a.size(); i++) {
            try {
                ((InterfaceC0022c) this.f59a.get(i)).mo156a(str2);
            } catch (Exception e) {
                LoggingFW.log(40000, this, e.getMessage(), e);
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m167b(String str) {
        String str2 = String.valueOf(C0015d.m201a(System.currentTimeMillis())) + " - " + str;
        for (int i = 0; i < this.f59a.size(); i++) {
            try {
                ((InterfaceC0022c) this.f59a.get(i)).mo152b(str2);
            } catch (Exception e) {
                LoggingFW.log(40000, this, e.getMessage(), e);
                return;
            }
        }
    }
}
