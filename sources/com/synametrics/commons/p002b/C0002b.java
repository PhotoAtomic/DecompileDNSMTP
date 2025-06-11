package com.synametrics.commons.p002b;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/* renamed from: com.synametrics.commons.b.b */
/* loaded from: input.jar:com/synametrics/commons/b/b.class */
public final class C0002b extends AbstractC0003c {

    /* renamed from: a */
    private ByteArrayOutputStream f0a;

    /* renamed from: b */
    private OutputStream f1b;

    @Override // com.synametrics.commons.p002b.AbstractC0003c
    /* renamed from: a */
    protected final OutputStream mo220a() {
        return this.f1b;
    }

    @Override // com.synametrics.commons.p002b.AbstractC0003c
    /* renamed from: b */
    protected final void mo218b() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream((File) null);
        fileOutputStream.write(byteArray);
        this.f1b = fileOutputStream;
        this.f0a = null;
    }
}
