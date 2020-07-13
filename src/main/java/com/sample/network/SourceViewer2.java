/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/13
 */

package com.sample.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
public class SourceViewer2 {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "https://aquerytool.com";
    if ( args.length > 0) {
      try {
        // URLConnection을 연다.
        URL u = new URL(args[0]);
        URLConnection uc = u.openConnection();
        try (InputStream raw = uc.getInputStream()) {
          InputStream buffer = new BufferedInputStream(raw);
          // InputStream을 Reader로 연결
          Reader reader = new InputStreamReader(buffer);
          int c;
          while ((c = reader.read()) != -1 ) {
            System.out.print((char)c);
          }
        }
      } catch (MalformedURLException e) {
        System.err.println(args[0] + " is not a parseable URL.");
      } catch (IOException e) {
        System.err.println(e);
      }
    }
  }

}
