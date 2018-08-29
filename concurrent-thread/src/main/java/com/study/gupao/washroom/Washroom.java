package com.study.gupao.washroom;

/**
 * 厕所类
 * 由于厕所坏了，必须等到厕所修好了才能用
 * @author BigWang
 * @date 2018/8/23
 **/
public class Washroom {

    private Object lock = new Object();

    /**
     * 厕所状态
     */
    private  boolean broke = true;

    private boolean getBroke() {
        return broke;
    }

    private void setBroke(boolean broke) {
        this.broke = broke;
    }

    /**
     * 上厕所
     * @param name
     * @throws InterruptedException
     */
    public void takeShit(String name) {
        synchronized (lock){
            //厕所坏了需要修理
            while(getBroke()){
                System.out.println(name+"得到锁");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(name+"上完了厕所");
        }
    }

    /**
     * 修理厕所
     * @throws InterruptedException
     */
    public void fix() {
        synchronized (lock){
            System.out.println("修理工得到锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setBroke(false);
            System.out.println("修理完了，可以上厕所了");
            lock.notifyAll();
        }
    }
}
