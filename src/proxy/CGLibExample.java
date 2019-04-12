package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class ClassForProxy {
    public void method1() {
        System.out.println("method1 run");
    }

    public void method2() {
        System.out.println("method2 run");
    }
}

public class CGLibExample implements MethodInterceptor {

    private Object obj;

    public Object getInstance(Object obj) {
        this.obj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("method run before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("method run after");
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        ClassForProxy classForProxy = (ClassForProxy) new CGLibExample().getInstance(new ClassForProxy());
        classForProxy.method1();
        new ClassForProxy().method2();
    }
}