/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.6.2
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.api.client.model;

import java.util.Objects;
import java.util.Arrays;
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
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private Long created;

  public static final String SERIALIZED_NAME_LAST_MODIFIED = "lastModified";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED)
  private Long lastModified;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_PUBLIC = "public";
  @SerializedName(SERIALIZED_NAME_PUBLIC)
  private Boolean _public;

  public static final String SERIALIZED_NAME_SUSPENDED = "suspended";
  @SerializedName(SERIALIZED_NAME_SUSPENDED)
  private Boolean suspended;

  public static final String SERIALIZED_NAME_HASH_TO_SIGN = "hashToSign";
  @SerializedName(SERIALIZED_NAME_HASH_TO_SIGN)
  private String hashToSign;

  public static final String SERIALIZED_NAME_DEADLINE = "deadline";
  @SerializedName(SERIALIZED_NAME_DEADLINE)
  private Long deadline;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;

  public static final String SERIALIZED_NAME_MAX_SIGNATURES = "maxSignatures";
  @SerializedName(SERIALIZED_NAME_MAX_SIGNATURES)
  private Integer maxSignatures;

  public static final String SERIALIZED_NAME_AUTHORIZED_SIGNEES = "authorizedSignees";
  @SerializedName(SERIALIZED_NAME_AUTHORIZED_SIGNEES)
  private List<AuthorizedSignee> authorizedSignees = null;

  public static final String SERIALIZED_NAME_ANCHORS = "anchors";
  @SerializedName(SERIALIZED_NAME_ANCHORS)
  private List<Anchor> anchors = null;


   /**
   * Signature request identifier. It is allocated by the platform, and so must not be provided at creation time. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Signature request identifier. It is allocated by the platform, and so must not be provided at creation time. ")

  public String getId() {
    return id;
  }




   /**
   * Date of creation (in milliseconds since Unix epoch). 
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date of creation (in milliseconds since Unix epoch). ")

  public Long getCreated() {
    return created;
  }




   /**
   * Date of last modification (in milliseconds since Unix epoch). 
   * @return lastModified
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date of last modification (in milliseconds since Unix epoch). ")

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


  public SignatureRequest _public(Boolean _public) {
    
    this._public = _public;
    return this;
  }

   /**
   * &#x60;true&#x60; (or unset) if the signature anchors created in the scope of this signature request must be public (ie. discoverable by their &#x60;signedHash&#x60;).&lt;br&gt; &#x60;false&#x60; if they must be private (ie. not dicoverable).&lt;br&gt; **If this field is not set at creation time, all anchors created will be  public by default.** 
   * @return _public
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` (or unset) if the signature anchors created in the scope of this signature request must be public (ie. discoverable by their `signedHash`).<br> `false` if they must be private (ie. not dicoverable).<br> **If this field is not set at creation time, all anchors created will be  public by default.** ")

  public Boolean getPublic() {
    return _public;
  }


  public void setPublic(Boolean _public) {
    this._public = _public;
  }


  public SignatureRequest suspended(Boolean suspended) {
    
    this.suspended = suspended;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signature request is suspended, or &#x60;false&#x60; (or unset) if not.&lt;br&gt; When suspended, no signature can be registered. 
   * @return suspended
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if the signature request is suspended, or `false` (or unset) if not.<br> When suspended, no signature can be registered. ")

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
   * SHA256 hash (ie. the fingerprint) of the original data to sign. The value must be provided as an hexadecimal lowercase string. 
   * @return hashToSign
  **/
  @ApiModelProperty(required = true, value = "SHA256 hash (ie. the fingerprint) of the original data to sign. The value must be provided as an hexadecimal lowercase string. ")

  public String getHashToSign() {
    return hashToSign;
  }


  public void setHashToSign(String hashToSign) {
    this.hashToSign = hashToSign;
  }


  public SignatureRequest deadline(Long deadline) {
    
    this.deadline = deadline;
    return this;
  }

   /**
   * Deadline of the signature request (in milliseconds since Unix epoch).&lt;br&gt; When not set, null or 0, no deadline is applied.&lt;br&gt; If set, signatures registered after the deadline are refused. 
   * @return deadline
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Deadline of the signature request (in milliseconds since Unix epoch).<br> When not set, null or 0, no deadline is applied.<br> If set, signatures registered after the deadline are refused. ")

  public Long getDeadline() {
    return deadline;
  }


  public void setDeadline(Long deadline) {
    this.deadline = deadline;
  }


  public SignatureRequest identityURL(String identityURL) {
    
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to use to verify the signee&#39;s identity.&lt;br&gt; If set, it is used to verify the identity of signees at signature registration time. 
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Web hook to use to verify the signee's identity.<br> If set, it is used to verify the identity of signees at signature registration time. ")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


  public SignatureRequest maxSignatures(Integer maxSignatures) {
    
    this.maxSignatures = maxSignatures;
    return this;
  }

   /**
   * Maximum number of signatures to accept for this signature request.&lt;br&gt; When not set, null or 0, no maximum is applied.&lt;br&gt; This property and the &#x60;authorizedSignees&#x60; property are mutually exclusive.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return maxSignatures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Maximum number of signatures to accept for this signature request.<br> When not set, null or 0, no maximum is applied.<br> This property and the `authorizedSignees` property are mutually exclusive.<br> **This property is only available to the owner of the signature request.** ")

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
   * List of all signees authorized to register their signature for this signature request (no duplicate is authorized).&lt;br&gt; When not set or null, anybody can sign the signature request.&lt;br&gt; If set, signatures registered by signees not in this list are rejected.&lt;br&gt; This property and the &#x60;maxSignatures&#x60; property are mutually exclusive.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return authorizedSignees
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of all signees authorized to register their signature for this signature request (no duplicate is authorized).<br> When not set or null, anybody can sign the signature request.<br> If set, signatures registered by signees not in this list are rejected.<br> This property and the `maxSignatures` property are mutually exclusive.<br> **This property is only available to the owner of the signature request.** ")

  public List<AuthorizedSignee> getAuthorizedSignees() {
    return authorizedSignees;
  }


  public void setAuthorizedSignees(List<AuthorizedSignee> authorizedSignees) {
    this.authorizedSignees = authorizedSignees;
  }


   /**
   * List of signature anchors created in the scope of this signature request&lt;br&gt; A signature anchor is created each time a new signature is registered.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return anchors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of signature anchors created in the scope of this signature request<br> A signature anchor is created each time a new signature is registered.<br> **This property is only available to the owner of the signature request.** ")

  public List<Anchor> getAnchors() {
    return anchors;
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
        Objects.equals(this._public, signatureRequest._public) &&
        Objects.equals(this.suspended, signatureRequest.suspended) &&
        Objects.equals(this.hashToSign, signatureRequest.hashToSign) &&
        Objects.equals(this.deadline, signatureRequest.deadline) &&
        Objects.equals(this.identityURL, signatureRequest.identityURL) &&
        Objects.equals(this.maxSignatures, signatureRequest.maxSignatures) &&
        Objects.equals(this.authorizedSignees, signatureRequest.authorizedSignees) &&
        Objects.equals(this.anchors, signatureRequest.anchors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, lastModified, name, _public, suspended, hashToSign, deadline, identityURL, maxSignatures, authorizedSignees, anchors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequest {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    suspended: ").append(toIndentedString(suspended)).append("\n");
    sb.append("    hashToSign: ").append(toIndentedString(hashToSign)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
    sb.append("    maxSignatures: ").append(toIndentedString(maxSignatures)).append("\n");
    sb.append("    authorizedSignees: ").append(toIndentedString(authorizedSignees)).append("\n");
    sb.append("    anchors: ").append(toIndentedString(anchors)).append("\n");
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

