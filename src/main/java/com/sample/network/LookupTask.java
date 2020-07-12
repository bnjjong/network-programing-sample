/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

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
public class LookupTask implements Callable<String> {

  private String line;

  public LookupTask(String line) {
    this.line = line;
  }

  @Override
  public String call() throws Exception {
    try {
      // ip 주소 분리
      int index = line.indexOf(' ');
      String address = line.substring(0, index);
      String theRest = line.substring(index);
      String hostname = InetAddress.getByName(address).getHostName();
      return hostname + " " + theRest;
    } catch (UnknownHostException e) {
      return line;
    }
  }
}
