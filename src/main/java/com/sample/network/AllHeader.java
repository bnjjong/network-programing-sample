/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/13
 */

package com.sample.network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * create on 2020/07/13.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class AllHeader {

  public static void main(String[] args) {
    args = new String[4];
    args[0] = "http://www.oreilly.com";
    args[1] = "http://www.oreilly.com/favicon.ico";
    args[2] = "https://aquerytool.com";
    args[3] = "https://google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
    for (int i=0; i < args.length; i++) {
      try {
        URL u = new URL(args[i]);
        URLConnection uc = u.openConnection();
        for (int j=1; ; j++) {
          String header = uc.getHeaderField(j);
          if(header == null) break;
          System.out.println(uc.getHeaderFieldKey(j) +  ":" + header);
        }
      } catch (MalformedURLException e) {
        System.err.println(args[i] + " is not a URL I understand");
      } catch (IOException e) {
        System.err.println(e);
      }
      System.out.println();
    }
  }

}
