/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/13
 */

package com.sample.network;

import java.util.Date;
import java.util.Locale;

/**
 * create on 2020/07/13.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class CacheControl {
  private Date maxAge = null;
  private Date sMaxAge = null;
  private boolean mustRevalidate = false;
  private boolean noCache = false;
  private boolean noStore = false;
  private boolean proxyRevalidate = false;
  private boolean publicCache = false;
  private boolean privateCache = false;

  public CacheControl(String s) {
    if (s == null || !s.contains(",")) {
      return; // 기본 정책
    }

    String value = s.split(":")[1].trim();
    String[] components = value.split(",");

    Date now = new Date();
    for (String component : components) {
      try {
        component = component.trim().toLowerCase(Locale.US);
        if( component.startsWith("max-age=")) {
          int secondsIntheFuture = Integer.parseInt(component.substring(8));
          maxAge = new Date(now.getTime() + 1000 * secondsIntheFuture);
        } else if (component.startsWith("s-maxage=")) {
          int secondsIntheFuture = Integer.parseInt(component.substring(8));
          sMaxAge = new Date(now.getTime() + 1000 * secondsIntheFuture);
        } else if (component.startsWith("must-revalidate")) {
          mustRevalidate = true;
        } else if (component.startsWith("proxy-revalidate")) {
          proxyRevalidate = true;
        } else if (component.startsWith("no-cache")) {
          noCache = true;
        } else if (component.startsWith("public")) {
          publicCache = true;
        } else if (component.startsWith("private")) {
          privateCache = true;
        }
      } catch (RuntimeException e) {
        continue;
      }
    }
  }

  public Date getMaxAge() {
    return maxAge;
  }

  public Date getsMaxAge() {
    return sMaxAge;
  }

  public boolean isMustRevalidate() {
    return mustRevalidate;
  }

  public boolean isNoCache() {
    return noCache;
  }

  public boolean isNoStore() {
    return noStore;
  }

  public boolean isProxyRevalidate() {
    return proxyRevalidate;
  }

  public boolean isPublicCache() {
    return publicCache;
  }

  public boolean isPrivateCache() {
    return privateCache;
  }

}
