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


package io.woleet.api.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Anchor
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-12T09:54:01.385+02:00")
public class Anchor {
  @SerializedName("id")
  private String id = null;

  @SerializedName("created")
  private Long created = null;

  @SerializedName("lastModified")
  private Long lastModified = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("signedHash")
  private String signedHash = null;

  @SerializedName("pubKey")
  private String pubKey = null;

  @SerializedName("signature")
  private String signature = null;

  @SerializedName("identityURL")
  private String identityURL = null;

  @SerializedName("public")
  private Boolean _public = true;

  @SerializedName("notifyByEmail")
  private Boolean notifyByEmail = false;

  @SerializedName("tags")
  private List<String> tags = new ArrayList<String>();

  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("callbackURL")
  private String callbackURL = null;

  /**
   * The status of the anchor:<br> - WAIT: waiting to be processed. The receipt is not yet available for download.<br> - NEW: to be sent to the blockchain. The receipt is not yet available for download.<br> - SENT: sent to the blockchain. The receipt is available for download.<br> - CONFIRMED: confirmed at least 6 times by the blockchain. The receipt is available for download.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   */
  public enum StatusEnum {
    @SerializedName("WAIT")
    WAIT("WAIT"),
    
    @SerializedName("NEW")
    NEW("NEW"),
    
    @SerializedName("SENT")
    SENT("SENT"),
    
