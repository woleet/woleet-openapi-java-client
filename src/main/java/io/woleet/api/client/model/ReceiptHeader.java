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


/**
 * ReceiptHeader
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-21T14:15:59.181+01:00")
public class ReceiptHeader   {
  @SerializedName("chainpoint_version")
  private String chainpointVersion = "1.0";

  @SerializedName("hash_type")
  private String hashType = "SHA-256";

  @SerializedName("merkle_root")
  private String merkleRoot = null;

  @SerializedName("tx_id")
  private String txId = null;

  @SerializedName("timestamp")
  private Long timestamp = null;

  public ReceiptHeader chainpointVersion(String chainpointVersion) {
    this.chainpointVersion = chainpointVersion;
    return this;
  }

   /**
   * Get chainpointVersion
   * @return chainpointVersion
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getChainpointVersion() {
    return chainpointVersion;
  }

  public void setChainpointVersion(String chainpointVersion) {
    this.chainpointVersion = chainpointVersion;
  }

  public ReceiptHeader hashType(String hashType) {
    this.hashType = hashType;
    return this;
  }

   /**
   * Get hashType
   * @return hashType
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getHashType() {
    return hashType;
  }

  public void setHashType(String hashType) {
    this.hashType = hashType;
  }

  public ReceiptHeader merkleRoot(String merkleRoot) {
    this.merkleRoot = merkleRoot;
    return this;
  }

   /**
   * Get merkleRoot
   * @return merkleRoot
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getMerkleRoot() {
    return merkleRoot;
  }

  public void setMerkleRoot(String merkleRoot) {
    this.merkleRoot = merkleRoot;
  }

  public ReceiptHeader txId(String txId) {
    this.txId = txId;
    return this;
  }

   /**
   * Get txId
   * @return txId
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
  }

  public ReceiptHeader timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptHeader receiptHeader = (ReceiptHeader) o;
    return Objects.equals(this.chainpointVersion, receiptHeader.chainpointVersion) &&
        Objects.equals(this.hashType, receiptHeader.hashType) &&
        Objects.equals(this.merkleRoot, receiptHeader.merkleRoot) &&
        Objects.equals(this.txId, receiptHeader.txId) &&
        Objects.equals(this.timestamp, receiptHeader.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chainpointVersion, hashType, merkleRoot, txId, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptHeader {\n");
    
    sb.append("    chainpointVersion: ").append(toIndentedString(chainpointVersion)).append("\n");
    sb.append("    hashType: ").append(toIndentedString(hashType)).append("\n");
    sb.append("    merkleRoot: ").append(toIndentedString(merkleRoot)).append("\n");
    sb.append("    txId: ").append(toIndentedString(txId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
