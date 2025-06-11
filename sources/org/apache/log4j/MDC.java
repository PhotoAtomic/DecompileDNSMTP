package org.apache.log4j;

import java.util.Hashtable;
import org.apache.log4j.helpers.C0065i;
import org.apache.log4j.helpers.C0078v;
/* loaded from: input.jar:org/apache/log4j/MDC.class */
public class MDC {

    /* renamed from: a */
    private static MDC f116a = new MDC();

    /* renamed from: b */
    private boolean f117b = C0065i.m70a();

    /* renamed from: c */
    private Object f118c;

    private MDC() {
        if (this.f117b) {
            return;
        }
        this.f118c = new C0078v();
    }

    public static void put(String str, Object obj) {
        MDC mdc = f116a;
        if (mdc.f117b) {
            return;
        }
        Hashtable hashtable = (Hashtable) ((C0078v) mdc.f118c).get();
        Hashtable hashtable2 = hashtable;
        if (hashtable == null) {
            hashtable2 = new Hashtable(7);
            ((C0078v) mdc.f118c).set(hashtable2);
        }
        hashtable2.put(str, obj);
    }

    public static Object get(String str) {
        Hashtable hashtable;
        MDC mdc = f116a;
        if (mdc.f117b || (hashtable = (Hashtable) ((C0078v) mdc.f118c).get()) == null || str == null) {
            return null;
        }
        return hashtable.get(str);
    }

    public static void remove(String str) {
        Hashtable hashtable;
        MDC mdc = f116a;
        if (mdc.f117b || (hashtable = (Hashtable) ((C0078v) mdc.f118c).get()) == null) {
            return;
        }
        hashtable.remove(str);
    }

    public static Hashtable getContext() {
        MDC mdc = f116a;
        if (mdc.f117b) {
            return null;
        }
        return (Hashtable) ((C0078v) mdc.f118c).get();
    }
}
