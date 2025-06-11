package com.synametrics.devnull.panel;

import com.synametrics.commons.util.C0015d;
import javax.swing.JLabel;
/* renamed from: com.synametrics.devnull.panel.c */
/* loaded from: input.jar:com/synametrics/devnull/panel/c.class */
final class RunnableC0034c implements Runnable {

    /* renamed from: a */
    private /* synthetic */ MainPanel f80a;

    /* renamed from: b */
    private final /* synthetic */ String f81b;

    /* renamed from: c */
    private final /* synthetic */ byte[] f82c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0034c(MainPanel mainPanel, String str, byte[] bArr) {
        this.f80a = mainPanel;
        this.f81b = str;
        this.f82c = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        i = this.f80a.lineCount;
        if (i > 1000) {
            this.f80a.txtMessages.setText("");
            this.f80a.txtMessages.append("Messages cleared to save memory\r\n");
            this.f80a.lineCount = 0;
        }
        MainPanel mainPanel = this.f80a;
        i2 = mainPanel.lineCount;
        mainPanel.lineCount = i2 + 1;
        this.f80a.txtMessages.append(String.valueOf(C0015d.m201a(System.currentTimeMillis())) + " " + this.f81b + C0015d.f25a);
        this.f80a.txtLastMessage.setText(this.f82c.length > 32768 ? new String(this.f82c, 0, 32768) : new String(this.f82c));
        JLabel jLabel = this.f80a.lblMessageCount;
        StringBuilder sb = new StringBuilder();
        i3 = this.f80a.messageCount;
        jLabel.setText(sb.append(i3).toString());
        MainPanel.m157a(this.f80a, this.f82c);
    }
}
