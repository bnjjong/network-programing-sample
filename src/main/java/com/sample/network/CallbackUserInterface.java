/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/11
 */

package com.sample.network;

import jakarta.xml.bind.DatatypeConverter;

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
public class CallbackUserInterface {

  // main 메소드의 스레드에서 수행된것이 아님
  // CallbackDigest 쓰레드에서 이 메소드를 수행 함.
  public static void receiveDigest(byte[] digest, String filename) {
    StringBuilder result = new StringBuilder(filename);
    result.append(": ");
    result.append(DatatypeConverter.printHexBinary(digest));
    System.out.println(result);
  }

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "sha256-sample.txt";

    for (String filename : args) {
      CallbackDigest cb = new CallbackDigest(filename);
      Thread t = new Thread(cb);
      t.start();
    }
  }
}
