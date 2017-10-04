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


package io.woleet.api.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.woleet.api.client.model.Anchor;
import io.woleet.api.client.model.AuthorizedSignee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SignatureRequest
 */

public class SignatureRequest {
  @SerializedName("id")
  private String id = null;

  @SerializedName("created")
  private Long created = null;

  @SerializedName("lastModified")
  private Long lastModified = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("suspended")
  private Boolean suspended = null;

  @SerializedName("hashToSign")
  private String hashToSign = null;

  @SerializedName("anchors")
  private List<Anchor> anchors = null;

  @SerializedName("deadline")
  private Long deadline = null;

  @SerializedName("maxSignatures")
  private Integer maxSignatures = null;

  @SerializedName("authorizedSignees")
  private List<AuthorizedSignee> authorizedSignees = null;

   /**
   * Signature request identifier.&lt;br&gt; **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return id
  **/
  @ApiModelProperty(value = "Signature request identifier.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public String getId() {
    return id;
  }

   /**
   * Date of creation (in milliseconds since Unix epoch).&lt;br&gt; **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return created
  **/
  @ApiModelProperty(value = "Date of creation (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Long getCreated() {
    return created;
  }

   /**
   * Date of last modification (in milliseconds since Unix epoch).&lt;br&gt; **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return lastModified
  **/
  @ApiModelProperty(value = "Date of last modification (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Long getLastModified() {
    return lastModified;
  }

