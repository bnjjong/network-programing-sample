/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/10
 */

package com.sample.network;

import jakarta.xml.bind.DatatypeConverter;

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
public class ReturnDigestUserInterface {

  public static void main(String[] args) {
    args = new String[1];
    args[0] = "sha256-sample.txt";

    ReturnDigest[] digests = new ReturnDigest[args.length];
    for (int i=0; i<args.length; i++){
      // 다이제스트 계산
      digests[i] = new ReturnDigest(args[i]);
      digests[i].start();
    }

    // 결과 출력
    for (int i=0; i< args.length; i++) {
      while (true) {
        System.out.println("start result>>>");
        byte[] digest = digests[i].getDigest();
        if(digest != null) {
          System.out.println("get digest!");
          String result = args[i] + ": "
              + DatatypeConverter.printHexBinary(digest);
          System.out.println(result);
          break;
        }
      }
    }

  }

}
