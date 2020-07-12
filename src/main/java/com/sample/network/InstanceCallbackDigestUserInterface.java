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
public class InstanceCallbackDigestUserInterface {
  private String filename;
  private byte[] digest;

  public InstanceCallbackDigestUserInterface(String filename) {
    this.filename = filename;
  }

  // 생성자에 속하지 않는다.
  // 생성자에서 스레드를 시작하는 것은 매우 위험하며, 생성된 스레드가 자신을 생성한 객체를 다시 호출할 때 특히 위험 함.
  public void calculateDigest() {
    InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
    Thread t = new Thread(cb);
    t.start();
  }
  public void receiveDigest(byte[] digest) {
    this.digest = digest;
    System.out.println(this);
  }

  @Override
  public String toString() {
    String result = filename + ": ";
    if (digest != null) {
      result += DatatypeConverter.printHexBinary(digest);
    } else {
      result += "digest not available";
    }
    return result;
  }

  // 정적 메소드 대신 인스턴스 메소를 사용하는 방법
  // 메인 클래스의 각 인스턴스(InstanceCallbackDigestUserInterface) 는 정확히 파일 하나만 처리하므로 부가적인 자료 구조를 사용하지 않아도 됨.
  // 정적 메소드에 비해 유연하게 재계산이 가능 함.
  public static void main(String[] args) {
    args = new String[1];
    args[0] = "sha256-sample.txt";
    for (String filename : args) {
      InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
      d.calculateDigest();
    }
  }
}
