package com.java.learn.singleon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 4:线程安全的单列运用 enum 
 * @author yzhang98
 *
 */
public class Singleon04 {
	//私有的构造方法
	private Singleon04(){
		
	}
	
	public static Singleon04 getSingleon(){
		return Instance.INSTANCE.getSingleon04() ;
	}
	
	enum Instance {
		INSTANCE ;
		
		private  Singleon04 singleon04 = null ;
		
		private Instance() {
			singleon04 = new Singleon04() ;
		}

		public Singleon04 getSingleon04() {
			return singleon04;
		}
			
		
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10) ;
		
		for (int i = 0; i < 10; i++) {
		executorService.execute(()->System.out.println(Singleon04.getSingleon()));
		}
		executorService.shutdown();
	}

}
