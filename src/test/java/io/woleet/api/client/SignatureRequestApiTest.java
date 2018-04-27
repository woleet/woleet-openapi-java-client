/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/v1.5.1/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.5.1
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.woleet.api.client;

import io.woleet.api.ApiException;
import io.woleet.api.client.model.SignatureRequest;
import io.woleet.api.client.model.SignatureRequestSign;
import io.woleet.api.client.model.SignatureRequestSignResult;
import io.woleet.api.client.model.SignatureRequests;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SignatureRequestApi
 */
@Ignore
public class SignatureRequestApiTest {

    private final SignatureRequestApi api = new SignatureRequestApi();

    
    /**
     * Create a new signature request.
     *
     * Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have enough anchoring credits on your account to fulfill the signature request (each signature registered will cost you 1 anchoring credit).&lt;br&gt; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createSignatureRequestTest() throws ApiException {
        SignatureRequest signatureRequest = null;
        SignatureRequest response = api.createSignatureRequest(signatureRequest);

        // TODO: test validations
    }
    
    /**
     * Delete a signature request.
     *
     * Use this operation to delete a signature request.&lt;br&gt; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteSignatureRequestTest() throws ApiException {
        String requestid = null;
        api.deleteSignatureRequest(requestid);

        // TODO: test validations
    }
    
    /**
     * Get a signature request by its identifier.
     *
     * Use this operation to retrieve a signature request by its identifier.&lt;br&gt; When accessed with no authentication, only public attributes of the signature request are returned. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSignatureRequestTest() throws ApiException {
        String requestid = null;
        SignatureRequest response = api.getSignatureRequest(requestid);

        // TODO: test validations
    }
    
    /**
     * Search for signature requests.
     *
     * Use this operation to retrieve all signature requests having a given &#x60;name&#x60; and/or &#x60;hashToSign&#x60; property.&lt;br&gt; Only requests belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSignatureRequestsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String direction = null;
        String sort = null;
        String name = null;
        String hashToSign = null;
        SignatureRequests response = api.searchSignatureRequests(page, size, direction, sort, name, hashToSign);

        // TODO: test validations
    }
    
    /**
     * Sign a signature request.
     *
     * Use this operation to register a signature for a signature request.&lt;br&gt; The signature is automatically anchored (on behalf of the owner of the signature request). The signature anchor created is added to the list of signature anchors of the signature request. This is a publicly accessible endpoint: authentication is not required to register a signature. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void signSignatureRequestTest() throws ApiException {
        String requestid = null;
        SignatureRequestSign signature = null;
        SignatureRequestSignResult response = api.signSignatureRequest(requestid, signature);

        // TODO: test validations
    }
    
    /**
     * Update a signature request.
     *
     * Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;suspended&#x60;, &#x60;deadline&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateSignatureRequestTest() throws ApiException {
        String requestid = null;
        SignatureRequest request = null;
        SignatureRequest response = api.updateSignatureRequest(requestid, request);

        // TODO: test validations
    }
    
}
