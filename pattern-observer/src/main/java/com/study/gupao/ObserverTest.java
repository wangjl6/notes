package com.study.gupao;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 *
 * @author 善变时光
 * @since 2018/6/26
 **/
public class ObserverTest {

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();


        Observer observer1 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

                System.out.printf("传了个参数==%s \n",arg);
                System.out.println(o.countObservers());
            }
        };

        Observer observer2 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

                System.out.printf("传了个参数==%s \n",arg);
                System.out.println(Thread.currentThread().getName());
            }
        };

        Observer observer3 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

                System.out.printf("传了个参数==%s \n",arg);
                System.out.println(o.countObservers());
            }
        };

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);
        observable.setChanged();
        observable.notifyObservers("a");
    }


    static class MyObservable extends Observable{
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
