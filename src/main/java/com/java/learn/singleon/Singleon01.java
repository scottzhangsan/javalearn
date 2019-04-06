package com.java.learn.singleon;
/**
 * 1:恶汉模式，线程安全的
 * @author yzhang98
 *
 */
public class Singleon01 {
	//私有的构造方法
	private Singleon01(){
		
	}
	//静态变量，类加载的时候，初始化
	private static Singleon01 singleon01 = new Singleon01() ;
	
	public static Singleon01 getSingleon(){
		return singleon01 ;
	}

}
