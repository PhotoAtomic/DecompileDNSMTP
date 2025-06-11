package org.apache.log4j.p008a;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import org.apache.log4j.Appender;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.config.C0054a;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0065i;
import org.apache.log4j.helpers.C0069m;
import org.apache.log4j.p009b.C0043a;
import org.apache.log4j.spi.AbstractC0092j;
import org.apache.log4j.spi.InterfaceC0083a;
import org.apache.log4j.spi.InterfaceC0084b;
import org.apache.log4j.spi.InterfaceC0087e;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* renamed from: org.apache.log4j.a.b */
/* loaded from: input.jar:org/apache/log4j/a/b.class */
public final class C0040b implements InterfaceC0083a {

    /* renamed from: a */
    private static Class[] f135a;

    /* renamed from: b */
    private Hashtable f136b = new Hashtable();

    /* renamed from: c */
    private Hierarchy f137c;

    /* renamed from: d */
    private static Class f138d;

    /* renamed from: e */
    private static Class f139e;

    /* renamed from: f */
    private static Class f140f;

    /* renamed from: g */
    private static Class f141g;

    /* renamed from: a */
    private Appender m129a(Element element) {
        String m125b = m125b(element.getAttribute("ref"));
        Document ownerDocument = element.getOwnerDocument();
        Appender appender = (Appender) this.f136b.get(m125b);
        if (appender != null) {
            return appender;
        }
        Element element2 = null;
        NodeList elementsByTagName = ownerDocument.getElementsByTagName("appender");
        int i = 0;
        while (true) {
            if (i >= elementsByTagName.getLength()) {
                break;
            }
            Node item = elementsByTagName.item(i);
            if (m125b.equals(item.getAttributes().getNamedItem("name").getNodeValue())) {
                element2 = (Element) item;
                break;
            }
            i++;
        }
        if (element2 == null) {
            C0059c.m80b(new StringBuffer().append("No appender named [").append(m125b).append("] could be found.").toString());
            return null;
        }
        Appender m124b = m124b(element2);
        this.f136b.put(m125b, m124b);
        return m124b;
    }

