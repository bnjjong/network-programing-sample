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
public class SpamCheck {
  public static final String BLACKHOLE = "sbl.spamhaus.org";

  public static void main(String[] args) {
    args = new String[3];
    args[0] = "207.34.56.23";
    args[1] = "125.12.32.4";
    args[2] = "130.130.130.130";
    for (String arg : args){
      if(isSpammer(arg)) {
        System.out.println(arg + " is a known spammer!");
      } else {
        System.out.println(arg + " appears legitimate!");
      }
    }
  }

  private static boolean isSpammer(String arg) {
    try {
      InetAddress address = InetAddress.getByName(arg);
      byte[] quad = address.getAddress();
      String query = BLACKHOLE;
      for (byte octet : quad) {
        int unsignedByte = octet < 0 ? octet + 256 : octet;
        query = unsignedByte + "." + query;
      }
      InetAddress.getByName(query);
      return true;
    } catch (UnknownHostException e) {
      return false;
    }
  }

}
