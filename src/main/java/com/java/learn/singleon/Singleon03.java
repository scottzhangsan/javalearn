package com.java.learn.singleon;
/**
 * 3:线程安全的懒汉模式
 * @author yzhang98
 *
 */
public class Singleon03 {
	//私有的构造方法
	private Singleon03(){
		
	}
	
	//静态变量，加入 volatile ,防止指令重排序
	private static  volatile Singleon03 singleon03 =  null ;
	
	public static Singleon03 getSingleon(){
		if (singleon03 == null ) {
			synchronized (Singleon03.class) {
				if (singleon03 == null ) {
					singleon03 = new Singleon03() ;
				}
			}
		}
		return singleon03 ;
	}

}
