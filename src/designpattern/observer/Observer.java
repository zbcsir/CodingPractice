package designpattern.observer;

public class Observer implements IObserver {
    private String name;

    Observer(String name) {
        this.name = name;
    }

    @Override
    public void observed(String info) {
        System.out.println("���� "+ name + " �ı��棺" + info);
    }
}
