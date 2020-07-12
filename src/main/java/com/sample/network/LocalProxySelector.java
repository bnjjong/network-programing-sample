/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
public class LocalProxySelector extends ProxySelector {
  private List<URI> failed = new ArrayList<>();

  @Override
  public List<Proxy> select(URI uri) {
    List<Proxy> result = new ArrayList<>();
    if(failed.contains(uri) || !"http".equalsIgnoreCase(uri.getScheme())) {
      result.add(Proxy.NO_PROXY);
    } else {
      SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8080);
      Proxy proxy = new Proxy(Type.HTTP, proxyAddress);
      result.add(proxy);
    }
    return result;
  }

  @Override
  public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    failed.add(uri);
  }

  public static void main(String[] args) {
    ProxySelector selector = new LocalProxySelector();
    ProxySelector.setDefault(selector);
  }
}
