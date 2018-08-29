package com.study.gupao.cglib;

/**
 * cglib代理测试类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class CglibProxyTest {
    public static void main(String[] args) {
        Takeaway takeaway = (Takeaway) new TakeawayProxy().getInstance(Takeaway.class);
        /*跟jdk动态代理一样，也会代理所有被代理对象的方法，
        但是cglib在执行代理方法时如果方法中涉及内部调用时也会一起代理，jdk的不会，比如toString()
        */
//        takeaway.equals(1);
        System.out.println(takeaway.getClass());
        takeaway.takeawayByMobile();
    }
}
