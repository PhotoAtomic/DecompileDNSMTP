package com.synametrics.commons.util;
/* renamed from: com.synametrics.commons.util.c */
/* loaded from: input.jar:com/synametrics/commons/util/c.class */
public final class C0014c {

    /* renamed from: a */
    private static byte[] f24a;

    static {
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        f24a = new byte[256];
        for (int i = 0; i < 256; i++) {
            f24a[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f24a[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f24a[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f24a[i4] = (byte) ((i4 + 52) - 48);
        }
        f24a[43] = 62;
        f24a[47] = 63;
    }

    /* renamed from: a */
    public static byte[] m203a(char[] cArr) {
        int length = cArr.length;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] > 255 || f24a[cArr[i]] < 0) {
                length--;
            }
        }
        int i2 = (length / 4) * 3;
        if (length % 4 == 3) {
            i2 += 2;
        }
        if (length % 4 == 2) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < cArr.length; i6++) {
            byte b = cArr[i6] > 255 ? (byte) -1 : f24a[cArr[i6]];
            byte b2 = b;
            if (b >= 0) {
                i3 += 6;
                i4 = (i4 << 6) | b2;
                if (i3 >= 8) {
                    i3 -= 8;
                    int i7 = i5;
                    i5++;
                    bArr[i7] = (byte) (i4 >> i3);
                }
            }
        }
        if (i5 != bArr.length) {
            throw new Error("Miscalculated data length (wrote " + i5 + " instead of " + bArr.length + ")");
        }
        return bArr;
    }
}
