package org.apache.log4j.p008a;

import org.apache.log4j.helpers.C0059c;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
/* renamed from: org.apache.log4j.a.c */
/* loaded from: input.jar:org/apache/log4j/a/c.class */
public final class C0041c implements ErrorHandler {
    @Override // org.xml.sax.ErrorHandler
    public final void error(SAXParseException sAXParseException) {
        C0059c.m80b(new StringBuffer().append("Parsing error on line ").append(sAXParseException.getLineNumber()).append(" and column ").append(sAXParseException.getColumnNumber()).toString());
        C0059c.m79b(sAXParseException.getMessage(), sAXParseException.getException());
    }

    @Override // org.xml.sax.ErrorHandler
    public final void fatalError(SAXParseException sAXParseException) {
        error(sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public final void warning(SAXParseException sAXParseException) {
        C0059c.m78c(new StringBuffer().append("Parsing error on line ").append(sAXParseException.getLineNumber()).append(" and column ").append(sAXParseException.getColumnNumber()).toString());
        C0059c.m77c(sAXParseException.getMessage(), sAXParseException.getException());
    }
}
