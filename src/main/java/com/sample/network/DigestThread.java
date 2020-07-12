/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/10
 */

package com.sample.network;

import jakarta.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * create on 2020/07/10.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class DigestThread extends Thread {
  private String filename;

  public DigestThread(String filename) {
    this.filename = filename;
  }

  @Override
  public void run() {

  }

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "sha256-sample.txt";
    for(String filename : args) {
      Thread t = new DigestThread(filename);
      t.start();
    }
  }
}
