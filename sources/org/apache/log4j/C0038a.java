package org.apache.log4j;

import org.apache.log4j.helpers.AbstractC0062f;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.a */
/* loaded from: input.jar:org/apache/log4j/a.class */
public final class C0038a extends AbstractC0062f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0038a(String str) {
        super(str);
    }

    @Override // org.apache.log4j.helpers.AbstractC0062f
    /* renamed from: a */
    public final void mo76a() {
        new PropertyConfigurator().doConfigure$320994e6(this.f208a, LogManager.getLoggerRepository$1ce6f9a2());
    }
}
