package servicosgerais.thymeleaf.configs;

import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.auth.AuthScheme;
import org.apache.commons.httpclient.auth.BasicScheme;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class HttpComponentsClientHttpRequestFactoryBasicAuth 
extends HttpComponentsClientHttpRequestFactory {

  org.apache.http.HttpHost host;

  public HttpComponentsClientHttpRequestFactoryBasicAuth(org.apache.http.HttpHost host) {
      super();
      this.host = host;
  }

  protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
      return createHttpContext();
  }
   
  private HttpContext createHttpContext() {
      AuthCache authCache = new BasicAuthCache();

      //BasicScheme basicAuth = new BasicScheme();
      org.apache.http.auth.AuthScheme basicAuth = new org.apache.http.impl.auth.BasicScheme();
      authCache.put(host, basicAuth);

      BasicHttpContext localcontext = new BasicHttpContext();
      localcontext.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
      return localcontext;
  }
}