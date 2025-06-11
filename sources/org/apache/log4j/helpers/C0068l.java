package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.NoSuchElementException;
/* renamed from: org.apache.log4j.helpers.l */
/* loaded from: input.jar:org/apache/log4j/helpers/l.class */
public final class C0068l implements Enumeration {

    /* renamed from: a */
    private static final C0068l f222a = new C0068l();

    private C0068l() {
    }

    /* renamed from: a */
    public static C0068l m65a() {
        return f222a;
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return false;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        throw new NoSuchElementException();
    }
}
