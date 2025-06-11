package org.apache.log4j.p009b;

import java.util.Hashtable;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0065i;
import org.apache.log4j.helpers.C0069m;
/* renamed from: org.apache.log4j.b.a */
/* loaded from: input.jar:org/apache/log4j/b/a.class */
public final class C0043a {

    /* renamed from: a */
    private Hashtable f146a = new Hashtable();

    /* renamed from: b */
    private static InterfaceC0045c f147b = new C0044b();

    /* renamed from: c */
    private static Class f148c;

    /* renamed from: a */
    public static void m112a(Hierarchy hierarchy, String str, String str2) {
        Class cls;
        C0059c.m83a(new StringBuffer().append("Rendering class: [").append(str2).append("], Rendered class: [").append(str).append("].").toString());
        if (f148c == null) {
            cls = m113a("org.apache.log4j.b.c");
            f148c = cls;
        } else {
            cls = f148c;
        }
        InterfaceC0045c interfaceC0045c = (InterfaceC0045c) C0069m.m62a(str2, cls, (Object) null);
        if (interfaceC0045c == null) {
            C0059c.m80b(new StringBuffer().append("Could not instantiate renderer [").append(str2).append("].").toString());
            return;
        }
        try {
            hierarchy.setRenderer(C0065i.m67b(str), interfaceC0045c);
        } catch (ClassNotFoundException e) {
            C0059c.m79b(new StringBuffer().append("Could not find class [").append(str).append("].").toString(), e);
        }
    }

    /* renamed from: a */
    public final String m114a(Object obj) {
        InterfaceC0045c interfaceC0045c;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                interfaceC0045c = f147b;
                break;
            }
            InterfaceC0045c interfaceC0045c2 = (InterfaceC0045c) this.f146a.get(cls2);
            if (interfaceC0045c2 != null) {
                interfaceC0045c = interfaceC0045c2;
                break;
            }
            InterfaceC0045c m116a = m116a((Class) cls2);
            if (m116a != null) {
                interfaceC0045c = m116a;
                break;
            }
            cls = cls2.getSuperclass();
        }
        return interfaceC0045c.mo111a(obj);
    }

    /* renamed from: a */
    private InterfaceC0045c m116a(Class cls) {
        InterfaceC0045c interfaceC0045c = (InterfaceC0045c) this.f146a.get(cls);
        if (interfaceC0045c != null) {
            return interfaceC0045c;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            InterfaceC0045c m116a = m116a((Class) cls2);
            if (m116a != null) {
                return m116a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m117a() {
        this.f146a.clear();
    }

    /* renamed from: a */
    public final void m115a(Class cls, InterfaceC0045c interfaceC0045c) {
        this.f146a.put(cls, interfaceC0045c);
    }

    /* renamed from: a */
    private static Class m113a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
