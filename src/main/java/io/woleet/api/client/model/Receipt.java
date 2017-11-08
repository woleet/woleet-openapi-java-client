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
import io.woleet.api.client.model.ReceiptAnchorsNode;
import io.woleet.api.client.model.ReceiptHeader;
import io.woleet.api.client.model.ReceiptProofNode;
import io.woleet.api.client.model.ReceiptSignature;
import io.woleet.api.client.model.ReceiptTarget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Receipt
 */

public class Receipt {
  @SerializedName("type")
  private String type = null;

  @SerializedName("targetHash")
  private String targetHash = null;

  @SerializedName("merkleRoot")
  private String merkleRoot = null;

  @SerializedName("proof")
  private List<ReceiptProofNode> proof = null;

  @SerializedName("anchors")
  private List<ReceiptAnchorsNode> anchors = null;

  @SerializedName("signature")
  private ReceiptSignature signature = null;

  @SerializedName("header")
  private ReceiptHeader header = null;

  @SerializedName("target")
  private ReceiptTarget target = null;

  public Receipt type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Receipt targetHash(String targetHash) {
    this.targetHash = targetHash;
    return this;
  }

   /**
   * Get targetHash
   * @return targetHash
  **/
  @ApiModelProperty(value = "")
  public String getTargetHash() {
    return targetHash;
  }

  public void setTargetHash(String targetHash) {
    this.targetHash = targetHash;
  }

  public Receipt merkleRoot(String merkleRoot) {
    this.merkleRoot = merkleRoot;
    return this;
  }

   /**
   * Get merkleRoot
   * @return merkleRoot
  **/
  @ApiModelProperty(value = "")
  public String getMerkleRoot() {
    return merkleRoot;
  }

  public void setMerkleRoot(String merkleRoot) {
    this.merkleRoot = merkleRoot;
  }

  public Receipt proof(List<ReceiptProofNode> proof) {
    this.proof = proof;
    return this;
  }

  public Receipt addProofItem(ReceiptProofNode proofItem) {
    if (this.proof == null) {
      this.proof = new ArrayList<ReceiptProofNode>();
    }
    this.proof.add(proofItem);
    return this;
  }

   /**
   * Get proof
   * @return proof
  **/
  @ApiModelProperty(value = "")
  public List<ReceiptProofNode> getProof() {
    return proof;
  }

  public void setProof(List<ReceiptProofNode> proof) {
    this.proof = proof;
  }

  public Receipt anchors(List<ReceiptAnchorsNode> anchors) {
    this.anchors = anchors;
    return this;
  }

  public Receipt addAnchorsItem(ReceiptAnchorsNode anchorsItem) {
    if (this.anchors == null) {
      this.anchors = new ArrayList<ReceiptAnchorsNode>();
    }
    this.anchors.add(anchorsItem);
    return this;
  }

   /**
   * Get anchors
   * @return anchors
  **/
  @ApiModelProperty(value = "")
  public List<ReceiptAnchorsNode> getAnchors() {
    return anchors;
  }

  public void setAnchors(List<ReceiptAnchorsNode> anchors) {
    this.anchors = anchors;
  }

  public Receipt signature(ReceiptSignature signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @ApiModelProperty(value = "")
  public ReceiptSignature getSignature() {
    return signature;
  }

  public void setSignature(ReceiptSignature signature) {
    this.signature = signature;
  }

  public Receipt header(ReceiptHeader header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  public ReceiptHeader getHeader() {
    return header;
  }

  public void setHeader(ReceiptHeader header) {
    this.header = header;
  }

  public Receipt target(ReceiptTarget target) {
    this.target = target;
    return this;
  }

   /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(value = "")
  public ReceiptTarget getTarget() {
    return target;
  }

  public void setTarget(ReceiptTarget target) {
    this.target = target;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Receipt receipt = (Receipt) o;
    return Objects.equals(this.type, receipt.type) &&
        Objects.equals(this.targetHash, receipt.targetHash) &&
        Objects.equals(this.merkleRoot, receipt.merkleRoot) &&
        Objects.equals(this.proof, receipt.proof) &&
        Objects.equals(this.anchors, receipt.anchors) &&
        Objects.equals(this.signature, receipt.signature) &&
        Objects.equals(this.header, receipt.header) &&
        Objects.equals(this.target, receipt.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, targetHash, merkleRoot, proof, anchors, signature, header, target);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Receipt {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    targetHash: ").append(toIndentedString(targetHash)).append("\n");
    sb.append("    merkleRoot: ").append(toIndentedString(merkleRoot)).append("\n");
    sb.append("    proof: ").append(toIndentedString(proof)).append("\n");
    sb.append("    anchors: ").append(toIndentedString(anchors)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

