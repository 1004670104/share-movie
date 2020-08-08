package com.cn.share.movie.web.designPattern.observer;


import java.util.ArrayList;
import java.util.List;

//抽象观察者
interface Observer{
    void response();
}
//具体观察者
class ConcreteObserver1 implements Observer{

    @Override
    public void response() {
        System.out.println("notify ConcreteObserver1");
    }
}
//具体观察者
class ConcreteObserver2 implements Observer{

    @Override
    public void response() {
        System.out.println("notify ConcreteObserver2");
    }
}
//抽象目标
abstract class subject{
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public abstract void notifyObServer();

}
//具体目标
class ConcreteSubject extends subject{

    @Override
    public void notifyObServer() {
        for (Observer observer : observers) {
            observer.response();
        }
    }

}
public class ObserverPattern {
    public static void main(String[] args) {
        subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObServer();
     }
}
