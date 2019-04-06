package com.java.learn.singleon;
/**
 * 2:懒汉模式，非线程安全的
 * @author yzhang98
 *
 */
public class Singleon02 {
	//私有的构造方法
	private Singleon02(){
		
	}
	//静态变量
	private static Singleon02 singleon02 =  null ;
	
	/**
	 * 非线程安全的，当两个线程同时判断出 singleon为null的时候，会同时初始化两个对象
	 * @return
	 */
	public static Singleon02 getSingleon(){
		if (singleon02 == null ) {
			return new Singleon02() ;
		}
		return singleon02 ;
	}

}
