package org.apache.log4j.spi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.C0059c;
/* renamed from: org.apache.log4j.spi.d */
/* loaded from: input.jar:org/apache/log4j/spi/d.class */
public final class C0086d extends Logger {
    public C0086d(Level level) {
        super("root");
        setLevel(level);
    }

    @Override // org.apache.log4j.Category
    public final void setLevel(Level level) {
        if (level == null) {
            C0059c.m79b("You have tried to set a null level to root.", new Throwable());
        } else {
            this.level = level;
        }
    }
}
