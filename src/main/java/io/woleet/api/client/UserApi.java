/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.12.0
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


import io.woleet.api.client.model.CallbackSecret;
import io.woleet.api.client.model.Credits;
import io.woleet.api.client.model.Tokens;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient localVarApiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getCallbackSecret
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The current callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCallbackSecretCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/callbackSecret";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private okhttp3.Call getCallbackSecretValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getCallbackSecretCall(_callback);
        return localVarCall;

    }

    /**
     * Get the current callback secret (null if not set).
     * Use this operation to get the API callback secret.
     * @return CallbackSecret
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The current callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public CallbackSecret getCallbackSecret() throws ApiException {
        ApiResponse<CallbackSecret> localVarResp = getCallbackSecretWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get the current callback secret (null if not set).
     * Use this operation to get the API callback secret.
     * @return ApiResponse&lt;CallbackSecret&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The current callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CallbackSecret> getCallbackSecretWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getCallbackSecretValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<CallbackSecret>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get the current callback secret (null if not set). (asynchronously)
     * Use this operation to get the API callback secret.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The current callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCallbackSecretAsync(final ApiCallback<CallbackSecret> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCallbackSecretValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<CallbackSecret>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getCredits
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The remaining signature and anchoring credits. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCreditsCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/credits";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private okhttp3.Call getCreditsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getCreditsCall(_callback);
        return localVarCall;

    }

    /**
     * Get user&#39;s credits.
     * Use this operation to get the remaining signature and anchoring credits of the authenticated user.
     * @return Credits
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The remaining signature and anchoring credits. </td><td>  -  </td></tr>
     </table>
     */
    public Credits getCredits() throws ApiException {
        ApiResponse<Credits> localVarResp = getCreditsWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get user&#39;s credits.
     * Use this operation to get the remaining signature and anchoring credits of the authenticated user.
     * @return ApiResponse&lt;Credits&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The remaining signature and anchoring credits. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Credits> getCreditsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getCreditsValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<Credits>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get user&#39;s credits. (asynchronously)
     * Use this operation to get the remaining signature and anchoring credits of the authenticated user.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The remaining signature and anchoring credits. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCreditsAsync(final ApiCallback<Credits> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCreditsValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<Credits>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getTokens
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens of the user, possibly empty. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getTokensCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/tokens";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private okhttp3.Call getTokensValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getTokensCall(_callback);
        return localVarCall;

    }

    /**
     * Get user&#39;s registered JWT tokens.
     * Use this operation to list all JWT tokens registered for the authenticated user.
     * @return Tokens
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens of the user, possibly empty. </td><td>  -  </td></tr>
     </table>
     */
    public Tokens getTokens() throws ApiException {
        ApiResponse<Tokens> localVarResp = getTokensWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get user&#39;s registered JWT tokens.
     * Use this operation to list all JWT tokens registered for the authenticated user.
     * @return ApiResponse&lt;Tokens&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens of the user, possibly empty. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Tokens> getTokensWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getTokensValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<Tokens>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get user&#39;s registered JWT tokens. (asynchronously)
     * Use this operation to list all JWT tokens registered for the authenticated user.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens of the user, possibly empty. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getTokensAsync(final ApiCallback<Tokens> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTokensValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<Tokens>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for putTokens
     * @param tokens The list of JWT tokens to update. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens has been successfully updated. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call putTokensCall(Tokens tokens, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = tokens;

        // create path and map variables
        String localVarPath = "/user/tokens";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call putTokensValidateBeforeCall(Tokens tokens, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'tokens' is set
        if (tokens == null) {
            throw new ApiException("Missing the required parameter 'tokens' when calling putTokens(Async)");
        }
        

        okhttp3.Call localVarCall = putTokensCall(tokens, _callback);
        return localVarCall;

    }

    /**
     * Update user&#39;s registered JWT tokens.
     * Use this operation to update the list of JWT tokens registered for the authenticated user.
     * @param tokens The list of JWT tokens to update. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens has been successfully updated. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public void putTokens(Tokens tokens) throws ApiException {
        putTokensWithHttpInfo(tokens);
    }

    /**
     * Update user&#39;s registered JWT tokens.
     * Use this operation to update the list of JWT tokens registered for the authenticated user.
     * @param tokens The list of JWT tokens to update. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens has been successfully updated. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> putTokensWithHttpInfo(Tokens tokens) throws ApiException {
        okhttp3.Call localVarCall = putTokensValidateBeforeCall(tokens, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Update user&#39;s registered JWT tokens. (asynchronously)
     * Use this operation to update the list of JWT tokens registered for the authenticated user.
     * @param tokens The list of JWT tokens to update. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of JWT tokens has been successfully updated. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call putTokensAsync(Tokens tokens, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = putTokensValidateBeforeCall(tokens, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateCallbackSecret
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly generated callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateCallbackSecretCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/callbackSecret";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateCallbackSecretValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = updateCallbackSecretCall(_callback);
        return localVarCall;

    }

    /**
     * Generates a new callback secret.
     * Use this operation to generate the API callback secret.
     * @return CallbackSecret
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly generated callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public CallbackSecret updateCallbackSecret() throws ApiException {
        ApiResponse<CallbackSecret> localVarResp = updateCallbackSecretWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Generates a new callback secret.
     * Use this operation to generate the API callback secret.
     * @return ApiResponse&lt;CallbackSecret&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly generated callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CallbackSecret> updateCallbackSecretWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = updateCallbackSecretValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<CallbackSecret>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Generates a new callback secret. (asynchronously)
     * Use this operation to generate the API callback secret.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly generated callback secret. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateCallbackSecretAsync(final ApiCallback<CallbackSecret> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateCallbackSecretValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<CallbackSecret>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
