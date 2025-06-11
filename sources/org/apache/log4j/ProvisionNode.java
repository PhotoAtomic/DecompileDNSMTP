package org.apache.log4j;

import java.util.Vector;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: input.jar:org/apache/log4j/ProvisionNode.class */
public class ProvisionNode extends Vector {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProvisionNode(Logger logger) {
        addElement(logger);
    }
}
