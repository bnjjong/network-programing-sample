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
public class SourceViewer {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "https://aquerytool.com/";
    if (args.length > 0 ) {
      InputStream in = null;
      try {
        URL u = new URL(args[0]);
        in = u.openStream();
        // 입력의 성능을 높이기 위한 버퍼
        in = new BufferedInputStream(in);
        // inputStream을 Reader로 연결(chain)
        Reader r = new InputStreamReader(in);
        int c;
        while ((c = r.read()) != -1) {
          System.out.print((char)c);
        }
      } catch (MalformedURLException e) {
        System.err.println(args[0] + " is not a parseable URL");
      } catch (IOException e) {
        System.err.println(e);
      } finally {
        if (in != null) {
          try {
            in.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

}
