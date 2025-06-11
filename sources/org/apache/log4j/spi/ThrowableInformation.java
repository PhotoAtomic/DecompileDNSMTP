package org.apache.log4j.spi;

import java.io.Serializable;
/* loaded from: input.jar:org/apache/log4j/spi/ThrowableInformation.class */
public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;

    /* renamed from: a */
    private transient Throwable f301a;
    private String[] rep;

    public ThrowableInformation(Throwable th) {
        this.f301a = th;
    }

    /* renamed from: a */
    public final String[] m6a() {
        if (this.rep != null) {
            return (String[]) this.rep.clone();
        }
        C0090h c0090h = new C0090h();
        this.f301a.printStackTrace(c0090h);
        this.rep = c0090h.m3a();
        return this.rep;
    }
}
