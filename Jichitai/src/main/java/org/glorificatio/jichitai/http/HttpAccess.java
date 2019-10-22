package org.glorificatio.jichitai.http;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.glorificatio.jichitai.hp.Site;

public class HttpAccess {

	public HttpAccess() {
	}
	
	
	
	public HttpResult access(String url) throws AccessException {
		
		HttpResult result = null;
		try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
			// HTTPリクエストの設定を行います。
			// ここでは例としてタイムアウトの時間を設定します。
			RequestConfig config = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();

			// HTTPのGETリクエストを構築します。
			// ここでは例としてHTTPヘッダ(User-Agent)と設定をセットします。
			HttpHead httphead = new HttpHead(url);
			httphead.setConfig(config);

			// HTTPリクエストを実行します。 HTTPステータスが200の場合は取得したHTMLを表示します。
			try (CloseableHttpResponse resp = httpClient.execute(httphead);) {
				result = new HttpResult();
				int status = resp.getStatusLine().getStatusCode();
				result.setStatusCode(status);
			}
		} catch (IOException e) {
			throw new AccessException(e);
		}
		
		return result;
	}
}
