package com.poscoict.posledger.assets.test;

import java.util.Date;

import com.poscoict.posledger.assets.util.DateUtil;

public class MyTest {
	public static void main(String[] args) {
		System.out.println(DateUtil.formatDate(new Date(1562214781183L), "yyyy.MM.dd HH:mm:ss"));
	}
}