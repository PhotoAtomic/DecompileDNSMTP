package com.synametrics.devnull.panel;

import com.synametrics.commons.util.C0015d;
import java.awt.Component;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.synametrics.devnull.panel.b */
/* loaded from: input.jar:com/synametrics/devnull/panel/b.class */
public final class RunnableC0033b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Component f78a;

    /* renamed from: b */
    private final /* synthetic */ String f79b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0033b(MainPanel mainPanel, Component component, String str) {
        this.f78a = component;
        this.f79b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0015d.m200a(this.f78a, this.f79b);
    }
}
