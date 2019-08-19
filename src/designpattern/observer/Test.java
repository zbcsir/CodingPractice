package designpattern.observer;

public class Test {
    public static void main(String[] args) {
        SomeObj obj = new SomeObj("廷清");
        Observer observer1 = new Observer("监视者1号");
        Observer observer2 = new Observer("监视者2号");
        obj.addObserver(observer1);
        obj.addObserver(observer2);
        obj.playing();
        obj.studying();
    }
}
