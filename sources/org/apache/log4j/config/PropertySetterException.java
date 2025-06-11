package org.apache.log4j.config;
/* loaded from: input.jar:org/apache/log4j/config/PropertySetterException.class */
public class PropertySetterException extends Exception {
    protected Throwable rootCause;

    public PropertySetterException(String str) {
        super(str);
    }

    public PropertySetterException(Throwable th) {
        this.rootCause = th;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String str = message;
        if (message == null && this.rootCause != null) {
            str = this.rootCause.getMessage();
        }
        return str;
    }
}
