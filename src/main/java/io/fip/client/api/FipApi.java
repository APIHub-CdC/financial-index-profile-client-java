package io.fip.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.fip.client.ApiClient;
import io.fip.client.ApiException;
import io.fip.client.ApiResponse;
import io.fip.client.Configuration;
import io.fip.client.Pair;
import io.fip.client.ProgressRequestBody;
import io.fip.client.ProgressResponseBody;
import io.fip.client.model.Respuesta;

public class FipApi {
	private ApiClient apiClient;

	public FipApi() {
		this(Configuration.getDefaultApiClient());
	}

	public FipApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public okhttp3.Call madurezCall(String xApiKey, String username, String password, String folioConsulta,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/{folioConsulta}".replaceAll("\\{" + "folioConsulta" + "\\}",
				apiClient.escapeString(folioConsulta.toString()));
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		if (username != null)
			localVarHeaderParams.put("username", apiClient.parameterToString(username));
		if (password != null)
			localVarHeaderParams.put("password", apiClient.parameterToString(password));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call madurezValidateBeforeCall(String xApiKey, String username, String password,
			String folioConsulta, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling madurez(Async)");
		}
		if (username == null) {
			throw new ApiException("Missing the required parameter 'username' when calling madurez(Async)");
		}
		if (password == null) {
			throw new ApiException("Missing the required parameter 'password' when calling madurez(Async)");
		}
		if (folioConsulta == null) {
			throw new ApiException("Missing the required parameter 'folioConsulta' when calling madurez(Async)");
		}

		okhttp3.Call call = madurezCall(xApiKey, username, password, folioConsulta, progressListener,
				progressRequestListener);
		return call;
	}

	public Respuesta madurez(String xApiKey, String username, String password, String folioConsulta)
			throws ApiException {
		ApiResponse<Respuesta> resp = madurezWithHttpInfo(xApiKey, username, password, folioConsulta);
		return resp.getData();
	}

	public ApiResponse<Respuesta> madurezWithHttpInfo(String xApiKey, String username, String password,
			String folioConsulta) throws ApiException {
		okhttp3.Call call = madurezValidateBeforeCall(xApiKey, username, password, folioConsulta, null, null);
		Type localVarReturnType = new TypeToken<Respuesta>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}
}
