package org.apache.log4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0065i;
import org.apache.log4j.helpers.C0069m;
import org.apache.log4j.spi.C0086d;
import org.apache.log4j.spi.C0093k;
import org.apache.log4j.spi.InterfaceC0091i;
/* loaded from: input.jar:org/apache/log4j/LogManager.class */
public class LogManager {
    public static final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
    public static final String DEFAULT_CONFIGURATION_KEY = "log4j.configuration";
    public static final String CONFIGURATOR_CLASS_KEY = "log4j.configuratorClass";
    public static final String DEFAULT_INIT_OVERRIDE_KEY = "log4j.defaultInitOverride";

    /* renamed from: a */
    private static Object f113a = null;

    /* renamed from: b */
    private static C0093k f114b = new C0093k(new Hierarchy(new C0086d(Level.DEBUG)));

    public static void setRepositorySelector$1f281151(C0093k c0093k, Object obj) {
        if (f113a != null && f113a != obj) {
            throw new IllegalArgumentException("Attempted to reset the LoggerFactory without possessing the guard.");
        }
        if (c0093k == null) {
            throw new IllegalArgumentException("RepositorySelector must be non-null.");
        }
        f113a = obj;
        f114b = c0093k;
    }

    public static Hierarchy getLoggerRepository$1ce6f9a2() {
        return f114b.m0a();
    }

    public static Logger getRootLogger() {
        return f114b.m0a().getRootLogger();
    }

    public static Logger getLogger(String str) {
        return f114b.m0a().getLogger(str);
    }

    public static Logger getLogger(Class cls) {
        return f114b.m0a().getLogger(cls.getName());
    }

    public static Logger getLogger(String str, InterfaceC0091i interfaceC0091i) {
        return f114b.m0a().getLogger(str, interfaceC0091i);
    }

    public static Logger exists(String str) {
        return f114b.m0a().exists(str);
    }

    public static Enumeration getCurrentLoggers() {
        return f114b.m0a().getCurrentLoggers();
    }

    public static void shutdown() {
        f114b.m0a().shutdown();
    }

    public static void resetConfiguration() {
        f114b.m0a().resetConfiguration();
    }

    static {
        URL m69a;
        String m61a = C0069m.m61a(DEFAULT_INIT_OVERRIDE_KEY, (String) null);
        if (m61a == null || "false".equalsIgnoreCase(m61a)) {
            String m61a2 = C0069m.m61a(DEFAULT_CONFIGURATION_KEY, (String) null);
            String m61a3 = C0069m.m61a(CONFIGURATOR_CLASS_KEY, (String) null);
            if (m61a2 == null) {
                URL m69a2 = C0065i.m69a("log4j.xml");
                m69a = m69a2;
                if (m69a2 == null) {
                    m69a = C0065i.m69a(DEFAULT_CONFIGURATION_FILE);
                }
            } else {
                try {
                    m69a = new URL(m61a2);
                } catch (MalformedURLException unused) {
                    m69a = C0065i.m69a(m61a2);
                }
            }
            if (m69a == null) {
                C0059c.m83a(new StringBuffer().append("Could not find resource: [").append(m61a2).append("].").toString());
                return;
            }
            C0059c.m83a(new StringBuffer().append("Using URL [").append(m69a).append("] for automatic log4j configuration.").toString());
            C0069m.m57a(m69a, m61a3, getLoggerRepository$1ce6f9a2());
        }
    }
}
