package org.apache.log4j;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.helpers.C0068l;
import org.apache.log4j.helpers.C0076t;
import org.apache.log4j.spi.InterfaceC0084b;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/Category.class */
public class Category implements InterfaceC0084b {
    protected String name;
    protected volatile Level level;
    protected volatile Category parent;

    /* renamed from: a */
    private static final String f91a;
    protected ResourceBundle resourceBundle;
    protected Hierarchy repository$9b94581;

    /* renamed from: b */
    private C0076t f92b;
    protected boolean additive = true;

    /* renamed from: c */
    private static Class f93c;

    /* JADX INFO: Access modifiers changed from: protected */
    public Category(String str) {
        this.name = str;
    }

    @Override // org.apache.log4j.spi.InterfaceC0084b
    public synchronized void addAppender(Appender appender) {
        if (this.f92b == null) {
            this.f92b = new C0076t();
        }
        this.f92b.addAppender(appender);
        this.repository$9b94581.fireAddAppenderEvent(this, appender);
    }

    public void assertLog(boolean z, String str) {
        if (z) {
            return;
        }
        error(str);
    }

    public void callAppenders(LoggingEvent loggingEvent) {
        int i = 0;
        Category category = this;
        while (true) {
            Category category2 = category;
            if (category2 != null) {
                synchronized (category2) {
                    if (category2.f92b != null) {
                        i += category2.f92b.m32a(loggingEvent);
                    }
                    if (!category2.additive) {
                        break;
                    }
                }
                break;
            }
            break;
            category = category2.parent;
        }
        if (i == 0) {
            this.repository$9b94581.emitNoAppenderWarning(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m142a() {
        Enumeration allAppenders = getAllAppenders();
        if (allAppenders != null) {
            while (allAppenders.hasMoreElements()) {
                Appender appender = (Appender) allAppenders.nextElement();
                if (appender instanceof InterfaceC0084b) {
                    appender.close();
                }
            }
        }
    }

    public void debug(Object obj) {
        if (!this.repository$9b94581.isDisabled(10000) && Level.DEBUG.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.DEBUG, obj, null);
        }
    }

    public void debug(Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(10000) && Level.DEBUG.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.DEBUG, obj, th);
        }
    }

