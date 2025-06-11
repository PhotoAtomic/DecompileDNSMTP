package com.synametrics.commons.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.synametrics.commons.gui.panel.a */
/* loaded from: input.jar:com/synametrics/commons/gui/panel/a.class */
public final class C0004a implements ActionListener {

    /* renamed from: a */
    private /* synthetic */ EnhancedStatusBar f4a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0004a(EnhancedStatusBar enhancedStatusBar) {
        this.f4a = enhancedStatusBar;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        EnhancedStatusBar.m217a(this.f4a);
    }
}
