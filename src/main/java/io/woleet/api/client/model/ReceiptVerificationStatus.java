/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.6.0
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
import java.io.IOException;

/**
 * ReceiptVerificationStatus
 */

public class ReceiptVerificationStatus {
  /**
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified&lt;br&gt; The receipt format is valid, the transaction is present in the Bitcoin blockchain and confirmed at least once, the receipt contains a valid Merkle proof linking its &#x60;targetHash&#x60; property to the transaction&#39;s &#x60;OP_RETURN&#x60; field.&lt;br&gt; The creation time and the number of confirmation of the block containing the transaction is returned in the &#x60;timestamp&#x60; and &#x60;confirmations&#x60; properties.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to exist at that time and has not been modified since.&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not include a valid Bitcoin transaction&lt;br&gt; - TX_NOT_CONFIRMED: the transaction is not yet confirmed by the blockchain (ie. not yet included in a block)&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature 
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    VERIFIED("VERIFIED"),
    
    INVALID_PROOF("INVALID_PROOF"),
    
    TX_NOT_FOUND("TX_NOT_FOUND"),
    
    TX_NOT_CONFIRMED("TX_NOT_CONFIRMED"),
    
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

    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CodeEnum.fromValue(String.valueOf(value));
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

  public static final String SERIALIZED_NAME_IDENTITY_VERIFICATION_STATUS = "identityVerificationStatus";
  @SerializedName(SERIALIZED_NAME_IDENTITY_VERIFICATION_STATUS)
  private IdentityVerificationStatus identityVerificationStatus = null;

  public ReceiptVerificationStatus code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified&lt;br&gt; The receipt format is valid, the transaction is present in the Bitcoin blockchain and confirmed at least once, the receipt contains a valid Merkle proof linking its &#x60;targetHash&#x60; property to the transaction&#39;s &#x60;OP_RETURN&#x60; field.&lt;br&gt; The creation time and the number of confirmation of the block containing the transaction is returned in the &#x60;timestamp&#x60; and &#x60;confirmations&#x60; properties.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to exist at that time and has not been modified since.&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not include a valid Bitcoin transaction&lt;br&gt; - TX_NOT_CONFIRMED: the transaction is not yet confirmed by the blockchain (ie. not yet included in a block)&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature 
   * @return code
  **/
  @ApiModelProperty(value = "Proof receipt verification status code:<br> - VERIFIED: the proof receipt is verified<br> The receipt format is valid, the transaction is present in the Bitcoin blockchain and confirmed at least once, the receipt contains a valid Merkle proof linking its `targetHash` property to the transaction's `OP_RETURN` field.<br> The creation time and the number of confirmation of the block containing the transaction is returned in the `timestamp` and `confirmations` properties.<br> Any data whose SHA256 hash matches the proof receipt's `targetHash` is proven to exist at that time and has not been modified since.<br> - TX_NOT_FOUND: the receipt's `anchors` property does not include a valid Bitcoin transaction<br> - TX_NOT_CONFIRMED: the transaction is not yet confirmed by the blockchain (ie. not yet included in a block)<br> - INVALID_PROOF: the receipt's `proof` property is not a valid Merkle proof<br> - TX_MISMATCH_RECEIPT: the receipt's `merkleRoot` property does not match the transaction's `OP_RETURN` field<br> - INVALID_SIGNATURE: the receipt's `signature` property is not a valid signature ")
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
   * Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).&lt;br&gt; Any data whose SHA256 hash equals this proof receipt&#39;s target hash property is proven to exist at that time and has not been modified since. 
   * @return timestamp
  **/
  @ApiModelProperty(value = "Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).<br> This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this proof receipt's target hash property is proven to exist at that time and has not been modified since. ")
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
  @ApiModelProperty(value = "Number of confirmations of the Bitcoin block into which the anchoring process occurred.")
  public Integer getConfirmations() {
    return confirmations;
  }

  public void setConfirmations(Integer confirmations) {
    this.confirmations = confirmations;
  }

  public ReceiptVerificationStatus identityVerificationStatus(IdentityVerificationStatus identityVerificationStatus) {
    this.identityVerificationStatus = identityVerificationStatus;
    return this;
  }

   /**
   * Get identityVerificationStatus
   * @return identityVerificationStatus
  **/
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
        Objects.equals(this.identityVerificationStatus, receiptVerificationStatus.identityVerificationStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, text, timestamp, confirmations, identityVerificationStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptVerificationStatus {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    confirmations: ").append(toIndentedString(confirmations)).append("\n");
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

