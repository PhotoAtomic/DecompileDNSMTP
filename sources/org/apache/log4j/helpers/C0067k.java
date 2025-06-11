package org.apache.log4j.helpers;

import org.apache.log4j.spi.InterfaceC0087e;
/* renamed from: org.apache.log4j.helpers.k */
/* loaded from: input.jar:org/apache/log4j/helpers/k.class */
public final class C0067k implements InterfaceC0087e {

    /* renamed from: a */
    private boolean f221a = true;

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public final void activateOptions() {
    }

    @Override // org.apache.log4j.spi.InterfaceC0087e
    /* renamed from: a */
    public final void mo4a(String str, Exception exc, int i) {
        if (this.f221a) {
            C0059c.m79b(str, exc);
            this.f221a = false;
        }
    }

    @Override // org.apache.log4j.spi.InterfaceC0087e
    /* renamed from: a */
    public final void mo5a(String str) {
        if (this.f221a) {
            C0059c.m80b(str);
            this.f221a = false;
        }
    }
}
