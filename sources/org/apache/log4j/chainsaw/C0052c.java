package org.apache.log4j.chainsaw;

import java.util.Comparator;
/* renamed from: org.apache.log4j.chainsaw.c */
/* loaded from: input.jar:org/apache/log4j/chainsaw/c.class */
final class C0052c implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        return (obj2 != null && ((C0051b) obj).m95a() >= ((C0051b) obj2).m95a()) ? -1 : 1;
    }
}
