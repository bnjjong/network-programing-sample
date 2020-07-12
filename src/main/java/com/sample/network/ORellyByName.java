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
public class ORellyByName {

  public static void main(String[] args) {
    try {
      InetAddress address = InetAddress.getByName("aquerytool.com");
      System.out.println(address);

      address = InetAddress.getByName("222.112.149.179");
      System.out.println("hostName : " + address.getHostName());

      InetAddress[] addresses = InetAddress.getAllByName("aquerytool.com");
      for (InetAddress address1 : addresses) {
        System.out.println(address1);
      }

      InetAddress me = InetAddress.getLocalHost();
      System.out.println("my address is " +me.getHostAddress());
      byte[] addressByte = me.getAddress();
      if(addressByte.length == 4 ) {
        System.out.println("address version is IPv4");
      } else if(addressByte.length == 16 ) {
        System.out.println("address version is IPv6");
      } else {
        System.out.println("unknown address");
      }

      InetAddress ia = InetAddress.getByName("222.112.149.179");
      System.out.println(ia.getCanonicalHostName());
    } catch (UnknownHostException e) {
      System.err.println("Could not find www.oreilly.com");
    }
  }

}
