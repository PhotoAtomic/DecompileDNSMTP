package com.synametrics.commons.util.p003a;

import com.synametrics.commons.util.logging.LoggingFW;
import java.util.Vector;
/* renamed from: com.synametrics.commons.util.a.c */
/* loaded from: input.jar:com/synametrics/commons/util/a/c.class */
public abstract class AbstractC0009c {

    /* renamed from: a */
    private int f11a;

    /* renamed from: b */
    private int f12b;

    /* renamed from: c */
    private int f13c;

    /* renamed from: d */
    private Vector f14d;

    /* renamed from: a */
    public abstract Object mo206a();

    public AbstractC0009c(int i, int i2, int i3) {
        Math.max(1, i);
        this.f11a = Math.max(i, i2);
        this.f12b = Math.min(i2 - i, i3);
        this.f14d = new Vector(i2, i3);
        for (int i4 = 0; i4 < i; i4++) {
            C0011e c0011e = new C0011e();
            c0011e.f19a = true;
            c0011e.f20b = mo206a();
            this.f14d.add(c0011e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0131, code lost:
        return r7;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Object m207b() {
        Object obj = null;
        int i = 0;
        while (true) {
            int size = this.f14d.size();
            if (this.f13c >= size) {
                this.f13c = 0;
            }
            int i2 = this.f13c;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                C0011e c0011e = (C0011e) this.f14d.get(i2);
                if (c0011e.f19a) {
                    obj = c0011e.f20b;
                    c0011e.f19a = false;
                    c0011e.f21c = System.currentTimeMillis();
                    int i3 = i2 + 1;
                    this.f13c = i3 == this.f11a ? 0 : i3;
                } else {
                    i2++;
                }
            }
            if (obj != null) {
                return obj;
            }
            LoggingFW.log(10000, this, "Increasing thread pool size. Current size = " + this.f14d.size());
            if (i >= 1 || this.f14d.size() >= this.f11a) {
                if (obj == null && i < 2) {
                    i++;
                    try {
                        wait(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (obj != null) {
                    break;
                } else if (i >= 2) {
                    break;
                }
            } else {
                int size2 = this.f14d.size();
                int min = Math.min(this.f12b, this.f11a - size2);
                for (int i4 = 0; i4 < min; i4++) {
                    C0011e c0011e2 = new C0011e();
                    c0011e2.f19a = true;
                    c0011e2.f20b = mo206a();
                    c0011e2.f21c = System.currentTimeMillis();
                    this.f14d.add(c0011e2);
                }
                obj = ((C0011e) this.f14d.get(size2)).f20b;
                ((C0011e) this.f14d.get(size2)).f19a = false;
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m208a(Object obj) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.f14d.size()) {
                break;
            }
            C0011e c0011e = (C0011e) this.f14d.get(i);
            if (c0011e.f20b == obj) {
                c0011e.f19a = true;
                c0011e.f21c = System.currentTimeMillis();
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            throw new ArrayStoreException("Invalid object returned to the pool");
        }
    }
}
