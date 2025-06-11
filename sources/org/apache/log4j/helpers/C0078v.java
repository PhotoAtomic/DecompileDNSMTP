package org.apache.log4j.helpers;

import java.util.Hashtable;
/* renamed from: org.apache.log4j.helpers.v */
/* loaded from: input.jar:org/apache/log4j/helpers/v.class */
public final class C0078v extends InheritableThreadLocal {
    @Override // java.lang.InheritableThreadLocal
    public final Object childValue(Object obj) {
        Hashtable hashtable = (Hashtable) obj;
        if (hashtable != null) {
            return hashtable.clone();
        }
        return null;
    }
}