  public SignatureRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the signature request (doesn&#39;t need to be unique). 
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the signature request (doesn't need to be unique). ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SignatureRequest suspended(Boolean suspended) {
    this.suspended = suspended;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signature request is suspended, or &#x60;false&#x60; (or unset) if not.&lt;br&gt; When suspended, no more signature can be registered before the request is resumed. 
   * @return suspended
  **/
  @ApiModelProperty(value = "`true` if the signature request is suspended, or `false` (or unset) if not.<br> When suspended, no more signature can be registered before the request is resumed. ")
  public Boolean getSuspended() {
    return suspended;
  }

  public void setSuspended(Boolean suspended) {
    this.suspended = suspended;
  }

  public SignatureRequest hashToSign(String hashToSign) {
    this.hashToSign = hashToSign;
    return this;
  }

   /**
   * SHA256 hash (ie. the fingerprint) of the original data to sign. 
   * @return hashToSign
  **/
  @ApiModelProperty(required = true, value = "SHA256 hash (ie. the fingerprint) of the original data to sign. ")
  public String getHashToSign() {
    return hashToSign;
  }

  public void setHashToSign(String hashToSign) {
    this.hashToSign = hashToSign;
  }

  public SignatureRequest anchors(List<Anchor> anchors) {
    this.anchors = anchors;
    return this;
  }

  public SignatureRequest addAnchorsItem(Anchor anchorsItem) {
    if (this.anchors == null) {
      this.anchors = new ArrayList<Anchor>();
    }
    this.anchors.add(anchorsItem);
    return this;
  }

   /**
   * List of signature anchors created for this signature request.&lt;br&gt; This property is only available to the owner of the signature request.&lt;br&gt; **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return anchors
  **/
  @ApiModelProperty(value = "List of signature anchors created for this signature request.<br> This property is only available to the owner of the signature request.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public List<Anchor> getAnchors() {
    return anchors;
  }

  public void setAnchors(List<Anchor> anchors) {
    this.anchors = anchors;
  }

  public SignatureRequest deadline(Long deadline) {
    this.deadline = deadline;
    return this;
  }

   /**
   * Deadline of the signature request (in milliseconds since Unix epoch).&lt;br&gt; When not set, null or 0, no deadline is applied.&lt;br&gt; If set, signatures registered after the deadline are refused. 
   * @return deadline
  **/
  @ApiModelProperty(value = "Deadline of the signature request (in milliseconds since Unix epoch).<br> When not set, null or 0, no deadline is applied.<br> If set, signatures registered after the deadline are refused. ")
  public Long getDeadline() {
    return deadline;
  }

  public void setDeadline(Long deadline) {
    this.deadline = deadline;
  }

  public SignatureRequest maxSignatures(Integer maxSignatures) {
    this.maxSignatures = maxSignatures;
    return this;
  }

   /**
   * Maximum number of signatures to accept for this signature request.&lt;br&gt; When not set, null or 0, no maximum is applied.&lt;br&gt; If set, signatures coming from signees not in this list are refused.&lt;br&gt; This property and the &#x60;authorizedSignees&#x60; property are mutually exclusive.&lt;br&gt; This property is only available to the owner of the signature request. 
   * @return maxSignatures
  **/
  @ApiModelProperty(value = "Maximum number of signatures to accept for this signature request.<br> When not set, null or 0, no maximum is applied.<br> If set, signatures coming from signees not in this list are refused.<br> This property and the `authorizedSignees` property are mutually exclusive.<br> This property is only available to the owner of the signature request. ")
  public Integer getMaxSignatures() {
    return maxSignatures;
  }

  public void setMaxSignatures(Integer maxSignatures) {
    this.maxSignatures = maxSignatures;
  }

  public SignatureRequest authorizedSignees(List<AuthorizedSignee> authorizedSignees) {
    this.authorizedSignees = authorizedSignees;
    return this;
  }

  public SignatureRequest addAuthorizedSigneesItem(AuthorizedSignee authorizedSigneesItem) {
    if (this.authorizedSignees == null) {
      this.authorizedSignees = new ArrayList<AuthorizedSignee>();
    }
    this.authorizedSignees.add(authorizedSigneesItem);
    return this;
  }

   /**
   * List of signees authorized to register their signature for this signature request (no duplicate is authorized).&lt;br&gt; When not set or null, anybody can sign the signature request.&lt;br&gt; If set, signatures from signees not in this list are refused.&lt;br&gt; This property and the &#x60;maxSignatures&#x60; property are mutually exclusive.&lt;br&gt; This property is only available to the owner of the signature request. 
   * @return authorizedSignees
  **/
  @ApiModelProperty(value = "List of signees authorized to register their signature for this signature request (no duplicate is authorized).<br> When not set or null, anybody can sign the signature request.<br> If set, signatures from signees not in this list are refused.<br> This property and the `maxSignatures` property are mutually exclusive.<br> This property is only available to the owner of the signature request. ")
  public List<AuthorizedSignee> getAuthorizedSignees() {
    return authorizedSignees;
  }

  public void setAuthorizedSignees(List<AuthorizedSignee> authorizedSignees) {
    this.authorizedSignees = authorizedSignees;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureRequest signatureRequest = (SignatureRequest) o;
    return Objects.equals(this.id, signatureRequest.id) &&
        Objects.equals(this.created, signatureRequest.created) &&
        Objects.equals(this.lastModified, signatureRequest.lastModified) &&
        Objects.equals(this.name, signatureRequest.name) &&
        Objects.equals(this.suspended, signatureRequest.suspended) &&
        Objects.equals(this.hashToSign, signatureRequest.hashToSign) &&
        Objects.equals(this.anchors, signatureRequest.anchors) &&
        Objects.equals(this.deadline, signatureRequest.deadline) &&
        Objects.equals(this.maxSignatures, signatureRequest.maxSignatures) &&
        Objects.equals(this.authorizedSignees, signatureRequest.authorizedSignees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, lastModified, name, suspended, hashToSign, anchors, deadline, maxSignatures, authorizedSignees);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
    sb.append("    hashToSign: ").append(toIndentedString(hashToSign)).append("\n");
    sb.append("    anchors: ").append(toIndentedString(anchors)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    maxSignatures: ").append(toIndentedString(maxSignatures)).append("\n");
    sb.append("    authorizedSignees: ").append(toIndentedString(authorizedSignees)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

