/*
 * Woleet API
 * # Basics The Woleet API is an **HTTP REST API**. It supports **CORS** and provides **Basic authentication** and **JWT authentication**, allowing an easy and secure interaction with both web clients and backend applications.  The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and, from it, **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.  Ready to use versions of the client code are provided as open source code for [JavaScript/NodeJS](https://github.com/woleet/woleet-openapi-js-client) and [Java](https://github.com/woleet/woleet-openapi-java-client).  The API base URL is **https://api.woleet.io/v1**. # Authentication The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.  The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using basic authentication) and then provide this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme. # Purpose The Woleet API provides an easy and cheap way to create **timestamped proofs of existence** and **timestamped proofs of signature** for your data (which can be of any type). Proofs created are **stored in the Bitcoin blockchain** and so are independent from Woleet (an access to the Bitcoin blockchain and some client side open source code is enough to verify proofs). Using the Woleet API, you can create durable and unfalsifiable cryptographic proofs usable to prove your data existed in a given state at a given date, and optionally was signed by a given signee.  The Woleet API creates **proofs of existence** conform to the open source standard [ChainPoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, without any interaction with Woleet, and so remain **verifiable forever** even if Woleet stops its operations.  The Woleet API creates **proofs of signature** that are an extension of the same standard proposed by Woleet (we are actively involved in the standardization process). Thus, the existence and timestamp of a signature is verifiable using the same tools used to verify proofs of existence. When it comes to verifying the validity of the signature and the identity of the signee, some additional processing is performed: since this processing can be fully performed client side with no additional data, proofs of signature remain **verifiable forever** even if Woleet stops its operations. # Creating proofs To create a **proof of existence** for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you only need to compute the SHA256 hash of the file client side and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or on the type of the file, and the file is not even leaked to Woleet.  To create a **proof of signature** for a file, you also need to create an anchor, and so to compute the SHA256 hash of the file and choose a name for the anchor, but some additional data is required: your public key (the one associated with the private key used to sign the SHA256 hash of the file) and your signature itself. Optionally, you can provide a URL allowing to verify your identity by ensuring you own the public key and the TLS certificate of the URL.  Newly created **anchors are automatically collected** by the platform and **recorded in the Bitcoin blockchain**: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate a URL to an anchor that the platform will call whenever the anchor status changes.  Once an anchor is recorded in the Bitcoin blockchain, you can retrieve its associated **proof receipt** using the Woleet API. Proof receipts **conform to the [ChainPoint](https://www.chainpoint.org/) standard receipt format** (with some extension when it comes to proofs of signature). The proof receipt is the only piece of data required to prove the existence/signature of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt on-demand whenever you want to verify a file. # Verifying proofs Verifying a **proof of existence** using the Woleet API is straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, so you just need to check that the SHA256 hash of the file matches the proof receipt's `hash` property.  Verifying a **proof of signature** using the Woleet API is also straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, then verifies the signature, and optionally verifies that the signee owns the public key and the TLS certificate, so you just need to check that the SHA256 hash of the file matches the proof receipt's `signedHash` property.  The Woleet API can also be used to verify any ChainPoint standard receipts, including the ones created by other providers.  Woleet also provides an open source [JavaScript library for web clients](https://github.com/woleet/woleet-weblibs) implementing the full verification process without the help of the Woleet API. # About public and private anchors An anchor can be public (which is the default) or private.  A **private anchor** is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the data to anyone wanting to verify the proof.  A **public anchor** is discoverable by anyone knowing the hash of the data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to retrieve the proof receipt using only the data hash as input, and then to verify it using the Woleet API or any other mean: - use the `/anchorids` endpoint to retrieve the anchor identifier by its hash - use the `receipt/{anchorid}` endpoint to retrieve the proof receipt (which includes the anchor's metadata). - use the `receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the data or signature timestamp.  # About the verification process For your understanding, here is a formal description of the verification process of a **proof of existence**: - compute the SHA256 hash of the file - check that the `target_hash` property of the proof receipt matches the hash of the file - check that the `target_proof` property of the proof receipt is a valid Merkle proof (see the [ChainPoint](https://www.chainpoint.org/) standard for this step) - retrieve the Bitcoin transaction matching the `tx_id` property of the proof receipt - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkle_root` property of the proof receipt  For **proof of signature**, an additional verification process is performed: - check that the SHA256 hash of the `signature` property matches its `target_hash` property - check that the `signature` property is a valid signature of the `signedHash` property for the public key stored in the `pubKey` property - additionally, if an `identityURL` property is available:   - call `identityURL` to make the callee sign some random data using the public key `pubKey`    - check that the returned signature is valid    - get the TLS certificates of the URL (it must be an HTTPS URL) to get insight about the signee identity 
 *
 * OpenAPI spec version: 1.2.2
 * Contact: contact@woleet.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createAnchorValidateBeforeCall(Anchor anchor, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchor' is set
        if (anchor == null) {
            throw new ApiException("Missing the required parameter 'anchor' when calling createAnchor(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createAnchorCall(anchor, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new anchor.
     * Use this operation to create a new anchor.&lt;br&gt; An anchor can be: - a data anchor (generating a proof of existence receipt) allows to prove the existence of some data at some point in time.&lt;br&gt; - a signature anchor (generating a proof of signature receipt) allows to prove the existence of the signature of some data at some point in time, the validity of the signature and the identity of the signee.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required (though the property &#x60;identityURL&#x60; is highly recommended): the &#x60;signedHash&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have at least 1 anchoring credit on your account. The &#x60;signature&#x60; property must contains a valid signature of the &#x60;data&#x60; property using the private key paired with the &#x60;pubKey&#x60; public key. 
     * @param anchor Anchor object to create. (required)
     * @return Anchor
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchor createAnchor(Anchor anchor) throws ApiException {
        ApiResponse<Anchor> resp = createAnchorWithHttpInfo(anchor);
        return resp.getData();
    }

    /**
     * Create a new anchor.
     * Use this operation to create a new anchor.&lt;br&gt; An anchor can be: - a data anchor (generating a proof of existence receipt) allows to prove the existence of some data at some point in time.&lt;br&gt; - a signature anchor (generating a proof of signature receipt) allows to prove the existence of the signature of some data at some point in time, the validity of the signature and the identity of the signee.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required (though the property &#x60;identityURL&#x60; is highly recommended): the &#x60;signedHash&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have at least 1 anchoring credit on your account. The &#x60;signature&#x60; property must contains a valid signature of the &#x60;data&#x60; property using the private key paired with the &#x60;pubKey&#x60; public key. 
     * @param anchor Anchor object to create. (required)
     * @return ApiResponse&lt;Anchor&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchor> createAnchorWithHttpInfo(Anchor anchor) throws ApiException {
        com.squareup.okhttp.Call call = createAnchorValidateBeforeCall(anchor, null, null);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new anchor. (asynchronously)
     * Use this operation to create a new anchor.&lt;br&gt; An anchor can be: - a data anchor (generating a proof of existence receipt) allows to prove the existence of some data at some point in time.&lt;br&gt; - a signature anchor (generating a proof of signature receipt) allows to prove the existence of the signature of some data at some point in time, the validity of the signature and the identity of the signee.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required (though the property &#x60;identityURL&#x60; is highly recommended): the &#x60;signedHash&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have at least 1 anchoring credit on your account. The &#x60;signature&#x60; property must contains a valid signature of the &#x60;data&#x60; property using the private key paired with the &#x60;pubKey&#x60; public key. 
     * @param anchor Anchor object to create. (required)
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

        com.squareup.okhttp.Call call = createAnchorValidateBeforeCall(anchor, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for deleteAnchor */
    private com.squareup.okhttp.Call deleteAnchorCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteAnchorValidateBeforeCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling deleteAnchor(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteAnchorCall(anchorid, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete an existing anchor.
     * Use this operation to delete a given anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 
     * @param anchorid Identifier of the anchor to delete. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteAnchor(String anchorid) throws ApiException {
        deleteAnchorWithHttpInfo(anchorid);
    }

    /**
     * Delete an existing anchor.
     * Use this operation to delete a given anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 
     * @param anchorid Identifier of the anchor to delete. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteAnchorWithHttpInfo(String anchorid) throws ApiException {
        com.squareup.okhttp.Call call = deleteAnchorValidateBeforeCall(anchorid, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete an existing anchor. (asynchronously)
     * Use this operation to delete a given anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 
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

        com.squareup.okhttp.Call call = deleteAnchorValidateBeforeCall(anchorid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getAnchor */
    private com.squareup.okhttp.Call getAnchorCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAnchorValidateBeforeCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling getAnchor(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getAnchorCall(anchorid, progressListener, progressRequestListener);
        return call;

        
        
        
        
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
        com.squareup.okhttp.Call call = getAnchorValidateBeforeCall(anchorid, null, null);
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

        com.squareup.okhttp.Call call = getAnchorValidateBeforeCall(anchorid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchAnchorIds */
    private com.squareup.okhttp.Call searchAnchorIdsCall(Integer page, Integer size, String hash, String signedHash, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/anchorids".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));
        if (hash != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hash", hash));
        if (signedHash != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "signedHash", signedHash));

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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchAnchorIdsValidateBeforeCall(Integer page, Integer size, String hash, String signedHash, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = searchAnchorIdsCall(page, size, hash, signedHash, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Search for public anchors&#39; identifiers.
     * Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param hash &#x60;hash&#x60; to search for: all public anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all public anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @return AnchorIds
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AnchorIds searchAnchorIds(Integer page, Integer size, String hash, String signedHash) throws ApiException {
        ApiResponse<AnchorIds> resp = searchAnchorIdsWithHttpInfo(page, size, hash, signedHash);
        return resp.getData();
    }

    /**
     * Search for public anchors&#39; identifiers.
     * Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param hash &#x60;hash&#x60; to search for: all public anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all public anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @return ApiResponse&lt;AnchorIds&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AnchorIds> searchAnchorIdsWithHttpInfo(Integer page, Integer size, String hash, String signedHash) throws ApiException {
        com.squareup.okhttp.Call call = searchAnchorIdsValidateBeforeCall(page, size, hash, signedHash, null, null);
        Type localVarReturnType = new TypeToken<AnchorIds>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for public anchors&#39; identifiers. (asynchronously)
     * Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param hash &#x60;hash&#x60; to search for: all public anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all public anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAnchorIdsAsync(Integer page, Integer size, String hash, String signedHash, final ApiCallback<AnchorIds> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchAnchorIdsValidateBeforeCall(page, size, hash, signedHash, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AnchorIds>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchAnchors */
    private com.squareup.okhttp.Call searchAnchorsCall(Integer page, Integer size, String direction, String sort, String name, String hash, String signedHash, List<String> tags, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        if (signedHash != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "signedHash", signedHash));
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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchAnchorsValidateBeforeCall(Integer page, Integer size, String direction, String sort, String name, String hash, String signedHash, List<String> tags, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = searchAnchorsCall(page, size, direction, sort, name, hash, signedHash, tags, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Search for anchors.
     * Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60;, &#x60;hash&#x60; and &#x60;signedHash&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all anchors whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large anchor set.**  (optional)
     * @param hash &#x60;hash&#x60; to search for: all anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @param tags &#x60;tags&#x60; to search for: all anchors having all of these tags sets are returned.  (optional)
     * @return Anchors
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchors searchAnchors(Integer page, Integer size, String direction, String sort, String name, String hash, String signedHash, List<String> tags) throws ApiException {
        ApiResponse<Anchors> resp = searchAnchorsWithHttpInfo(page, size, direction, sort, name, hash, signedHash, tags);
        return resp.getData();
    }

    /**
     * Search for anchors.
     * Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60;, &#x60;hash&#x60; and &#x60;signedHash&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all anchors whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large anchor set.**  (optional)
     * @param hash &#x60;hash&#x60; to search for: all anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @param tags &#x60;tags&#x60; to search for: all anchors having all of these tags sets are returned.  (optional)
     * @return ApiResponse&lt;Anchors&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchors> searchAnchorsWithHttpInfo(Integer page, Integer size, String direction, String sort, String name, String hash, String signedHash, List<String> tags) throws ApiException {
        com.squareup.okhttp.Call call = searchAnchorsValidateBeforeCall(page, size, direction, sort, name, hash, signedHash, tags, null, null);
        Type localVarReturnType = new TypeToken<Anchors>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for anchors. (asynchronously)
     * Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60;, &#x60;hash&#x60; and &#x60;signedHash&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all anchors whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large anchor set.**  (optional)
     * @param hash &#x60;hash&#x60; to search for: all anchors whose &#x60;hash&#x60; property is equal are returned.  (optional)
     * @param signedHash &#x60;signedHash&#x60; to search for: all anchors whose &#x60;signedHash&#x60; property is equal are returned.  (optional)
     * @param tags &#x60;tags&#x60; to search for: all anchors having all of these tags sets are returned.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAnchorsAsync(Integer page, Integer size, String direction, String sort, String name, String hash, String signedHash, List<String> tags, final ApiCallback<Anchors> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchAnchorsValidateBeforeCall(page, size, direction, sort, name, hash, signedHash, tags, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchors>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for updateAnchor */
    private com.squareup.okhttp.Call updateAnchorCall(String anchorid, Anchor anchor, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = anchor;
        
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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateAnchorValidateBeforeCall(String anchorid, Anchor anchor, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling updateAnchor(Async)");
        }
        
        // verify the required parameter 'anchor' is set
        if (anchor == null) {
            throw new ApiException("Missing the required parameter 'anchor' when calling updateAnchor(Async)");
        }
        
        
        com.squareup.okhttp.Call call = updateAnchorCall(anchorid, anchor, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update an existing anchor.
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update. (required)
     * @param anchor Anchor object to update. (required)
     * @return Anchor
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Anchor updateAnchor(String anchorid, Anchor anchor) throws ApiException {
        ApiResponse<Anchor> resp = updateAnchorWithHttpInfo(anchorid, anchor);
        return resp.getData();
    }

    /**
     * Update an existing anchor.
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update. (required)
     * @param anchor Anchor object to update. (required)
     * @return ApiResponse&lt;Anchor&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Anchor> updateAnchorWithHttpInfo(String anchorid, Anchor anchor) throws ApiException {
        com.squareup.okhttp.Call call = updateAnchorValidateBeforeCall(anchorid, anchor, null, null);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update an existing anchor. (asynchronously)
     * Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 
     * @param anchorid Identifier of anchor to update. (required)
     * @param anchor Anchor object to update. (required)
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

        com.squareup.okhttp.Call call = updateAnchorValidateBeforeCall(anchorid, anchor, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Anchor>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