    public void error(Object obj) {
        if (!this.repository$9b94581.isDisabled(40000) && Level.ERROR.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.ERROR, obj, null);
        }
    }

    public void error(Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(40000) && Level.ERROR.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.ERROR, obj, th);
        }
    }

    public static Logger exists(String str) {
        return LogManager.exists(str);
    }

    public void fatal(Object obj) {
        if (!this.repository$9b94581.isDisabled(50000) && Level.FATAL.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.FATAL, obj, null);
        }
    }

    public void fatal(Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(50000) && Level.FATAL.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.FATAL, obj, th);
        }
    }

    protected void forcedLog(String str, Priority priority, Object obj, Throwable th) {
        callAppenders(new LoggingEvent(str, this, priority, obj, th));
    }

    public boolean getAdditivity() {
        return this.additive;
    }

    public synchronized Enumeration getAllAppenders() {
        return this.f92b == null ? C0068l.m65a() : this.f92b.m35a();
    }

    public synchronized Appender getAppender(String str) {
        if (this.f92b == null || str == null) {
            return null;
        }
        return this.f92b.m34a(str);
    }

    public Level getEffectiveLevel() {
        Category category = this;
        while (true) {
            Category category2 = category;
            if (category2 == null) {
                return null;
            }
            if (category2.level != null) {
                return category2.level;
            }
            category = category2.parent;
        }
    }

    public Priority getChainedPriority() {
        Category category = this;
        while (true) {
            Category category2 = category;
            if (category2 == null) {
                return null;
            }
            if (category2.level != null) {
                return category2.level;
            }
            category = category2.parent;
        }
    }

    public static Enumeration getCurrentCategories() {
        return LogManager.getCurrentLoggers();
    }

    public Hierarchy getHierarchy$1ce6f9a2() {
        return this.repository$9b94581;
    }

    public Hierarchy getLoggerRepository$1ce6f9a2() {
        return this.repository$9b94581;
    }

    public static Category getInstance(String str) {
        return LogManager.getLogger(str);
    }

    public static Category getInstance(Class cls) {
        return LogManager.getLogger(cls);
    }

    public final String getName() {
        return this.name;
    }

    public final Category getParent() {
        return this.parent;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final Level getPriority() {
        return this.level;
    }

    public static final Category getRoot() {
        return LogManager.getRootLogger();
    }

    public ResourceBundle getResourceBundle() {
        Category category = this;
        while (true) {
            Category category2 = category;
            if (category2 == null) {
                return null;
            }
            if (category2.resourceBundle != null) {
                return category2.resourceBundle;
            }
            category = category2.parent;
        }
    }

    protected String getResourceBundleString(String str) {
        ResourceBundle resourceBundle = getResourceBundle();
        if (resourceBundle == null) {
            return null;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            error(new StringBuffer().append("No resource is associated with key \"").append(str).append("\".").toString());
            return null;
        }
    }

    public void info(Object obj) {
        if (!this.repository$9b94581.isDisabled(20000) && Level.INFO.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.INFO, obj, null);
        }
    }

    public void info(Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(20000) && Level.INFO.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.INFO, obj, th);
        }
    }

    public boolean isAttached(Appender appender) {
        if (appender == null || this.f92b == null) {
            return false;
        }
        return this.f92b.m33a(appender);
    }

    public boolean isDebugEnabled() {
        if (this.repository$9b94581.isDisabled(10000)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isEnabledFor(Priority priority) {
        if (this.repository$9b94581.isDisabled(priority.f124a)) {
            return false;
        }
        return priority.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isInfoEnabled() {
        if (this.repository$9b94581.isDisabled(20000)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(getEffectiveLevel());
    }

    public void l7dlog(Priority priority, String str, Throwable th) {
        if (!this.repository$9b94581.isDisabled(priority.f124a) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            String str2 = resourceBundleString;
            if (resourceBundleString == null) {
                str2 = str;
            }
            forcedLog(f91a, priority, str2, th);
        }
    }

    public void l7dlog(Priority priority, String str, Object[] objArr, Throwable th) {
        if (!this.repository$9b94581.isDisabled(priority.f124a) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            forcedLog(f91a, priority, resourceBundleString == null ? str : MessageFormat.format(resourceBundleString, objArr), th);
        }
    }

    public void log(Priority priority, Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(priority.f124a) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, priority, obj, th);
        }
    }

    public void log(Priority priority, Object obj) {
        if (!this.repository$9b94581.isDisabled(priority.f124a) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, priority, obj, null);
        }
    }

    public void log(String str, Priority priority, Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(priority.f124a) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(str, priority, obj, th);
        }
    }

    public synchronized void removeAllAppenders() {
        if (this.f92b != null) {
            this.f92b.m31b();
            this.f92b = null;
        }
    }

    public synchronized void removeAppender(Appender appender) {
        if (appender == null || this.f92b == null) {
            return;
        }
        this.f92b.m29b(appender);
    }

    public synchronized void removeAppender(String str) {
        if (str == null || this.f92b == null) {
            return;
        }
        this.f92b.m30b(str);
    }

    public void setAdditivity(boolean z) {
        this.additive = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m140a(Hierarchy hierarchy) {
        this.repository$9b94581 = hierarchy;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setPriority(Priority priority) {
        this.level = (Level) priority;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public static void shutdown() {
        LogManager.shutdown();
    }

    public void warn(Object obj) {
        if (!this.repository$9b94581.isDisabled(30000) && Level.WARN.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.WARN, obj, null);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (!this.repository$9b94581.isDisabled(30000) && Level.WARN.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(f91a, Level.WARN, obj, th);
        }
    }

    /* renamed from: a */
    private static Class m141a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        if (f93c == null) {
            cls = m141a("org.apache.log4j.Category");
            f93c = cls;
        } else {
            cls = f93c;
        }
        f91a = cls.getName();
    }
}
