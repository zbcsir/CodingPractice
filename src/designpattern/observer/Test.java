package designpattern.observer;

public class Test {
    public static void main(String[] args) {
        SomeObj obj = new SomeObj("͢��");
        Observer observer1 = new Observer("������1��");
        Observer observer2 = new Observer("������2��");
        obj.addObserver(observer1);
        obj.addObserver(observer2);
        obj.playing();
        obj.studying();
    }
}
