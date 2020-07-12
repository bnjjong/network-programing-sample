/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
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
public class SecureSourceViewer {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "https://aquerytool.com/";
    Authenticator.setDefault(new DialogAuthenticator());

    for (int i=0; i<args.length; i++) {
      try {
        URL u = new URL(args[i]);
        try (InputStream in = new BufferedInputStream( u.openStream())) {
          // InputStream을 Reader 에 연결
          Reader r = new InputStreamReader(in);
          int c;
          while ((c=r.read()) != -1) {
            System.out.print((char) c);
          }
        } catch (IOException e) {
          System.err.println(args[0] + "is not a parseable URL");
        }
      } catch (MalformedURLException e) {
        System.err.println(e);
      }
      System.out.println();
    }
    //AWT를 사용하였기 때문에 프로그램을 명확하게 종료해야 한다.
    System.exit(0);

  }

}
