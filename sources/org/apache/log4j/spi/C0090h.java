package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.util.Vector;
/* renamed from: org.apache.log4j.spi.h */
/* loaded from: input.jar:org/apache/log4j/spi/h.class */
final class C0090h extends PrintWriter {

    /* renamed from: a */
    private Vector f302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0090h() {
        super(new C0085c());
        this.f302a = new Vector();
    }

    @Override // java.io.PrintWriter
    public final void print(Object obj) {
        this.f302a.addElement(obj.toString());
    }

    @Override // java.io.PrintWriter
    public final void print(char[] cArr) {
        this.f302a.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter
    public final void print(String str) {
        this.f302a.addElement(str);
    }

    @Override // java.io.PrintWriter
    public final void println(Object obj) {
        this.f302a.addElement(obj.toString());
    }

    @Override // java.io.PrintWriter
    public final void println(char[] cArr) {
        this.f302a.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter
    public final void println(String str) {
        this.f302a.addElement(str);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] cArr) {
        this.f302a.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        this.f302a.addElement(new String(cArr, i, i2));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String str, int i, int i2) {
        this.f302a.addElement(str.substring(i, i + i2));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String str) {
        this.f302a.addElement(str);
    }

    /* renamed from: a */
    public final String[] m3a() {
        int size = this.f302a.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) this.f302a.elementAt(i);
        }
        return strArr;
    }
}
