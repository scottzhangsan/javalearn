package com.java.learn.concurreny.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 原子性 synchronized 
 * 1：修饰代码块，大括号括起来的代码，作用于调用的对象
 * 2:修饰方法，整个方法，作用于调用的对象
 * 3：修饰静态方法。整个静态方法，作用于所有的对象
 * 4：修饰类，括号括起来的部分，作用于所有的对象
 * @author yzhang98
 *
 */
public class Synchronize02 {
	
	private static Logger logger = LoggerFactory.getLogger(Synchronize02.class) ;
	
	public static void main(String[] args) {
		Synchronize02 test01 = new Synchronize02();
		Synchronize02 test02 = new Synchronize02() ;
		ExecutorService executorService = Executors.newCachedThreadPool() ;
		executorService.execute(()->test01.test01(1));
		executorService.execute(()->test02.test01(2));
		executorService.shutdown(); 
		
	}
	
	/**
	 * 修饰代码块
	 */
	public void test01(int j){
		synchronized (Synchronize02.class) {
			for (int i = 0; i < 10; i++) {
				logger.info("i的值为，{},{}",j,i);
			}
		}
	}
	/**
	 * 修饰整个方法
	 */
	public synchronized static void test02(int j){
		for (int i = 0; i < 10; i++) {
			logger.info("i的值为，{},{}",j,i);
		}
	}
	
	

}
