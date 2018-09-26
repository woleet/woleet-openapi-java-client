/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/v1.5.1/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.5.2
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.woleet.api.client;

import io.woleet.api.ApiException;
import io.woleet.api.client.model.Anchor;
import io.woleet.api.client.model.AnchorIds;
import io.woleet.api.client.model.Anchors;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AnchorApi
 */
@Ignore
public class AnchorApiTest {

    private final AnchorApi api = new AnchorApi();

    
    /**
     * Create a new anchor.
     *
     * Use this operation to create a new anchor of one of these two types:&lt;br&gt;  - a data anchor (generating a proof of existence receipt) allows to prove the existence of some data at some point in time.&lt;br&gt; - a signature anchor (generating a proof of signature receipt) allows to prove the existence of the signature of some data at some point in time, the validity of the signature and the signee&#39;s identity.&lt;br&gt;  The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required (though the &#x60;identityURL&#x60; property is highly recommended): the &#x60;signedHash&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have at least 1 anchoring credit on your account. The &#x60;signature&#x60; property must contain a valid signature of the &#x60;data&#x60; property using the private key paired with the &#x60;pubKey&#x60; public key. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createAnchorTest() throws ApiException {
        Anchor anchor = null;
        Anchor response = api.createAnchor(anchor);

        // TODO: test validations
    }
    
    /**
     * Delete an anchor.
     *
     * Use this operation to delete an anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAnchorTest() throws ApiException {
        String anchorid = null;
        api.deleteAnchor(anchorid);

        // TODO: test validations
    }
    
    /**
     * Get an anchor by its identifier.
     *
     * Use this operation to retrieve an anchor by its identifier.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAnchorTest() throws ApiException {
        String anchorid = null;
        Anchor response = api.getAnchor(anchorid);

        // TODO: test validations
    }
    
    /**
     * Search for public anchors&#39; identifiers.
     *
     * Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve public anchors&#39; identifiers.&lt;br&gt; Paging is supported. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchAnchorIdsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String hash = null;
        String signedHash = null;
        AnchorIds response = api.searchAnchorIds(page, size, hash, signedHash);

        // TODO: test validations
    }
    
    /**
     * Search for anchors.
     *
     * Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchAnchorsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        String direction = null;
        String sort = null;
        String name = null;
        String hash = null;
        String signedHash = null;
        List<String> tags = null;
        Anchors response = api.searchAnchors(page, size, direction, sort, name, hash, signedHash, tags);

        // TODO: test validations
    }
    
    /**
     * Update an anchor.
     *
     * Use this operation to update an anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateAnchorTest() throws ApiException {
        String anchorid = null;
        Anchor anchor = null;
        Anchor response = api.updateAnchor(anchorid, anchor);

        // TODO: test validations
    }
    
}
