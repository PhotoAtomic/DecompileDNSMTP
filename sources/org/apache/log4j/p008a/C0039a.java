package org.apache.log4j.p008a;

import java.io.InputStream;
import org.apache.log4j.helpers.C0059c;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
/* renamed from: org.apache.log4j.a.a */
/* loaded from: input.jar:org/apache/log4j/a/a.class */
public final class C0039a implements EntityResolver {
    @Override // org.xml.sax.EntityResolver
    public final InputSource resolveEntity(String str, String str2) {
        if (str2.endsWith("log4j.dtd")) {
            Class<?> cls = getClass();
            InputStream resourceAsStream = cls.getResourceAsStream("/org/apache/log4j/xml/log4j.dtd");
            if (resourceAsStream == null) {
                C0059c.m80b(new StringBuffer().append("Could not find [log4j.dtd]. Used [").append(cls.getClassLoader()).append("] class loader in the search.").toString());
                return null;
            }
            return new InputSource(resourceAsStream);
        }
        return null;
    }
}
