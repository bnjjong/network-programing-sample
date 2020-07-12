/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * create on 2020/07/12.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class PooledWeblog {

  private final static int NUM_THREADS = 4;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
    Queue<LogEntry> results = new LinkedList<>();
    try(
        BufferedReader in = new BufferedReader(
          new InputStreamReader(
              new FileInputStream(args[0]), StandardCharsets.UTF_8
          )
        );
    ){
      for(String entry = in.readLine(); entry != null; entry = in.readLine()) {
        LookupTask task = new LookupTask(entry);
        Future<String> future = executor.submit(task);
        LogEntry result = new LogEntry(entry, future);
        results.add(result);
      }

      // 결과 출력 시작. 출력할 결과 없는 경우 매번 블록 된다.
      for (LogEntry result : results) {
        try {
          System.out.println(result.future.get());
        } catch (InterruptedException | ExecutionException e) {
          System.out.println(result.original);
        }
      }
      executor.shutdown();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static class LogEntry {
    String original;
    Future<String> future;

    public LogEntry(String original, Future<String> future) {
      this.original = original;
      this.future = future;
    }
  }

}


