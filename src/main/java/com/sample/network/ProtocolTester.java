/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

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
public class ProtocolTester {

  public static void main(String[] args) {
    // 하이퍼텍스트 전송 프로토콜
    testProtocol("http://www.adc.org");
    // 보안 http
    testProtocol("https://www.amazon.com/exec/obidos/order2/");
    // 파일 전송 프로토콜
    testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");
    // 간이메일 전송 프로토콜
    testProtocol("mailto:elharo@ibiblio.org");
    // 텔넷
    testProtocol("telnet://dibner.poly.edu/");
    // 로컬 파일 접근
    testProtocol("file:///etc/passwd");
    // gopher
    testProtocol("gopher://gopher.anc.org.za/");
    // LDAP, 경량 디렉터리 접근 프로토콜
    testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
    // JAR
    testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!/com/macfaq/io/StreamCopier.class");
    // NFS, 네트워크 파일 시스템
    testProtocol("nfs://utopia.poly.edu/usr/tmp/");
    // JDBC
    testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
    // rmi 원격 메소드 호출
    testProtocol("rmi://ibiblio.org/RenderEngine");
    // HotJava
    testProtocol("doc:/UsersGuide/release.html");
    testProtocol("netdoc:/UsersGuide/release.html");
    testProtocol("systemresource://www.adc.org/+/index.html");
    testProtocol("verbatim:http://www.adc.org/");


  }

  private static void testProtocol(String url) {
    try {
      URL u = new URL(url);
      System.out.println(u.getProtocol() + " is supported");
    } catch (MalformedURLException e) {
      String protocol = url.substring(0, url.indexOf(':'));
      System.out.println(protocol + " is not supported");
    }
  }

}
