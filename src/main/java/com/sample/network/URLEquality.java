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
public class URLEquality {

  public static void main(String[] args) {
    try {
//      URL u1 = new URL("http://www.ibiblio.org/");
//      URL u2 = new URL("http://ibiblio.org/");

      URL u1 = new URL("http://www.ncsa.uiuc.edu/HTMLPrimer.html#GS");
      URL u2 = new URL("http://www.ncsa.uiuc.edu/HTMLPrimer.html#HD");
      if(u2.equals(u1)) {
        System.out.println(u2 + " is the same as " + u1);
      } else {
        System.out.println(u2 + " is not the same as " + u1);
      }

      // 부위 지정자는 고려하지 않음.
      if(u2.sameFile(u1)) {
        System.out.println(u2 + " is the same file as " + u1);
      } else {
        System.out.println(u2 + " is not the same file as " + u1);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

}
