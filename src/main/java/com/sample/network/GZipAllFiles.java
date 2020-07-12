/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/11
 */

package com.sample.network;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class GZipAllFiles {
  public final static int THREAD_COUNT = 4;

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "output.txt";
    ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

    for(String filename : args) {
      File f = new File(filename);
      if(f.exists()) {
        if(f.isDirectory()) {
          File[] files = f.listFiles();
          for (int i=0; i<files.length; i++) {
            if(!files[i].isDirectory()) { // 디렉터리 아래에 있는 디렉터리는 처리 하지 않음.
              Runnable task = new GZipRunnable(files[i]);
              pool.submit(task);
            }
          }
        } else {
          Runnable task = new GZipRunnable(f);
          pool.submit(task);
        }
      }
    }
    // 대기중인 작업을 중단하진 않는다.
    // 추가적인 작업이 내부 큐에 추가될 수 없으며 대기중인 작업이 모두 끝나면 즉시 종료 됨.
    pool.shutdown();
  }

}
