/*
 * Woleet API
 * # Basics  The Woleet API is an **HTTP REST API**. It supports **CORS** and provides **Basic authentication** and **JWT authentication**, allowing an easy and secure interaction with both web clients and backend applications.   The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and, from it, **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.   Ready to use versions of the client code are provided as open source code for [JavaScript/NodeJS](https://github.com/woleet/woleet-openapi-js-client) and [Java](https://github.com/woleet/woleet-openapi-java-client).   The API base URL is **https://api.woleet.io/v1**.  # Authentication  The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.   The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using Basic authentication) and then provide this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme.  # Purpose  The Woleet API provides an easy and cheap way to create **timestamped proofs of existence** and **timestamped proofs of signature** for your data (which can be of any type). Proofs created are **stored in the Bitcoin blockchain** and so are independent from Woleet (an access to the Bitcoin blockchain and some client side open source code is enough to verify proofs). Using the Woleet API, you can create durable and unfalsifiable cryptographic proofs usable to prove your data existed in a given state at a given date, and optionally was signed by a given signee.   The Woleet API creates **proofs of existence** conform to the open source standard [Chainpoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, without any interaction with Woleet, and so remain **verifiable forever** even if Woleet stops its operations.   The Woleet API creates **proofs of signature** that are an extension of the same standard proposed by Woleet (we are actively involved in the standardization process). Thus, the existence and timestamp of a signature is verifiable using the same tools used to verify proofs of existence. When it comes to verifying the validity of the signature and the signee's identity, some additional processing is performed: since this processing can be fully performed client side with no additional data, proofs of signature remain **verifiable forever** even if Woleet stops its operations.  # Creating proofs  To create a **proof of existence** for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you only need to compute the SHA256 hash of the file client side and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or on the type of the file, and the file is not even leaked to Woleet.   To create a **proof of signature** for a file, you also need to create an anchor, and so to compute the SHA256 hash of the file and choose a name for the anchor, but some additional data is required: your public key (the one associated with the private key used to sign the SHA256 hash of the file) and your signature itself. Optionally, you can provide a URL allowing to verify your identity by ensuring you own the public key and the TLS certificate of the URL.   Newly created **anchors are automatically collected** by the platform and **recorded in the Bitcoin blockchain**: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate a URL to an anchor that the platform will call whenever the anchor status changes.   Once an anchor is recorded in the Bitcoin blockchain, you can retrieve its associated **proof receipt** using the Woleet API. Proof receipts **conform to the [Chainpoint 1 or 2](https://www.chainpoint.org/) proof receipt format** (with some Woleet extensions when it comes to proofs of signature). The proof receipt is the only piece of data required to prove the existence/signature of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt on-demand whenever you want to verify a file.  # Verifying proofs  Verifying a **proof of existence** using the Woleet API is straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, so you just need to check that the SHA256 hash of the file matches the proof receipt's `hash` property.   Verifying a **proof of signature** using the Woleet API is also straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, then verifies the signature, and optionally verifies that the signee owns the public key and the TLS certificate, so you just need to check that the SHA256 hash of the file matches the proof receipt's `signedHash` property.   The Woleet API can also be used to verify any Chainpoint 1 or 2 proof receipt, including those created by other providers.   Woleet also provides an open source [JavaScript library for web clients](https://github.com/woleet/woleet-weblibs) implementing the full verification process without the help of the Woleet API.  # About public and private anchors  An anchor can be public (which is the default) or private.   A **private anchor** is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the data to anyone wanting to verify the proof.   A **public anchor** is discoverable by anyone knowing the hash of the data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to retrieve the proof receipt using only the data hash as input, and then to verify it using the Woleet API or any other mean:  - use the `/anchorids` endpoint to retrieve the anchor identifier by its hash  - use the `/receipt/{anchorid}` endpoint to retrieve the proof receipt.  - use the `/receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the data or signature timestamp.  # About the verification process  For your understanding, here is a formal description of the verification process of a **proof of existence**:  - compute the SHA256 hash of the file  - check that the `targetHash` property of the proof receipt matches the hash of the file  - check that the `proof` property of the proof receipt is a valid Merkle proof (see the [Chainpoint](https://www.chainpoint.org/) standard for this step)  - retrieve the Bitcoin transaction from the `anchors` property of the proof receipt  - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkleRoot` property of the proof receipt   For **proof of signature**, an additional verification process is performed:  - check that the SHA256 hash of the `signature` property matches its `targetHash` property  - check that the `signature` property is a valid signature of the `signedHash` property for the public key stored in the `pubKey` property  - additionally, if an `identityURL` property is available:   - call `identityURL` to make the callee sign some random data using the public key `pubKey`    - check that the returned signature is valid    - get the TLS certificates of the URL (it must be an HTTPS URL) to get insight about the signee's identity  # Using domains  If you want to use the Woleet API for a given domain (eg. the \"acme\" domain, that would be accessible at **https://`acme`.woleet.io/_**) you still have to use the base URL **https://api.woleet.io/v1**, but you need to specify the domain to use by adding a `Domain` header to your calls. Obviously, you need to authenticate using the credentials of one of the domain's users. 
 *
 * OpenAPI spec version: 1.5.0
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
     * Build call for getReceipt
     * @param anchorid Identifier of the anchor for which to build the proof receipt. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getReceiptCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/receipt/{anchorid}"
            .replaceAll("\\{" + "anchorid" + "\\}", apiClient.escapeString(anchorid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getReceiptValidateBeforeCall(String anchorid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'anchorid' is set
        if (anchorid == null) {
            throw new ApiException("Missing the required parameter 'anchorid' when calling getReceipt(Async)");
        }
        

        com.squareup.okhttp.Call call = getReceiptCall(anchorid, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the proof receipt of an anchor.
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorid Identifier of the anchor for which to build the proof receipt. (required)
     * @return Receipt
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Receipt getReceipt(String anchorid) throws ApiException {
        ApiResponse<Receipt> resp = getReceiptWithHttpInfo(anchorid);
        return resp.getData();
    }

    /**
     * Get the proof receipt of an anchor.
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorid Identifier of the anchor for which to build the proof receipt. (required)
     * @return ApiResponse&lt;Receipt&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Receipt> getReceiptWithHttpInfo(String anchorid) throws ApiException {
        com.squareup.okhttp.Call call = getReceiptValidateBeforeCall(anchorid, null, null);
        Type localVarReturnType = new TypeToken<Receipt>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the proof receipt of an anchor. (asynchronously)
     * Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 
     * @param anchorid Identifier of the anchor for which to build the proof receipt. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getReceiptAsync(String anchorid, final ApiCallback<Receipt> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getReceiptValidateBeforeCall(anchorid, progressListener, progressRequestListener);
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
     * Use this operation to verify a Chainpoint proof receipt.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
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
     * Use this operation to verify a Chainpoint proof receipt.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
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
     * Use this operation to verify a Chainpoint proof receipt.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
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
