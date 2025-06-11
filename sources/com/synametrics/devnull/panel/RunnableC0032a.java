package com.synametrics.devnull.panel;

import com.synametrics.commons.util.C0015d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.synametrics.devnull.panel.a */
/* loaded from: input.jar:com/synametrics/devnull/panel/a.class */
public final class RunnableC0032a implements Runnable {

    /* renamed from: a */
    private /* synthetic */ MainPanel f76a;

    /* renamed from: b */
    private final /* synthetic */ String f77b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0032a(MainPanel mainPanel, String str) {
        this.f76a = mainPanel;
        this.f77b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        i = this.f76a.logLineCount;
        if (i > 5000) {
            this.f76a.txtSmtpLog.setText("");
            this.f76a.txtSmtpLog.append("Messages cleared to save memory\r\n");
            this.f76a.logLineCount = 0;
        }
        MainPanel mainPanel = this.f76a;
        i2 = mainPanel.logLineCount;
        mainPanel.logLineCount = i2 + 1;
        this.f76a.txtSmtpLog.append(String.valueOf(this.f77b) + C0015d.f25a);
    }
}
