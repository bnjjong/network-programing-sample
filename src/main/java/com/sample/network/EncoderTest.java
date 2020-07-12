/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
public class EncoderTest {

  public static void main(String[] args) {
    try {
      System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
      System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
      System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
      System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
      System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
      System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
      System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
      System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
      System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
      System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
      System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
      System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-8"));
      System.out.println(URLEncoder.encode("Thisástringáhasánon-ASCII", "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Broken VM does not support UTF-8");
    }
  }

}
