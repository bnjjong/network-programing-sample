/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.net.MalformedURLException;
import java.net.URL;

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
public class URLSplitter {

  public static void main(String[] args) {
    args = new String[4];
    args[0] = "ftp://mp3:mp3@138.247.121.61:21000/c%3a/";
    args[1] = "http://www.oreilly.com";
    args[2] = "http://www.ibiblio.org/nywc/compositions.phtml?category=Piano";
    args[3] = "http://admin@www.blackstar.com:8080/";
    for (int i=0; i < args.length; i++) {
      System.out.println("start>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      try {
        URL u = new URL(args[i]);
        System.out.println("This URL is " + u);
        System.out.println("This Scheme is " + u.getProtocol());
        System.out.println("This user info is " + u.getUserInfo());

        String host = u.getHost();
        if (host != null) {
          int atSign = host.indexOf("@");
          if (atSign != -1) host = host.substring(atSign+1);
          System.out.println("The host is " + host);
        } else {
          System.out.println("The host is null");
        }
        System.out.println("The port is " + u.getPort());
        System.out.println("The path is " + u.getPath());
        System.out.println("The ref is " + u.getRef());
        System.out.println("The query string is " + u.getQuery());

      } catch (MalformedURLException e) {
        System.err.println(args[i]+ " is not a URL I understand.");
      }
      System.out.println("end>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println("");
    }
  }

}
