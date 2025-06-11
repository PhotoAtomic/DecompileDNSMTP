package com.synametrics.commons.util;

import com.synametrics.commons.util.logging.LoggingFW;
import java.awt.Component;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/* renamed from: com.synametrics.commons.util.d */
/* loaded from: input.jar:com/synametrics/commons/util/d.class */
public final class C0015d {

    /* renamed from: a */
    public static final String f25a;

    /* renamed from: b */
    public static final String f26b;

    static {
        String property = System.getProperty("line.separator");
        f25a = property;
        property.length();
        System.getProperty("path.separator");
        f26b = System.getProperty("file.separator");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String, java.lang.Exception] */
    /* renamed from: a */
    public static String m201a(long j) {
        ?? format;
        try {
            format = DateFormat.getDateTimeInstance(3, 3).format(new Date(j));
            return format;
        } catch (Exception e) {
            format.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static int m202a(int i, int i2) {
        return (int) (Math.random() * (i2 + 1));
    }

    /* renamed from: a */
    public static boolean m198a(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return str.matches("[0-2]?[0-9]?[0-9](\\.[0-2]?[0-9]?[0-9]){3}");
    }

    /* renamed from: a */
    public static String m197a(String str, int i, char c) {
        if (str == null) {
            str = "";
        }
        if (str.length() >= 20) {
            return str;
        }
        char[] cArr = new char[20];
        for (int i2 = 0; i2 < 20; i2++) {
            if (i2 < str.length()) {
                cArr[i2] = str.charAt(i2);
            } else {
                cArr[i2] = ' ';
            }
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static String m194b(String str, int i, char c) {
        if (str == null) {
            str = "";
        }
        if (str.length() >= 8) {
            return str;
        }
        char[] cArr = new char[8];
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 < 8 - str.length()) {
                cArr[i3] = ' ';
            } else {
                cArr[i3] = str.charAt(i2);
                i2++;
            }
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m196a(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return String.valueOf(str.substring(0, indexOf)) + str3 + m196a(str.substring(indexOf + str2.length()), str2, str3);
    }

    /* renamed from: a */
    private static boolean m199a(File file, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            LoggingFW.log(40000, "com.synametrics.util.TGlob", e.getMessage(), e);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m195a(String str, byte[] bArr) {
        return m199a(new File(str), bArr);
    }

    /* renamed from: a */
    public static void m200a(Component component, String str) {
        JOptionPane.showMessageDialog(component, str, "Error", 0);
    }
}
