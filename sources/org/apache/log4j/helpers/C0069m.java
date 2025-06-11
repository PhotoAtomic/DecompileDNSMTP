package org.apache.log4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.InterfaceC0083a;
/* renamed from: org.apache.log4j.helpers.m */
/* loaded from: input.jar:org/apache/log4j/helpers/m.class */
public final class C0069m {

    /* renamed from: a */
    private static String f223a = "${";

    /* renamed from: b */
    private static char f224b = '}';

    /* renamed from: c */
    private static int f225c = 2;

    /* renamed from: d */
    private static int f226d = 1;

    /* renamed from: e */
    private static Class f227e;

    /* renamed from: f */
    private static Class f228f;

    /* renamed from: g */
    private static Class f229g;

    private C0069m() {
    }

    /* renamed from: a */
    public static String m64a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i;
            i++;
            char charAt = str.charAt(i2);
            char c = charAt;
            if (charAt == '\\') {
                i++;
                char charAt2 = str.charAt(i);
                c = charAt2;
                if (charAt2 == 'n') {
                    c = '\n';
                } else if (c == 'r') {
                    c = '\r';
                } else if (c == 't') {
                    c = '\t';
                } else if (c == 'f') {
                    c = '\f';
                } else if (c == '\b') {
                    c = '\b';
                } else if (c == '\"') {
                    c = '\"';
                } else if (c == '\'') {
                    c = '\'';
                } else if (c == '\\') {
                    c = '\\';
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m61a(String str, String str2) {
        try {
            return System.getProperty(str, null);
        } catch (Throwable unused) {
            C0059c.m83a(new StringBuffer().append("Was not allowed to read system property \"").append(str).append("\".").toString());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m56a(Properties properties, String str, Class cls, Object obj) {
        String m60a = m60a(str, properties);
        if (m60a == null) {
            C0059c.m80b(new StringBuffer().append("Could not find value for key ").append(str).toString());
            return null;
        }
        return m62a(m60a.trim(), cls, (Object) null);
    }

    /* renamed from: a */
    public static boolean m58a(String str, boolean z) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return "true".equalsIgnoreCase(trim) || !"false".equalsIgnoreCase(trim);
    }

    /* renamed from: a */
    public static Level m59a(String str, Level level) {
        Class<?> cls;
        Class<?> cls2;
        if (str == null) {
            return level;
        }
        int indexOf = str.indexOf(35);
        if (indexOf == -1) {
            if (AbstractC0060d.NULL_DATE_FORMAT.equalsIgnoreCase(str)) {
                return null;
            }
            return Level.toLevel(str, level);
        }
        Level level2 = level;
        String substring = str.substring(indexOf + 1);
        String substring2 = str.substring(0, indexOf);
        if (AbstractC0060d.NULL_DATE_FORMAT.equalsIgnoreCase(substring2)) {
            return null;
        }
        C0059c.m83a(new StringBuffer().append("toLevel:class=[").append(substring).append("]").append(":pri=[").append(substring2).append("]").toString());
        try {
            Class m67b = C0065i.m67b(substring);
            Class<?>[] clsArr = new Class[2];
            if (f227e == null) {
                cls = m55b("java.lang.String");
                f227e = cls;
            } else {
                cls = f227e;
            }
            clsArr[0] = cls;
            if (f228f == null) {
                cls2 = m55b("org.apache.log4j.Level");
                f228f = cls2;
            } else {
                cls2 = f228f;
            }
            clsArr[1] = cls2;
            level2 = (Level) m67b.getMethod("toLevel", clsArr).invoke(null, substring2, level);
        } catch (ClassCastException e) {
            C0059c.m77c(new StringBuffer().append("class [").append(substring).append("] is not a subclass of org.apache.log4j.Level").toString(), e);
        } catch (ClassNotFoundException unused) {
            C0059c.m78c(new StringBuffer().append("custom level class [").append(substring).append("] not found.").toString());
        } catch (IllegalAccessException e2) {
            C0059c.m77c(new StringBuffer().append("class [").append(substring).append("] cannot be instantiated due to access restrictions").toString(), e2);
        } catch (NoSuchMethodException e3) {
            C0059c.m77c(new StringBuffer().append("custom level class [").append(substring).append("]").append(" does not have a constructor which takes one string parameter").toString(), e3);
        } catch (InvocationTargetException e4) {
            C0059c.m77c(new StringBuffer().append("custom level class [").append(substring).append("]").append(" could not be instantiated").toString(), e4);
        } catch (Exception e5) {
            C0059c.m77c(new StringBuffer().append("class [").append(substring).append("], level [").append(substring2).append("] conversion failed.").toString(), e5);
        }
        return level2;
    }

    /* renamed from: a */
    public static long m63a(String str, long j) {
        if (str == null) {
            return j;
        }
        String upperCase = str.trim().toUpperCase();
        long j2 = 1;
        int indexOf = upperCase.indexOf("KB");
        if (indexOf != -1) {
            j2 = 1024;
            upperCase = upperCase.substring(0, indexOf);
        } else {
            int indexOf2 = upperCase.indexOf("MB");
            if (indexOf2 != -1) {
                j2 = 1048576;
                upperCase = upperCase.substring(0, indexOf2);
            } else {
                int indexOf3 = upperCase.indexOf("GB");
                if (indexOf3 != -1) {
                    j2 = 1073741824;
                    upperCase = upperCase.substring(0, indexOf3);
                }
            }
        }
        if (upperCase != null) {
            try {
                return Long.valueOf(upperCase).longValue() * j2;
            } catch (NumberFormatException e) {
                C0059c.m80b(new StringBuffer().append("[").append(upperCase).append("] is not in proper int form.").toString());
                C0059c.m79b(new StringBuffer().append("[").append(str).append("] not in expected format.").toString(), e);
            }
        }
        return j;
    }

    /* renamed from: a */
    public static String m60a(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return m54b(property, properties);
        } catch (IllegalArgumentException e) {
            C0059c.m79b(new StringBuffer().append("Bad option value [").append(property).append("].").toString(), e);
            return property;
        }
    }

    /* renamed from: a */
    public static Object m62a(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class<?> m67b = C0065i.m67b(str);
                if (cls.isAssignableFrom(m67b)) {
                    return m67b.newInstance();
                }
                C0059c.m80b(new StringBuffer().append("A \"").append(str).append("\" object is not assignable to a \"").append(cls.getName()).append("\" variable.").toString());
                C0059c.m80b(new StringBuffer().append("The class \"").append(cls.getName()).append("\" was loaded by ").toString());
                C0059c.m80b(new StringBuffer().append("[").append(cls.getClassLoader()).append("] whereas object of type ").toString());
                C0059c.m80b(new StringBuffer().append("\"").append(m67b.getName()).append("\" was loaded by [").append(m67b.getClassLoader()).append("].").toString());
                return obj;
            } catch (Exception e) {
                C0059c.m79b(new StringBuffer().append("Could not instantiate class [").append(str).append("].").toString(), e);
            }
        }
        return obj;
    }

