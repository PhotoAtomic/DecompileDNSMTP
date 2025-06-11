package com.synametrics.devnull.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.synametrics.devnull.panel.d */
/* loaded from: input.jar:com/synametrics/devnull/panel/d.class */
public final class C0035d implements ActionListener {

    /* renamed from: a */
    private /* synthetic */ MainPanel f83a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0035d(MainPanel mainPanel) {
        this.f83a = mainPanel;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        this.f83a.txtCacheDir.setEnabled(this.f83a.chkSaveMessages.isSelected());
    }
}
