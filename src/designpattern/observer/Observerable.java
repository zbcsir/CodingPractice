package designpattern.observer;

public interface Observerable {
    void addObserver(IObserver IObserver);
    void delObserver(IObserver IObserver);
    void notifyObservers(String info);
}
