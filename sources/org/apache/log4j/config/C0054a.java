package org.apache.log4j.config;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0069m;
import org.apache.log4j.spi.InterfaceC0089g;
/* renamed from: org.apache.log4j.config.a */
/* loaded from: input.jar:org/apache/log4j/config/a.class */
public final class C0054a {

    /* renamed from: a */
    private Object f191a;

    /* renamed from: b */
    private PropertyDescriptor[] f192b;

    /* renamed from: c */
    private static Class f193c;

    /* renamed from: d */
    private static Class f194d;

    public C0054a(Object obj) {
        this.f191a = obj;
    }

    /* renamed from: b */
    private void m84b() {
        try {
            this.f192b = Introspector.getBeanInfo(this.f191a.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            C0059c.m80b(new StringBuffer().append("Failed to introspect ").append(this.f191a).append(": ").append(e.getMessage()).toString());
            this.f192b = new PropertyDescriptor[0];
        }
    }

    /* renamed from: a */
    public static void m87a(Object obj, Properties properties, String str) {
        C0054a c0054a = new C0054a(obj);
        int length = str.length();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String m60a = C0069m.m60a(str2, properties);
                String substring = str2.substring(length);
                if (!"layout".equals(substring) || !(c0054a.f191a instanceof Appender)) {
                    c0054a.m85a(substring, m60a);
                }
            }
        }
        c0054a.m88a();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01af A[Catch: PropertySetterException -> 0x0216, TryCatch #3 {PropertySetterException -> 0x0216, blocks: (B:20:0x007d, B:22:0x0092, B:23:0x00b2, B:24:0x00b3, B:26:0x00c0, B:27:0x00c9, B:28:0x00ca, B:30:0x00d6, B:32:0x00e2, B:34:0x00f1, B:65:0x01af, B:66:0x01d1, B:67:0x01d2, B:68:0x01f7, B:70:0x020d, B:71:0x0215, B:37:0x00fd, B:39:0x0108, B:40:0x0114, B:42:0x011f, B:43:0x012b, B:45:0x0136, B:47:0x0140, B:48:0x0146, B:50:0x0150, B:51:0x0156, B:53:0x015c, B:55:0x016b, B:57:0x0173, B:54:0x0168, B:33:0x00ee), top: B:77:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d2 A[Catch: PropertySetterException -> 0x0216, TryCatch #3 {PropertySetterException -> 0x0216, blocks: (B:20:0x007d, B:22:0x0092, B:23:0x00b2, B:24:0x00b3, B:26:0x00c0, B:27:0x00c9, B:28:0x00ca, B:30:0x00d6, B:32:0x00e2, B:34:0x00f1, B:65:0x01af, B:66:0x01d1, B:67:0x01d2, B:68:0x01f7, B:70:0x020d, B:71:0x0215, B:37:0x00fd, B:39:0x0108, B:40:0x0114, B:42:0x011f, B:43:0x012b, B:45:0x0136, B:47:0x0140, B:48:0x0146, B:50:0x0150, B:51:0x0156, B:53:0x015c, B:55:0x016b, B:57:0x0173, B:54:0x0168, B:33:0x00ee), top: B:77:0x007d }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m85a(String str, String str2) {
        PropertyDescriptor propertyDescriptor;
        Object obj;
        Object obj2;
        Class cls;
        Class cls2;
        if (str2 == null) {
            return;
        }
        String decapitalize = Introspector.decapitalize(str);
        if (this.f192b == null) {
            m84b();
        }
        int i = 0;
        while (true) {
            if (i >= this.f192b.length) {
                propertyDescriptor = null;
                break;
            } else if (decapitalize.equals(this.f192b[i].getName())) {
                propertyDescriptor = this.f192b[i];
                break;
            } else {
                i++;
            }
        }
        PropertyDescriptor propertyDescriptor2 = propertyDescriptor;
        if (propertyDescriptor == null) {
            C0059c.m78c(new StringBuffer().append("No such property [").append(decapitalize).append("] in ").append(this.f191a.getClass().getName()).append(".").toString());
            return;
        }
        try {
            Method writeMethod = propertyDescriptor2.getWriteMethod();
            if (writeMethod == null) {
                throw new PropertySetterException(new StringBuffer().append("No setter for property [").append(decapitalize).append("].").toString());
            }
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new PropertySetterException("#params for setter != 1");
            }
            Class<?> cls3 = parameterTypes[0];
            if (str2 != null) {
                String trim = str2.trim();
                if (f193c == null) {
                    cls = m86a("java.lang.String");
                    f193c = cls;
                } else {
                    cls = f193c;
                }
                if (cls.isAssignableFrom(cls3)) {
                    obj = str2;
                } else if (Integer.TYPE.isAssignableFrom(cls3)) {
                    obj = new Integer(trim);
                } else if (Long.TYPE.isAssignableFrom(cls3)) {
                    obj = new Long(trim);
                } else if (!Boolean.TYPE.isAssignableFrom(cls3)) {
                    if (f194d == null) {
                        cls2 = m86a("org.apache.log4j.Priority");
                        f194d = cls2;
                    } else {
                        cls2 = f194d;
                    }
                    if (cls2.isAssignableFrom(cls3)) {
                        obj = C0069m.m59a(trim, Level.DEBUG);
                    }
                } else if ("true".equalsIgnoreCase(trim)) {
                    obj = Boolean.TRUE;
                } else if ("false".equalsIgnoreCase(trim)) {
                    obj = Boolean.FALSE;
                }
                obj2 = obj;
                if (obj2 != null) {
                    throw new PropertySetterException(new StringBuffer().append("Conversion to type [").append(parameterTypes[0]).append("] failed.").toString());
                }
                C0059c.m83a(new StringBuffer().append("Setting property [").append(decapitalize).append("] to [").append(obj2).append("].").toString());
                try {
                    writeMethod.invoke(this.f191a, obj2);
                    return;
                } catch (Exception e) {
                    throw new PropertySetterException(e);
                }
            }
            obj = null;
            obj2 = obj;
            if (obj2 != null) {
            }
        } catch (PropertySetterException e2) {
            C0059c.m77c(new StringBuffer().append("Failed to set property [").append(decapitalize).append("] to value \"").append(str2).append("\". ").toString(), e2.rootCause);
        }
    }

    /* renamed from: a */
    public final void m88a() {
        if (this.f191a instanceof InterfaceC0089g) {
            ((InterfaceC0089g) this.f191a).activateOptions();
        }
    }

    /* renamed from: a */
    private static Class m86a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
