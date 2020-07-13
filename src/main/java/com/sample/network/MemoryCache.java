/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/13
 */

package com.sample.network;

import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class MemoryCache extends ResponseCache {
  private final Map<URI, SimpleCacheResponse> responses = new ConcurrentHashMap<>();
  private final int maxEntries;

  public MemoryCache() {
    this(100);
  }

  public MemoryCache(int maxEntries) {
    this.maxEntries = maxEntries;
  }

  @Override
  public CacheRequest put(URI uri, URLConnection conn) throws IOException {
    if (responses.size() >= maxEntries) return null;

    CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
    if (control.isNoStore()) {
      return null;
    } else if (!conn.getHeaderField(0).startsWith("GET ")) {
      // GET 방식만 캐시한다.
      return null;
    }

    SimpleCacheRequest request = new SimpleCacheRequest();
    SimpleCacheResponse response = new SimpleCacheResponse(request, conn, control);
    responses.put(uri, response);
    return request;
  }

  @Override
  public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders)
      throws IOException {
    if ("GET".equals(rqstMethod)) {
      SimpleCacheResponse response = responses.get(uri);
      // 만료일 확인
      if (response != null && response.isExpired()) {
        responses.remove(response);
        response = null;
      }
      return response;
    } else {
      return null;
    }
  }
}
