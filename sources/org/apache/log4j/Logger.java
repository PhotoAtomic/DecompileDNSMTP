package org.apache.log4j;

import org.apache.log4j.spi.InterfaceC0091i;
/* loaded from: input.jar:org/apache/log4j/Logger.class */
public class Logger extends Category {

    /* renamed from: a */
    private static Class f115a;

    /* JADX INFO: Access modifiers changed from: protected */
    public Logger(String str) {
        super(str);
    }

    public static Logger getLogger(String str) {
        return LogManager.getLogger(str);
    }

    public static Logger getLogger(Class cls) {
        return LogManager.getLogger(cls.getName());
    }

    public static Logger getRootLogger() {
        return LogManager.getRootLogger();
    }

    public static Logger getLogger(String str, InterfaceC0091i interfaceC0091i) {
        return LogManager.getLogger(str, interfaceC0091i);
    }

    /* renamed from: a */
    private static Class m135a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        if (f115a == null) {
            cls = m135a("org.apache.log4j.Level");
            f115a = cls;
        } else {
            cls = f115a;
        }
        cls.getName();
    }
}
