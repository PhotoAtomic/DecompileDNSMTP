package org.apache.log4j.helpers;

import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.InterfaceC0087e;
/* renamed from: org.apache.log4j.helpers.h */
/* loaded from: input.jar:org/apache/log4j/helpers/h.class */
public final class C0064h extends C0075s {

    /* renamed from: b */
    private long f214b;

    public C0064h(Writer writer, InterfaceC0087e interfaceC0087e) {
        super(writer, interfaceC0087e);
    }

    @Override // org.apache.log4j.helpers.C0075s, java.io.Writer
    public final void write(String str) {
        try {
            this.out.write(str);
            this.f214b += str.length();
        } catch (IOException e) {
            this.f250a.mo4a("Write failure.", e, 1);
        }
    }

    /* renamed from: a */
    public final long m72a() {
        return this.f214b;
    }

    /* renamed from: a */
    public final void m71a(long j) {
        this.f214b = j;
    }
}
