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
public class IPCharacteristics {

  public static void main(String[] args) throws UnknownHostException {
    args = new String[1];
//    args[0] = "127.0.0.1";
//    args[0] = "192.168.254.32";
//    args[0] = "aquerytool.com";
//    args[0] = "224.0.2.1";
//    args[0] = "FF01:0:0:0:0:0:0:1";
//    args[0] = "FF05:0:0:0:0:0:0:101";
    args[0] = "0::1";
    InetAddress address = InetAddress.getByName(args[0]);

    if(address.isAnyLocalAddress()) {
      System.out.println(address + " is a wildcard address");
    }
    if(address.isLoopbackAddress()) {
      System.out.println(address + " is loopback address");
    }

    if(address.isLinkLocalAddress()) {
      System.out.println(address + " is link-local address");
    } else if(address.isSiteLocalAddress()) {
      System.out.println(address +  " is a site-local address.");
    } else {
      System.out.println(address + "is global address");
    }

    if(address.isMulticastAddress()) {
      if(address.isMCGlobal()) {
        System.out.println(address + " is a global multicast address");
      } else if(address.isMCOrgLocal()) {
        System.out.println(address + " is an organization wide multicast address");
      } else if(address.isMCSiteLocal()) {
        System.out.println(address + " is a site wide multicast address");
      } else if(address.isMCLinkLocal()) {
        System.out.println(address + " is subnet wide multicast address");
      } else if(address.isMCNodeLocal()) {
        System.out.println(address + " is an interface-local multicast address");
      } else {
        System.out.println(address + " is unknown multicast address type");
      }
    } else {
      System.out.println(address + " is a unicast address");
    }
  }

}
