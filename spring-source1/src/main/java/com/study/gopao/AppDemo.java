package com.study.gopao;

import org.springframework.stereotype.Component;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/17
 **/
@Component
public class AppDemo {
	public void sayHello() throws Exception {
		System.out.println("hello world");
		throw  new  Exception("11111111");
	}
}
