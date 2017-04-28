/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池
 * <p>
 * Title: ThreadPoll.java
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: Tianjian
 * </p>
 * <p>
 * team: TianjianTeam
 * </p>
 * <p>
 * 
 * @author: cheng
 *          </p>
 * @date 2014-7-2下午5:51:20
 * @version 1.0
 * 
 */
public class ThreadExecutor {
	
	public static final ExecutorService THREAD_EXECUTOR = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
	
	private ThreadExecutor() {}
	
	public static void execute(Runnable runnable) {
		THREAD_EXECUTOR.execute(runnable);
		// T type, E entity, K key, V value
		// <ID, ENTITY>
	}

	public static <V> void executeCalls(Collection<Callable<V>> callables, ExecuteCallBack callBack) {
		try {
			List<Future<V>> futureList = THREAD_EXECUTOR.invokeAll(callables);
			if(callBack != null) callBack.callBack(futureList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static <V> V executeResult(Callable<V> callable) {
		try {
			return THREAD_EXECUTOR.submit(callable).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <V> V executeResult(Runnable runnable) {
		V retV = null;
		try {
			retV = (V) THREAD_EXECUTOR.submit(runnable).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retV;
	}
	
	public interface ExecuteCallBack<V> {
		void callBack(List<Future<V>> futureList);
	}
	
}
