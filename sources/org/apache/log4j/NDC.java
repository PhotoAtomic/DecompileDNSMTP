package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import org.apache.log4j.helpers.C0059c;
/* loaded from: input.jar:org/apache/log4j/NDC.class */
public class NDC {

    /* renamed from: a */
    private static Hashtable f119a = new Hashtable();

    /* renamed from: b */
    private static int f120b = 0;

    private NDC() {
    }

    public static void clear() {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        if (stack != null) {
            stack.setSize(0);
        }
    }

    public static Stack cloneStack() {
        Object obj = f119a.get(Thread.currentThread());
        if (obj == null) {
            return null;
        }
        return (Stack) ((Stack) obj).clone();
    }

    public static void inherit(Stack stack) {
        if (stack != null) {
            f119a.put(Thread.currentThread(), stack);
        }
    }

    public static String get() {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return ((C0055d) stack.peek()).f195a;
    }

    public static int getDepth() {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        if (stack == null) {
            return 0;
        }
        return stack.size();
    }

    public static String pop() {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        return (stack == null || stack.isEmpty()) ? "" : ((C0055d) stack.pop()).f196b;
    }

    public static String peek() {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        return (stack == null || stack.isEmpty()) ? "" : ((C0055d) stack.peek()).f196b;
    }

    public static void push(String str) {
        Thread currentThread = Thread.currentThread();
        Stack stack = (Stack) f119a.get(currentThread);
        if (stack == null) {
            C0055d c0055d = new C0055d(str, null);
            Stack stack2 = new Stack();
            f119a.put(currentThread, stack2);
            stack2.push(c0055d);
        } else if (stack.isEmpty()) {
            stack.push(new C0055d(str, null));
        } else {
            stack.push(new C0055d(str, (C0055d) stack.peek()));
        }
    }

    public static void remove() {
        f119a.remove(Thread.currentThread());
        synchronized (f119a) {
            int i = f120b + 1;
            f120b = i;
            if (i <= 5) {
                return;
            }
            f120b = 0;
            int i2 = 0;
            Vector vector = new Vector();
            Enumeration keys = f119a.keys();
            while (keys.hasMoreElements() && i2 <= 4) {
                Thread thread = (Thread) keys.nextElement();
                if (thread.isAlive()) {
                    i2++;
                } else {
                    i2 = 0;
                    vector.addElement(thread);
                }
            }
            int size = vector.size();
            for (int i3 = 0; i3 < size; i3++) {
                Thread thread2 = (Thread) vector.elementAt(i3);
                C0059c.m83a(new StringBuffer().append("Lazy NDC removal for thread [").append(thread2.getName()).append("] (").append(f119a.size()).append(").").toString());
                f119a.remove(thread2);
            }
        }
    }

    public static void setMaxDepth(int i) {
        Stack stack = (Stack) f119a.get(Thread.currentThread());
        if (stack == null || i >= stack.size()) {
            return;
        }
        stack.setSize(i);
    }
}
