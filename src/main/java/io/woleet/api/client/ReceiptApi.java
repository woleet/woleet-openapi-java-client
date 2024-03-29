/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.13.0
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
    private ApiClient localVarApiClient;

    public ReceiptApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ReceiptApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getOTSReceipt
     * @param anchorId Identifier of the data anchor for which to build the proof receipt. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt (conform to the OpenTimestamps format). </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> The proof receipt is not yet available. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOTSReceiptCall(String anchorId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/receipt/{anchorId}/ots"
            .replaceAll("\\{" + "anchorId" + "\\}", localVarApiClient.escapeString(anchorId.toString()));

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getOTSReceiptValidateBeforeCall(String anchorId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'anchorId' is set
        if (anchorId == null) {
            throw new ApiException("Missing the required parameter 'anchorId' when calling getOTSReceipt(Async)");
        }
        

        okhttp3.Call localVarCall = getOTSReceiptCall(anchorId, _callback);
        return localVarCall;

    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format).
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given data anchor (note that this operation is NOT available for signature anchors).&lt;br&gt; This binary file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the data anchor for which to build the proof receipt. (required)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt (conform to the OpenTimestamps format). </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> The proof receipt is not yet available. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public File getOTSReceipt(String anchorId) throws ApiException {
        ApiResponse<File> localVarResp = getOTSReceiptWithHttpInfo(anchorId);
        return localVarResp.getData();
    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format).
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given data anchor (note that this operation is NOT available for signature anchors).&lt;br&gt; This binary file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the data anchor for which to build the proof receipt. (required)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt (conform to the OpenTimestamps format). </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> The proof receipt is not yet available. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<File> getOTSReceiptWithHttpInfo(String anchorId) throws ApiException {
        okhttp3.Call localVarCall = getOTSReceiptValidateBeforeCall(anchorId, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get the proof receipt of an anchor (OpenTimestamps proof format). (asynchronously)
     * Use this operation to retrieve the OpenTimestamps proof receipt associated to a given data anchor (note that this operation is NOT available for signature anchors).&lt;br&gt; This binary file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the data anchor for which to build the proof receipt. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt (conform to the OpenTimestamps format). </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> The proof receipt is not yet available. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getOTSReceiptAsync(String anchorId, final ApiCallback<File> _callback) throws ApiException {

        okhttp3.Call localVarCall = getOTSReceiptValidateBeforeCall(anchorId, _callback);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getReceipt
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param allowPartial &#x60;true&#x60; if a partial proof receipt is to be returned when the proof of timestamp is not yet available (ie. the data or the signature has not yet been anchored).&lt;br&gt; If the proof of timestamp is availalble (anchor is SENT or CONFIRMED) a regular proof receipt is returned (with response code 200). Otherwise, a partial proof receipt not including the proof of timestamp is returned (response code 202).&lt;br&gt; The partial proof receipt of a signature anchor allows to verify the signature and the identity of the signer immediatly after signing, without having to wait for the anchoring process to complete.  (optional, default to false)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt. </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> If &#x60;allowPartial&#x60; is &#x60;false&#x60; or unset: the proof receipt is not yet available.&lt;br&gt; If &#x60;allowPartial&#x60; is &#x60;true&#x60;: the partial proof receipt (returned in the response body).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getReceiptCall(String anchorId, Boolean allowPartial, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/receipt/{anchorId}"
            .replaceAll("\\{" + "anchorId" + "\\}", localVarApiClient.escapeString(anchorId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (allowPartial != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("allowPartial", allowPartial));
        }

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getReceiptValidateBeforeCall(String anchorId, Boolean allowPartial, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'anchorId' is set
        if (anchorId == null) {
            throw new ApiException("Missing the required parameter 'anchorId' when calling getReceipt(Async)");
        }
        

        okhttp3.Call localVarCall = getReceiptCall(anchorId, allowPartial, _callback);
        return localVarCall;

    }

    /**
     * Get the proof receipt of an anchor.
     * Use this operation to retrieve the proof receipt associated to a given anchor.&lt;br&gt; This JSON file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param allowPartial &#x60;true&#x60; if a partial proof receipt is to be returned when the proof of timestamp is not yet available (ie. the data or the signature has not yet been anchored).&lt;br&gt; If the proof of timestamp is availalble (anchor is SENT or CONFIRMED) a regular proof receipt is returned (with response code 200). Otherwise, a partial proof receipt not including the proof of timestamp is returned (response code 202).&lt;br&gt; The partial proof receipt of a signature anchor allows to verify the signature and the identity of the signer immediatly after signing, without having to wait for the anchoring process to complete.  (optional, default to false)
     * @return Receipt
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt. </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> If &#x60;allowPartial&#x60; is &#x60;false&#x60; or unset: the proof receipt is not yet available.&lt;br&gt; If &#x60;allowPartial&#x60; is &#x60;true&#x60;: the partial proof receipt (returned in the response body).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public Receipt getReceipt(String anchorId, Boolean allowPartial) throws ApiException {
        ApiResponse<Receipt> localVarResp = getReceiptWithHttpInfo(anchorId, allowPartial);
        return localVarResp.getData();
    }

    /**
     * Get the proof receipt of an anchor.
     * Use this operation to retrieve the proof receipt associated to a given anchor.&lt;br&gt; This JSON file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param allowPartial &#x60;true&#x60; if a partial proof receipt is to be returned when the proof of timestamp is not yet available (ie. the data or the signature has not yet been anchored).&lt;br&gt; If the proof of timestamp is availalble (anchor is SENT or CONFIRMED) a regular proof receipt is returned (with response code 200). Otherwise, a partial proof receipt not including the proof of timestamp is returned (response code 202).&lt;br&gt; The partial proof receipt of a signature anchor allows to verify the signature and the identity of the signer immediatly after signing, without having to wait for the anchoring process to complete.  (optional, default to false)
     * @return ApiResponse&lt;Receipt&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt. </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> If &#x60;allowPartial&#x60; is &#x60;false&#x60; or unset: the proof receipt is not yet available.&lt;br&gt; If &#x60;allowPartial&#x60; is &#x60;true&#x60;: the partial proof receipt (returned in the response body).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Receipt> getReceiptWithHttpInfo(String anchorId, Boolean allowPartial) throws ApiException {
        okhttp3.Call localVarCall = getReceiptValidateBeforeCall(anchorId, allowPartial, null);
        Type localVarReturnType = new TypeToken<Receipt>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get the proof receipt of an anchor. (asynchronously)
     * Use this operation to retrieve the proof receipt associated to a given anchor.&lt;br&gt; This JSON file is only available once the anchor status is SENT.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier needs to be known). 
     * @param anchorId Identifier of the anchor for which to build the proof receipt. (required)
     * @param allowPartial &#x60;true&#x60; if a partial proof receipt is to be returned when the proof of timestamp is not yet available (ie. the data or the signature has not yet been anchored).&lt;br&gt; If the proof of timestamp is availalble (anchor is SENT or CONFIRMED) a regular proof receipt is returned (with response code 200). Otherwise, a partial proof receipt not including the proof of timestamp is returned (response code 202).&lt;br&gt; The partial proof receipt of a signature anchor allows to verify the signature and the identity of the signer immediatly after signing, without having to wait for the anchoring process to complete.  (optional, default to false)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt. </td><td>  -  </td></tr>
        <tr><td> 202 </td><td> If &#x60;allowPartial&#x60; is &#x60;false&#x60; or unset: the proof receipt is not yet available.&lt;br&gt; If &#x60;allowPartial&#x60; is &#x60;true&#x60;: the partial proof receipt (returned in the response body).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No anchor matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getReceiptAsync(String anchorId, Boolean allowPartial, final ApiCallback<Receipt> _callback) throws ApiException {

        okhttp3.Call localVarCall = getReceiptValidateBeforeCall(anchorId, allowPartial, _callback);
        Type localVarReturnType = new TypeToken<Receipt>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for verifyReceipt
     * @param receipt Proof receipt to verify. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt verification status. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call verifyReceiptCall(Receipt receipt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = receipt;

        // create path and map variables
        String localVarPath = "/receipt/verify";

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
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call verifyReceiptValidateBeforeCall(Receipt receipt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'receipt' is set
        if (receipt == null) {
            throw new ApiException("Missing the required parameter 'receipt' when calling verifyReceipt(Async)");
        }
        

        okhttp3.Call localVarCall = verifyReceiptCall(receipt, _callback);
        return localVarCall;

    }

    /**
     * Verify a proof receipt.
     * Use this operation to verify a proof receipt and get the timestamp of the proof.&lt;br&gt; For a proof of seal/signaure receipt, this operation also verifies the signature.&lt;br&gt; If the proof of seal/signature receipt includes an identity URL, this operation also verifies the identity of the signer.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Proof receipt to verify. (required)
     * @return ReceiptVerificationStatus
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt verification status. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ReceiptVerificationStatus verifyReceipt(Receipt receipt) throws ApiException {
        ApiResponse<ReceiptVerificationStatus> localVarResp = verifyReceiptWithHttpInfo(receipt);
        return localVarResp.getData();
    }

    /**
     * Verify a proof receipt.
     * Use this operation to verify a proof receipt and get the timestamp of the proof.&lt;br&gt; For a proof of seal/signaure receipt, this operation also verifies the signature.&lt;br&gt; If the proof of seal/signature receipt includes an identity URL, this operation also verifies the identity of the signer.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Proof receipt to verify. (required)
     * @return ApiResponse&lt;ReceiptVerificationStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt verification status. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ReceiptVerificationStatus> verifyReceiptWithHttpInfo(Receipt receipt) throws ApiException {
        okhttp3.Call localVarCall = verifyReceiptValidateBeforeCall(receipt, null);
        Type localVarReturnType = new TypeToken<ReceiptVerificationStatus>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Verify a proof receipt. (asynchronously)
     * Use this operation to verify a proof receipt and get the timestamp of the proof.&lt;br&gt; For a proof of seal/signaure receipt, this operation also verifies the signature.&lt;br&gt; If the proof of seal/signature receipt includes an identity URL, this operation also verifies the identity of the signer.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 
     * @param receipt Proof receipt to verify. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The proof receipt verification status. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call verifyReceiptAsync(Receipt receipt, final ApiCallback<ReceiptVerificationStatus> _callback) throws ApiException {

        okhttp3.Call localVarCall = verifyReceiptValidateBeforeCall(receipt, _callback);
        Type localVarReturnType = new TypeToken<ReceiptVerificationStatus>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
