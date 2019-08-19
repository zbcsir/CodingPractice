package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ض���
 */
public class SomeObj implements ISomeObj, Observerable{
    private List<IObserver> observers = new ArrayList<>();
    private String name;

    SomeObj(String name) {
        this.name = name;
    }

    @Override
    public void studying() {
        System.out.println("��ʼѧϰ");
        notifyObservers(name + "��һ￪ʼѧϰ��");
    }

    @Override
    public void playing() {
        System.out.println("����");
        notifyObservers(name + "��һ￪ʼ����");
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
