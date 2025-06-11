package com.synametrics.commons.util.p003a;

import com.synametrics.commons.util.logging.LoggingFW;
/* renamed from: com.synametrics.commons.util.a.a */
/* loaded from: input.jar:com/synametrics/commons/util/a/a.class */
public final class C0007a extends Thread {

    /* renamed from: a */
    private volatile InterfaceC0008b f9a;

    /* renamed from: b */
    private volatile Object f10b;

    /* renamed from: a */
    public final void m209a(Object obj) {
        this.f10b = null;
    }

    /* renamed from: a */
    public final void m210a(InterfaceC0008b interfaceC0008b) {
        this.f9a = interfaceC0008b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.synametrics.commons.util.a.b] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.synametrics.commons.util.a.b] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            m211a();
            ?? r0 = this.f9a;
            if (r0 != 0) {
                try {
                    r0 = this.f9a;
                    r0.mo184a();
                } catch (Exception e) {
                    r0.printStackTrace();
                }
            }
            try {
                C0010d.m205c().m208a(this);
            } catch (RuntimeException e2) {
                LoggingFW.log(40000, this, "Error occurred while returning object back to pool. " + e2.getMessage() + ". Thread name = " + Thread.currentThread().getName());
            }
        }
    }

    /* renamed from: a */
    private synchronized void m211a() {
        try {
            wait();
        } catch (InterruptedException unused) {
        }
    }
}
