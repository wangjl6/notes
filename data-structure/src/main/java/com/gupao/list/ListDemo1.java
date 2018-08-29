package com.gupao.list;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 主要区分各种list区别
 *
 * @author BigWang
 * @createTime 2018/8/28
 **/
public class ListDemo1 {

    public static void main(String[] args) {




        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add("");
        arrayList.add("");
        arrayList.add(null);
        arrayList.add(null);

        System.out.println(arrayList);
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add("");
        linkedList.add("");
        linkedList.add(null);
        linkedList.add(null);
        System.out.println(linkedList);


    }
}
