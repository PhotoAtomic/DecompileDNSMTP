package com.synametrics.commons.util.p004b;

import com.synametrics.commons.util.logging.LoggingFW;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* renamed from: com.synametrics.commons.util.b.a */
/* loaded from: input.jar:com/synametrics/commons/util/b/a.class */
public final class C0013a {
    /* renamed from: a */
    public static String m204a(String str, String str2, int i) {
        try {
            Matcher matcher = Pattern.compile(str2, 2).matcher(str);
            return !matcher.find() ? "" : str.substring(matcher.start(), matcher.end());
        } catch (PatternSyntaxException unused) {
            LoggingFW.log(30000, "com.synametrics.commons.util.regex.MatchingEngine", "'" + str2 + "' is not a valid regular expression");
            return "";
        }
    }
}
