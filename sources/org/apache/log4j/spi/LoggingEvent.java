package org.apache.log4j.spi;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.Category;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0065i;
/* loaded from: input.jar:org/apache/log4j/spi/LoggingEvent.class */
public class LoggingEvent implements Serializable {

    /* renamed from: a */
    public final transient String f293a;

    /* renamed from: c */
    private transient Category f294c;
    public final String categoryName;

    /* renamed from: d */
    private transient Priority f295d;
    private String ndc;
    private Hashtable mdcCopy;
    private boolean ndcLookupRequired = true;
    private boolean mdcCopyLookupRequired = true;

    /* renamed from: e */
    private transient Object f296e;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp;
    private LocationInfo locationInfo;
    static final long serialVersionUID = -868428216207166145L;

    /* renamed from: i */
    private static Class f300i;

    /* renamed from: b */
    private static long f292b = System.currentTimeMillis();

    /* renamed from: f */
    private static Integer[] f297f = new Integer[1];

    /* renamed from: g */
    private static Class[] f298g = {Integer.TYPE};

    /* renamed from: h */
    private static Hashtable f299h = new Hashtable(3);

    public LoggingEvent(String str, Category category, Priority priority, Object obj, Throwable th) {
        this.f293a = str;
        this.f294c = category;
        this.categoryName = category.getName();
        this.f295d = priority;
        this.f296e = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th);
        }
        this.timeStamp = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final LocationInfo m18a() {
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(new Throwable(), this.f293a);
        }
        return this.locationInfo;
    }

    /* renamed from: b */
    public final Level m16b() {
        return (Level) this.f295d;
    }

    /* renamed from: c */
    public final String m14c() {
        return this.categoryName;
    }

    /* renamed from: d */
    public final Object m13d() {
        return this.f296e != null ? this.f296e : m10g();
    }

    /* renamed from: e */
    public final String m12e() {
        if (this.ndcLookupRequired) {
            this.ndcLookupRequired = false;
            this.ndc = NDC.get();
        }
        return this.ndc;
    }

    /* renamed from: a */
    public final Object m17a(String str) {
        Object obj;
        return (this.mdcCopy == null || (obj = this.mdcCopy.get(str)) == null) ? MDC.get(str) : obj;
    }

    /* renamed from: f */
    public final void m11f() {
        if (this.mdcCopyLookupRequired) {
            this.mdcCopyLookupRequired = false;
            Hashtable context = MDC.getContext();
            if (context != null) {
                this.mdcCopy = (Hashtable) context.clone();
            }
        }
    }

    /* renamed from: g */
    public final String m10g() {
        if (this.renderedMessage == null && this.f296e != null) {
            if (this.f296e instanceof String) {
                this.renderedMessage = (String) this.f296e;
            } else {
                Hierarchy hierarchy$1ce6f9a2 = this.f294c.getHierarchy$1ce6f9a2();
                if (hierarchy$1ce6f9a2 instanceof Hierarchy) {
                    this.renderedMessage = hierarchy$1ce6f9a2.getRendererMap().m114a(this.f296e);
                } else {
                    this.renderedMessage = this.f296e.toString();
                }
            }
        }
        return this.renderedMessage;
    }

    /* renamed from: h */
    public static long m9h() {
        return f292b;
    }

    /* renamed from: i */
    public final String m8i() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    /* renamed from: j */
    public final String[] m7j() {
        if (this.throwableInfo == null) {
            return null;
        }
        return this.throwableInfo.m6a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        try {
            String str = (String) objectInputStream.readObject();
            if (str == null) {
                this.f295d = Level.toLevel(readInt);
            } else {
                Method method = (Method) f299h.get(str);
                Method method2 = method;
                if (method == null) {
                    method2 = C0065i.m67b(str).getDeclaredMethod("toLevel", f298g);
                    f299h.put(str, method2);
                }
                f297f[0] = new Integer(readInt);
                this.f295d = (Level) method2.invoke(null, f297f);
            }
        } catch (Exception e) {
            C0059c.m77c("Level deserialization failed, reverting to default.", e);
            this.f295d = Level.toLevel(readInt);
        }
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(null, null);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Class<?> cls;
        m8i();
        m10g();
        m12e();
        m11f();
        m7j();
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f295d.toInt());
        Class<?> cls2 = this.f295d.getClass();
        if (f300i == null) {
            cls = m15b("org.apache.log4j.Level");
            f300i = cls;
        } else {
            cls = f300i;
        }
        if (cls2 == cls) {
            objectOutputStream.writeObject(null);
        } else {
            objectOutputStream.writeObject(cls2.getName());
        }
    }

    /* renamed from: b */
    private static Class m15b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
