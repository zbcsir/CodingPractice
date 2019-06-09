package memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// Java方法区内存溢出实验，失败？

/**
 * -XX:PermSize=1M -XX:MaxPermSize=1M
 */
public class MethodAreaOOM {
    static class OOMObject {
        int i;
    }

    private void methodAreaOOM() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
            System.out.println("created");
        }
    }

    public static void main(String[] args) {
        MethodAreaOOM m = new MethodAreaOOM();
        m.methodAreaOOM();
    }
}
