package org.apache.log4j.chainsaw;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Category;
import org.apache.log4j.Priority;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: input.jar:org/apache/log4j/chainsaw/MyTableModel.class */
public class MyTableModel extends AbstractTableModel {

    /* renamed from: a */
    private static final Category f166a;

    /* renamed from: b */
    private static final Comparator f167b;

    /* renamed from: c */
    private static final String[] f168c;

    /* renamed from: d */
    private static final C0051b[] f169d;

    /* renamed from: e */
    private static final DateFormat f170e;
    private final Object mLock = new Object();
    private final SortedSet mAllEvents = new TreeSet(f167b);
    private C0051b[] mFilteredEvents = f169d;
    private final List mPendingEvents = new ArrayList();
    private boolean mPaused = false;
    private String mThreadFilter = "";
    private String mMessageFilter = "";
    private String mNDCFilter = "";
    private String mCategoryFilter = "";
    private Priority mPriorityFilter = Priority.DEBUG;

    /* renamed from: f */
    private static Class f171f;

    /* renamed from: g */
    private static Class f172g;

    /* renamed from: h */
    private static Class f173h;

    MyTableModel() {
        Thread thread = new Thread(new RunnableC0050a(this));
        thread.setDaemon(true);
        thread.start();
    }

    public int getRowCount() {
        int length;
        synchronized (this.mLock) {
            length = this.mFilteredEvents.length;
        }
        return length;
    }

    public int getColumnCount() {
        return f168c.length;
    }

    public String getColumnName(int i) {
        return f168c[i];
    }

    public Class getColumnClass(int i) {
        if (i == 2) {
            if (f172g == null) {
                Class m104a = m104a("java.lang.Boolean");
                f172g = m104a;
                return m104a;
            }
            return f172g;
        } else if (f173h == null) {
            Class m104a2 = m104a("java.lang.Object");
            f173h = m104a2;
            return m104a2;
        } else {
            return f173h;
        }
    }

    public Object getValueAt(int i, int i2) {
        synchronized (this.mLock) {
            C0051b c0051b = this.mFilteredEvents[i];
            if (i2 == 0) {
                return f170e.format(new Date(c0051b.m95a()));
            } else if (i2 == 1) {
                return c0051b.m94b();
            } else if (i2 == 2) {
                return c0051b.m89g() == null ? Boolean.FALSE : Boolean.TRUE;
            } else if (i2 == 3) {
                return c0051b.m93c();
            } else if (i2 == 4) {
                return c0051b.m92d();
            } else {
                return c0051b.m90f();
            }
        }
    }

    /* renamed from: a */
    public final void m100a(C0051b c0051b) {
        synchronized (this.mLock) {
            this.mPendingEvents.add(c0051b);
        }
    }

    /* renamed from: b */
    private boolean m98b(C0051b c0051b) {
        if (!c0051b.m94b().isGreaterOrEqual(this.mPriorityFilter) || c0051b.m91e().indexOf(this.mThreadFilter) < 0 || c0051b.m93c().indexOf(this.mCategoryFilter) < 0) {
            return false;
        }
        if (this.mNDCFilter.length() == 0 || (c0051b.m92d() != null && c0051b.m92d().indexOf(this.mNDCFilter) >= 0)) {
            String m90f = c0051b.m90f();
            return m90f == null ? this.mMessageFilter.length() == 0 : m90f.indexOf(this.mMessageFilter) >= 0;
        }
        return false;
    }

    /* renamed from: a */
    private static Class m104a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Object m103a(MyTableModel myTableModel) {
        return myTableModel.mLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m99b(MyTableModel myTableModel) {
        return myTableModel.mPaused;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static List m97c(MyTableModel myTableModel) {
        return myTableModel.mPendingEvents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static SortedSet m96d(MyTableModel myTableModel) {
        return myTableModel.mAllEvents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m102a(MyTableModel myTableModel, C0051b c0051b) {
        return myTableModel.m98b(c0051b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m101a(MyTableModel myTableModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int size = myTableModel.mAllEvents.size();
        for (C0051b c0051b : myTableModel.mAllEvents) {
            if (myTableModel.m98b(c0051b)) {
                arrayList.add(c0051b);
            }
        }
        C0051b c0051b2 = myTableModel.mFilteredEvents.length == 0 ? null : myTableModel.mFilteredEvents[0];
        myTableModel.mFilteredEvents = (C0051b[]) arrayList.toArray(f169d);
        if (!z || c0051b2 == null) {
            myTableModel.fireTableDataChanged();
        } else {
            int indexOf = arrayList.indexOf(c0051b2);
            if (indexOf < 1) {
                f166a.warn("In strange state");
                myTableModel.fireTableDataChanged();
            } else {
                myTableModel.fireTableRowsInserted(0, indexOf - 1);
            }
        }
        f166a.debug(new StringBuffer().append("Total time [ms]: ").append(System.currentTimeMillis() - currentTimeMillis).append(" in update, size: ").append(size).toString());
    }

    static {
        Class cls;
        if (f171f == null) {
            cls = m104a("org.apache.log4j.chainsaw.MyTableModel");
            f171f = cls;
        } else {
            cls = f171f;
        }
        f166a = Category.getInstance(cls);
        f167b = new C0052c();
        f168c = new String[]{"Time", "Priority", "Trace", "Category", "NDC", "Message"};
        f169d = new C0051b[0];
        f170e = DateFormat.getDateTimeInstance(3, 2);
    }
}
