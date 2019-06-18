/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.6.1
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


import java.io.File;
import io.woleet.api.client.model.Receipt;
import io.woleet.api.client.model.ReceiptVerificationStatus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptApi {
    private ApiClient apiClient;

    public ReceiptApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ReceiptApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getOTSReceipt
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getOTSReceiptCall(String anchorId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/receipt/{anchorId}/ots"
            .replaceAll("\\{" + "anchorId" + "\\}", apiClient.escapeString(anchorId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOTSReceiptValidateBeforeCall(String anchorId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorId' is set
        if (anchorId == null) {
            throw new ApiException("Missing the required parameter 'anchorId' when calling getOTSReceipt(Async)");
        }
        

        com.squareup.okhttp.Call call = getOTSReceiptCall(anchorId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format).
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getOTSReceipt(String anchorId) throws ApiException {
        ApiResponse<File> resp = getOTSReceiptWithHttpInfo(anchorId);
        return resp.getData();
    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format).
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> getOTSReceiptWithHttpInfo(String anchorId) throws ApiException {
        com.squareup.okhttp.Call call = getOTSReceiptValidateBeforeCall(anchorId, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format). (asynchronously)
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOTSReceiptAsync(String anchorId, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOTSReceiptValidateBeforeCall(anchorId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getReceipt
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getReceiptCall(String anchorId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/receipt/{anchorId}"
            .replaceAll("\\{" + "anchorId" + "\\}", apiClient.escapeString(anchorId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getReceiptValidateBeforeCall(String anchorId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorId' is set
        if (anchorId == null) {
            throw new ApiException("Missing the required parameter 'anchorId' when calling getReceipt(Async)");
        }
        

        com.squareup.okhttp.Call call = getReceiptCall(anchorId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the proof receipt of an anchor (Chainpoint proof format).
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @return Receipt
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Receipt getReceipt(String anchorId) throws ApiException {
        ApiResponse<Receipt> resp = getReceiptWithHttpInfo(anchorId);
        return resp.getData();
    }

    /**
     * Get the proof receipt of an anchor (Chainpoint proof format).
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @return ApiResponse&lt;Receipt&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Receipt> getReceiptWithHttpInfo(String anchorId) throws ApiException {
        com.squareup.okhttp.Call call = getReceiptValidateBeforeCall(anchorId, null, null);
        Type localVarReturnType = new TypeToken<Receipt>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the proof receipt of an anchor (Chainpoint proof format). (asynchronously)
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getReceiptAsync(String anchorId, final ApiCallback<Receipt> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getReceiptValidateBeforeCall(anchorId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Receipt>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for verifyReceipt
     * @param receipt Chainpoint proof receipt to verify. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call verifyReceiptCall(Receipt receipt, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = receipt;

        // create path and map variables
        String localVarPath = "/receipt/verify";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call verifyReceiptValidateBeforeCall(Receipt receipt, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'receipt' is set
        if (receipt == null) {
            throw new ApiException("Missing the required parameter 'receipt' when calling verifyReceipt(Async)");
        }
        

        com.squareup.okhttp.Call call = verifyReceiptCall(receipt, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Verify a proof receipt.
     * Use this operation to verify a Chainpoint proof receipt and get the timestamp of the proof.&lt;br&gt; For proof of signature receipts including an identity URL, this operation also verify and returns information about the signee&#39;s identity.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Chainpoint proof receipt to verify. (required)
     * @return ReceiptVerificationStatus
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ReceiptVerificationStatus verifyReceipt(Receipt receipt) throws ApiException {
        ApiResponse<ReceiptVerificationStatus> resp = verifyReceiptWithHttpInfo(receipt);
        return resp.getData();
    }

    /**
     * Verify a proof receipt.
     * Use this operation to verify a Chainpoint proof receipt and get the timestamp of the proof.&lt;br&gt; For proof of signature receipts including an identity URL, this operation also verify and returns information about the signee&#39;s identity.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Chainpoint proof receipt to verify. (required)
     * @return ApiResponse&lt;ReceiptVerificationStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ReceiptVerificationStatus> verifyReceiptWithHttpInfo(Receipt receipt) throws ApiException {
        com.squareup.okhttp.Call call = verifyReceiptValidateBeforeCall(receipt, null, null);
        Type localVarReturnType = new TypeToken<ReceiptVerificationStatus>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Verify a proof receipt. (asynchronously)
     * Use this operation to verify a Chainpoint proof receipt and get the timestamp of the proof.&lt;br&gt; For proof of signature receipts including an identity URL, this operation also verify and returns information about the signee&#39;s identity.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Chainpoint proof receipt to verify. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call verifyReceiptAsync(Receipt receipt, final ApiCallback<ReceiptVerificationStatus> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = verifyReceiptValidateBeforeCall(receipt, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ReceiptVerificationStatus>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
