/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/11
 */

package com.sample.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

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
public class GZipRunnable implements Runnable{
  private final File input;

  public GZipRunnable(File input) {
    this.input = input;
  }

  @Override
  public void run() {
    // 압축 파일인지 체크
    if(!input.getName().endsWith(".gz")) {
      File output = new File(input.getParent(), input.getName() + ".gz");
      if(!output.exists()) { // 이미 존재하면 덮어쓰지 않음.
        try(
          InputStream in = new BufferedInputStream(new FileInputStream(input));
          OutputStream out = new BufferedOutputStream( new GZIPOutputStream(new FileOutputStream(output)));
        ) {
          int b;
          while ((b = in.read()) != -1) out.write(b);
          out.flush();
        } catch (IOException e) {
          System.err.println(e);
        }

      }
    }
  }
}