    /* renamed from: b */
    private Appender m124b(Element element) {
        String m125b = m125b(element.getAttribute("class"));
        C0059c.m83a(new StringBuffer().append("Class name: [").append(m125b).append(']').toString());
        try {
            Appender appender = (Appender) C0065i.m67b(m125b).newInstance();
            C0054a c0054a = new C0054a(appender);
            appender.setName(m125b(element.getAttribute("name")));
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals("param")) {
                        m126a(element2, c0054a);
                    } else if (element2.getTagName().equals("layout")) {
                        appender.setLayout(m119d(element2));
                    } else if (element2.getTagName().equals("filter")) {
                        m123b(element2, appender);
                    } else if (element2.getTagName().equals("errorHandler")) {
                        m128a(element2, appender);
                    } else if (element2.getTagName().equals("appender-ref")) {
                        String m125b2 = m125b(element2.getAttribute("ref"));
                        if (appender instanceof InterfaceC0084b) {
                            C0059c.m83a(new StringBuffer().append("Attaching appender named [").append(m125b2).append("] to appender named [").append(appender.getName()).append("].").toString());
                            ((InterfaceC0084b) appender).addAppender(m129a(element2));
                        } else {
                            C0059c.m80b(new StringBuffer().append("Requesting attachment of appender named [").append(m125b2).append("] to appender named [").append(appender.getName()).append("] which does not implement org.apache.log4j.spi.AppenderAttachable.").toString());
                        }
                    }
                }
            }
            c0054a.m88a();
            return appender;
        } catch (Exception e) {
            C0059c.m79b("Could not create an Appender. Reported error follows.", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m128a(Element element, Appender appender) {
        Class cls;
        String m125b = m125b(element.getAttribute("class"));
        if (f139e == null) {
            cls = m121c("org.apache.log4j.spi.e");
            f139e = cls;
        } else {
            cls = f139e;
        }
        InterfaceC0087e interfaceC0087e = (InterfaceC0087e) C0069m.m62a(m125b, cls, (Object) null);
        if (interfaceC0087e != null) {
            C0054a c0054a = new C0054a(interfaceC0087e);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    String tagName = element2.getTagName();
                    if (tagName.equals("param")) {
                        m126a(element2, c0054a);
                    } else if (tagName.equals("appender-ref")) {
                        m129a(element2);
                    } else if (tagName.equals("logger-ref")) {
                        this.f137c.getLogger(element2.getAttribute("ref"));
                    } else if (tagName.equals("root-ref")) {
                        this.f137c.getRootLogger();
                    }
                }
            }
            c0054a.m88a();
            appender.setErrorHandler(interfaceC0087e);
        }
    }

    /* renamed from: b */
    private void m123b(Element element, Appender appender) {
        Class cls;
        String m125b = m125b(element.getAttribute("class"));
        if (f140f == null) {
            cls = m121c("org.apache.log4j.spi.j");
            f140f = cls;
        } else {
            cls = f140f;
        }
        AbstractC0092j abstractC0092j = (AbstractC0092j) C0069m.m62a(m125b, cls, (Object) null);
        if (abstractC0092j != null) {
            C0054a c0054a = new C0054a(abstractC0092j);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals("param")) {
                        m126a(element2, c0054a);
                    }
                }
            }
            c0054a.m88a();
            C0059c.m83a(new StringBuffer().append("Adding filter of type [").append(abstractC0092j.getClass()).append("] to appender named [").append(appender.getName()).append("].").toString());
            appender.addFilter(abstractC0092j);
        }
    }

    /* renamed from: c */
    private void m120c(Element element) {
        Class cls;
        String m125b = m125b(element.getAttribute("class"));
        if ("".equals(m125b)) {
            C0059c.m80b("Category Factory tag class attribute not found.");
            C0059c.m83a("No Category Factory configured.");
            return;
        }
        C0059c.m83a(new StringBuffer().append("Desired category factory: [").append(m125b).append(']').toString());
        if (f141g == null) {
            cls = m121c("org.apache.log4j.spi.i");
            f141g = cls;
        } else {
            cls = f141g;
        }
        C0054a c0054a = new C0054a(C0069m.m62a(m125b, cls, (Object) null));
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("param")) {
                    m126a(element2, c0054a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m127a(Element element, Logger logger, boolean z) {
        C0054a c0054a = new C0054a(logger);
        logger.removeAllAppenders();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if (tagName.equals("appender-ref")) {
                    Element element3 = (Element) item;
                    Appender m129a = m129a(element3);
                    String m125b = m125b(element3.getAttribute("ref"));
                    if (m129a != null) {
                        C0059c.m83a(new StringBuffer().append("Adding appender named [").append(m125b).append("] to category [").append(logger.getName()).append("].").toString());
                    } else {
                        C0059c.m83a(new StringBuffer().append("Appender named [").append(m125b).append("] not found.").toString());
                    }
                    logger.addAppender(m129a);
                } else if (tagName.equals("level")) {
                    m122b(element2, logger, z);
                } else if (tagName.equals("priority")) {
                    m122b(element2, logger, z);
                } else if (tagName.equals("param")) {
                    m126a(element2, c0054a);
                }
            }
        }
        c0054a.m88a();
    }

    /* renamed from: d */
    private Layout m119d(Element element) {
        String m125b = m125b(element.getAttribute("class"));
        C0059c.m83a(new StringBuffer().append("Parsing layout of class: \"").append(m125b).append("\"").toString());
        try {
            Layout layout = (Layout) C0065i.m67b(m125b).newInstance();
            C0054a c0054a = new C0054a(layout);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals("param")) {
                        m126a(element2, c0054a);
                    }
                }
            }
            c0054a.m88a();
            return layout;
        } catch (Exception e) {
            C0059c.m79b("Could not create the Layout. Reported error follows.", e);
            return null;
        }
    }

    /* renamed from: b */
    private void m122b(Element element, Logger logger, boolean z) {
        String name = logger.getName();
        if (z) {
            name = "root";
        }
        String m125b = m125b(element.getAttribute("value"));
        C0059c.m83a(new StringBuffer().append("Level value for ").append(name).append(" is  [").append(m125b).append("].").toString());
        if (!"inherited".equalsIgnoreCase(m125b) && !"null".equalsIgnoreCase(m125b)) {
            String m125b2 = m125b(element.getAttribute("class"));
            if ("".equals(m125b2)) {
                logger.setLevel(C0069m.m59a(m125b, Level.DEBUG));
            } else {
                C0059c.m83a(new StringBuffer().append("Desired Level sub-class: [").append(m125b2).append(']').toString());
                try {
                    logger.setLevel((Level) C0065i.m67b(m125b2).getMethod("toLevel", f135a).invoke(null, m125b));
                } catch (Exception e) {
                    C0059c.m79b(new StringBuffer().append("Could not create level [").append(m125b).append("]. Reported error follows.").toString(), e);
                    return;
                }
            }
        } else if (z) {
            C0059c.m80b("Root level cannot be inherited. Ignoring directive.");
        } else {
            logger.setLevel(null);
        }
        C0059c.m83a(new StringBuffer().append(name).append(" level set to ").append(logger.getLevel()).toString());
    }

    /* renamed from: a */
    private void m126a(Element element, C0054a c0054a) {
        c0054a.m85a(m125b(element.getAttribute("name")), m125b(C0069m.m64a(element.getAttribute("value"))));
    }

    @Override // org.apache.log4j.spi.InterfaceC0083a
    public final void doConfigure$336c30bb(URL url, Hierarchy hierarchy) {
        try {
            m131a(url.openStream(), hierarchy);
        } catch (IOException e) {
            C0059c.m79b(new StringBuffer().append("Could not open [").append(url).append("].").toString(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.apache.log4j.a.b] */
    /* renamed from: a */
    private void m131a(InputStream inputStream, Hierarchy hierarchy) {
        InputSource inputSource = new InputSource(inputStream);
        FactoryConfigurationError factoryConfigurationError = this;
        factoryConfigurationError.f137c = hierarchy;
        try {
            C0059c.m83a(new StringBuffer().append("System property is :").append(C0069m.m61a("javax.xml.parsers.DocumentBuilderFactory", (String) null)).toString());
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            C0059c.m83a("Standard DocumentBuilderFactory search succeded.");
            factoryConfigurationError = new StringBuffer().append("DocumentBuilderFactory is: ").append(newInstance.getClass().getName()).toString();
            C0059c.m83a((String) factoryConfigurationError);
            try {
                newInstance.setValidating(true);
                DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                newDocumentBuilder.setErrorHandler(new C0041c());
                newDocumentBuilder.setEntityResolver(new C0039a());
                inputSource.setSystemId("dummy://log4j.dtd");
                m118e(newDocumentBuilder.parse(inputSource).getDocumentElement());
            } catch (Exception e) {
                C0059c.m79b(new StringBuffer().append("Could not parse input source [").append(inputSource).append("].").toString(), e);
            }
        } catch (FactoryConfigurationError e2) {
            C0059c.m82a("Could not instantiate a DocumentBuilderFactory.", factoryConfigurationError.getException());
            throw e2;
        }
    }

    /* renamed from: a */
    public static void m130a(String str) {
        C0040b c0040b = new C0040b();
        Hierarchy loggerRepository$1ce6f9a2 = LogManager.getLoggerRepository$1ce6f9a2();
        FileInputStream fileInputStream = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                c0040b.m131a(fileInputStream, loggerRepository$1ce6f9a2);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    C0059c.m79b(new StringBuffer().append("Could not close [").append(str).append("].").toString(), e);
                }
            } catch (IOException e2) {
                C0059c.m79b(new StringBuffer().append("Could not open [").append(str).append("].").toString(), e2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        C0059c.m79b(new StringBuffer().append("Could not close [").append(str).append("].").toString(), e3);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    C0059c.m79b(new StringBuffer().append("Could not close [").append(str).append("].").toString(), e4);
                }
            }
            throw th;
        }
    }

    /* renamed from: e */
    private void m118e(Element element) {
        Logger logger;
        String tagName = element.getTagName();
        if (!tagName.equals("log4j:configuration")) {
            if (!tagName.equals("configuration")) {
                C0059c.m80b("DOM element is - not a <log4j:configuration> element.");
                return;
            } else {
                C0059c.m78c("The <configuration> element has been deprecated.");
                C0059c.m78c("Use the <log4j:configuration> element instead.");
            }
        }
        String m125b = m125b(element.getAttribute("debug"));
        C0059c.m83a(new StringBuffer().append("debug attribute= \"").append(m125b).append("\".").toString());
        if (m125b.equals("") || m125b.equals("null")) {
            C0059c.m83a("Ignoring debug attribute.");
        } else {
            C0059c.m81a(C0069m.m58a(m125b, true));
        }
        String m125b2 = m125b(element.getAttribute("configDebug"));
        if (!m125b2.equals("") && !m125b2.equals("null")) {
            C0059c.m78c("The \"configDebug\" attribute is deprecated.");
            C0059c.m78c("Use the \"debug\" attribute instead.");
            C0059c.m81a(C0069m.m58a(m125b2, true));
        }
        String m125b3 = m125b(element.getAttribute("threshold"));
        C0059c.m83a(new StringBuffer().append("Threshold =\"").append(m125b3).append("\".").toString());
        if (!"".equals(m125b3) && !"null".equals(m125b3)) {
            this.f137c.setThreshold(m125b3);
        }
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals("categoryFactory")) {
                    m120c(element2);
                }
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            Node item2 = childNodes.item(i2);
            if (item2.getNodeType() == 1) {
                Element element3 = (Element) item2;
                String tagName2 = element3.getTagName();
                if (tagName2.equals("category") || tagName2.equals("logger")) {
                    String m125b4 = m125b(element3.getAttribute("name"));
                    String m125b5 = m125b(element3.getAttribute("class"));
                    if ("".equals(m125b5)) {
                        C0059c.m83a("Retreiving an instance of org.apache.log4j.Logger.");
                        logger = this.f137c.getLogger(m125b4);
                    } else {
                        C0059c.m83a(new StringBuffer().append("Desired logger sub-class: [").append(m125b5).append(']').toString());
                        try {
                            logger = (Logger) C0065i.m67b(m125b5).getMethod("getLogger", f135a).invoke(null, m125b4);
                        } catch (Exception e) {
                            C0059c.m79b(new StringBuffer().append("Could not retrieve category [").append(m125b4).append("]. Reported error follows.").toString(), e);
                        }
                    }
                    synchronized (logger) {
                        boolean m58a = C0069m.m58a(m125b(element3.getAttribute("additivity")), true);
                        C0059c.m83a(new StringBuffer().append("Setting [").append(logger.getName()).append("] additivity to [").append(m58a).append("].").toString());
                        logger.setAdditivity(m58a);
                        m127a(element3, logger, false);
                    }
                } else if (tagName2.equals("root")) {
                    Logger rootLogger = this.f137c.getRootLogger();
                    synchronized (rootLogger) {
                        m127a(element3, rootLogger, true);
                    }
                } else if (tagName2.equals("renderer")) {
                    String m125b6 = m125b(element3.getAttribute("renderingClass"));
                    String m125b7 = m125b(element3.getAttribute("renderedClass"));
                    if (this.f137c instanceof Hierarchy) {
                        C0043a.m112a(this.f137c, m125b7, m125b6);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private String m125b(String str) {
        try {
            return C0069m.m54b(str, null);
        } catch (IllegalArgumentException e) {
            C0059c.m77c("Could not perform variable substitution.", e);
            return str;
        }
    }

    /* renamed from: c */
    private static Class m121c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        Class[] clsArr = new Class[1];
        if (f138d == null) {
            cls = m121c("java.lang.String");
            f138d = cls;
        } else {
            cls = f138d;
        }
        clsArr[0] = cls;
        f135a = clsArr;
    }
}
