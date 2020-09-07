/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.7.5
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
 * SignatureRequestSign
 */

public class SignatureRequestSign {
  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private String signature;

  public static final String SERIALIZED_NAME_PUB_KEY = "pubKey";
  @SerializedName(SERIALIZED_NAME_PUB_KEY)
  private String pubKey;

  public static final String SERIALIZED_NAME_SIGNED_IDENTITY = "signedIdentity";
  @SerializedName(SERIALIZED_NAME_SIGNED_IDENTITY)
  private String signedIdentity;

  public static final String SERIALIZED_NAME_SIGNED_ISSUER_DOMAIN = "signedIssuerDomain";
  @SerializedName(SERIALIZED_NAME_SIGNED_ISSUER_DOMAIN)
  private String signedIssuerDomain;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;

  /**
   * Type of device used to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent&lt;br&gt; - MOBILE: Woleet.ID Mobile or equivalent&lt;br&gt; - NANO: Ledger Nano S or equivalent 
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

  public static final String SERIALIZED_NAME_SIGNEE_ID = "signeeId";
  @SerializedName(SERIALIZED_NAME_SIGNEE_ID)
  private String signeeId;

  public static final String SERIALIZED_NAME_O_T_P = "OTP";
  @SerializedName(SERIALIZED_NAME_O_T_P)
  private String OTP;


  public SignatureRequestSign signature(String signature) {
    
    this.signature = signature;
    return this;
  }

   /**
   * Signature of the &#x60;hashToSign&#x60; property of the signature request using the public key &#x60;pubKey&#x60;, or, if any of &#x60;signedIdentity&#x60; or &#x60;signedIssuerDomain&#x60; is provided, signature of SHA256(&#x60;hashToSign&#x60; + &#x60;signedIdentity&#x60; + &#x60;signedIssuerDomain&#x60;) using the public key &#x60;pubKey&#x60;. 
   * @return signature
  **/
  @ApiModelProperty(required = true, value = "Signature of the `hashToSign` property of the signature request using the public key `pubKey`, or, if any of `signedIdentity` or `signedIssuerDomain` is provided, signature of SHA256(`hashToSign` + `signedIdentity` + `signedIssuerDomain`) using the public key `pubKey`. ")

  public String getSignature() {
    return signature;
  }


  public void setSignature(String signature) {
    this.signature = signature;
  }


  public SignatureRequestSign pubKey(String pubKey) {
    
    this.pubKey = pubKey;
    return this;
  }

   /**
   * Public key used to sign.
   * @return pubKey
  **/
  @ApiModelProperty(required = true, value = "Public key used to sign.")

  public String getPubKey() {
    return pubKey;
  }


  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }


  public SignatureRequestSign signedIdentity(String signedIdentity) {
    
    this.signedIdentity = signedIdentity;
    return this;
  }

   /**
   * X500 Distinguished Name representing the signed identity.&lt;br&gt; If set, the CN (common name) and EMAILADDRESS (email address) attributes must match the common name and email address of the signer as set in the signature request. 
   * @return signedIdentity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "X500 Distinguished Name representing the signed identity.<br> If set, the CN (common name) and EMAILADDRESS (email address) attributes must match the common name and email address of the signer as set in the signature request. ")

  public String getSignedIdentity() {
    return signedIdentity;
  }


  public void setSignedIdentity(String signedIdentity) {
    this.signedIdentity = signedIdentity;
  }


  public SignatureRequestSign signedIssuerDomain(String signedIssuerDomain) {
    
    this.signedIssuerDomain = signedIssuerDomain;
    return this;
  }

   /**
   * Domain name of the identity issuer (ie. of the organization who verified the identity).&lt;br&gt; If set, the domain name of the identity URL must be included in the &#x60;signedIssuerDomain&#x60; domain name. 
   * @return signedIssuerDomain
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Domain name of the identity issuer (ie. of the organization who verified the identity).<br> If set, the domain name of the identity URL must be included in the `signedIssuerDomain` domain name. ")

  public String getSignedIssuerDomain() {
    return signedIssuerDomain;
  }


  public void setSignedIssuerDomain(String signedIssuerDomain) {
    this.signedIssuerDomain = signedIssuerDomain;
  }


  public SignatureRequestSign identityURL(String identityURL) {
    
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to use to verify the signer&#39;s identity.&lt;br&gt; If set, it is used in place of the &#x60;identityURL&#x60; property of the signer to create the signature anchor. 
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Web hook to use to verify the signer's identity.<br> If set, it is used in place of the `identityURL` property of the signer to create the signature anchor. ")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


  public SignatureRequestSign device(DeviceEnum device) {
    
    this.device = device;
    return this;
  }

   /**
   * Type of device used to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent&lt;br&gt; - MOBILE: Woleet.ID Mobile or equivalent&lt;br&gt; - NANO: Ledger Nano S or equivalent 
   * @return device
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Type of device used to sign:<br> - SERVER: Woleet.ID Server or equivalent<br> - MOBILE: Woleet.ID Mobile or equivalent<br> - NANO: Ledger Nano S or equivalent ")

  public DeviceEnum getDevice() {
    return device;
  }


  public void setDevice(DeviceEnum device) {
    this.device = device;
  }


  public SignatureRequestSign signeeId(String signeeId) {
    
    this.signeeId = signeeId;
    return this;
  }

   /**
   * Secret identifier of the signer (provided by email).
   * @return signeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Secret identifier of the signer (provided by email).")

  public String getSigneeId() {
    return signeeId;
  }


  public void setSigneeId(String signeeId) {
    this.signeeId = signeeId;
  }


  public SignatureRequestSign OTP(String OTP) {
    
    this.OTP = OTP;
    return this;
  }

   /**
   * OTP of the signer (only required if &#x60;requiresOTP&#x60; was set to &#x60;true&#x60; for thìs signer). 
   * @return OTP
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "OTP of the signer (only required if `requiresOTP` was set to `true` for thìs signer). ")

  public String getOTP() {
    return OTP;
  }


  public void setOTP(String OTP) {
    this.OTP = OTP;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureRequestSign signatureRequestSign = (SignatureRequestSign) o;
    return Objects.equals(this.signature, signatureRequestSign.signature) &&
        Objects.equals(this.pubKey, signatureRequestSign.pubKey) &&
        Objects.equals(this.signedIdentity, signatureRequestSign.signedIdentity) &&
        Objects.equals(this.signedIssuerDomain, signatureRequestSign.signedIssuerDomain) &&
        Objects.equals(this.identityURL, signatureRequestSign.identityURL) &&
        Objects.equals(this.device, signatureRequestSign.device) &&
        Objects.equals(this.signeeId, signatureRequestSign.signeeId) &&
        Objects.equals(this.OTP, signatureRequestSign.OTP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signature, pubKey, signedIdentity, signedIssuerDomain, identityURL, device, signeeId, OTP);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequestSign {\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
    sb.append("    signedIdentity: ").append(toIndentedString(signedIdentity)).append("\n");
    sb.append("    signedIssuerDomain: ").append(toIndentedString(signedIssuerDomain)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    signeeId: ").append(toIndentedString(signeeId)).append("\n");
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

