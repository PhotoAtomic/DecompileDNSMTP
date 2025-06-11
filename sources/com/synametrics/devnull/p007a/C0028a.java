package com.synametrics.devnull.p007a;

import com.synametrics.commons.util.C0012b;
import com.synametrics.commons.util.C0015d;
import com.synametrics.commons.util.C0016e;
import com.synametrics.commons.util.net.p005a.p006a.C0021b;
import com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c;
import com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.synametrics.devnull.a.a */
/* loaded from: input.jar:com/synametrics/devnull/a/a.class */
public final class C0028a implements InterfaceC0022c, InterfaceC0023d {

    /* renamed from: d */
    private int f67d;

    /* renamed from: e */
    private String f68e;

    /* renamed from: h */
    private String f71h;

    /* renamed from: a */
    private int f64a = 0;

    /* renamed from: b */
    private List f65b = new ArrayList();

    /* renamed from: c */
    private C0021b f66c = new C0021b();

    /* renamed from: f */
    private int f69f = 0;

    /* renamed from: g */
    private String f70g = "Mutex";

    public C0028a(int i, String str, String str2, String str3) {
        this.f67d = 25;
        this.f71h = null;
        if (i > 0) {
            this.f67d = i;
        }
        this.f68e = str;
        this.f71h = str3;
        C0016e c0016e = new C0016e(str2, ",");
        for (int i2 = 0; i2 < c0016e.m193a(); i2++) {
            if (c0016e.m192a(i2).trim().length() > 0) {
                this.f65b.add(c0016e.m192a(i2).trim().toLowerCase());
            }
        }
        if (str != null) {
            File file = new File(str);
            if (!file.exists()) {
                System.out.println("ERROR: Save to directory does not exist. Emails won't be saved.");
                str = null;
            }
            if (!file.isDirectory()) {
                System.out.println("ERROR: Save to value must refer to a valid directory on your hard disk. It is not referring to a directory. Emails won't be saved.");
                str = null;
            }
        }
        System.out.println("");
        System.out.println("-------------------------------------------------");
        System.out.println("DevNullSMTP running with following configuration:");
        System.out.println("-------------------------------------------------");
        System.out.println("TCP/IP Port: " + i);
        System.out.println("Save to: " + (str == null ? "Messages won't be saved" : str));
        System.out.println("Acceptable domains: " + (str2 == null ? "Open relay" : str2));
        System.out.println("");
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: c */
    public final void mo150c(String str) {
        System.err.println(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v15 */
    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: a */
    public final String mo155a(String str, String str2, byte[] bArr) {
        int i;
        this.f64a++;
        if (this.f64a % 50 == 0) {
            System.out.println(".");
        } else {
            System.out.print(".");
        }
        if (this.f71h != null) {
            new C0012b(this.f71h).start();
        }
        if (this.f68e != null) {
            ?? r0 = this.f70g;
            synchronized (r0) {
                this.f69f = this.f69f + 1;
                r0 = r0;
                C0015d.m195a(String.valueOf(this.f68e) + C0015d.f26b + (String.valueOf(i) + "_" + System.currentTimeMillis() + ".eml"), bArr);
                return null;
            }
        }
        return null;
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: d */
    public final String mo148d(String str) {
        if (this.f65b.size() == 0) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < this.f65b.size(); i++) {
            if (lowerCase.indexOf("@" + ((String) this.f65b.get(i))) > 0) {
                return null;
            }
        }
        return "Relaying denied";
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c
    /* renamed from: a */
    public final void mo156a(String str) {
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c
    /* renamed from: b */
    public final void mo152b(String str) {
    }

    /* renamed from: a */
    public final void m164a() {
        this.f66c.m182a(this.f67d, this);
    }
}
