package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被监控对象
 */
public class SomeObj implements ISomeObj, Observerable{
    private List<IObserver> observers = new ArrayList<>();
    private String name;

    SomeObj(String name) {
        this.name = name;
    }

    @Override
    public void studying() {
        System.out.println("开始学习");
        notifyObservers(name + "这家伙开始学习了");
    }

    @Override
    public void playing() {
        System.out.println("玩会儿");
        notifyObservers(name + "这家伙开始玩了");
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String info) {
        for (IObserver observer : observers) {
            observer.observed(info);
        }
    }
}
