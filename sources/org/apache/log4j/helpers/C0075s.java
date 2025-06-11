package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.InterfaceC0087e;
/* renamed from: org.apache.log4j.helpers.s */
/* loaded from: input.jar:org/apache/log4j/helpers/s.class */
public class C0075s extends FilterWriter {

    /* renamed from: a */
    protected InterfaceC0087e f250a;

    public C0075s(Writer writer, InterfaceC0087e interfaceC0087e) {
        super(writer);
        m36a(interfaceC0087e);
    }

    @Override // java.io.Writer
    public void write(String str) {
        try {
            this.out.write(str);
        } catch (IOException e) {
            this.f250a.mo4a(new StringBuffer().append("Failed to write [").append(str).append("].").toString(), e, 1);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.f250a.mo4a("Failed to flush writer,", e, 2);
        }
    }

    /* renamed from: a */
    public final void m36a(InterfaceC0087e interfaceC0087e) {
        if (interfaceC0087e == null) {
            throw new IllegalArgumentException("Attempted to set null ErrorHandler.");
        }
        this.f250a = interfaceC0087e;
    }
}