    @SerializedName("CONFIRMED")
    CONFIRMED("CONFIRMED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("timestamp")
  private Long timestamp = null;

  @SerializedName("confirmations")
  private Integer confirmations = null;

  @SerializedName("txId")
  private String txId = null;

   /**
   * Anchor identifier.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Anchor identifier.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public String getId() {
    return id;
  }

   /**
   * Date of creation (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return created
  **/
  @ApiModelProperty(example = "null", value = "Date of creation (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Long getCreated() {
    return created;
  }

   /**
   * Date of last modification (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return lastModified
  **/
  @ApiModelProperty(example = "null", value = "Date of last modification (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Long getLastModified() {
    return lastModified;
  }

  public Anchor name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Anchor name (don't need to be unique).
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Anchor name (don't need to be unique).")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Anchor hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * SHA256 hash (ie. the fingerprint) of the original data to anchor.<br> **This property must not be provided when creating a signature anchor: it is set at creation time to the SHA256 hash of the `signature` property provided (so the signature is what is actually anchored in this case).** 
   * @return hash
  **/
  @ApiModelProperty(example = "null", required = true, value = "SHA256 hash (ie. the fingerprint) of the original data to anchor.<br> **This property must not be provided when creating a signature anchor: it is set at creation time to the SHA256 hash of the `signature` property provided (so the signature is what is actually anchored in this case).** ")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public Anchor signedHash(String signedHash) {
    this.signedHash = signedHash;
    return this;
  }

   /**
   * SHA256 hash (ie. the fingerprint) of the original data to sign.<br> **This property must not be provided when creating a data anchor.** 
   * @return signedHash
  **/
  @ApiModelProperty(example = "null", value = "SHA256 hash (ie. the fingerprint) of the original data to sign.<br> **This property must not be provided when creating a data anchor.** ")
  public String getSignedHash() {
    return signedHash;
  }

  public void setSignedHash(String signedHash) {
    this.signedHash = signedHash;
  }

  public Anchor pubKey(String pubKey) {
    this.pubKey = pubKey;
    return this;
  }

   /**
   * Public key of the signee.<br> **Currently only Bitcoin addresses are supported.**<br> **This property must not be provided when creating a data anchor.** 
   * @return pubKey
  **/
  @ApiModelProperty(example = "null", value = "Public key of the signee.<br> **Currently only Bitcoin addresses are supported.**<br> **This property must not be provided when creating a data anchor.** ")
  public String getPubKey() {
    return pubKey;
  }

  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }

  public Anchor signature(String signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Signature of the `signedHash` property content using the public key stored in the `pubKey` property.<br> **Only Bitcoin signatures are currently supported.** **This property must not be provided when creating a data anchor.** 
   * @return signature
  **/
  @ApiModelProperty(example = "null", value = "Signature of the `signedHash` property content using the public key stored in the `pubKey` property.<br> **Only Bitcoin signatures are currently supported.** **This property must not be provided when creating a data anchor.** ")
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public Anchor identityURL(String identityURL) {
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to be called whenever the signee identity has to be verified.<br> Calling this URL allows to verify that the owner of the URL (identified by the associated TLS certificate) also owns the public key used to produce the signature, by asking the URL to sign some random data.<br> This URL must use an HTTPS scheme with a valid and non expired TLS certificate.<br> This URL must implement the following GET operation:<br> input:<br> - `pubKey`: the public key of the signee (that is to be verified)<br> - `leftData`: a random SHA256 hash generated by the caller<br> output:<br> - `signature`: a valid signature of the string (`leftData` + `rightData`) produced using the public key `pubKey`<br> - `rightData`: a random SHA256 hash generated by the callee 
   * @return identityURL
  **/
  @ApiModelProperty(example = "null", value = "Web hook to be called whenever the signee identity has to be verified.<br> Calling this URL allows to verify that the owner of the URL (identified by the associated TLS certificate) also owns the public key used to produce the signature, by asking the URL to sign some random data.<br> This URL must use an HTTPS scheme with a valid and non expired TLS certificate.<br> This URL must implement the following GET operation:<br> input:<br> - `pubKey`: the public key of the signee (that is to be verified)<br> - `leftData`: a random SHA256 hash generated by the caller<br> output:<br> - `signature`: a valid signature of the string (`leftData` + `rightData`) produced using the public key `pubKey`<br> - `rightData`: a random SHA256 hash generated by the callee ")
  public String getIdentityURL() {
    return identityURL;
  }

  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }

  public Anchor _public(Boolean _public) {
    this._public = _public;
    return this;
  }

   /**
   * `true` (or unset) if the anchor is public. `false` if the anchor is private.<br> If this field is not set at creation time, the anchor is public by default. 
   * @return _public
  **/
  @ApiModelProperty(example = "null", value = "`true` (or unset) if the anchor is public. `false` if the anchor is private.<br> If this field is not set at creation time, the anchor is public by default. ")
  public Boolean getPublic() {
    return _public;
  }

  public void setPublic(Boolean _public) {
    this._public = _public;
  }

  public Anchor notifyByEmail(Boolean notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
    return this;
  }

   /**
   * `true` if the receipt must be sent by email once available. 
   * @return notifyByEmail
  **/
  @ApiModelProperty(example = "null", value = "`true` if the receipt must be sent by email once available. ")
  public Boolean getNotifyByEmail() {
    return notifyByEmail;
  }

  public void setNotifyByEmail(Boolean notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
  }

  public Anchor tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Anchor addTagsItem(String tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Set of tags associated to the anchor. There is no restriction on tag names, except they cannot contain spaces.<br> Tags are aimed at classifying and searching anchors. 
   * @return tags
  **/
  @ApiModelProperty(example = "null", value = "Set of tags associated to the anchor. There is no restriction on tag names, except they cannot contain spaces.<br> Tags are aimed at classifying and searching anchors. ")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Anchor metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * A JSON object containing a set of key/values to store with the anchor and giving additional information about the anchored data.<br> Values must be of type null, boolean, string or number: nested JSON objects are not allowed.<br> ex: { title: 'Ubik', author: 'Philip K. Dick', read: true, rank: 10.0, coauthor: null } 
   * @return metadata
  **/
  @ApiModelProperty(example = "null", value = "A JSON object containing a set of key/values to store with the anchor and giving additional information about the anchored data.<br> Values must be of type null, boolean, string or number: nested JSON objects are not allowed.<br> ex: { title: 'Ubik', author: 'Philip K. Dick', read: true, rank: 10.0, coauthor: null } ")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  public Anchor callbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
    return this;
  }

   /**
   * Web hook to be called by the platform whenever the anchor status change: the platform does a POST request on this URL with the anchor as a JSON object in the request body. 
   * @return callbackURL
  **/
  @ApiModelProperty(example = "null", value = "Web hook to be called by the platform whenever the anchor status change: the platform does a POST request on this URL with the anchor as a JSON object in the request body. ")
  public String getCallbackURL() {
    return callbackURL;
  }

  public void setCallbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
  }

   /**
   * The status of the anchor:<br> - WAIT: waiting to be processed. The receipt is not yet available for download.<br> - NEW: to be sent to the blockchain. The receipt is not yet available for download.<br> - SENT: sent to the blockchain. The receipt is available for download.<br> - CONFIRMED: confirmed at least 6 times by the blockchain. The receipt is available for download.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the anchor:<br> - WAIT: waiting to be processed. The receipt is not yet available for download.<br> - NEW: to be sent to the blockchain. The receipt is not yet available for download.<br> - SENT: sent to the blockchain. The receipt is available for download.<br> - CONFIRMED: confirmed at least 6 times by the blockchain. The receipt is available for download.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public StatusEnum getStatus() {
    return status;
  }

   /**
   * Proven timestamp of the data.<br> This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this anchor's hash is proven to be existent at that time and unmodified.<br> This field is set when the first confirmation of the Bitcoin block occurs.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return timestamp
  **/
  @ApiModelProperty(example = "null", value = "Proven timestamp of the data.<br> This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this anchor's hash is proven to be existent at that time and unmodified.<br> This field is set when the first confirmation of the Bitcoin block occurs.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Long getTimestamp() {
    return timestamp;
  }

   /**
   * Number of confirmations of the Bitcoin block into which the anchoring happened.<br> This field is set when the first confirmation of the Bitcoin block occurs, and removed when the block is confirmed.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** 
   * @return confirmations
  **/
  @ApiModelProperty(example = "null", value = "Number of confirmations of the Bitcoin block into which the anchoring happened.<br> This field is set when the first confirmation of the Bitcoin block occurs, and removed when the block is confirmed.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.** ")
  public Integer getConfirmations() {
    return confirmations;
  }

   /**
   * Identifier of the Bitcoin transaction where the anchoring occurred.
   * @return txId
  **/
  @ApiModelProperty(example = "null", value = "Identifier of the Bitcoin transaction where the anchoring occurred.")
  public String getTxId() {
    return txId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Anchor anchor = (Anchor) o;
    return Objects.equals(this.id, anchor.id) &&
        Objects.equals(this.created, anchor.created) &&
        Objects.equals(this.lastModified, anchor.lastModified) &&
        Objects.equals(this.name, anchor.name) &&
        Objects.equals(this.hash, anchor.hash) &&
        Objects.equals(this.signedHash, anchor.signedHash) &&
        Objects.equals(this.pubKey, anchor.pubKey) &&
        Objects.equals(this.signature, anchor.signature) &&
        Objects.equals(this.identityURL, anchor.identityURL) &&
        Objects.equals(this._public, anchor._public) &&
        Objects.equals(this.notifyByEmail, anchor.notifyByEmail) &&
        Objects.equals(this.tags, anchor.tags) &&
        Objects.equals(this.metadata, anchor.metadata) &&
        Objects.equals(this.callbackURL, anchor.callbackURL) &&
        Objects.equals(this.status, anchor.status) &&
        Objects.equals(this.timestamp, anchor.timestamp) &&
        Objects.equals(this.confirmations, anchor.confirmations) &&
        Objects.equals(this.txId, anchor.txId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, lastModified, name, hash, signedHash, pubKey, signature, identityURL, _public, notifyByEmail, tags, metadata, callbackURL, status, timestamp, confirmations, txId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Anchor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    signedHash: ").append(toIndentedString(signedHash)).append("\n");
    sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    notifyByEmail: ").append(toIndentedString(notifyByEmail)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    callbackURL: ").append(toIndentedString(callbackURL)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    confirmations: ").append(toIndentedString(confirmations)).append("\n");
    sb.append("    txId: ").append(toIndentedString(txId)).append("\n");
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

