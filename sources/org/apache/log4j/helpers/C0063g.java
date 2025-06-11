package org.apache.log4j.helpers;
/* renamed from: org.apache.log4j.helpers.g */
/* loaded from: input.jar:org/apache/log4j/helpers/g.class */
public final class C0063g {
    /* renamed from: a */
    public static String m73a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 6);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt == '>') {
                stringBuffer.append("&gt;");
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    static {
        "]]>".length();
    }
}
