/**
 * Woleet API
 * # Basics The Woleet API is an **HTTP REST API**: it has predictable, resource-oriented URLs and uses HTTP response codes to indicate API errors. It uses built-in HTTP features, like **Basic authentication** and HTTP verbs, for an easy integration with off-the-shelf HTTP clients. It supports **CORS** and provides **JWT authentication** allowing an easy and secure interaction with both web clients and backend applications.  The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.  The API base URL is **https://api.woleet.io/v1**. # Authentication The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.  The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using basic authentication) and then pass this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme. # Purpose The Woleet API provides an easy way to create **timestamped proofs of existence** for your files. Proofs created are **stored in the Bitcoin blockchain** and so are public, durable and unfalsifiable. The Woleet API provides you with an easy and cheap way to proove that your files existed in a given state at a given date.  The Woleet API creates proofs of existence conform to the open source standard [ChainPoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, and will stay **valid forever** even if Woleet stops it operations. # Creating proofs of existence To create a proof of existence for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you simply need to compute the file's SHA256 hash and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or the type of the file.  Newly created anchors are automatically collected by the platform and recorded in the Bitcoin blockchain: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate an URL to the anchor that the platform will call whenever the anchor's status change.  Once an anchor is recorded in the Bitcoin blockchain, you can retreive its associated **proof receipt** using the Wollet API. Proof receipts **conform to the [ChainPoint](https://www.chainpoint.org/) standard receipt format**. The proof receipt is the only piece of data required to prove the existence of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt whenever you want to verify a file. # Verifying files using proofs of existence Verifying a file is straighforward using the Woleet API: the API takes care of verifying that the proof receipt is valid and correctly recorded in a Bitcoin transaction, so you just have to check that the file's SHA256 hash match the one recorded in the proof receipt.  The Woleet API can also be used to verify any ChainPoint standard receipts, including the ones created by other providers.  Woleet also provides some sample open source code for various languages implementing the full verification process without the help of the Woleet API. # About public and private anchors An anchor can be public (which is the default) or private.  A private anchor is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the anchored data to anyone wanting to verify the data timestamp.  A public anchor is discoverable by anyone knowing the hash of the anchored data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to verify the timestamp of the anchored data using only the data hash as input: the proof receipt is no longer required, as it can be retreived from the anchor identifier and then verified. The process is the following: - use the `/anchorids` endpoint to retreive the anchor identifier by its hash - use the `receipt/{anchorid}` endpoint to retreive the proof receipt (which includes the anchor's metadata). - use the `receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the anchored data timestamp.  # About the verification process For your understanding, here is a description of the verification process: - compute the SHA256 hash of the file - check that the `target_hash` property of the receipt match the hash of the file - check that the `target_proof` property of the receipt is a valid Merkle proof (see the [ChainPoint](https://www.chainpoint.org/) standard for this step) - retreive the Bitcoin transaction matching the `tx_id` property of the receipt - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkle_root` property of the receipt 
 *
 * OpenAPI spec version: 1.0.1
 * Contact: contact@woleet.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

import io.woleet.api.client.model.Anchor;
import io.woleet.api.client.model.AnchorIds;
import io.woleet.api.client.model.Anchors;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnchorApi {
    private ApiClient apiClient;

    public AnchorApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AnchorApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for createAnchor */
    private com.squareup.okhttp.Call createAnchorCall(Anchor anchor, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = anchor;
        
        // verify the required parameter 'anchor' is set
        if (anchor == null) {
            throw new ApiException("Missing the required parameter 'anchor' when calling createAnchor(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/anchor".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a new anchor.
     * Use this operation to create a new anchor.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required. 
     * @param anchor Anchor object to create.  (required)
     * @return Anchor
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchor createAnchor(Anchor anchor) throws ApiException {
        ApiResponse<Anchor> resp = createAnchorWithHttpInfo(anchor);
        return resp.getData();
    }

    /**
     * Create a new anchor.
     * Use this operation to create a new anchor.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required. 
     * @param anchor Anchor object to create.  (required)
     * @return ApiResponse&lt;Anchor&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchor> createAnchorWithHttpInfo(Anchor anchor) throws ApiException {
        com.squareup.okhttp.Call call = createAnchorCall(anchor, null, null);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new anchor. (asynchronously)
     * Use this operation to create a new anchor.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required. 
     * @param anchor Anchor object to create.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createAnchorAsync(Anchor anchor, final ApiCallback<Anchor> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createAnchorCall(anchor, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for deleteAnchor */
    private com.squareup.okhttp.Call deleteAnchorCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling deleteAnchor(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/anchor/{anchorid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "anchorid" + "\\}", apiClient.escapeString(anchorid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Delete an existing anchor.
     * Use this operation to delete a given anchor.&lt;br&gt; *WARNING*: You should never delete an anchor, overwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only. 
     * @param anchorid Identifier of the anchor to delete. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteAnchor(String anchorid) throws ApiException {
        deleteAnchorWithHttpInfo(anchorid);
    }

    /**
     * Delete an existing anchor.
     * Use this operation to delete a given anchor.&lt;br&gt; *WARNING*: You should never delete an anchor, overwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only. 
     * @param anchorid Identifier of the anchor to delete. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteAnchorWithHttpInfo(String anchorid) throws ApiException {
        com.squareup.okhttp.Call call = deleteAnchorCall(anchorid, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete an existing anchor. (asynchronously)
     * Use this operation to delete a given anchor.&lt;br&gt; *WARNING*: You should never delete an anchor, overwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only. 
     * @param anchorid Identifier of the anchor to delete. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteAnchorAsync(String anchorid, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteAnchorCall(anchorid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getAnchor */
    private com.squareup.okhttp.Call getAnchorCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling getAnchor(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/anchor/{anchorid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "anchorid" + "\\}", apiClient.escapeString(anchorid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get an anchor by its identifier.
     * Use this operation to retrieve an anchor by its identifier. 
     * @param anchorid Identifier of the anchor to retrieve. (required)
     * @return Anchor
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchor getAnchor(String anchorid) throws ApiException {
        ApiResponse<Anchor> resp = getAnchorWithHttpInfo(anchorid);
        return resp.getData();
    }

    /**
     * Get an anchor by its identifier.
     * Use this operation to retrieve an anchor by its identifier. 
     * @param anchorid Identifier of the anchor to retrieve. (required)
     * @return ApiResponse&lt;Anchor&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchor> getAnchorWithHttpInfo(String anchorid) throws ApiException {
        com.squareup.okhttp.Call call = getAnchorCall(anchorid, null, null);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get an anchor by its identifier. (asynchronously)
     * Use this operation to retrieve an anchor by its identifier. 
     * @param anchorid Identifier of the anchor to retrieve. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAnchorAsync(String anchorid, final ApiCallback<Anchor> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getAnchorCall(anchorid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchAnchorIds */
    private com.squareup.okhttp.Call searchAnchorIdsCall(String hash, Integer page, Integer size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'hash' is set
        if (hash == null) {
            throw new ApiException("Missing the required parameter 'hash' when calling searchAnchorIds(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/anchorids".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));
        if (hash != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Search for public anchors&#39; identifiers.
     * Use this operation to retreive the identifiers of all public anchors having a given hash.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (required)
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @return AnchorIds
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AnchorIds searchAnchorIds(String hash, Integer page, Integer size) throws ApiException {
        ApiResponse<AnchorIds> resp = searchAnchorIdsWithHttpInfo(hash, page, size);
        return resp.getData();
    }

    /**
     * Search for public anchors&#39; identifiers.
     * Use this operation to retreive the identifiers of all public anchors having a given hash.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (required)
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @return ApiResponse&lt;AnchorIds&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AnchorIds> searchAnchorIdsWithHttpInfo(String hash, Integer page, Integer size) throws ApiException {
        com.squareup.okhttp.Call call = searchAnchorIdsCall(hash, page, size, null, null);
        Type localVarReturnType = new TypeToken<AnchorIds>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for public anchors&#39; identifiers. (asynchronously)
     * Use this operation to retreive the identifiers of all public anchors having a given hash.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (required)
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAnchorIdsAsync(String hash, Integer page, Integer size, final ApiCallback<AnchorIds> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchAnchorIdsCall(hash, page, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AnchorIds>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchAnchors */
    private com.squareup.okhttp.Call searchAnchorsCall(Integer page, Integer size, String direction, String sort, String name, String hash, List<String> tags, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/anchors".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));
        if (direction != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "direction", direction));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
        if (hash != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));
        if (tags != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "tags", tags));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Search for anchors.
     * Use this operation to retreive all anchors having a given name, hash and/or tags.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possbile values are &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;name&#x60;, &#x60;hash&#x60;.  (optional, default to created)
     * @param name Name to search for: a sub-string like &#x60;My file&#x60; or a regex like &#x60;/[mM]y.*file/&#x60; can be used. All anchors whose name contains the sub-string or match the regex are returned.  (optional)
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (optional)
     * @param tags List of tags to search for. Only anchors having all these tags sets are returned.  (optional)
     * @return Anchors
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchors searchAnchors(Integer page, Integer size, String direction, String sort, String name, String hash, List<String> tags) throws ApiException {
        ApiResponse<Anchors> resp = searchAnchorsWithHttpInfo(page, size, direction, sort, name, hash, tags);
        return resp.getData();
    }

    /**
     * Search for anchors.
     * Use this operation to retreive all anchors having a given name, hash and/or tags.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possbile values are &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;name&#x60;, &#x60;hash&#x60;.  (optional, default to created)
     * @param name Name to search for: a sub-string like &#x60;My file&#x60; or a regex like &#x60;/[mM]y.*file/&#x60; can be used. All anchors whose name contains the sub-string or match the regex are returned.  (optional)
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (optional)
     * @param tags List of tags to search for. Only anchors having all these tags sets are returned.  (optional)
     * @return ApiResponse&lt;Anchors&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchors> searchAnchorsWithHttpInfo(Integer page, Integer size, String direction, String sort, String name, String hash, List<String> tags) throws ApiException {
        com.squareup.okhttp.Call call = searchAnchorsCall(page, size, direction, sort, name, hash, tags, null, null);
        Type localVarReturnType = new TypeToken<Anchors>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for anchors. (asynchronously)
     * Use this operation to retreive all anchors having a given name, hash and/or tags.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retreive (from 0).  (optional, default to 0)
     * @param size Number of anchors per page.  (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possbile values are &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;name&#x60;, &#x60;hash&#x60;.  (optional, default to created)
     * @param name Name to search for: a sub-string like &#x60;My file&#x60; or a regex like &#x60;/[mM]y.*file/&#x60; can be used. All anchors whose name contains the sub-string or match the regex are returned.  (optional)
     * @param hash Hash to search for: all anchors whose hash is exactly the same are returned.  (optional)
     * @param tags List of tags to search for. Only anchors having all these tags sets are returned.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAnchorsAsync(Integer page, Integer size, String direction, String sort, String name, String hash, List<String> tags, final ApiCallback<Anchors> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchAnchorsCall(page, size, direction, sort, name, hash, tags, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchors>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for updateAnchor */
    private com.squareup.okhttp.Call updateAnchorCall(String anchorid, Anchor anchor, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = anchor;
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling updateAnchor(Async)");
        }
        
        // verify the required parameter 'anchor' is set
        if (anchor == null) {
            throw new ApiException("Missing the required parameter 'anchor' when calling updateAnchor(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/anchor/{anchorid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "anchorid" + "\\}", apiClient.escapeString(anchorid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Update an existing anchor.
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; &#x60;targetURI&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update.  (required)
     * @param anchor Anchor object to update.  (required)
     * @return Anchor
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchor updateAnchor(String anchorid, Anchor anchor) throws ApiException {
        ApiResponse<Anchor> resp = updateAnchorWithHttpInfo(anchorid, anchor);
        return resp.getData();
    }

    /**
     * Update an existing anchor.
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; &#x60;targetURI&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update.  (required)
     * @param anchor Anchor object to update.  (required)
     * @return ApiResponse&lt;Anchor&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchor> updateAnchorWithHttpInfo(String anchorid, Anchor anchor) throws ApiException {
        com.squareup.okhttp.Call call = updateAnchorCall(anchorid, anchor, null, null);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update an existing anchor. (asynchronously)
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; &#x60;targetURI&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update.  (required)
     * @param anchor Anchor object to update.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateAnchorAsync(String anchorid, Anchor anchor, final ApiCallback<Anchor> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateAnchorCall(anchorid, anchor, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
