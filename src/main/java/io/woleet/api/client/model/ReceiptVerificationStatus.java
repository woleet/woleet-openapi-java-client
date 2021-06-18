/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.10.0
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
import io.woleet.api.client.model.IdentityVerificationStatus;
import io.woleet.api.client.model.SignatureVerificationStatus;
import io.woleet.api.client.model.TimestampVerificationStatus;
import java.io.IOException;

/**
 * ReceiptVerificationStatus
 */

public class ReceiptVerificationStatus {
  /**
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: success: the proof receipt is verified: both the proof of timestamp AND the proof of signature (if applicable) are valid&lt;br&gt; - INVALID_SIGNATURE: error: the proof of signature is invalid&lt;br&gt; - any other verification status code: the proof of timestamp is not ready or invalid 
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    VERIFIED("VERIFIED"),
    
    TX_NOT_SENT("TX_NOT_SENT"),
    
    TX_NOT_CONFIRMED("TX_NOT_CONFIRMED"),
    
    INVALID_PROOF("INVALID_PROOF"),
    
    TX_NOT_FOUND("TX_NOT_FOUND"),
    
    TX_MISMATCH_RECEIPT("TX_MISMATCH_RECEIPT"),
    
    INVALID_SIGNATURE("INVALID_SIGNATURE");

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

  public static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
  @SerializedName(SERIALIZED_NAME_TIMESTAMP)
  private Long timestamp;

  public static final String SERIALIZED_NAME_CONFIRMATIONS = "confirmations";
  @SerializedName(SERIALIZED_NAME_CONFIRMATIONS)
  private Integer confirmations;

  public static final String SERIALIZED_NAME_TIMESTAMP_VERIFICATION_STATUS = "timestampVerificationStatus";
  @SerializedName(SERIALIZED_NAME_TIMESTAMP_VERIFICATION_STATUS)
  private TimestampVerificationStatus timestampVerificationStatus;

  public static final String SERIALIZED_NAME_SIGNATURE_VERIFICATION_STATUS = "signatureVerificationStatus";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_VERIFICATION_STATUS)
  private SignatureVerificationStatus signatureVerificationStatus;

  public static final String SERIALIZED_NAME_IDENTITY_VERIFICATION_STATUS = "identityVerificationStatus";
  @SerializedName(SERIALIZED_NAME_IDENTITY_VERIFICATION_STATUS)
  private IdentityVerificationStatus identityVerificationStatus;


  public ReceiptVerificationStatus code(CodeEnum code) {
    
    this.code = code;
    return this;
  }

   /**
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: success: the proof receipt is verified: both the proof of timestamp AND the proof of signature (if applicable) are valid&lt;br&gt; - INVALID_SIGNATURE: error: the proof of signature is invalid&lt;br&gt; - any other verification status code: the proof of timestamp is not ready or invalid 
   * @return code
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Proof receipt verification status code:<br> - VERIFIED: success: the proof receipt is verified: both the proof of timestamp AND the proof of signature (if applicable) are valid<br> - INVALID_SIGNATURE: error: the proof of signature is invalid<br> - any other verification status code: the proof of timestamp is not ready or invalid ")

  public CodeEnum getCode() {
    return code;
  }


  public void setCode(CodeEnum code) {
    this.code = code;
  }


  public ReceiptVerificationStatus text(String text) {
    
    this.text = text;
    return this;
  }

   /**
   * Proof receipt verification status text giving more insight about verification errors.
   * @return text
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Proof receipt verification status text giving more insight about verification errors.")

  public String getText() {
    return text;
  }


  public void setText(String text) {
    this.text = text;
  }


  public ReceiptVerificationStatus timestamp(Long timestamp) {
    
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch). 
   * @return timestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).<br> This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch). ")

  public Long getTimestamp() {
    return timestamp;
  }


  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  public ReceiptVerificationStatus confirmations(Integer confirmations) {
    
    this.confirmations = confirmations;
    return this;
  }

   /**
   * Number of confirmations of the Bitcoin block into which the anchoring process occurred.
   * @return confirmations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of confirmations of the Bitcoin block into which the anchoring process occurred.")

  public Integer getConfirmations() {
    return confirmations;
  }


  public void setConfirmations(Integer confirmations) {
    this.confirmations = confirmations;
  }


  public ReceiptVerificationStatus timestampVerificationStatus(TimestampVerificationStatus timestampVerificationStatus) {
    
    this.timestampVerificationStatus = timestampVerificationStatus;
    return this;
  }

   /**
   * Get timestampVerificationStatus
   * @return timestampVerificationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TimestampVerificationStatus getTimestampVerificationStatus() {
    return timestampVerificationStatus;
  }


  public void setTimestampVerificationStatus(TimestampVerificationStatus timestampVerificationStatus) {
    this.timestampVerificationStatus = timestampVerificationStatus;
  }


  public ReceiptVerificationStatus signatureVerificationStatus(SignatureVerificationStatus signatureVerificationStatus) {
    
    this.signatureVerificationStatus = signatureVerificationStatus;
    return this;
  }

   /**
   * Get signatureVerificationStatus
   * @return signatureVerificationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignatureVerificationStatus getSignatureVerificationStatus() {
    return signatureVerificationStatus;
  }


  public void setSignatureVerificationStatus(SignatureVerificationStatus signatureVerificationStatus) {
    this.signatureVerificationStatus = signatureVerificationStatus;
  }


  public ReceiptVerificationStatus identityVerificationStatus(IdentityVerificationStatus identityVerificationStatus) {
    
    this.identityVerificationStatus = identityVerificationStatus;
    return this;
  }

   /**
   * Get identityVerificationStatus
   * @return identityVerificationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdentityVerificationStatus getIdentityVerificationStatus() {
    return identityVerificationStatus;
  }


  public void setIdentityVerificationStatus(IdentityVerificationStatus identityVerificationStatus) {
    this.identityVerificationStatus = identityVerificationStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptVerificationStatus receiptVerificationStatus = (ReceiptVerificationStatus) o;
    return Objects.equals(this.code, receiptVerificationStatus.code) &&
        Objects.equals(this.text, receiptVerificationStatus.text) &&
        Objects.equals(this.timestamp, receiptVerificationStatus.timestamp) &&
        Objects.equals(this.confirmations, receiptVerificationStatus.confirmations) &&
        Objects.equals(this.timestampVerificationStatus, receiptVerificationStatus.timestampVerificationStatus) &&
        Objects.equals(this.signatureVerificationStatus, receiptVerificationStatus.signatureVerificationStatus) &&
        Objects.equals(this.identityVerificationStatus, receiptVerificationStatus.identityVerificationStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, text, timestamp, confirmations, timestampVerificationStatus, signatureVerificationStatus, identityVerificationStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptVerificationStatus {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    confirmations: ").append(toIndentedString(confirmations)).append("\n");
    sb.append("    timestampVerificationStatus: ").append(toIndentedString(timestampVerificationStatus)).append("\n");
    sb.append("    signatureVerificationStatus: ").append(toIndentedString(signatureVerificationStatus)).append("\n");
    sb.append("    identityVerificationStatus: ").append(toIndentedString(identityVerificationStatus)).append("\n");
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

