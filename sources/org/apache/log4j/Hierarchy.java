package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.p009b.C0043a;
import org.apache.log4j.p009b.InterfaceC0045c;
import org.apache.log4j.spi.InterfaceC0088f;
import org.apache.log4j.spi.InterfaceC0091i;
/* loaded from: input.jar:org/apache/log4j/Hierarchy.class */
public class Hierarchy {

    /* renamed from: a */
    private InterfaceC0091i f105a;

    /* renamed from: d */
    private Logger f108d;

    /* renamed from: e */
    private C0043a f109e;

    /* renamed from: f */
    private int f110f;

    /* renamed from: g */
    private Level f111g;

    /* renamed from: h */
    private boolean f112h = false;

    /* renamed from: c */
    private Hashtable f107c = new Hashtable();

    /* renamed from: b */
    private Vector f106b = new Vector(1);

    public Hierarchy(Logger logger) {
        this.f108d = logger;
        setThreshold(Level.ALL);
        this.f108d.m140a(this);
        this.f109e = new C0043a();
        this.f105a = new C0056e();
    }

    public void addRenderer(Class cls, InterfaceC0045c interfaceC0045c) {
        this.f109e.m115a(cls, interfaceC0045c);
    }

    public void addHierarchyEventListener(InterfaceC0088f interfaceC0088f) {
        if (this.f106b.contains(interfaceC0088f)) {
            C0059c.m78c("Ignoring attempt to add an existent listener.");
        } else {
            this.f106b.addElement(interfaceC0088f);
        }
    }

    public void clear() {
        this.f107c.clear();
    }

    public void emitNoAppenderWarning(Category category) {
        if (this.f112h) {
            return;
        }
        C0059c.m78c(new StringBuffer().append("No appenders could be found for logger (").append(category.getName()).append(").").toString());
        C0059c.m78c("Please initialize the log4j system properly.");
        this.f112h = true;
    }

    public Logger exists(String str) {
        Object obj = this.f107c.get(new C0046c(str));
        if (obj instanceof Logger) {
            return (Logger) obj;
        }
        return null;
    }

    public void setThreshold(String str) {
        Level level = Level.toLevel(str, (Level) null);
        if (level != null) {
            setThreshold(level);
        } else {
            C0059c.m78c(new StringBuffer().append("Could not convert [").append(str).append("] to Level.").toString());
        }
    }

    public void setThreshold(Level level) {
        if (level != null) {
            this.f110f = level.f124a;
            this.f111g = level;
        }
    }

    public void fireAddAppenderEvent(Category category, Appender appender) {
        if (this.f106b != null) {
            int size = this.f106b.size();
            for (int i = 0; i < size; i++) {
                this.f106b.elementAt(i);
            }
        }
    }

    public Level getThreshold() {
        return this.f111g;
    }

    public Logger getLogger(String str) {
        return getLogger(str, this.f105a);
    }

    public Logger getLogger(String str, InterfaceC0091i interfaceC0091i) {
        C0046c c0046c = new C0046c(str);
        synchronized (this.f107c) {
            Object obj = this.f107c.get(c0046c);
            if (obj == null) {
                Logger mo2a = interfaceC0091i.mo2a(str);
                mo2a.m140a(this);
                this.f107c.put(c0046c, mo2a);
                m136a(mo2a);
                return mo2a;
            } else if (obj instanceof Logger) {
                return (Logger) obj;
            } else if (obj instanceof ProvisionNode) {
                Logger mo2a2 = interfaceC0091i.mo2a(str);
                mo2a2.m140a(this);
                this.f107c.put(c0046c, mo2a2);
                ProvisionNode provisionNode = (ProvisionNode) obj;
                int size = provisionNode.size();
                for (int i = 0; i < size; i++) {
                    Logger logger = (Logger) provisionNode.elementAt(i);
                    if (!logger.parent.name.startsWith(mo2a2.name)) {
                        mo2a2.parent = logger.parent;
                        logger.parent = mo2a2;
                    }
                }
                m136a(mo2a2);
                return mo2a2;
            } else {
                return null;
            }
        }
    }

    public Enumeration getCurrentLoggers() {
        Vector vector = new Vector(this.f107c.size());
        Enumeration elements = this.f107c.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Logger) {
                vector.addElement(nextElement);
            }
        }
        return vector.elements();
    }

    public Enumeration getCurrentCategories() {
        return getCurrentLoggers();
    }

    public C0043a getRendererMap() {
        return this.f109e;
    }

    public Logger getRootLogger() {
        return this.f108d;
    }

    public boolean isDisabled(int i) {
        return this.f110f > i;
    }

    public void overrideAsNeeded(String str) {
        C0059c.m78c("The Hiearchy.overrideAsNeeded method has been deprecated.");
    }

    public void resetConfiguration() {
        getRootLogger().setLevel(Level.DEBUG);
        this.f108d.setResourceBundle(null);
        setThreshold(Level.ALL);
        synchronized (this.f107c) {
            shutdown();
            Enumeration currentLoggers = getCurrentLoggers();
            while (currentLoggers.hasMoreElements()) {
                Logger logger = (Logger) currentLoggers.nextElement();
                logger.setLevel(null);
                logger.setAdditivity(true);
                logger.setResourceBundle(null);
            }
        }
        this.f109e.m117a();
    }

    public void setDisableOverride(String str) {
        C0059c.m78c("The Hiearchy.setDisableOverride method has been deprecated.");
    }

    public void setRenderer(Class cls, InterfaceC0045c interfaceC0045c) {
        this.f109e.m115a(cls, interfaceC0045c);
    }

    public void shutdown() {
        Logger rootLogger = getRootLogger();
        rootLogger.m142a();
        synchronized (this.f107c) {
            Enumeration currentLoggers = getCurrentLoggers();
            while (currentLoggers.hasMoreElements()) {
                ((Logger) currentLoggers.nextElement()).m142a();
            }
            rootLogger.removeAllAppenders();
            Enumeration currentLoggers2 = getCurrentLoggers();
            while (currentLoggers2.hasMoreElements()) {
                ((Logger) currentLoggers2.nextElement()).removeAllAppenders();
            }
        }
    }

    /* renamed from: a */
    private final void m136a(Logger logger) {
        String str = logger.name;
        boolean z = false;
        int lastIndexOf = str.lastIndexOf(46, str.length() - 1);
        while (true) {
            int i = lastIndexOf;
            if (i < 0) {
                break;
            }
            C0046c c0046c = new C0046c(str.substring(0, i));
            Object obj = this.f107c.get(c0046c);
            if (obj == null) {
                this.f107c.put(c0046c, new ProvisionNode(logger));
            } else if (obj instanceof Category) {
                z = true;
                logger.parent = (Category) obj;
                break;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(logger);
            } else {
                new IllegalStateException(new StringBuffer().append("unexpected object type ").append(obj.getClass()).append(" in ht.").toString()).printStackTrace();
            }
            lastIndexOf = str.lastIndexOf(46, i - 1);
        }
        if (z) {
            return;
        }
        logger.parent = this.f108d;
    }
}
