package org.apache.log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import org.apache.log4j.config.C0054a;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0069m;
import org.apache.log4j.p009b.C0043a;
import org.apache.log4j.spi.InterfaceC0083a;
import org.apache.log4j.spi.InterfaceC0089g;
import org.apache.log4j.spi.InterfaceC0091i;
/* loaded from: input.jar:org/apache/log4j/PropertyConfigurator.class */
public class PropertyConfigurator implements InterfaceC0083a {
    protected Hashtable registry = new Hashtable(11);
    protected InterfaceC0091i loggerFactory = new C0056e();
    public static final String LOGGER_FACTORY_KEY = "log4j.loggerFactory";

    /* renamed from: a */
    private static Class f127a;

    /* renamed from: b */
    private static Class f128b;

    /* renamed from: c */
    private static Class f129c;

    public void doConfigure$320994e6(String str, Hierarchy hierarchy) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            properties.load(fileInputStream);
            fileInputStream.close();
            doConfigure$55ee8828(properties, hierarchy);
        } catch (IOException e) {
            C0059c.m79b(new StringBuffer().append("Could not read configuration file [").append(str).append("].").toString(), e);
            C0059c.m80b(new StringBuffer().append("Ignoring configuration file [").append(str).append("].").toString());
        }
    }

    public static void configure(String str) {
        new PropertyConfigurator().doConfigure$320994e6(str, LogManager.getLoggerRepository$1ce6f9a2());
    }

    public static void configure(URL url) {
        new PropertyConfigurator().doConfigure$336c30bb(url, LogManager.getLoggerRepository$1ce6f9a2());
    }

    public static void configure(Properties properties) {
        new PropertyConfigurator().doConfigure$55ee8828(properties, LogManager.getLoggerRepository$1ce6f9a2());
    }

    public static void configureAndWatch(String str) {
        configureAndWatch(str, 60000L);
    }

    public static void configureAndWatch(String str, long j) {
        C0038a c0038a = new C0038a(str);
        c0038a.m75a(j);
        c0038a.start();
    }

    public void doConfigure$55ee8828(Properties properties, Hierarchy hierarchy) {
        String property = properties.getProperty("log4j.debug");
        String str = property;
        if (property == null) {
            String property2 = properties.getProperty("log4j.configDebug");
            str = property2;
            if (property2 != null) {
                C0059c.m78c("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
            }
        }
        if (str != null) {
            C0059c.m81a(C0069m.m58a(str, true));
        }
        String m60a = C0069m.m60a("log4j.threshold", properties);
        if (m60a != null) {
            hierarchy.setThreshold(C0069m.m59a(m60a, Level.ALL));
            C0059c.m83a(new StringBuffer().append("Hierarchy threshold set to [").append(hierarchy.getThreshold()).append("].").toString());
        }
        String m60a2 = C0069m.m60a("log4j.rootLogger", properties);
        String str2 = m60a2;
        if (m60a2 == null) {
            str2 = C0069m.m60a("log4j.rootCategory", properties);
        }
        if (str2 == null) {
            C0059c.m83a("Could not find root logger information. Is this OK?");
        } else {
            Logger rootLogger = hierarchy.getRootLogger();
            synchronized (rootLogger) {
                m133a(properties, rootLogger, "root", str2);
            }
        }
        configureLoggerFactory(properties);
        parseCatsAndRenderers$55ee8828(properties, hierarchy);
        C0059c.m83a("Finished configuring.");
        this.registry.clear();
    }

    @Override // org.apache.log4j.spi.InterfaceC0083a
    public void doConfigure$336c30bb(URL url, Hierarchy hierarchy) {
        Properties properties = new Properties();
        C0059c.m83a(new StringBuffer().append("Reading configuration from URL ").append(url).toString());
        try {
            properties.load(url.openStream());
            doConfigure$55ee8828(properties, hierarchy);
        } catch (IOException e) {
            C0059c.m79b(new StringBuffer().append("Could not read configuration file from URL [").append(url).append("].").toString(), e);
            C0059c.m80b(new StringBuffer().append("Ignoring configuration file [").append(url).append("].").toString());
        }
    }

    protected void configureLoggerFactory(Properties properties) {
        Class cls;
        String m60a = C0069m.m60a(LOGGER_FACTORY_KEY, properties);
        if (m60a != null) {
            C0059c.m83a(new StringBuffer().append("Setting category factory to [").append(m60a).append("].").toString());
            if (f127a == null) {
                cls = m134a("org.apache.log4j.spi.i");
                f127a = cls;
            } else {
                cls = f127a;
            }
            this.loggerFactory = (InterfaceC0091i) C0069m.m62a(m60a, cls, this.loggerFactory);
            C0054a.m87a(this.loggerFactory, properties, "log4j.factory.");
        }
    }

    protected void parseCatsAndRenderers$55ee8828(Properties properties, Hierarchy hierarchy) {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            if (str.startsWith("log4j.category.") || str.startsWith("log4j.logger.")) {
                String str2 = null;
                if (str.startsWith("log4j.category.")) {
                    str2 = str.substring("log4j.category.".length());
                } else if (str.startsWith("log4j.logger.")) {
                    str2 = str.substring("log4j.logger.".length());
                }
                String m60a = C0069m.m60a(str, properties);
                Logger logger = hierarchy.getLogger(str2, this.loggerFactory);
                synchronized (logger) {
                    m133a(properties, logger, str2, m60a);
                    String str3 = str2;
                    String m60a2 = C0069m.m60a(new StringBuffer().append("log4j.additivity.").append(str3).toString(), properties);
                    C0059c.m83a(new StringBuffer().append("Handling log4j.additivity.").append(str3).append("=[").append(m60a2).append("]").toString());
                    if (m60a2 != null && !m60a2.equals("")) {
                        boolean m58a = C0069m.m58a(m60a2, true);
                        C0059c.m83a(new StringBuffer().append("Setting additivity for \"").append(str3).append("\" to ").append(m58a).toString());
                        logger.setAdditivity(m58a);
                    }
                }
            } else if (str.startsWith("log4j.renderer.")) {
                String substring = str.substring("log4j.renderer.".length());
                String m60a3 = C0069m.m60a(str, properties);
                if (hierarchy instanceof Hierarchy) {
                    C0043a.m112a(hierarchy, substring, m60a3);
                }
            }
        }
    }

    /* renamed from: a */
    private void m133a(Properties properties, Logger logger, String str, String str2) {
        Class cls;
        Appender appender;
        Class cls2;
        C0059c.m83a(new StringBuffer().append("Parsing for [").append(str).append("] with value=[").append(str2).append("].").toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ",");
        if (!str2.startsWith(",") && !str2.equals("")) {
            if (!stringTokenizer.hasMoreTokens()) {
                return;
            }
            String nextToken = stringTokenizer.nextToken();
            C0059c.m83a(new StringBuffer().append("Level token is [").append(nextToken).append("].").toString());
            if (!"inherited".equalsIgnoreCase(nextToken) && !"null".equalsIgnoreCase(nextToken)) {
                logger.setLevel(C0069m.m59a(nextToken, Level.DEBUG));
            } else if (str.equals("root")) {
                C0059c.m78c("The root logger cannot be set to null.");
            } else {
                logger.setLevel(null);
            }
            C0059c.m83a(new StringBuffer().append("Category ").append(str).append(" set to ").append(logger.getLevel()).toString());
        }
        logger.removeAllAppenders();
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && !trim.equals(",")) {
                C0059c.m83a(new StringBuffer().append("Parsing appender named \"").append(trim).append("\".").toString());
                Appender appender2 = (Appender) this.registry.get(trim);
                if (appender2 != null) {
                    C0059c.m83a(new StringBuffer().append("Appender \"").append(trim).append("\" was already parsed.").toString());
                    appender = appender2;
                } else {
                    String stringBuffer = new StringBuffer().append("log4j.appender.").append(trim).toString();
                    String stringBuffer2 = new StringBuffer().append(stringBuffer).append(".layout").toString();
                    if (f128b == null) {
                        cls = m134a("org.apache.log4j.Appender");
                        f128b = cls;
                    } else {
                        cls = f128b;
                    }
                    Appender appender3 = (Appender) C0069m.m56a(properties, stringBuffer, cls, null);
                    if (appender3 == null) {
                        C0059c.m80b(new StringBuffer().append("Could not instantiate appender named \"").append(trim).append("\".").toString());
                        appender = null;
                    } else {
                        appender3.setName(trim);
                        if (appender3 instanceof InterfaceC0089g) {
                            if (appender3.requiresLayout()) {
                                if (f129c == null) {
                                    cls2 = m134a("org.apache.log4j.Layout");
                                    f129c = cls2;
                                } else {
                                    cls2 = f129c;
                                }
                                Layout layout = (Layout) C0069m.m56a(properties, stringBuffer2, cls2, null);
                                if (layout != null) {
                                    appender3.setLayout(layout);
                                    C0059c.m83a(new StringBuffer().append("Parsing layout options for \"").append(trim).append("\".").toString());
                                    C0054a.m87a(layout, properties, new StringBuffer().append(stringBuffer2).append(".").toString());
                                    C0059c.m83a(new StringBuffer().append("End of parsing for \"").append(trim).append("\".").toString());
                                }
                            }
                            C0054a.m87a(appender3, properties, new StringBuffer().append(stringBuffer).append(".").toString());
                            C0059c.m83a(new StringBuffer().append("Parsed \"").append(trim).append("\" options.").toString());
                        }
                        this.registry.put(appender3.getName(), appender3);
                        appender = appender3;
                    }
                }
                Appender appender4 = appender;
                if (appender != null) {
                    logger.addAppender(appender4);
                }
            }
        }
    }

    /* renamed from: a */
    private static Class m134a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
