/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.13.0
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
import io.woleet.api.client.model.Identity;
import io.woleet.api.client.model.Key;
import io.woleet.api.client.model.SignedIdentity;
import io.woleet.api.client.model.X509SubjectIssuer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IdentityVerificationStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IdentityVerificationStatus {
  /**
   * Identity verification status code: - VERIFIED: success: the signature key is controlled by the identity server (ie. the server provided a valid proof of ownership of the key),&lt;br&gt; and/or the signature key matches an identity on the identity server (ie. the server claimed the signer identity),&lt;br&gt; and/or the identity is signed (ie. the signer claimed his identity by including it in the signed data),&lt;br&gt; and/or the signed identity matches the one on the identity server (both the signer and the identity server claim the identity) - HTTP_ERROR: error: the identity URL cannot be called or returned an HTTP error other than 404 - IDENTITY_NOT_FOUND: error: the key does not match any identity on the identity server (ie. the identity URL returned a HTTP error 404) - IDENTITY_MISMATCH: error: the signed identity mismatches the identity on the identity server - INVALID_SIGNATURE: error: the identity server returned an invalid signature (ie. the server failed to provide a valid proof of ownership of the key) - DEPRECATED_KEY: error: the key expired or was revoked before the signature timestamp 
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    VERIFIED("VERIFIED"),
    
    HTTP_ERROR("HTTP_ERROR"),
    
    IDENTITY_NOT_FOUND("IDENTITY_NOT_FOUND"),
    
    IDENTITY_MISMATCH("IDENTITY_MISMATCH"),
    
    INVALID_SIGNATURE("INVALID_SIGNATURE"),
    
    DEPRECATED_KEY("DEPRECATED_KEY");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CODE = "code";
  @SerializedName(SERIALIZED_NAME_CODE)
  private CodeEnum code;

  public static final String SERIALIZED_NAME_TEXT = "text";
  @SerializedName(SERIALIZED_NAME_TEXT)
  private String text;

  public static final String SERIALIZED_NAME_CERTIFICATES = "certificates";
  @SerializedName(SERIALIZED_NAME_CERTIFICATES)
  private List<X509SubjectIssuer> certificates = null;

  public static final String SERIALIZED_NAME_IDENTITY = "identity";
  @SerializedName(SERIALIZED_NAME_IDENTITY)
  private Identity identity;

  public static final String SERIALIZED_NAME_SIGNED_IDENTITY = "signedIdentity";
  @SerializedName(SERIALIZED_NAME_SIGNED_IDENTITY)
  private SignedIdentity signedIdentity;

  public static final String SERIALIZED_NAME_KEY = "key";
  @SerializedName(SERIALIZED_NAME_KEY)
  private Key key;


  public IdentityVerificationStatus code(CodeEnum code) {
    
    this.code = code;
    return this;
  }

   /**
   * Identity verification status code: - VERIFIED: success: the signature key is controlled by the identity server (ie. the server provided a valid proof of ownership of the key),&lt;br&gt; and/or the signature key matches an identity on the identity server (ie. the server claimed the signer identity),&lt;br&gt; and/or the identity is signed (ie. the signer claimed his identity by including it in the signed data),&lt;br&gt; and/or the signed identity matches the one on the identity server (both the signer and the identity server claim the identity) - HTTP_ERROR: error: the identity URL cannot be called or returned an HTTP error other than 404 - IDENTITY_NOT_FOUND: error: the key does not match any identity on the identity server (ie. the identity URL returned a HTTP error 404) - IDENTITY_MISMATCH: error: the signed identity mismatches the identity on the identity server - INVALID_SIGNATURE: error: the identity server returned an invalid signature (ie. the server failed to provide a valid proof of ownership of the key) - DEPRECATED_KEY: error: the key expired or was revoked before the signature timestamp 
   * @return code
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identity verification status code: - VERIFIED: success: the signature key is controlled by the identity server (ie. the server provided a valid proof of ownership of the key),<br> and/or the signature key matches an identity on the identity server (ie. the server claimed the signer identity),<br> and/or the identity is signed (ie. the signer claimed his identity by including it in the signed data),<br> and/or the signed identity matches the one on the identity server (both the signer and the identity server claim the identity) - HTTP_ERROR: error: the identity URL cannot be called or returned an HTTP error other than 404 - IDENTITY_NOT_FOUND: error: the key does not match any identity on the identity server (ie. the identity URL returned a HTTP error 404) - IDENTITY_MISMATCH: error: the signed identity mismatches the identity on the identity server - INVALID_SIGNATURE: error: the identity server returned an invalid signature (ie. the server failed to provide a valid proof of ownership of the key) - DEPRECATED_KEY: error: the key expired or was revoked before the signature timestamp ")

  public CodeEnum getCode() {
    return code;
  }


  public void setCode(CodeEnum code) {
    this.code = code;
  }


  public IdentityVerificationStatus text(String text) {
    
    this.text = text;
    return this;
  }

   /**
   * Identity verification status text (gives more insights about the verification process).
   * @return text
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identity verification status text (gives more insights about the verification process).")

  public String getText() {
    return text;
  }


  public void setText(String text) {
    this.text = text;
  }


  public IdentityVerificationStatus certificates(List<X509SubjectIssuer> certificates) {
    
    this.certificates = certificates;
    return this;
  }

  public IdentityVerificationStatus addCertificatesItem(X509SubjectIssuer certificatesItem) {
    if (this.certificates == null) {
      this.certificates = new ArrayList<X509SubjectIssuer>();
    }
    this.certificates.add(certificatesItem);
    return this;
  }

   /**
   * Array of subjects and issuers of the certificates extracted from the identity URL&#39;s TLS certificate.
   * @return certificates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Array of subjects and issuers of the certificates extracted from the identity URL's TLS certificate.")

  public List<X509SubjectIssuer> getCertificates() {
    return certificates;
  }


  public void setCertificates(List<X509SubjectIssuer> certificates) {
    this.certificates = certificates;
  }


  public IdentityVerificationStatus identity(Identity identity) {
    
    this.identity = identity;
    return this;
  }

   /**
   * Get identity
   * @return identity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Identity getIdentity() {
    return identity;
  }


  public void setIdentity(Identity identity) {
    this.identity = identity;
  }


  public IdentityVerificationStatus signedIdentity(SignedIdentity signedIdentity) {
    
    this.signedIdentity = signedIdentity;
    return this;
  }

   /**
   * Get signedIdentity
   * @return signedIdentity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignedIdentity getSignedIdentity() {
    return signedIdentity;
  }


  public void setSignedIdentity(SignedIdentity signedIdentity) {
    this.signedIdentity = signedIdentity;
  }


  public IdentityVerificationStatus key(Key key) {
    
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Key getKey() {
    return key;
  }


  public void setKey(Key key) {
    this.key = key;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityVerificationStatus identityVerificationStatus = (IdentityVerificationStatus) o;
    return Objects.equals(this.code, identityVerificationStatus.code) &&
        Objects.equals(this.text, identityVerificationStatus.text) &&
        Objects.equals(this.certificates, identityVerificationStatus.certificates) &&
        Objects.equals(this.identity, identityVerificationStatus.identity) &&
        Objects.equals(this.signedIdentity, identityVerificationStatus.signedIdentity) &&
        Objects.equals(this.key, identityVerificationStatus.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, text, certificates, identity, signedIdentity, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityVerificationStatus {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    certificates: ").append(toIndentedString(certificates)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    signedIdentity: ").append(toIndentedString(signedIdentity)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

