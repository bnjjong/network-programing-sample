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
public class JoinDiegestUserInterface {

  public static void main(String[] args) {
    ReturnDigest[] digestsThreads = new ReturnDigest[args.length];

    for(int i=0; i<args.length; i++) {
      digestsThreads[i] = new ReturnDigest(args[i]);
      digestsThreads[i].start();
    }

    for (int i=0; i<args.length; i++) {
      try {
        // java 5 이후로 Executor 와 Future 로 대체 하여 더 쉽게 구현 가능.
        digestsThreads[i].join();
        // 결과 출력
        StringBuffer result = new StringBuffer(args[i]);
        result.append(": ");
        byte[] digest = digestsThreads[i].getDigest();
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
