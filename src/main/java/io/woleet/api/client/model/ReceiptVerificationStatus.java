/*
 * Woleet API
 * # Basics The Woleet API is an **HTTP REST API**. It supports **CORS** and provides **Basic authentication** and **JWT authentication**, allowing an easy and secure interaction with both web clients and backend applications.  The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and, from it, **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.  Ready to use versions of the client code are provided as open source code for [JavaScript/NodeJS](https://github.com/woleet/woleet-openapi-js-client) and [Java](https://github.com/woleet/woleet-openapi-java-client).  The API base URL is **https://api.woleet.io/v1**. # Authentication The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.  The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using Basic authentication) and then provide this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme. # Purpose The Woleet API provides an easy and cheap way to create **timestamped proofs of existence** and **timestamped proofs of signature** for your data (which can be of any type). Proofs created are **stored in the Bitcoin blockchain** and so are independent from Woleet (an access to the Bitcoin blockchain and some client side open source code is enough to verify proofs). Using the Woleet API, you can create durable and unfalsifiable cryptographic proofs usable to prove your data existed in a given state at a given date, and optionally was signed by a given signee.  The Woleet API creates **proofs of existence** conform to the open source standard [Chainpoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, without any interaction with Woleet, and so remain **verifiable forever** even if Woleet stops its operations.  The Woleet API creates **proofs of signature** that are an extension of the same standard proposed by Woleet (we are actively involved in the standardization process). Thus, the existence and timestamp of a signature is verifiable using the same tools used to verify proofs of existence. When it comes to verifying the validity of the signature and the signee's identity, some additional processing is performed: since this processing can be fully performed client side with no additional data, proofs of signature remain **verifiable forever** even if Woleet stops its operations. # Creating proofs To create a **proof of existence** for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you only need to compute the SHA256 hash of the file client side and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or on the type of the file, and the file is not even leaked to Woleet.  To create a **proof of signature** for a file, you also need to create an anchor, and so to compute the SHA256 hash of the file and choose a name for the anchor, but some additional data is required: your public key (the one associated with the private key used to sign the SHA256 hash of the file) and your signature itself. Optionally, you can provide a URL allowing to verify your identity by ensuring you own the public key and the TLS certificate of the URL.  Newly created **anchors are automatically collected** by the platform and **recorded in the Bitcoin blockchain**: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate a URL to an anchor that the platform will call whenever the anchor status changes.  Once an anchor is recorded in the Bitcoin blockchain, you can retrieve its associated **proof receipt** using the Woleet API. Proof receipts **conform to the [Chainpoint 1 or 2](https://www.chainpoint.org/) proof receipt format** (with some Woleet extensions when it comes to proofs of signature). The proof receipt is the only piece of data required to prove the existence/signature of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt on-demand whenever you want to verify a file. # Verifying proofs Verifying a **proof of existence** using the Woleet API is straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, so you just need to check that the SHA256 hash of the file matches the proof receipt's `hash` property.  Verifying a **proof of signature** using the Woleet API is also straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, then verifies the signature, and optionally verifies that the signee owns the public key and the TLS certificate, so you just need to check that the SHA256 hash of the file matches the proof receipt's `signedHash` property.  The Woleet API can also be used to verify any Chainpoint 1 or 2 proof receipt, including those created by other providers.  Woleet also provides an open source [JavaScript library for web clients](https://github.com/woleet/woleet-weblibs) implementing the full verification process without the help of the Woleet API. # About public and private anchors An anchor can be public (which is the default) or private.  A **private anchor** is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the data to anyone wanting to verify the proof.  A **public anchor** is discoverable by anyone knowing the hash of the data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to retrieve the proof receipt using only the data hash as input, and then to verify it using the Woleet API or any other mean: - use the `/anchorids` endpoint to retrieve the anchor identifier by its hash - use the `receipt/{anchorid}` endpoint to retrieve the proof receipt. - use the `receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the data or signature timestamp.  # About the verification process For your understanding, here is a formal description of the verification process of a **proof of existence**: - compute the SHA256 hash of the file - check that the `targetHash` property of the proof receipt matches the hash of the file - check that the `proof` property of the proof receipt is a valid Merkle proof (see the [Chainpoint](https://www.chainpoint.org/) standard for this step) - retrieve the Bitcoin transaction from the `anchors` property of the proof receipt - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkleRoot` property of the proof receipt  For **proof of signature**, an additional verification process is performed: - check that the SHA256 hash of the `signature` property matches its `targetHash` property - check that the `signature` property is a valid signature of the `signedHash` property for the public key stored in the `pubKey` property - additionally, if an `identityURL` property is available:   - call `identityURL` to make the callee sign some random data using the public key `pubKey`    - check that the returned signature is valid    - get the TLS certificates of the URL (it must be an HTTPS URL) to get insight about the signee's identity 
 *
 * OpenAPI spec version: 1.3.1
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.woleet.api.client.model;

import java.util.Objects;
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
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified: the receipt format is valid, the associated Bitcoin transaction is present in the blockchain, and the receipt contains a valid cryptographic proof that its &#x60;targetHash&#x60; property is anchored into the transaction&#39;s &#x60;OP_RETURN&#x60; field. The time of the Bitcoin block into which the anchoring process occurred is returned in the &#x60;timestamp&#x60; property.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to be existent at that time and unmodified.&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not point to a valid Bitcoin transaction&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature&lt;br&gt; 
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    VERIFIED("VERIFIED"),
    
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

    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
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

  @SerializedName("code")
  private CodeEnum code = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("timestamp")
  private Long timestamp = null;

  @SerializedName("confirmations")
  private Integer confirmations = null;

  @SerializedName("identityVerificationStatus")
  private IdentityVerificationStatus identityVerificationStatus = null;

  public ReceiptVerificationStatus code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified: the receipt format is valid, the associated Bitcoin transaction is present in the blockchain, and the receipt contains a valid cryptographic proof that its &#x60;targetHash&#x60; property is anchored into the transaction&#39;s &#x60;OP_RETURN&#x60; field. The time of the Bitcoin block into which the anchoring process occurred is returned in the &#x60;timestamp&#x60; property.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to be existent at that time and unmodified.&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not point to a valid Bitcoin transaction&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature&lt;br&gt; 
   * @return code
  **/
  @ApiModelProperty(value = "Proof receipt verification status code:<br> - VERIFIED: the proof receipt is verified: the receipt format is valid, the associated Bitcoin transaction is present in the blockchain, and the receipt contains a valid cryptographic proof that its `targetHash` property is anchored into the transaction's `OP_RETURN` field. The time of the Bitcoin block into which the anchoring process occurred is returned in the `timestamp` property.<br> Any data whose SHA256 hash matches the proof receipt's `targetHash` is proven to be existent at that time and unmodified.<br> - INVALID_PROOF: the receipt's `proof` property is not a valid Merkle proof<br> - TX_NOT_FOUND: the receipt's `anchors` property does not point to a valid Bitcoin transaction<br> - TX_MISMATCH_RECEIPT: the receipt's `merkleRoot` property does not match the transaction's `OP_RETURN` field<br> - INVALID_SIGNATURE: the receipt's `signature` property is not a valid signature<br> ")
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
   * Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).&lt;br&gt; Any data whose SHA256 hash equals this proof receipt&#39;s target hash property is proven to be existent at that time and unmodified. 
   * @return timestamp
  **/
  @ApiModelProperty(value = "Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).<br> This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).<br> Any data whose SHA256 hash equals this proof receipt's target hash property is proven to be existent at that time and unmodified. ")
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

