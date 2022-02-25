/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.11.1
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.api.client;

import io.woleet.api.ApiCallback;
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.ApiResponse;
import io.woleet.api.Configuration;
import io.woleet.api.Pair;
import io.woleet.api.ProgressRequestBody;
import io.woleet.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.woleet.api.client.model.Token;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenApi {
    private ApiClient localVarApiClient;

    public TokenApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TokenApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for generateToken
     * @param cdata Client data to inject into the generated JWT token (64 characters max).&lt;br&gt; This data is not processed by the platform, and can be easily retrieved from the token by Base64 decoding its &#x60;payload&#x60;.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call generateTokenCall(String cdata, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (cdata != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("cdata", cdata));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call generateTokenValidateBeforeCall(String cdata, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = generateTokenCall(cdata, _callback);
        return localVarCall;

    }

    /**
     * Generate a JWT token.
     * Use this operation to generate a new JWT token.&lt;br&gt; JWT tokens can be used to authenticate to the API, using the &#x60;Bearer&#x60; scheme of the &#x60;Authorization&#x60; header, like:&lt;br&gt; &#x60;Authorization: Bearer {JWT token}&#x60; 
     * @param cdata Client data to inject into the generated JWT token (64 characters max).&lt;br&gt; This data is not processed by the platform, and can be easily retrieved from the token by Base64 decoding its &#x60;payload&#x60;.  (optional)
     * @return Token
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public Token generateToken(String cdata) throws ApiException {
        ApiResponse<Token> localVarResp = generateTokenWithHttpInfo(cdata);
        return localVarResp.getData();
    }

    /**
     * Generate a JWT token.
     * Use this operation to generate a new JWT token.&lt;br&gt; JWT tokens can be used to authenticate to the API, using the &#x60;Bearer&#x60; scheme of the &#x60;Authorization&#x60; header, like:&lt;br&gt; &#x60;Authorization: Bearer {JWT token}&#x60; 
     * @param cdata Client data to inject into the generated JWT token (64 characters max).&lt;br&gt; This data is not processed by the platform, and can be easily retrieved from the token by Base64 decoding its &#x60;payload&#x60;.  (optional)
     * @return ApiResponse&lt;Token&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Token> generateTokenWithHttpInfo(String cdata) throws ApiException {
        okhttp3.Call localVarCall = generateTokenValidateBeforeCall(cdata, null);
        Type localVarReturnType = new TypeToken<Token>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Generate a JWT token. (asynchronously)
     * Use this operation to generate a new JWT token.&lt;br&gt; JWT tokens can be used to authenticate to the API, using the &#x60;Bearer&#x60; scheme of the &#x60;Authorization&#x60; header, like:&lt;br&gt; &#x60;Authorization: Bearer {JWT token}&#x60; 
     * @param cdata Client data to inject into the generated JWT token (64 characters max).&lt;br&gt; This data is not processed by the platform, and can be easily retrieved from the token by Base64 decoding its &#x60;payload&#x60;.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call generateTokenAsync(String cdata, final ApiCallback<Token> _callback) throws ApiException {

        okhttp3.Call localVarCall = generateTokenValidateBeforeCall(cdata, _callback);
        Type localVarReturnType = new TypeToken<Token>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for revokeToken
     * @param token JWT token to revoke. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token is revoked. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call revokeTokenCall(String token, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (token != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("token", token));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call revokeTokenValidateBeforeCall(String token, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new ApiException("Missing the required parameter 'token' when calling revokeToken(Async)");
        }
        

        okhttp3.Call localVarCall = revokeTokenCall(token, _callback);
        return localVarCall;

    }

    /**
     * Revoke a JWT token.
     * Use this operation to revoke a JWT token.&lt;br&gt; JWT tokens have no expiration date so are always valid: if you need to invalidate a token (eg. because you think it is compromised) you need to use this endpoint to inform the platform that this token must no longer be accepted. 
     * @param token JWT token to revoke. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token is revoked. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public void revokeToken(String token) throws ApiException {
        revokeTokenWithHttpInfo(token);
    }

    /**
     * Revoke a JWT token.
     * Use this operation to revoke a JWT token.&lt;br&gt; JWT tokens have no expiration date so are always valid: if you need to invalidate a token (eg. because you think it is compromised) you need to use this endpoint to inform the platform that this token must no longer be accepted. 
     * @param token JWT token to revoke. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token is revoked. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> revokeTokenWithHttpInfo(String token) throws ApiException {
        okhttp3.Call localVarCall = revokeTokenValidateBeforeCall(token, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Revoke a JWT token. (asynchronously)
     * Use this operation to revoke a JWT token.&lt;br&gt; JWT tokens have no expiration date so are always valid: if you need to invalidate a token (eg. because you think it is compromised) you need to use this endpoint to inform the platform that this token must no longer be accepted. 
     * @param token JWT token to revoke. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The JWT token is revoked. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call revokeTokenAsync(String token, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = revokeTokenValidateBeforeCall(token, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}
