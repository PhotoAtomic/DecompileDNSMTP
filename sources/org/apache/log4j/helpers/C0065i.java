package org.apache.log4j.helpers;

import java.net.URL;
/* renamed from: org.apache.log4j.helpers.i */
/* loaded from: input.jar:org/apache/log4j/helpers/i.class */
public class C0065i {

    /* renamed from: a */
    private static boolean f215a;

    /* renamed from: b */
    private static boolean f216b;

    /* renamed from: c */
    private static Class f217c;

    /* renamed from: d */
    private static Class f218d;

    /* renamed from: a */
    public static URL m69a(String str) {
        Class cls;
        ClassLoader m68b;
        try {
            if (!f215a && (m68b = m68b()) != null) {
                C0059c.m83a(new StringBuffer().append("Trying to find [").append(str).append("] using context classloader ").append(m68b).append(".").toString());
                URL resource = m68b.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
            if (f217c == null) {
                cls = m66c("org.apache.log4j.helpers.i");
                f217c = cls;
            } else {
                cls = f217c;
            }
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                C0059c.m83a(new StringBuffer().append("Trying to find [").append(str).append("] using ").append(classLoader).append(" class loader.").toString());
                URL resource2 = classLoader.getResource(str);
                if (resource2 != null) {
                    return resource2;
                }
            }
        } catch (Throwable th) {
            C0059c.m77c("Caught Exception while in Loader.getResource. This may be innocuous.", th);
        }
        C0059c.m83a(new StringBuffer().append("Trying to find [").append(str).append("] using ClassLoader.getSystemResource().").toString());
        return ClassLoader.getSystemResource(str);
    }

    /* renamed from: a */
    public static boolean m70a() {
        return f215a;
    }

    /* renamed from: b */
    private static ClassLoader m68b() {
        Class cls;
        try {
            if (f218d == null) {
                cls = m66c("java.lang.Thread");
                f218d = cls;
            } else {
                cls = f218d;
            }
            return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Class m67b(String str) {
        if (f215a || f216b) {
            return Class.forName(str);
        }
        try {
            return m68b().loadClass(str);
        } catch (Throwable unused) {
            return Class.forName(str);
        }
    }

    /* renamed from: c */
    private static Class m66c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        int indexOf;
        f215a = true;
        f216b = false;
        String m61a = C0069m.m61a("java.version", (String) null);
        if (m61a != null && (indexOf = m61a.indexOf(46)) != -1 && m61a.charAt(indexOf + 1) != '1') {
            f215a = false;
        }
        String m61a2 = C0069m.m61a("log4j.ignoreTCL", (String) null);
        if (m61a2 != null) {
            f216b = C0069m.m58a(m61a2, true);
        }
    }
}
