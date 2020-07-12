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
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
public class Weblog {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "web.log";
    try (FileInputStream fin = new FileInputStream(args[0]);
        Reader in = new InputStreamReader(fin);
        BufferedReader bin = new BufferedReader(in);
    ) {
      for (String entry = bin.readLine();
        entry != null;
        entry = bin.readLine() ) {
        // ip 주소 분리
        int index = entry.indexOf(' ');
        String ip = entry.substring(0, index);
        System.out.println("ip is "+ip);
        String thRest = entry.substring(index);
        System.out.println("rest is "+thRest);

        // dns 에 호스트네임 쿼리 그리고 출력
        try {
          InetAddress address = InetAddress.getByName(ip);
          System.out.println(address.getHostName() + thRest);
        } catch (UnknownHostException ex) {
          System.err.println(entry);
        }
      }
    } catch (IOException e) {
      System.err.println("Exception: " + e);
    }
  }

}
