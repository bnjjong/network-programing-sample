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
import java.nio.charset.StandardCharsets;

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
public class QueryString {
  private StringBuilder query = new StringBuilder();

  public synchronized void add(String name, String value) {
    query.append('&');
    encode(name, value);

  }

  private synchronized void encode(String name, String value) {
    query.append(URLEncoder.encode(name, StandardCharsets.UTF_8));
    query.append('=');
    query.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
  }

  public String getQuery() {
    return query.toString();
  }

  @Override
  public String toString() {
    return getQuery();
  }

  public static void main(String[] args) {
    QueryString qs = new QueryString();
    qs.add("hl", "en");
    qs.add("as_q", "Java");
    qs.add("as_epq", "I/O");
    String url = "http://www.google.com/search?" + qs;
    System.out.println(url);
  }
}
