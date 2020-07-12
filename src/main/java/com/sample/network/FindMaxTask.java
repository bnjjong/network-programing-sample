/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/11
 */

package com.sample.network;

import java.util.concurrent.Callable;

/**
 * create on 2020/07/11.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class FindMaxTask implements Callable<Integer> {
  private int[] data;
  private int start;
  private int end;

  public FindMaxTask(int[] data, int start, int end) {
    this.data = data;
    this.start = start;
    this.end = end;
  }

  @Override
  public Integer call() throws Exception {
    int max = Integer.MIN_VALUE;
    for (int i=start; i < end; i++) {
      if(data[i] > max) max = data[i];
    }
    return max;
  }
}
