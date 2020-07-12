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
public class DigestRunnable implements Runnable{
  private String filename;

  public DigestRunnable(String filename) {
    this.filename = filename;
  }

  @Override
  public void run() {
    try {
      FileInputStream in = new FileInputStream(filename);
      MessageDigest sha = MessageDigest.getInstance("SHA-256");
      DigestInputStream din = new DigestInputStream(in, sha);
      while (din.read() != -1);
      din.close();

      byte[] digest = sha.digest();
      StringBuilder result = new StringBuilder(filename);
      result.append(": ");
      result.append(DatatypeConverter.printHexBinary(digest));
      System.out.println(result);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    for(String filename : args) {
      DigestRunnable dr = new DigestRunnable(filename);
      Thread t = new Thread(dr);
      t.start();
    }
  }
}
