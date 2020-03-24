package io.fip.client.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fip.client.ApiClient;
import io.fip.client.ApiException;
import io.fip.client.model.Respuesta;
import io.fip.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

public class FipApiTest {

	private Logger logger = LoggerFactory.getLogger(FipApiTest.class.getName());
	private final FipApi api = new FipApi();
	private ApiClient apiClient;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(new SignerInterceptor()).build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void madurezTest() throws ApiException {
		String xApiKey = "your_api_key";
		String username = "your_username";
		String password = "your_password";
		String folioConsulta = "1000000";

		try {
			Respuesta response = api.madurez(xApiKey, username, password, folioConsulta);
			Assert.assertTrue(response != null);
			if (response != null) {
				logger.info(response.toString());
			}
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
	}
}
