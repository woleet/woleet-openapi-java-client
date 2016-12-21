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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T14:15:59.181+01:00")
public class Anchor   {
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

  @SerializedName("public")
  private Boolean _public = true;

  @SerializedName("tags")
  private List<String> tags = new ArrayList<String>();

  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("callbackURL")
  private String callbackURL = null;

  @SerializedName("targetURI")
  private String targetURI = null;

  /**
   * The status of the anchor:<br> - WAIT: waiting to be processed.<br> - NEW: waiting to be sent to the blockchain.<br> - SENT: waiting to be confirmed 6 times by the blockchain.<br> - CONFIRMED: confirmed at least 6 times by the blockchain.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
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

   /**
   * Anchor identifier.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Anchor identifier.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
  public String getId() {
    return id;
  }

   /**
   * Date of creation (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return created
  **/
  @ApiModelProperty(example = "null", value = "Date of creation (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
  public Long getCreated() {
    return created;
  }

   /**
   * Date of last modification (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return lastModified
  **/
  @ApiModelProperty(example = "null", value = "Date of last modification (in milliseconds since Unix epoch).<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
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
  @ApiModelProperty(example = "null", required = true, value = "Anchor name (don't need to be unique). ")
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
   * SHA256 hash of the anchored data. This is the fingerprint of the anchored data. 
   * @return hash
  **/
  @ApiModelProperty(example = "null", required = true, value = "SHA256 hash of the anchored data. This is the fingerprint of the anchored data. ")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public Anchor _public(Boolean _public) {
    this._public = _public;
    return this;
  }

   /**
   * `true` (or unset) if the anchor is public. `false` is the anchor is private.<br> If this field is not set at creation time, the anchor is public by default.<br> 
   * @return _public
  **/
  @ApiModelProperty(example = "null", value = "`true` (or unset) if the anchor is public. `false` is the anchor is private.<br> If this field is not set at creation time, the anchor is public by default.<br> ")
  public Boolean getPublic() {
    return _public;
  }

  public void setPublic(Boolean _public) {
    this._public = _public;
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
   * A JavaScript object containing any set of key/values to store with the anchor and giving additional information about the anchored data.<br> ex: { title: 'Ubik', author: 'Philip K. Dick' } 
   * @return metadata
  **/
  @ApiModelProperty(example = "null", value = "A JavaScript object containing any set of key/values to store with the anchor and giving additional information about the anchored data.<br> ex: { title: 'Ubik', author: 'Philip K. Dick' } ")
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
   * URL to be called by the platform whenever the anchor status change: the platform performs a POST operation with the anchor as a JSON object in the body. 
   * @return callbackURL
  **/
  @ApiModelProperty(example = "null", value = "URL to be called by the platform whenever the anchor status change: the platform performs a POST operation with the anchor as a JSON object in the body. ")
  public String getCallbackURL() {
    return callbackURL;
  }

  public void setCallbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
  }

  public Anchor targetURI(String targetURI) {
    this.targetURI = targetURI;
    return this;
  }

   /**
   * URI of the anchored data (this URI is not used by the platform). 
   * @return targetURI
  **/
  @ApiModelProperty(example = "null", value = "URI of the anchored data (this URI is not used by the platform). ")
  public String getTargetURI() {
    return targetURI;
  }

  public void setTargetURI(String targetURI) {
    this.targetURI = targetURI;
  }

   /**
   * The status of the anchor:<br> - WAIT: waiting to be processed.<br> - NEW: waiting to be sent to the blockchain.<br> - SENT: waiting to be confirmed 6 times by the blockchain.<br> - CONFIRMED: confirmed at least 6 times by the blockchain.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the anchor:<br> - WAIT: waiting to be processed.<br> - NEW: waiting to be sent to the blockchain.<br> - SENT: waiting to be confirmed 6 times by the blockchain.<br> - CONFIRMED: confirmed at least 6 times by the blockchain.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
  public StatusEnum getStatus() {
    return status;
  }

   /**
   * Proven timestamp of the data.<br> This is actually the time of the Bitcoin block into which the anchoring process occured (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this anchor's hash is prooven to be existant at that time and unmodified.<br> This field is set when the first confirmation of the Bitcoin block occurs.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return timestamp
  **/
  @ApiModelProperty(example = "null", value = "Proven timestamp of the data.<br> This is actually the time of the Bitcoin block into which the anchoring process occured (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this anchor's hash is prooven to be existant at that time and unmodified.<br> This field is set when the first confirmation of the Bitcoin block occurs.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
  public Long getTimestamp() {
    return timestamp;
  }

   /**
   * Number of confirmations of the Bitcoin block into which the anchoring hapenned.<br> This field is set when the first confirmation of the Bitcoin block occurs, and removed when the block is confirmed.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. 
   * @return confirmations
  **/
  @ApiModelProperty(example = "null", value = "Number of confirmations of the Bitcoin block into which the anchoring hapenned.<br> This field is set when the first confirmation of the Bitcoin block occurs, and removed when the block is confirmed.<br> **This property is a read-only property managed by the platform: it must not be provided at creation time or modified.**. ")
  public Integer getConfirmations() {
    return confirmations;
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
        Objects.equals(this._public, anchor._public) &&
        Objects.equals(this.tags, anchor.tags) &&
        Objects.equals(this.metadata, anchor.metadata) &&
        Objects.equals(this.callbackURL, anchor.callbackURL) &&
        Objects.equals(this.targetURI, anchor.targetURI) &&
        Objects.equals(this.status, anchor.status) &&
        Objects.equals(this.timestamp, anchor.timestamp) &&
        Objects.equals(this.confirmations, anchor.confirmations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, lastModified, name, hash, _public, tags, metadata, callbackURL, targetURI, status, timestamp, confirmations);
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
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    callbackURL: ").append(toIndentedString(callbackURL)).append("\n");
    sb.append("    targetURI: ").append(toIndentedString(targetURI)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    confirmations: ").append(toIndentedString(confirmations)).append("\n");
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

