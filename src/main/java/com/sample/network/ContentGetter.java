/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.io.IOException;
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
public class ContentGetter {

  public static void main(String[] args) {
    args = new String[1];
//    args[0] = "http://www.naver.com";
    args[0] = "https://upload.wikimedia.org/wikipedia/commons/7/7d/IU_MelOn_Music_Awards_2017_06.jpg"; // URLImageSource
    if(args.length > 0) {
      try {
        URL u = new URL(args[0]);
        Object o = u.getContent();
        System.out.println("I got a " + o.getClass().getName());
      } catch (MalformedURLException e) {
        System.err.println(args[0] + " is not a parseable URL");
      } catch (IOException e) {
        System.err.println(e);
      }
    }
  }

}
