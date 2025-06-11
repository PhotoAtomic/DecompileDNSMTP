package com.synametrics.commons.p002b;

import java.io.IOException;
import java.io.OutputStream;
/* renamed from: com.synametrics.commons.b.c */
/* loaded from: input.jar:com/synametrics/commons/b/c.class */
public abstract class AbstractC0003c extends OutputStream {

    /* renamed from: a */
    private long f2a;

    /* renamed from: b */
    private boolean f3b;

    @Override // java.io.OutputStream
    public void write(int i) {
        m219a(1);
        mo220a().write(i);
        this.f2a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        m219a(bArr.length);
        mo220a().write(bArr);
        this.f2a += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        m219a(i2);
        mo220a().write(bArr, i, i2);
        this.f2a += i2;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        mo220a().flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
        } catch (IOException unused) {
        }
        mo220a().close();
    }

    /* renamed from: a */
    private void m219a(int i) {
        if (this.f3b || this.f2a + i <= 0) {
            return;
        }
        mo218b();
        this.f3b = true;
    }

    /* renamed from: a */
    protected abstract OutputStream mo220a();

    /* renamed from: b */
    protected abstract void mo218b();
}
