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
public class EncodingAwareSourceViewer {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "https://aquerytool.com";
    for ( int i=0; i<args.length; i++) {
      try {
        // 기본 인코딩 설정
        String encoding = "ISO-8859-1";
        URL u = new URL(args[i]);
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int encodingStart = contentType.indexOf("charset=");
        if ( encodingStart != -1) {
          encoding = contentType.substring(encodingStart + 8);
          System.out.println("your encoding type is " + encoding);
        }
        InputStream in = new BufferedInputStream(uc.getInputStream());
        Reader r = new InputStreamReader(in, encoding);
        int c;
        while ((c = r.read()) != -1) {
          System.out.print((char)c);
        }
        r.close();
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
