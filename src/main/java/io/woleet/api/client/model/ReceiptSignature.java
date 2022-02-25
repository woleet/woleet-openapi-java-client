/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.11.1
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
 * Proof of signature (for proof of signature receipts only).
 */
@ApiModel(description = "Proof of signature (for proof of signature receipts only).")

public class ReceiptSignature {
  public static final String SERIALIZED_NAME_SIGNED_HASH = "signedHash";
  @SerializedName(SERIALIZED_NAME_SIGNED_HASH)
  private String signedHash;

  public static final String SERIALIZED_NAME_SIGNED_IDENTITY = "signedIdentity";
  @SerializedName(SERIALIZED_NAME_SIGNED_IDENTITY)
  private String signedIdentity;

  public static final String SERIALIZED_NAME_SIGNED_ISSUER_DOMAIN = "signedIssuerDomain";
  @SerializedName(SERIALIZED_NAME_SIGNED_ISSUER_DOMAIN)
  private String signedIssuerDomain;

  public static final String SERIALIZED_NAME_PUB_KEY = "pubKey";
  @SerializedName(SERIALIZED_NAME_PUB_KEY)
  private String pubKey;

  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private String signature;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;


  public ReceiptSignature signedHash(String signedHash) {
    
    this.signedHash = signedHash;
    return this;
  }

   /**
   * SHA256 hash of the signed file.
   * @return signedHash
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789", value = "SHA256 hash of the signed file.")

  public String getSignedHash() {
    return signedHash;
  }


  public void setSignedHash(String signedHash) {
    this.signedHash = signedHash;
  }


  public ReceiptSignature signedIdentity(String signedIdentity) {
    
    this.signedIdentity = signedIdentity;
    return this;
  }

   /**
   * X500 Distinguished Name representing the signed identity.
   * @return signedIdentity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CN=John Doe,EMAILADDRESS=john.doe@acme.com", value = "X500 Distinguished Name representing the signed identity.")

  public String getSignedIdentity() {
    return signedIdentity;
  }


  public void setSignedIdentity(String signedIdentity) {
    this.signedIdentity = signedIdentity;
  }


  public ReceiptSignature signedIssuerDomain(String signedIssuerDomain) {
    
    this.signedIssuerDomain = signedIssuerDomain;
    return this;
  }

   /**
   * Domain name of the identity issuer (ie. of the organization who verified the identity).
   * @return signedIssuerDomain
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "acme.com", value = "Domain name of the identity issuer (ie. of the organization who verified the identity).")

  public String getSignedIssuerDomain() {
    return signedIssuerDomain;
  }


  public void setSignedIssuerDomain(String signedIssuerDomain) {
    this.signedIssuerDomain = signedIssuerDomain;
  }


  public ReceiptSignature pubKey(String pubKey) {
    
    this.pubKey = pubKey;
    return this;
  }

   /**
   * Public key of the signer.&lt;br&gt; **Currently only Bitcoin addresses are supported.** 
   * @return pubKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1Ddk3zx55biVKXodadBVbRC5txWG7YwGAx", value = "Public key of the signer.<br> **Currently only Bitcoin addresses are supported.** ")

  public String getPubKey() {
    return pubKey;
  }


  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }


  public ReceiptSignature signature(String signature) {
    
    this.signature = signature;
    return this;
  }

   /**
   * Signature of the &#x60;signedHash&#x60; property using the public key &#x60;pubKey&#x60;, or, if any of &#x60;signedIdentity&#x60; or &#x60;signedIssuerDomain&#x60; is provided, signature of SHA256(&#x60;signedHash&#x60; + &#x60;signedIdentity&#x60; + &#x60;signedIssuerDomain&#x60;) using the public key &#x60;pubKey&#x60;. 
   * @return signature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "IGcvQrBq8w7eJDekrOhy9sIqttmicMp47vzf77Dg4PJJfFdZVDVGeHki3pitfWrs6ysoccKUK0xEx7Da2Cb8ljw=", value = "Signature of the `signedHash` property using the public key `pubKey`, or, if any of `signedIdentity` or `signedIssuerDomain` is provided, signature of SHA256(`signedHash` + `signedIdentity` + `signedIssuerDomain`) using the public key `pubKey`. ")

  public String getSignature() {
    return signature;
  }


  public void setSignature(String signature) {
    this.signature = signature;
  }


  public ReceiptSignature identityURL(String identityURL) {
    
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to use to verify the signer&#39;s identity.
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://wids.acme.com/identity", value = "Web hook to use to verify the signer's identity.")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptSignature receiptSignature = (ReceiptSignature) o;
    return Objects.equals(this.signedHash, receiptSignature.signedHash) &&
        Objects.equals(this.signedIdentity, receiptSignature.signedIdentity) &&
        Objects.equals(this.signedIssuerDomain, receiptSignature.signedIssuerDomain) &&
        Objects.equals(this.pubKey, receiptSignature.pubKey) &&
        Objects.equals(this.signature, receiptSignature.signature) &&
        Objects.equals(this.identityURL, receiptSignature.identityURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signedHash, signedIdentity, signedIssuerDomain, pubKey, signature, identityURL);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptSignature {\n");
    sb.append("    signedHash: ").append(toIndentedString(signedHash)).append("\n");
    sb.append("    signedIdentity: ").append(toIndentedString(signedIdentity)).append("\n");
    sb.append("    signedIssuerDomain: ").append(toIndentedString(signedIssuerDomain)).append("\n");
    sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
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

