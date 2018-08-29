package com.gupao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/28
 **/
public class MapDemo1 {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Collections.synchronizedMap(hashMap);
        hashMap.put(null,1);
        hashMap.put(1,1);
        hashMap.put(2,1);
        hashMap.put("1",1);
        hashMap.put("1",4);
        System.out.println(hashMap);


        TreeMap treeMap = new TreeMap();
//        treeMap.put(null,1);
        treeMap.put("5",2);
        treeMap.put("1",1);
        treeMap.put("2",1);
        treeMap.put("3",2);
        System.out.println(treeMap);

        Hashtable hashtable = new Hashtable();

        hashtable.put(1,1);
        hashtable.put(4,1);
        hashtable.put(3,2);
        hashtable.put(5,2);
        System.out.println(hashtable);

    }
}
