/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.8.0
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
import java.io.IOException;

/**
 * AuthorizedSignee
 */

public class AuthorizedSignee {
  public static final String SERIALIZED_NAME_COMMON_NAME = "commonName";
  @SerializedName(SERIALIZED_NAME_COMMON_NAME)
  private String commonName;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_COUNTRY_CALLING_CODE = "countryCallingCode";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CALLING_CODE)
  private String countryCallingCode;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;

  public static final String SERIALIZED_NAME_REQUIRES_O_T_P = "requiresOTP";
  @SerializedName(SERIALIZED_NAME_REQUIRES_O_T_P)
  private Boolean requiresOTP;

  public static final String SERIALIZED_NAME_SIGNS_FACE_TO_FACE = "signsFaceToFace";
  @SerializedName(SERIALIZED_NAME_SIGNS_FACE_TO_FACE)
  private Boolean signsFaceToFace;

  public static final String SERIALIZED_NAME_VARS = "vars";
  @SerializedName(SERIALIZED_NAME_VARS)
  private Object vars;

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private String lang;

  public static final String SERIALIZED_NAME_PUB_KEY = "pubKey";
  @SerializedName(SERIALIZED_NAME_PUB_KEY)
  private String pubKey;

  /**
   * The type of device the signer should use to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent&lt;br&gt; - MOBILE: Woleet.ID Mobile or equivalent&lt;br&gt; - NANO: Ledger Nano S or equivalent&lt;br&gt; If set, the signature application can use it to propose only the corresponding signature mode. 
   */
  @JsonAdapter(DeviceEnum.Adapter.class)
  public enum DeviceEnum {
    SERVER("SERVER"),
    
    MOBILE("MOBILE"),
    
    NANO("NANO");

    private String value;

    DeviceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DeviceEnum fromValue(String value) {
      for (DeviceEnum b : DeviceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DeviceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DeviceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DeviceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DeviceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DEVICE = "device";
  @SerializedName(SERIALIZED_NAME_DEVICE)
  private DeviceEnum device;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;

  public static final String SERIALIZED_NAME_FEEDBACK_SUBJECT = "feedbackSubject";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_SUBJECT)
  private String feedbackSubject;

  public static final String SERIALIZED_NAME_FEEDBACK_MESSAGE = "feedbackMessage";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_MESSAGE)
  private String feedbackMessage;

  public static final String SERIALIZED_NAME_ANCHOR_ID = "anchorId";
  @SerializedName(SERIALIZED_NAME_ANCHOR_ID)
  private String anchorId;

  public static final String SERIALIZED_NAME_SIGNED_ON = "signedOn";
  @SerializedName(SERIALIZED_NAME_SIGNED_ON)
  private Long signedOn;

  public static final String SERIALIZED_NAME_AUDIT_TRAIL_ID = "auditTrailId";
  @SerializedName(SERIALIZED_NAME_AUDIT_TRAIL_ID)
  private String auditTrailId;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_O_T_P = "OTP";
  @SerializedName(SERIALIZED_NAME_O_T_P)
  private String OTP;


  public AuthorizedSignee commonName(String commonName) {
    
    this.commonName = commonName;
    return this;
  }

   /**
   * The full name of the signer.
   * @return commonName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John Doe", value = "The full name of the signer.")

  public String getCommonName() {
    return commonName;
  }


  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  public AuthorizedSignee email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email of the signer.&lt;br&gt; Two signers cannot have the same email.&lt;br&gt; If set, &#x60;commonName&#x60; must also be set. 
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "john.doe@acme.com", value = "The email of the signer.<br> Two signers cannot have the same email.<br> If set, `commonName` must also be set. ")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public AuthorizedSignee countryCallingCode(String countryCallingCode) {
    
    this.countryCallingCode = countryCallingCode;
    return this;
  }

   /**
   * The country calling code of the signer (numbers only, no white space). 
   * @return countryCallingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "33", value = "The country calling code of the signer (numbers only, no white space). ")

  public String getCountryCallingCode() {
    return countryCallingCode;
  }


  public void setCountryCallingCode(String countryCallingCode) {
    this.countryCallingCode = countryCallingCode;
  }


  public AuthorizedSignee phone(String phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * The phone number of the signer (not including the country calling code, numbers only, no white spaces).&lt;br&gt; Two signers cannot have the same phone number.&lt;br&gt; If set, &#x60;commonName&#x60; must also be set.&lt;br&gt; This phone number must support SMS delivery. 
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "612345678", value = "The phone number of the signer (not including the country calling code, numbers only, no white spaces).<br> Two signers cannot have the same phone number.<br> If set, `commonName` must also be set.<br> This phone number must support SMS delivery. ")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone;
  }


  public AuthorizedSignee requiresOTP(Boolean requiresOTP) {
    
    this.requiresOTP = requiresOTP;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signer must provide an OTP to sign.&lt;br&gt; If &#x60;true&#x60;, &#x60;phone&#x60; must be set, since the OTP is sent by SMS. 
   * @return requiresOTP
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if the signer must provide an OTP to sign.<br> If `true`, `phone` must be set, since the OTP is sent by SMS. ")

  public Boolean getRequiresOTP() {
    return requiresOTP;
  }


  public void setRequiresOTP(Boolean requiresOTP) {
    this.requiresOTP = requiresOTP;
  }


  public AuthorizedSignee signsFaceToFace(Boolean signsFaceToFace) {
    
    this.signsFaceToFace = signsFaceToFace;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signer must sign face-to-face, or &#x60;false&#x60; (or unset) if the signer must sign using the regular signature workflow.&lt;br&gt; If &#x60;true&#x60;, &#x60;requiresOTP&#x60; must also be &#x60;true&#x60;. 
   * @return signsFaceToFace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if the signer must sign face-to-face, or `false` (or unset) if the signer must sign using the regular signature workflow.<br> If `true`, `requiresOTP` must also be `true`. ")

  public Boolean getSignsFaceToFace() {
    return signsFaceToFace;
  }


  public void setSignsFaceToFace(Boolean signsFaceToFace) {
    this.signsFaceToFace = signsFaceToFace;
  }


  public AuthorizedSignee vars(Object vars) {
    
    this.vars = vars;
    return this;
  }

   /**
   * A set of variables (key/value pairs) that can be used to customize the signature request workflow for this signer.&lt;br&gt; Values must be of type null, boolean, string or number: nested JSON objects are not allowed.&lt;br&gt; Variables defined here overwrites the ones defined at signature request level when emailing the signer.&lt;br&gt; **This property is only available to the owner and the signers of the signature request.** 
   * @return vars
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A set of variables (key/value pairs) that can be used to customize the signature request workflow for this signer.<br> Values must be of type null, boolean, string or number: nested JSON objects are not allowed.<br> Variables defined here overwrites the ones defined at signature request level when emailing the signer.<br> **This property is only available to the owner and the signers of the signature request.** ")

  public Object getVars() {
    return vars;
  }


  public void setVars(Object vars) {
    this.vars = vars;
  }


  public AuthorizedSignee lang(String lang) {
    
    this.lang = lang;
    return this;
  }

   /**
   * The preferred language (provided as an ISO 639-1 string) to use when emailing the signer.&lt;br&gt; If set, this property overwrites the &#x60;lang&#x60; property defined at signature request level. 
   * @return lang
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "fr", value = "The preferred language (provided as an ISO 639-1 string) to use when emailing the signer.<br> If set, this property overwrites the `lang` property defined at signature request level. ")

  public String getLang() {
    return lang;
  }


  public void setLang(String lang) {
    this.lang = lang;
  }


  public AuthorizedSignee pubKey(String pubKey) {
    
    this.pubKey = pubKey;
    return this;
  }

   /**
   * The public key the signer must use to sign.&lt;br&gt; If not set, the signer can use any key to sign.&lt;br&gt; **Currently only Bitcoin addresses are supported.** 
   * @return pubKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The public key the signer must use to sign.<br> If not set, the signer can use any key to sign.<br> **Currently only Bitcoin addresses are supported.** ")

  public String getPubKey() {
    return pubKey;
  }


  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }


  public AuthorizedSignee device(DeviceEnum device) {
    
    this.device = device;
    return this;
  }

   /**
   * The type of device the signer should use to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent&lt;br&gt; - MOBILE: Woleet.ID Mobile or equivalent&lt;br&gt; - NANO: Ledger Nano S or equivalent&lt;br&gt; If set, the signature application can use it to propose only the corresponding signature mode. 
   * @return device
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of device the signer should use to sign:<br> - SERVER: Woleet.ID Server or equivalent<br> - MOBILE: Woleet.ID Mobile or equivalent<br> - NANO: Ledger Nano S or equivalent<br> If set, the signature application can use it to propose only the corresponding signature mode. ")

  public DeviceEnum getDevice() {
    return device;
  }


  public void setDevice(DeviceEnum device) {
    this.device = device;
  }


  public AuthorizedSignee identityURL(String identityURL) {
    
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to use to verify the signer&#39;s identity.&lt;br&gt; If set, this property overwrites the &#x60;identityURL&#x60; property defined at signature request level. 
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Web hook to use to verify the signer's identity.<br> If set, this property overwrites the `identityURL` property defined at signature request level. ")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


   /**
   * Last feedback subject reported by the signer to the owner of the signature request.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return feedbackSubject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Last feedback subject reported by the signer to the owner of the signature request.<br> **This property is only available to the owner of the signature request.** ")

  public String getFeedbackSubject() {
    return feedbackSubject;
  }




   /**
   * Last feedback message reported by the signer to the owner of the signature request.&lt;br&gt; **This property is only available to the owner of the signature request.** 
   * @return feedbackMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Last feedback message reported by the signer to the owner of the signature request.<br> **This property is only available to the owner of the signature request.** ")

  public String getFeedbackMessage() {
    return feedbackMessage;
  }




   /**
   * If the signer has signed, identifier of the signature anchor created.
   * @return anchorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If the signer has signed, identifier of the signature anchor created.")

  public String getAnchorId() {
    return anchorId;
  }




   /**
   * If the signer has signed, date of signature (in milliseconds since Unix epoch).
   * @return signedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If the signer has signed, date of signature (in milliseconds since Unix epoch).")

  public Long getSignedOn() {
    return signedOn;
  }




   /**
   * Identifier of the signer in the audit trail.
   * @return auditTrailId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identifier of the signer in the audit trail.")

  public String getAuditTrailId() {
    return auditTrailId;
  }




   /**
   * **WARNING: Do not use (test purpose only).** 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**WARNING: Do not use (test purpose only).** ")

  public String getId() {
    return id;
  }




   /**
   * **WARNING: Do not use (test purpose only).** 
   * @return OTP
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**WARNING: Do not use (test purpose only).** ")

  public String getOTP() {
    return OTP;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizedSignee authorizedSignee = (AuthorizedSignee) o;
    return Objects.equals(this.commonName, authorizedSignee.commonName) &&
        Objects.equals(this.email, authorizedSignee.email) &&
        Objects.equals(this.countryCallingCode, authorizedSignee.countryCallingCode) &&
        Objects.equals(this.phone, authorizedSignee.phone) &&
        Objects.equals(this.requiresOTP, authorizedSignee.requiresOTP) &&
        Objects.equals(this.signsFaceToFace, authorizedSignee.signsFaceToFace) &&
        Objects.equals(this.vars, authorizedSignee.vars) &&
        Objects.equals(this.lang, authorizedSignee.lang) &&
        Objects.equals(this.pubKey, authorizedSignee.pubKey) &&
        Objects.equals(this.device, authorizedSignee.device) &&
        Objects.equals(this.identityURL, authorizedSignee.identityURL) &&
        Objects.equals(this.feedbackSubject, authorizedSignee.feedbackSubject) &&
        Objects.equals(this.feedbackMessage, authorizedSignee.feedbackMessage) &&
        Objects.equals(this.anchorId, authorizedSignee.anchorId) &&
        Objects.equals(this.signedOn, authorizedSignee.signedOn) &&
        Objects.equals(this.auditTrailId, authorizedSignee.auditTrailId) &&
        Objects.equals(this.id, authorizedSignee.id) &&
        Objects.equals(this.OTP, authorizedSignee.OTP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonName, email, countryCallingCode, phone, requiresOTP, signsFaceToFace, vars, lang, pubKey, device, identityURL, feedbackSubject, feedbackMessage, anchorId, signedOn, auditTrailId, id, OTP);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedSignee {\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    countryCallingCode: ").append(toIndentedString(countryCallingCode)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    requiresOTP: ").append(toIndentedString(requiresOTP)).append("\n");
    sb.append("    signsFaceToFace: ").append(toIndentedString(signsFaceToFace)).append("\n");
    sb.append("    vars: ").append(toIndentedString(vars)).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
    sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
    sb.append("    feedbackSubject: ").append(toIndentedString(feedbackSubject)).append("\n");
    sb.append("    feedbackMessage: ").append(toIndentedString(feedbackMessage)).append("\n");
    sb.append("    anchorId: ").append(toIndentedString(anchorId)).append("\n");
    sb.append("    signedOn: ").append(toIndentedString(signedOn)).append("\n");
    sb.append("    auditTrailId: ").append(toIndentedString(auditTrailId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    OTP: ").append(toIndentedString(OTP)).append("\n");
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

