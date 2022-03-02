/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.12.0
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
import io.woleet.api.client.model.SignatureRequestState;
import io.woleet.api.client.model.Watcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SignatureRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
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

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private SignatureRequestState state;

  public static final String SERIALIZED_NAME_CALLBACK_U_R_L = "callbackURL";
  @SerializedName(SERIALIZED_NAME_CALLBACK_U_R_L)
  private String callbackURL;

  public static final String SERIALIZED_NAME_VARS = "vars";
  @SerializedName(SERIALIZED_NAME_VARS)
  private Object vars;

  public static final String SERIALIZED_NAME_BASE_VARS_KEY = "baseVarsKey";
  @SerializedName(SERIALIZED_NAME_BASE_VARS_KEY)
  private String baseVarsKey;

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private String lang;

  public static final String SERIALIZED_NAME_PUBLIC = "public";
  @SerializedName(SERIALIZED_NAME_PUBLIC)
  private Boolean _public;

  public static final String SERIALIZED_NAME_HASH_TO_SIGN = "hashToSign";
  @SerializedName(SERIALIZED_NAME_HASH_TO_SIGN)
  private String hashToSign;

  public static final String SERIALIZED_NAME_ACTIVATION = "activation";
  @SerializedName(SERIALIZED_NAME_ACTIVATION)
  private Long activation;

  public static final String SERIALIZED_NAME_DEADLINE = "deadline";
  @SerializedName(SERIALIZED_NAME_DEADLINE)
  private Long deadline;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;

  public static final String SERIALIZED_NAME_FILE_NAME = "fileName";
  @SerializedName(SERIALIZED_NAME_FILE_NAME)
  private String fileName;

  public static final String SERIALIZED_NAME_FILE_U_R_L = "fileURL";
  @SerializedName(SERIALIZED_NAME_FILE_U_R_L)
  private String fileURL;

  public static final String SERIALIZED_NAME_MAX_SIGNATURES = "maxSignatures";
  @SerializedName(SERIALIZED_NAME_MAX_SIGNATURES)
  private Integer maxSignatures;

  public static final String SERIALIZED_NAME_AUTHORIZED_SIGNEES = "authorizedSignees";
  @SerializedName(SERIALIZED_NAME_AUTHORIZED_SIGNEES)
  private List<AuthorizedSignee> authorizedSignees = null;

  public static final String SERIALIZED_NAME_WATCHERS = "watchers";
  @SerializedName(SERIALIZED_NAME_WATCHERS)
  private List<Watcher> watchers = null;

  public static final String SERIALIZED_NAME_ORDERED = "ordered";
  @SerializedName(SERIALIZED_NAME_ORDERED)
  private Boolean ordered;

  public static final String SERIALIZED_NAME_ANCHORS = "anchors";
  @SerializedName(SERIALIZED_NAME_ANCHORS)
  private List<Anchor> anchors = null;

  public static final String SERIALIZED_NAME_AUDIT_TRAIL_DATA = "auditTrailData";
  @SerializedName(SERIALIZED_NAME_AUDIT_TRAIL_DATA)
  private String auditTrailData;

  public static final String SERIALIZED_NAME_AUDIT_TRAIL_ANCHOR_ID = "auditTrailAnchorId";
  @SerializedName(SERIALIZED_NAME_AUDIT_TRAIL_ANCHOR_ID)
  private String auditTrailAnchorId;

  public static final String SERIALIZED_NAME_PROOF_BUNDLE_COMPLETE = "proofBundleComplete";
  @SerializedName(SERIALIZED_NAME_PROOF_BUNDLE_COMPLETE)
  private Boolean proofBundleComplete;

  public static final String SERIALIZED_NAME_TEST_MODE = "testMode";
  @SerializedName(SERIALIZED_NAME_TEST_MODE)
  private Boolean testMode;


   /**
   * Signature request identifier. It is allocated by the platform, and so must not be provided at creation time.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcdef01-2345-6789-abcd-ef0123456789", value = "Signature request identifier. It is allocated by the platform, and so must not be provided at creation time.")

  public String getId() {
    return id;
  }




   /**
   * Date of creation (in milliseconds since Unix epoch).
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1620294758688", value = "Date of creation (in milliseconds since Unix epoch).")

  public Long getCreated() {
    return created;
  }




   /**
   * Date of last modification (in milliseconds since Unix epoch).
   * @return lastModified
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1620294759999", value = "Date of last modification (in milliseconds since Unix epoch).")

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
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Non-disclosure agreement", required = true, value = "Name of the signature request (doesn't need to be unique).")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public SignatureRequest state(SignatureRequestState state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureRequestState getState() {
    return state;
  }


  public void setState(SignatureRequestState state) {
    this.state = state;
  }


  public SignatureRequest callbackURL(String callbackURL) {
    
    this.callbackURL = callbackURL;
    return this;
  }

   /**
   * Web hook to be called by the platform whenever:&lt;br&gt; - the &#x60;state&#x60; property changes&lt;br&gt; - a new signature is registered&lt;br&gt; - the &#x60;proofBundleComplete&#x60; property is set to &#x60;true&#x60; by the platform (which means that the proof bundle and the Signature Attestation document are ready to download)&lt;br&gt; The platform does a POST request on this URL with the signature request as a JSON object in the request body.&lt;br&gt; Verifying the authenticity of the callback can be done by checking the HMAC-SHA1 signature of the request body provided by the platform in the &#x60;x-woleet-signature&#x60; header.&lt;br&gt; Please refer to &lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://doc.woleet.io/reference/using-callbacks\&quot;&gt;this documentation&lt;/a&gt; for more details. 
   * @return callbackURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://acme.com/callback/woleet/signatureRequest", value = "Web hook to be called by the platform whenever:<br> - the `state` property changes<br> - a new signature is registered<br> - the `proofBundleComplete` property is set to `true` by the platform (which means that the proof bundle and the Signature Attestation document are ready to download)<br> The platform does a POST request on this URL with the signature request as a JSON object in the request body.<br> Verifying the authenticity of the callback can be done by checking the HMAC-SHA1 signature of the request body provided by the platform in the `x-woleet-signature` header.<br> Please refer to <a target=\"_blank\" href=\"https://doc.woleet.io/reference/using-callbacks\">this documentation</a> for more details. ")

  public String getCallbackURL() {
    return callbackURL;
  }


  public void setCallbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
  }


  public SignatureRequest vars(Object vars) {
    
    this.vars = vars;
    return this;
  }

   /**
   * The set of variables (key/value pairs) to use to customize the signature request workflow.&lt;br&gt; Values must be of type null, boolean, string or number: nested JSON objects are not allowed.&lt;br&gt; In particular, these variables can be used to customize the various email sent and disable some of these emails.&lt;br&gt; Please refer to &lt;a target&#x3D;\&quot;_blank\&quot; href&#x3D;\&quot;https://doc.woleet.io/reference/custom-signature-workflow\&quot;&gt;this documentation&lt;/a&gt; for more details.&lt;br&gt; **This property is only available to the owner and the signers of the signature request.** 
   * @return vars
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"requesterName\":\"ACME Corp.\"}", value = "The set of variables (key/value pairs) to use to customize the signature request workflow.<br> Values must be of type null, boolean, string or number: nested JSON objects are not allowed.<br> In particular, these variables can be used to customize the various email sent and disable some of these emails.<br> Please refer to <a target=\"_blank\" href=\"https://doc.woleet.io/reference/custom-signature-workflow\">this documentation</a> for more details.<br> **This property is only available to the owner and the signers of the signature request.** ")

  public Object getVars() {
    return vars;
  }


  public void setVars(Object vars) {
    this.vars = vars;
  }


  public SignatureRequest baseVarsKey(String baseVarsKey) {
    
    this.baseVarsKey = baseVarsKey;
    return this;
  }

   /**
   * The key of an object in the user&#39;s k/v store to use as the base value of the &#x60;vars&#x60; property.&lt;br&gt; Properties defined in this object are overwritten by those defined in the &#x60;vars&#x60; property.&lt;br&gt; **Use this property to store large customization variables shared by multiple signature requests (like email tempates).** 
   * @return baseVarsKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "mySignatureRequestsSharedVars", value = "The key of an object in the user's k/v store to use as the base value of the `vars` property.<br> Properties defined in this object are overwritten by those defined in the `vars` property.<br> **Use this property to store large customization variables shared by multiple signature requests (like email tempates).** ")

  public String getBaseVarsKey() {
    return baseVarsKey;
  }


  public void setBaseVarsKey(String baseVarsKey) {
    this.baseVarsKey = baseVarsKey;
  }


  public SignatureRequest lang(String lang) {
    
    this.lang = lang;
    return this;
  }

   /**
   * The preferred language (provided as an ISO 639-1 string) to use when emailing the signers.
   * @return lang
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "fr", value = "The preferred language (provided as an ISO 639-1 string) to use when emailing the signers.")

  public String getLang() {
    return lang;
  }


  public void setLang(String lang) {
    this.lang = lang;
  }


  public SignatureRequest _public(Boolean _public) {
    
    this._public = _public;
    return this;
  }

   /**
   * &#x60;true&#x60; (or unset) if the signature request is public (ie. discoverable by its &#x60;hashToSign&#x60;) or &#x60;false&#x60; if it must be private (ie. not discoverable).&lt;br&gt; **Signature anchors created in the scope of a signature request inherit from its &#x60;public&#x60; property.** 
   * @return _public
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` (or unset) if the signature request is public (ie. discoverable by its `hashToSign`) or `false` if it must be private (ie. not discoverable).<br> **Signature anchors created in the scope of a signature request inherit from its `public` property.** ")

  public Boolean getPublic() {
    return _public;
  }


  public void setPublic(Boolean _public) {
    this._public = _public;
  }


  public SignatureRequest hashToSign(String hashToSign) {
    
    this.hashToSign = hashToSign;
    return this;
  }

   /**
   * SHA256 hash of the file to sign.&lt;br&gt; The value must be provided as an hexadecimal lowercase string. The hash of the empty file is forbidden.&lt;br&gt; 
   * @return hashToSign
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789", required = true, value = "SHA256 hash of the file to sign.<br> The value must be provided as an hexadecimal lowercase string. The hash of the empty file is forbidden.<br> ")

  public String getHashToSign() {
    return hashToSign;
  }


  public void setHashToSign(String hashToSign) {
    this.hashToSign = hashToSign;
  }


  public SignatureRequest activation(Long activation) {
    
    this.activation = activation;
    return this;
  }

   /**
   * Date of activation of the signature request (in milliseconds since Unix epoch).&lt;br&gt; When set, the platform waits for it before transitioning the signature request from PENDING to IN_PROGRESS automatically.&lt;br&gt; When not set, the platform transitions the signature request to IN_PROGRESS as soon as the signature request is transitioned to PENDING.&lt;br&gt; **Only stateful signature request can have an activation date.** 
   * @return activation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1720294759999", value = "Date of activation of the signature request (in milliseconds since Unix epoch).<br> When set, the platform waits for it before transitioning the signature request from PENDING to IN_PROGRESS automatically.<br> When not set, the platform transitions the signature request to IN_PROGRESS as soon as the signature request is transitioned to PENDING.<br> **Only stateful signature request can have an activation date.** ")

  public Long getActivation() {
    return activation;
  }


  public void setActivation(Long activation) {
    this.activation = activation;
  }


  public SignatureRequest deadline(Long deadline) {
    
    this.deadline = deadline;
    return this;
  }

   /**
   * Deadline of the signature request (in milliseconds since Unix epoch).&lt;br&gt; When not set or null, no deadline is applied.&lt;br&gt; If set, signatures registered after the deadline are refused. 
   * @return deadline
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1720294759999", value = "Deadline of the signature request (in milliseconds since Unix epoch).<br> When not set or null, no deadline is applied.<br> If set, signatures registered after the deadline are refused. ")

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
   * Web hook of the identity server to use to verify the signer&#39;s identity.&lt;br&gt; If set, it is used at signature registration time to verify the identity of the signers. 
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://wids.acme.com/identity", value = "Web hook of the identity server to use to verify the signer's identity.<br> If set, it is used at signature registration time to verify the identity of the signers. ")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


  public SignatureRequest fileName(String fileName) {
    
    this.fileName = fileName;
    return this;
  }

   /**
   * Name of the file to sign.&lt;br&gt; If set, the signature application can use it to give an indication about the file to the signers. 
   * @return fileName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "NDA.pdf", value = "Name of the file to sign.<br> If set, the signature application can use it to give an indication about the file to the signers. ")

  public String getFileName() {
    return fileName;
  }


  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public SignatureRequest fileURL(String fileURL) {
    
    this.fileURL = fileURL;
    return this;
  }

   /**
   * Public URL of the file to sign.&lt;br&gt; If set, the signature application can use it to download and present the file to the signers. 
   * @return fileURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://acme.com/files/NDA.pdf", value = "Public URL of the file to sign.<br> If set, the signature application can use it to download and present the file to the signers. ")

  public String getFileURL() {
    return fileURL;
  }


  public void setFileURL(String fileURL) {
    this.fileURL = fileURL;
  }


  public SignatureRequest maxSignatures(Integer maxSignatures) {
    
    this.maxSignatures = maxSignatures;
    return this;
  }

   /**
   * Maximum number of signatures to accept for this signature request.&lt;br&gt; When not set or null, no maximum is applied.&lt;br&gt; This property and the &#x60;authorizedSignees&#x60; property are mutually exclusive.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return maxSignatures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "10", value = "Maximum number of signatures to accept for this signature request.<br> When not set or null, no maximum is applied.<br> This property and the `authorizedSignees` property are mutually exclusive.<br> **This property is only available to the owner of the signature request.** ")

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
   * List of all signers authorized to register their signature (no duplicate is authorized).&lt;br&gt; When not set or null, anybody can sign the signature request.&lt;br&gt; If set, signers not being part of this list are not allowed to register their signature.&lt;br&gt; This property and the &#x60;maxSignatures&#x60; property are mutually exclusive. 
   * @return authorizedSignees
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of all signers authorized to register their signature (no duplicate is authorized).<br> When not set or null, anybody can sign the signature request.<br> If set, signers not being part of this list are not allowed to register their signature.<br> This property and the `maxSignatures` property are mutually exclusive. ")

  public List<AuthorizedSignee> getAuthorizedSignees() {
    return authorizedSignees;
  }


  public void setAuthorizedSignees(List<AuthorizedSignee> authorizedSignees) {
    this.authorizedSignees = authorizedSignees;
  }


  public SignatureRequest watchers(List<Watcher> watchers) {
    
    this.watchers = watchers;
    return this;
  }

  public SignatureRequest addWatchersItem(Watcher watchersItem) {
    if (this.watchers == null) {
      this.watchers = new ArrayList<Watcher>();
    }
    this.watchers.add(watchersItem);
    return this;
  }

   /**
   * List of all watchers to notify by email about the progress of the signature request.&lt;br&gt; The set of events being notified are:&lt;br&gt; - the signature request is activated&lt;br&gt; - a signer signs the signature request&lt;br&gt; - the signature request is canceled&lt;br&gt; - the signature request is closed or completed and the Signature Attestation document is ready **This property is only available to the owner of the signature request.** 
   * @return watchers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of all watchers to notify by email about the progress of the signature request.<br> The set of events being notified are:<br> - the signature request is activated<br> - a signer signs the signature request<br> - the signature request is canceled<br> - the signature request is closed or completed and the Signature Attestation document is ready **This property is only available to the owner of the signature request.** ")

  public List<Watcher> getWatchers() {
    return watchers;
  }


  public void setWatchers(List<Watcher> watchers) {
    this.watchers = watchers;
  }


  public SignatureRequest ordered(Boolean ordered) {
    
    this.ordered = ordered;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signers must sign in their order of appearance in the &#x60;authorizedSignees&#x60; list.&lt;br&gt; In this mode, each signer is notified only once the previous signer completes his signature.&lt;br&gt; **Only stateful signature request can be ordered.** 
   * @return ordered
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if the signers must sign in their order of appearance in the `authorizedSignees` list.<br> In this mode, each signer is notified only once the previous signer completes his signature.<br> **Only stateful signature request can be ordered.** ")

  public Boolean getOrdered() {
    return ordered;
  }


  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }


   /**
   * List of signature anchors created in the scope of this signature request&lt;br&gt; A signature anchor is created each time a new signature is registered. 
   * @return anchors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of signature anchors created in the scope of this signature request<br> A signature anchor is created each time a new signature is registered. ")

  public List<Anchor> getAnchors() {
    return anchors;
  }




   /**
   * Audit trail data.&lt;br&gt; When the signature request is COMPLETED (by the platform) or CLOSED (by the requester) its audit trail (ie. the list of events recorded by the platform during the signature request workflow) is serialized to a JSON object and Base64 encoded. This data is then signed by the platform and recorded in this property. 
   * @return auditTrailData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "eyJhdWRpdENvbnRleHQiOnsiaWQiOiJiNzkwNDMyYi1kNjYyLTQ2MzMtOGNjMi0xMjc0ODZiMjYzYjgiLCJuYW1lIjoiU2FtcGxlIn0sImF1ZGl0RXZlbnRzIjpbeyJkYXRlIjoxNjIyMTk5NTA5NDExLCJ0eXBlIjoiQ0xPU0VEIn1dfQo=", value = "Audit trail data.<br> When the signature request is COMPLETED (by the platform) or CLOSED (by the requester) its audit trail (ie. the list of events recorded by the platform during the signature request workflow) is serialized to a JSON object and Base64 encoded. This data is then signed by the platform and recorded in this property. ")

  public String getAuditTrailData() {
    return auditTrailData;
  }




   /**
   * Identifier of the signature anchor created by the platform to seal the audit trail data.&lt;br&gt; This property is set only once the audit trail is generated and can be used to retrieve its proof receipt. 
   * @return auditTrailAnchorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcdef01-2345-6789-abcd-ef0123456789", value = "Identifier of the signature anchor created by the platform to seal the audit trail data.<br> This property is set only once the audit trail is generated and can be used to retrieve its proof receipt. ")

  public String getAuditTrailAnchorId() {
    return auditTrailAnchorId;
  }




   /**
   * &#x60;true&#x60; when all pieces of evidence are available.&lt;br&gt; The proof bundle and the Signature Attestation are ready to download. 
   * @return proofBundleComplete
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` when all pieces of evidence are available.<br> The proof bundle and the Signature Attestation are ready to download. ")

  public Boolean getProofBundleComplete() {
    return proofBundleComplete;
  }




  public SignatureRequest testMode(Boolean testMode) {
    
    this.testMode = testMode;
    return this;
  }

   /**
   * **WARNING: Do not use (test purpose only).** 
   * @return testMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**WARNING: Do not use (test purpose only).** ")

  public Boolean getTestMode() {
    return testMode;
  }


  public void setTestMode(Boolean testMode) {
    this.testMode = testMode;
  }


  @Override
  public boolean equals(Object o) {
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
        Objects.equals(this.state, signatureRequest.state) &&
        Objects.equals(this.callbackURL, signatureRequest.callbackURL) &&
        Objects.equals(this.vars, signatureRequest.vars) &&
        Objects.equals(this.baseVarsKey, signatureRequest.baseVarsKey) &&
        Objects.equals(this.lang, signatureRequest.lang) &&
        Objects.equals(this._public, signatureRequest._public) &&
        Objects.equals(this.hashToSign, signatureRequest.hashToSign) &&
        Objects.equals(this.activation, signatureRequest.activation) &&
        Objects.equals(this.deadline, signatureRequest.deadline) &&
        Objects.equals(this.identityURL, signatureRequest.identityURL) &&
        Objects.equals(this.fileName, signatureRequest.fileName) &&
        Objects.equals(this.fileURL, signatureRequest.fileURL) &&
        Objects.equals(this.maxSignatures, signatureRequest.maxSignatures) &&
        Objects.equals(this.authorizedSignees, signatureRequest.authorizedSignees) &&
        Objects.equals(this.watchers, signatureRequest.watchers) &&
        Objects.equals(this.ordered, signatureRequest.ordered) &&
        Objects.equals(this.anchors, signatureRequest.anchors) &&
        Objects.equals(this.auditTrailData, signatureRequest.auditTrailData) &&
        Objects.equals(this.auditTrailAnchorId, signatureRequest.auditTrailAnchorId) &&
        Objects.equals(this.proofBundleComplete, signatureRequest.proofBundleComplete) &&
        Objects.equals(this.testMode, signatureRequest.testMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, lastModified, name, state, callbackURL, vars, baseVarsKey, lang, _public, hashToSign, activation, deadline, identityURL, fileName, fileURL, maxSignatures, authorizedSignees, watchers, ordered, anchors, auditTrailData, auditTrailAnchorId, proofBundleComplete, testMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequest {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    callbackURL: ").append(toIndentedString(callbackURL)).append("\n");
    sb.append("    vars: ").append(toIndentedString(vars)).append("\n");
    sb.append("    baseVarsKey: ").append(toIndentedString(baseVarsKey)).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    hashToSign: ").append(toIndentedString(hashToSign)).append("\n");
    sb.append("    activation: ").append(toIndentedString(activation)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileURL: ").append(toIndentedString(fileURL)).append("\n");
    sb.append("    maxSignatures: ").append(toIndentedString(maxSignatures)).append("\n");
    sb.append("    authorizedSignees: ").append(toIndentedString(authorizedSignees)).append("\n");
    sb.append("    watchers: ").append(toIndentedString(watchers)).append("\n");
    sb.append("    ordered: ").append(toIndentedString(ordered)).append("\n");
    sb.append("    anchors: ").append(toIndentedString(anchors)).append("\n");
    sb.append("    auditTrailData: ").append(toIndentedString(auditTrailData)).append("\n");
    sb.append("    auditTrailAnchorId: ").append(toIndentedString(auditTrailAnchorId)).append("\n");
    sb.append("    proofBundleComplete: ").append(toIndentedString(proofBundleComplete)).append("\n");
    sb.append("    testMode: ").append(toIndentedString(testMode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

