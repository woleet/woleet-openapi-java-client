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


import io.woleet.api.client.model.User;
import io.woleet.api.client.model.Users;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainApi {
    private ApiClient apiClient;

    public DomainApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DomainApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createDomainUser
     * @param user User object to create (password must be provided). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createDomainUserCall(User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/domain/admin/user";

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createDomainUserValidateBeforeCall(User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling createDomainUser(Async)");
        }
        

        com.squareup.okhttp.Call call = createDomainUserCall(user, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new domain user.
     * Use this operation to create a new user for a domain.
     * @param user User object to create (password must be provided). (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public User createDomainUser(User user) throws ApiException {
        ApiResponse<User> resp = createDomainUserWithHttpInfo(user);
        return resp.getData();
    }

    /**
     * Create a new domain user.
     * Use this operation to create a new user for a domain.
     * @param user User object to create (password must be provided). (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<User> createDomainUserWithHttpInfo(User user) throws ApiException {
        com.squareup.okhttp.Call call = createDomainUserValidateBeforeCall(user, null, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new domain user. (asynchronously)
     * Use this operation to create a new user for a domain.
     * @param user User object to create (password must be provided). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createDomainUserAsync(User user, final ApiCallback<User> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createDomainUserValidateBeforeCall(user, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteDomainUser
     * @param userid Identifier of the user to delete. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteDomainUserCall(String userid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userid}"
            .replaceAll("\\{" + "userid" + "\\}", apiClient.escapeString(userid.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteDomainUserValidateBeforeCall(String userid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userid' is set
        if (userid == null) {
            throw new ApiException("Missing the required parameter 'userid' when calling deleteDomainUser(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteDomainUserCall(userid, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a user.
     * Use this operation to delete a user.
     * @param userid Identifier of the user to delete. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDomainUser(String userid) throws ApiException {
        deleteDomainUserWithHttpInfo(userid);
    }

    /**
     * Delete a user.
     * Use this operation to delete a user.
     * @param userid Identifier of the user to delete. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteDomainUserWithHttpInfo(String userid) throws ApiException {
        com.squareup.okhttp.Call call = deleteDomainUserValidateBeforeCall(userid, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a user. (asynchronously)
     * Use this operation to delete a user.
     * @param userid Identifier of the user to delete. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDomainUserAsync(String userid, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteDomainUserValidateBeforeCall(userid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getDomainUser
     * @param userid Identifier of the user to retrieve. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDomainUserCall(String userid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userid}"
            .replaceAll("\\{" + "userid" + "\\}", apiClient.escapeString(userid.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDomainUserValidateBeforeCall(String userid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userid' is set
        if (userid == null) {
            throw new ApiException("Missing the required parameter 'userid' when calling getDomainUser(Async)");
        }
        

        com.squareup.okhttp.Call call = getDomainUserCall(userid, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a user by its identifier.
     * Use this operation to retrieve a user by its identifier.
     * @param userid Identifier of the user to retrieve. (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public User getDomainUser(String userid) throws ApiException {
        ApiResponse<User> resp = getDomainUserWithHttpInfo(userid);
        return resp.getData();
    }

    /**
     * Get a user by its identifier.
     * Use this operation to retrieve a user by its identifier.
     * @param userid Identifier of the user to retrieve. (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<User> getDomainUserWithHttpInfo(String userid) throws ApiException {
        com.squareup.okhttp.Call call = getDomainUserValidateBeforeCall(userid, null, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a user by its identifier. (asynchronously)
     * Use this operation to retrieve a user by its identifier.
     * @param userid Identifier of the user to retrieve. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDomainUserAsync(String userid, final ApiCallback<User> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDomainUserValidateBeforeCall(userid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDomainUsers
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;email&#x60;, &#x60;status&#x60; and &#x60;roles&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string or regex of the email.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDomainUsersCall(Integer page, Integer size, String direction, String sort, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));
        if (direction != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("direction", direction));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (email != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("email", email));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDomainUsersValidateBeforeCall(Integer page, Integer size, String direction, String sort, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getDomainUsersCall(page, size, direction, sort, email, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Search for users.
     * Use this operation to retrieve all users having a given &#x60;email&#x60; property.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;email&#x60;, &#x60;status&#x60; and &#x60;roles&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string or regex of the email.  (optional)
     * @return Users
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Users getDomainUsers(Integer page, Integer size, String direction, String sort, String email) throws ApiException {
        ApiResponse<Users> resp = getDomainUsersWithHttpInfo(page, size, direction, sort, email);
        return resp.getData();
    }

    /**
     * Search for users.
     * Use this operation to retrieve all users having a given &#x60;email&#x60; property.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;email&#x60;, &#x60;status&#x60; and &#x60;roles&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string or regex of the email.  (optional)
     * @return ApiResponse&lt;Users&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Users> getDomainUsersWithHttpInfo(Integer page, Integer size, String direction, String sort, String email) throws ApiException {
        com.squareup.okhttp.Call call = getDomainUsersValidateBeforeCall(page, size, direction, sort, email, null, null);
        Type localVarReturnType = new TypeToken<Users>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for users. (asynchronously)
     * Use this operation to retrieve all users having a given &#x60;email&#x60; property.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;email&#x60;, &#x60;status&#x60; and &#x60;roles&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string or regex of the email.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDomainUsersAsync(Integer page, Integer size, String direction, String sort, String email, final ApiCallback<Users> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDomainUsersValidateBeforeCall(page, size, direction, sort, email, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Users>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateDomainUser
     * @param userid Identifier of the user to update. (required)
     * @param user User object to update. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateDomainUserCall(String userid, User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userid}"
            .replaceAll("\\{" + "userid" + "\\}", apiClient.escapeString(userid.toString()));

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

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateDomainUserValidateBeforeCall(String userid, User user, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userid' is set
        if (userid == null) {
            throw new ApiException("Missing the required parameter 'userid' when calling updateDomainUser(Async)");
        }
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling updateDomainUser(Async)");
        }
        

        com.squareup.okhttp.Call call = updateDomainUserCall(userid, user, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update a user.
     * Use this operation to update a user.
     * @param userid Identifier of the user to update. (required)
     * @param user User object to update. (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public User updateDomainUser(String userid, User user) throws ApiException {
        ApiResponse<User> resp = updateDomainUserWithHttpInfo(userid, user);
        return resp.getData();
    }

    /**
     * Update a user.
     * Use this operation to update a user.
     * @param userid Identifier of the user to update. (required)
     * @param user User object to update. (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<User> updateDomainUserWithHttpInfo(String userid, User user) throws ApiException {
        com.squareup.okhttp.Call call = updateDomainUserValidateBeforeCall(userid, user, null, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a user. (asynchronously)
     * Use this operation to update a user.
     * @param userid Identifier of the user to update. (required)
     * @param user User object to update. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateDomainUserAsync(String userid, User user, final ApiCallback<User> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateDomainUserValidateBeforeCall(userid, user, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
