/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/v1.5.1/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.5.1
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
import java.io.IOException;

/**
 * For Chainpoint 1.x receipts only
 */
@ApiModel(description = "For Chainpoint 1.x receipts only")

public class ReceiptTargetProofNode {
  @SerializedName("left")
  private String left = null;

  @SerializedName("parent")
  private String parent = null;

  @SerializedName("right")
  private String right = null;

  public ReceiptTargetProofNode left(String left) {
    this.left = left;
    return this;
  }

   /**
   * Get left
   * @return left
  **/
  @ApiModelProperty(value = "")
  public String getLeft() {
    return left;
  }

  public void setLeft(String left) {
    this.left = left;
  }

  public ReceiptTargetProofNode parent(String parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public ReceiptTargetProofNode right(String right) {
    this.right = right;
    return this;
  }

   /**
   * Get right
   * @return right
  **/
  @ApiModelProperty(value = "")
  public String getRight() {
    return right;
  }

  public void setRight(String right) {
    this.right = right;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptTargetProofNode receiptTargetProofNode = (ReceiptTargetProofNode) o;
    return Objects.equals(this.left, receiptTargetProofNode.left) &&
        Objects.equals(this.parent, receiptTargetProofNode.parent) &&
        Objects.equals(this.right, receiptTargetProofNode.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, parent, right);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptTargetProofNode {\n");
    
    sb.append("    left: ").append(toIndentedString(left)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    right: ").append(toIndentedString(right)).append("\n");
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

