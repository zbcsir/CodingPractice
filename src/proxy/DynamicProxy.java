package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        IHello hello = new Hello();
        ProxyHander proxyHander = new ProxyHander(hello);
        IHello iHello = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                Hello.class.getInterfaces(), new ProxyHander(hello));
        iHello.sayHello();
    }
}

interface IHello {
    public void sayHello();
}

class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}

class ProxyHander implements InvocationHandler {

    private IHello hello;
    public ProxyHander(IHello hello) {
        this.hello = hello;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        Object invoke = method.invoke(hello, args);
        System.out.println("end");
        return invoke;
    }
}