    /* renamed from: b */
    public static String m54b(String str, Properties properties) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            int indexOf = str.indexOf(f223a, i2);
            if (indexOf == -1) {
                if (i2 == 0) {
                    return str;
                }
                stringBuffer.append(str.substring(i2, str.length()));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i2, indexOf));
            int indexOf2 = str.indexOf(f224b, indexOf);
            if (indexOf2 == -1) {
                throw new IllegalArgumentException(new StringBuffer().append('\"').append(str).append("\" has no closing brace. Opening brace at position ").append(indexOf).append('.').toString());
            }
            String substring = str.substring(indexOf + f225c, indexOf2);
            String m61a = m61a(substring, (String) null);
            String str2 = m61a;
            if (m61a == null && properties != null) {
                str2 = properties.getProperty(substring);
            }
            if (str2 != null) {
                stringBuffer.append(m54b(str2, properties));
            }
            i = indexOf2 + f226d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [org.apache.log4j.spi.a] */
    /* renamed from: a */
    public static void m57a(URL url, String str, Hierarchy hierarchy) {
        PropertyConfigurator propertyConfigurator;
        Class cls;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            C0059c.m83a(new StringBuffer().append("Preferred configurator class: ").append(str).toString());
            String str2 = str;
            if (f229g == null) {
                cls = m55b("org.apache.log4j.spi.a");
                f229g = cls;
            } else {
                cls = f229g;
            }
            ?? r0 = (InterfaceC0083a) m62a(str2, cls, (Object) null);
            propertyConfigurator = r0;
            if (r0 == 0) {
                C0059c.m80b(new StringBuffer().append("Could not instantiate configurator [").append(str).append("].").toString());
                return;
            }
        } else {
            propertyConfigurator = new PropertyConfigurator();
        }
        propertyConfigurator.doConfigure$336c30bb(url, hierarchy);
    }

    /* renamed from: b */
    private static Class m55b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
