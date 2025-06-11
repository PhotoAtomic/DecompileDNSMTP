package org.apache.log4j.helpers;
/* renamed from: org.apache.log4j.helpers.c */
/* loaded from: input.jar:org/apache/log4j/helpers/c.class */
public final class C0059c {

    /* renamed from: a */
    private static boolean f203a;

    /* renamed from: b */
    private static boolean f204b = false;

    /* renamed from: a */
    public static void m81a(boolean z) {
        f203a = z;
    }

    /* renamed from: a */
    public static void m83a(String str) {
        if (f203a) {
            System.out.println(new StringBuffer().append("log4j: ").append(str).toString());
        }
    }

    /* renamed from: a */
    public static void m82a(String str, Throwable th) {
        if (f203a) {
            System.out.println(new StringBuffer().append("log4j: ").append(str).toString());
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }

    /* renamed from: b */
    public static void m80b(String str) {
        System.err.println(new StringBuffer().append("log4j:ERROR ").append(str).toString());
    }

    /* renamed from: b */
    public static void m79b(String str, Throwable th) {
        System.err.println(new StringBuffer().append("log4j:ERROR ").append(str).toString());
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m78c(String str) {
        System.err.println(new StringBuffer().append("log4j:WARN ").append(str).toString());
    }

    /* renamed from: c */
    public static void m77c(String str, Throwable th) {
        System.err.println(new StringBuffer().append("log4j:WARN ").append(str).toString());
        if (th != null) {
            th.printStackTrace();
        }
    }

    static {
        f203a = false;
        String m61a = C0069m.m61a("log4j.debug", (String) null);
        String str = m61a;
        if (m61a == null) {
            str = C0069m.m61a("log4j.configDebug", (String) null);
        }
        if (str != null) {
            f203a = C0069m.m58a(str, true);
        }
    }
}
