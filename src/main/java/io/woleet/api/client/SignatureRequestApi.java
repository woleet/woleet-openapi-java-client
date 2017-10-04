/*
 * Woleet API
 * # Basics The Woleet API is an **HTTP REST API**. It supports **CORS** and provides **Basic authentication** and **JWT authentication**, allowing an easy and secure interaction with both web clients and backend applications.  The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and, from it, **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.  Ready to use versions of the client code are provided as open source code for [JavaScript/NodeJS](https://github.com/woleet/woleet-openapi-js-client) and [Java](https://github.com/woleet/woleet-openapi-java-client).  The API base URL is **https://api.woleet.io/v1**. # Authentication The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.  The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using Basic authentication) and then provide this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme. # Purpose The Woleet API provides an easy and cheap way to create **timestamped proofs of existence** and **timestamped proofs of signature** for your data (which can be of any type). Proofs created are **stored in the Bitcoin blockchain** and so are independent from Woleet (an access to the Bitcoin blockchain and some client side open source code is enough to verify proofs). Using the Woleet API, you can create durable and unfalsifiable cryptographic proofs usable to prove your data existed in a given state at a given date, and optionally was signed by a given signee.  The Woleet API creates **proofs of existence** conform to the open source standard [ChainPoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, without any interaction with Woleet, and so remain **verifiable forever** even if Woleet stops its operations.  The Woleet API creates **proofs of signature** that are an extension of the same standard proposed by Woleet (we are actively involved in the standardization process). Thus, the existence and timestamp of a signature is verifiable using the same tools used to verify proofs of existence. When it comes to verifying the validity of the signature and the signee's identity, some additional processing is performed: since this processing can be fully performed client side with no additional data, proofs of signature remain **verifiable forever** even if Woleet stops its operations. # Creating proofs To create a **proof of existence** for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you only need to compute the SHA256 hash of the file client side and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or on the type of the file, and the file is not even leaked to Woleet.  To create a **proof of signature** for a file, you also need to create an anchor, and so to compute the SHA256 hash of the file and choose a name for the anchor, but some additional data is required: your public key (the one associated with the private key used to sign the SHA256 hash of the file) and your signature itself. Optionally, you can provide a URL allowing to verify your identity by ensuring you own the public key and the TLS certificate of the URL.  Newly created **anchors are automatically collected** by the platform and **recorded in the Bitcoin blockchain**: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate a URL to an anchor that the platform will call whenever the anchor status changes.  Once an anchor is recorded in the Bitcoin blockchain, you can retrieve its associated **proof receipt** using the Woleet API. Proof receipts **conform to the [ChainPoint](https://www.chainpoint.org/) standard receipt format** (with some extension when it comes to proofs of signature). The proof receipt is the only piece of data required to prove the existence/signature of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt on-demand whenever you want to verify a file. # Verifying proofs Verifying a **proof of existence** using the Woleet API is straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, so you just need to check that the SHA256 hash of the file matches the proof receipt's `hash` property.  Verifying a **proof of signature** using the Woleet API is also straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, then verifies the signature, and optionally verifies that the signee owns the public key and the TLS certificate, so you just need to check that the SHA256 hash of the file matches the proof receipt's `signedHash` property.  The Woleet API can also be used to verify any ChainPoint standard receipts, including the ones created by other providers.  Woleet also provides an open source [JavaScript library for web clients](https://github.com/woleet/woleet-weblibs) implementing the full verification process without the help of the Woleet API. # About public and private anchors An anchor can be public (which is the default) or private.  A **private anchor** is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the data to anyone wanting to verify the proof.  A **public anchor** is discoverable by anyone knowing the hash of the data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to retrieve the proof receipt using only the data hash as input, and then to verify it using the Woleet API or any other mean: - use the `/anchorids` endpoint to retrieve the anchor identifier by its hash - use the `receipt/{anchorid}` endpoint to retrieve the proof receipt. - use the `receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the data or signature timestamp.  # About the verification process For your understanding, here is a formal description of the verification process of a **proof of existence**: - compute the SHA256 hash of the file - check that the `target_hash` property of the proof receipt matches the hash of the file - check that the `target_proof` property of the proof receipt is a valid Merkle proof (see the [ChainPoint](https://www.chainpoint.org/) standard for this step) - retrieve the Bitcoin transaction matching the `tx_id` property of the proof receipt - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkle_root` property of the proof receipt  For **proof of signature**, an additional verification process is performed: - check that the SHA256 hash of the `signature` property matches its `target_hash` property - check that the `signature` property is a valid signature of the `signedHash` property for the public key stored in the `pubKey` property - additionally, if an `identityURL` property is available:   - call `identityURL` to make the callee sign some random data using the public key `pubKey`    - check that the returned signature is valid    - get the TLS certificates of the URL (it must be an HTTPS URL) to get insight about the signee's identity 
 *
 * OpenAPI spec version: 1.3.1
 * Contact: contact@woleet.com
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


import io.woleet.api.client.model.SignatureRequest;
import io.woleet.api.client.model.SignatureRequestSign;
import io.woleet.api.client.model.SignatureRequestSignResult;
import io.woleet.api.client.model.SignatureRequests;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignatureRequestApi {
    private ApiClient apiClient;

    public SignatureRequestApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SignatureRequestApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createSignatureRequest
     * @param signatureRequest SignatureRequest object to create. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createSignatureRequestCall(SignatureRequest signatureRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = signatureRequest;
        
        // create path and map variables
        String localVarPath = "/signatureRequest";

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createSignatureRequestValidateBeforeCall(SignatureRequest signatureRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'signatureRequest' is set
        if (signatureRequest == null) {
            throw new ApiException("Missing the required parameter 'signatureRequest' when calling createSignatureRequest(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createSignatureRequestCall(signatureRequest, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new signature request.
     * Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have enough anchoring credits on your account to fulfill the signature request (each signature registered will cost you 1 anchoring credit).&lt;br&gt; 
     * @param signatureRequest SignatureRequest object to create. (required)
     * @return SignatureRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureRequest createSignatureRequest(SignatureRequest signatureRequest) throws ApiException {
        ApiResponse<SignatureRequest> resp = createSignatureRequestWithHttpInfo(signatureRequest);
        return resp.getData();
    }

    /**
     * Create a new signature request.
     * Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have enough anchoring credits on your account to fulfill the signature request (each signature registered will cost you 1 anchoring credit).&lt;br&gt; 
     * @param signatureRequest SignatureRequest object to create. (required)
     * @return ApiResponse&lt;SignatureRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureRequest> createSignatureRequestWithHttpInfo(SignatureRequest signatureRequest) throws ApiException {
        com.squareup.okhttp.Call call = createSignatureRequestValidateBeforeCall(signatureRequest, null, null);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new signature request. (asynchronously)
     * Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have enough anchoring credits on your account to fulfill the signature request (each signature registered will cost you 1 anchoring credit).&lt;br&gt; 
     * @param signatureRequest SignatureRequest object to create. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createSignatureRequestAsync(SignatureRequest signatureRequest, final ApiCallback<SignatureRequest> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createSignatureRequestValidateBeforeCall(signatureRequest, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteSignatureRequest
     * @param requestId Identifier of the signature request to delete. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteSignatureRequestCall(String requestId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/signatureRequest/{requestId}"
            .replaceAll("\\{" + "requestId" + "\\}", apiClient.escapeString(requestId.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteSignatureRequestValidateBeforeCall(String requestId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'requestId' is set
        if (requestId == null) {
            throw new ApiException("Missing the required parameter 'requestId' when calling deleteSignatureRequest(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteSignatureRequestCall(requestId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a signature request.
     * Use this operation to delete a signature request.&lt;br&gt; 
     * @param requestId Identifier of the signature request to delete. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteSignatureRequest(String requestId) throws ApiException {
        deleteSignatureRequestWithHttpInfo(requestId);
    }

    /**
     * Delete a signature request.
     * Use this operation to delete a signature request.&lt;br&gt; 
     * @param requestId Identifier of the signature request to delete. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteSignatureRequestWithHttpInfo(String requestId) throws ApiException {
        com.squareup.okhttp.Call call = deleteSignatureRequestValidateBeforeCall(requestId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a signature request. (asynchronously)
     * Use this operation to delete a signature request.&lt;br&gt; 
     * @param requestId Identifier of the signature request to delete. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteSignatureRequestAsync(String requestId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteSignatureRequestValidateBeforeCall(requestId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getSignatureRequest
     * @param requestId Identifier of the signature request to retrieve. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSignatureRequestCall(String requestId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/signatureRequest/{requestId}"
            .replaceAll("\\{" + "requestId" + "\\}", apiClient.escapeString(requestId.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSignatureRequestValidateBeforeCall(String requestId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'requestId' is set
        if (requestId == null) {
            throw new ApiException("Missing the required parameter 'requestId' when calling getSignatureRequest(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getSignatureRequestCall(requestId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a signature request by its identifier.
     * Use this operation to retrieve a signature request by its identifier.
     * @param requestId Identifier of the signature request to retrieve. (required)
     * @return SignatureRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureRequest getSignatureRequest(String requestId) throws ApiException {
        ApiResponse<SignatureRequest> resp = getSignatureRequestWithHttpInfo(requestId);
        return resp.getData();
    }

    /**
     * Get a signature request by its identifier.
     * Use this operation to retrieve a signature request by its identifier.
     * @param requestId Identifier of the signature request to retrieve. (required)
     * @return ApiResponse&lt;SignatureRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureRequest> getSignatureRequestWithHttpInfo(String requestId) throws ApiException {
        com.squareup.okhttp.Call call = getSignatureRequestValidateBeforeCall(requestId, null, null);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a signature request by its identifier. (asynchronously)
     * Use this operation to retrieve a signature request by its identifier.
     * @param requestId Identifier of the signature request to retrieve. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSignatureRequestAsync(String requestId, final ApiCallback<SignatureRequest> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSignatureRequestValidateBeforeCall(requestId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for searchSignatureRequests
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60; and &#x60;hashToSign&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large request set.**  (optional)
     * @param hashToSign &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchSignatureRequestsCall(Integer page, Integer size, String direction, String sort, String name, String hashToSign, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/signatureRequests";

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
        if (hashToSign != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "hashToSign", hashToSign));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchSignatureRequestsValidateBeforeCall(Integer page, Integer size, String direction, String sort, String name, String hashToSign, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = searchSignatureRequestsCall(page, size, direction, sort, name, hashToSign, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Search for signature requests.
     * Use this operation to retrieve all signature requests having a given &#x60;name&#x60; and/or &#x60;hashToSign&#x60; property.&lt;br&gt; Only requests belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60; and &#x60;hashToSign&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large request set.**  (optional)
     * @param hashToSign &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  (optional)
     * @return SignatureRequests
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureRequests searchSignatureRequests(Integer page, Integer size, String direction, String sort, String name, String hashToSign) throws ApiException {
        ApiResponse<SignatureRequests> resp = searchSignatureRequestsWithHttpInfo(page, size, direction, sort, name, hashToSign);
        return resp.getData();
    }

    /**
     * Search for signature requests.
     * Use this operation to retrieve all signature requests having a given &#x60;name&#x60; and/or &#x60;hashToSign&#x60; property.&lt;br&gt; Only requests belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60; and &#x60;hashToSign&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large request set.**  (optional)
     * @param hashToSign &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  (optional)
     * @return ApiResponse&lt;SignatureRequests&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureRequests> searchSignatureRequestsWithHttpInfo(Integer page, Integer size, String direction, String sort, String name, String hashToSign) throws ApiException {
        com.squareup.okhttp.Call call = searchSignatureRequestsValidateBeforeCall(page, size, direction, sort, name, hashToSign, null, null);
        Type localVarReturnType = new TypeToken<SignatureRequests>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for signature requests. (asynchronously)
     * Use this operation to retrieve all signature requests having a given &#x60;name&#x60; and/or &#x60;hashToSign&#x60; property.&lt;br&gt; Only requests belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of anchors per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60; and &#x60;hashToSign&#x60;.  (optional, default to created)
     * @param name &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large request set.**  (optional)
     * @param hashToSign &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchSignatureRequestsAsync(Integer page, Integer size, String direction, String sort, String name, String hashToSign, final ApiCallback<SignatureRequests> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchSignatureRequestsValidateBeforeCall(page, size, direction, sort, name, hashToSign, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureRequests>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for signSignatureRequest
     * @param requestId Identifier of the signature request. (required)
     * @param signature Signature to register. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call signSignatureRequestCall(String requestId, SignatureRequestSign signature, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = signature;
        
        // create path and map variables
        String localVarPath = "/signatureRequest/{requestId}/sign"
            .replaceAll("\\{" + "requestId" + "\\}", apiClient.escapeString(requestId.toString()));

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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call signSignatureRequestValidateBeforeCall(String requestId, SignatureRequestSign signature, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'requestId' is set
        if (requestId == null) {
            throw new ApiException("Missing the required parameter 'requestId' when calling signSignatureRequest(Async)");
        }
        
        // verify the required parameter 'signature' is set
        if (signature == null) {
            throw new ApiException("Missing the required parameter 'signature' when calling signSignatureRequest(Async)");
        }
        
        
        com.squareup.okhttp.Call call = signSignatureRequestCall(requestId, signature, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Sign a signature request.
     * Use this operation to register a signature for a signature request.&lt;br&gt; The signature is automatically anchored (on behalf of the owner of the signature request). The signature anchor created is added to the list of signature anchors of the signature request. This is a publicly accessible endpoint: authentication is not required to register a signature. 
     * @param requestId Identifier of the signature request. (required)
     * @param signature Signature to register. (required)
     * @return SignatureRequestSignResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureRequestSignResult signSignatureRequest(String requestId, SignatureRequestSign signature) throws ApiException {
        ApiResponse<SignatureRequestSignResult> resp = signSignatureRequestWithHttpInfo(requestId, signature);
        return resp.getData();
    }

    /**
     * Sign a signature request.
     * Use this operation to register a signature for a signature request.&lt;br&gt; The signature is automatically anchored (on behalf of the owner of the signature request). The signature anchor created is added to the list of signature anchors of the signature request. This is a publicly accessible endpoint: authentication is not required to register a signature. 
     * @param requestId Identifier of the signature request. (required)
     * @param signature Signature to register. (required)
     * @return ApiResponse&lt;SignatureRequestSignResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureRequestSignResult> signSignatureRequestWithHttpInfo(String requestId, SignatureRequestSign signature) throws ApiException {
        com.squareup.okhttp.Call call = signSignatureRequestValidateBeforeCall(requestId, signature, null, null);
        Type localVarReturnType = new TypeToken<SignatureRequestSignResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Sign a signature request. (asynchronously)
     * Use this operation to register a signature for a signature request.&lt;br&gt; The signature is automatically anchored (on behalf of the owner of the signature request). The signature anchor created is added to the list of signature anchors of the signature request. This is a publicly accessible endpoint: authentication is not required to register a signature. 
     * @param requestId Identifier of the signature request. (required)
     * @param signature Signature to register. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call signSignatureRequestAsync(String requestId, SignatureRequestSign signature, final ApiCallback<SignatureRequestSignResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = signSignatureRequestValidateBeforeCall(requestId, signature, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureRequestSignResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateSignatureRequest
     * @param requestId Identifier of signature request to update. (required)
     * @param request SignatureRequest object to update. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateSignatureRequestCall(String requestId, SignatureRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        
        // create path and map variables
        String localVarPath = "/signatureRequest/{requestId}"
            .replaceAll("\\{" + "requestId" + "\\}", apiClient.escapeString(requestId.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateSignatureRequestValidateBeforeCall(String requestId, SignatureRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'requestId' is set
        if (requestId == null) {
            throw new ApiException("Missing the required parameter 'requestId' when calling updateSignatureRequest(Async)");
        }
        
        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling updateSignatureRequest(Async)");
        }
        
        
        com.squareup.okhttp.Call call = updateSignatureRequestCall(requestId, request, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a signature request.
     * Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;suspended&#x60;, &#x60;deadline&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; 
     * @param requestId Identifier of signature request to update. (required)
     * @param request SignatureRequest object to update. (required)
     * @return SignatureRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureRequest updateSignatureRequest(String requestId, SignatureRequest request) throws ApiException {
        ApiResponse<SignatureRequest> resp = updateSignatureRequestWithHttpInfo(requestId, request);
        return resp.getData();
    }

    /**
     * Update a signature request.
     * Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;suspended&#x60;, &#x60;deadline&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; 
     * @param requestId Identifier of signature request to update. (required)
     * @param request SignatureRequest object to update. (required)
     * @return ApiResponse&lt;SignatureRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureRequest> updateSignatureRequestWithHttpInfo(String requestId, SignatureRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateSignatureRequestValidateBeforeCall(requestId, request, null, null);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a signature request. (asynchronously)
     * Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;suspended&#x60;, &#x60;deadline&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; 
     * @param requestId Identifier of signature request to update. (required)
     * @param request SignatureRequest object to update. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateSignatureRequestAsync(String requestId, SignatureRequest request, final ApiCallback<SignatureRequest> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateSignatureRequestValidateBeforeCall(requestId, request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
