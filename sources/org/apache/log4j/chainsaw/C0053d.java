package org.apache.log4j.chainsaw;

import java.util.StringTokenizer;
import org.apache.log4j.Priority;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: org.apache.log4j.chainsaw.d */
/* loaded from: input.jar:org/apache/log4j/chainsaw/d.class */
final class C0053d extends DefaultHandler {

    /* renamed from: a */
    private int f182a;

    /* renamed from: b */
    private long f183b;

    /* renamed from: c */
    private Priority f184c;

    /* renamed from: d */
    private String f185d;

    /* renamed from: e */
    private String f186e;

    /* renamed from: f */
    private String f187f;

    /* renamed from: g */
    private String f188g;

    /* renamed from: h */
    private String[] f189h;

    /* renamed from: i */
    private String f190i;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startDocument() {
        this.f182a = 0;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        StringBuffer stringBuffer = null;
        stringBuffer.append(String.valueOf(cArr, i, i2));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        if ("log4j:event".equals(str3)) {
            MyTableModel myTableModel = null;
            myTableModel.m100a(new C0051b(this.f183b, this.f184c, this.f185d, this.f186e, this.f187f, this.f188g, this.f189h, this.f190i));
            this.f182a++;
            this.f183b = 0L;
            this.f184c = null;
            this.f185d = null;
            this.f186e = null;
            this.f187f = null;
            this.f188g = null;
            this.f189h = null;
            this.f190i = null;
        } else if ("log4j:NDC".equals(str3)) {
            StringBuffer stringBuffer = null;
            this.f186e = stringBuffer.toString();
        } else if ("log4j:message".equals(str3)) {
            StringBuffer stringBuffer2 = null;
            this.f188g = stringBuffer2.toString();
        } else if ("log4j:throwable".equals(str3)) {
            StringBuffer stringBuffer3 = null;
            StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer3.toString(), "\n\t");
            this.f189h = new String[stringTokenizer.countTokens()];
            if (this.f189h.length > 0) {
                this.f189h[0] = stringTokenizer.nextToken();
                for (int i = 1; i < this.f189h.length; i++) {
                    this.f189h[i] = new StringBuffer().append("\t").append(stringTokenizer.nextToken()).toString();
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        StringBuffer stringBuffer = null;
        stringBuffer.setLength(0);
        if (!"log4j:event".equals(str3)) {
            if ("log4j:locationInfo".equals(str3)) {
                this.f190i = new StringBuffer().append(attributes.getValue("class")).append(".").append(attributes.getValue("method")).append("(").append(attributes.getValue("file")).append(":").append(attributes.getValue("line")).append(")").toString();
                return;
            }
            return;
        }
        this.f187f = attributes.getValue("thread");
        this.f183b = Long.parseLong(attributes.getValue("timestamp"));
        this.f185d = attributes.getValue("logger");
        this.f184c = Priority.toPriority(attributes.getValue("level"));
    }
}
