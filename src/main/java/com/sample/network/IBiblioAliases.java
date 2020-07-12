/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/11
 */

package com.sample.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
public class IBiblioAliases {

  public static void main(String[] args) {
    try{
      InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
      InetAddress helios = InetAddress.getByName("helios.ibiblio.org");
      if(ibiblio.equals(helios)) {
        System.out.println("www.ibiblio.org is the same as helios.ibiblio.org");
      } else {
        System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
      }
    } catch (UnknownHostException e) {
      System.err.println("host lookup failed");
    }
  }

}
