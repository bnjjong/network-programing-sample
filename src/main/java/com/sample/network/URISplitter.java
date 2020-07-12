/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.net.URI;
import java.net.URISyntaxException;

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
public class URISplitter {

  public static void main(String[] args) {
    args = new String[3];
    args[0] = "tel:+1-800-9988-9938";
    args[1] = "http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc";
    args[2] = "urn:isbn:1-565-92870-9";
    for (int i = 0; i < args.length; i++) {
      try {
        URI u = new URI(args[i]);
        System.out.println("This URI is " + u);
        if (u.isOpaque()) {
          System.out.println("This is an opaque URI.");
          System.out.println("This scheme is " + u.getScheme());
          System.out.println("This scheme specific part is " + u.getSchemeSpecificPart());
          System.out.println("This Fragment ID is " + u.getFragment());
        } else {
          System.out.println("This is a hierarchical URI");
          System.out.println("The scheme is " + u.getScheme());
          try {
            u = u.parseServerAuthority();
            System.out.println("The host is " + u.getHost());
            System.out.println("The user info is " + u.getUserInfo());
            System.out.println("The port is " + u.getPort());
          } catch (URISyntaxException e) {
            System.err.println("The authority is "+ u.getAuthority());
          }
          System.out.println("The path is " + u.getPath());
          System.out.println("The query string is " + u.getQuery());
          System.out.println("The fragment ID is " + u.getFragment());
        }
      } catch (URISyntaxException e) {
        System.err.println(args[i] + " does not seem to be a URI.");
      }
      System.out.println();
    }
  }

}
