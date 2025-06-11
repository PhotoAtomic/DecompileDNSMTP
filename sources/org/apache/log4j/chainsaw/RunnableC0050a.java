package org.apache.log4j.chainsaw;
/* renamed from: org.apache.log4j.chainsaw.a */
/* loaded from: input.jar:org/apache/log4j/chainsaw/a.class */
final class RunnableC0050a implements Runnable {

    /* renamed from: a */
    private final MyTableModel f174a;

    private RunnableC0050a(MyTableModel myTableModel, byte b) {
        this.f174a = myTableModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
            }
            synchronized (MyTableModel.m103a(this.f174a)) {
                if (!MyTableModel.m99b(this.f174a)) {
                    boolean z = true;
                    boolean z2 = false;
                    for (C0051b c0051b : MyTableModel.m97c(this.f174a)) {
                        MyTableModel.m96d(this.f174a).add(c0051b);
                        z = z && c0051b == MyTableModel.m96d(this.f174a).first();
                        z2 = z2 || MyTableModel.m102a(this.f174a, c0051b);
                    }
                    MyTableModel.m97c(this.f174a).clear();
                    if (z2) {
                        MyTableModel.m101a(this.f174a, z);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0050a(MyTableModel myTableModel) {
        this(myTableModel, (byte) 0);
    }
}
