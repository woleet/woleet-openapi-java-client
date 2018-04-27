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
 * ReceiptProofNode
 */

public class ReceiptProofNode {
  @SerializedName("left")
  private String left = null;

  @SerializedName("right")
  private String right = null;

  public ReceiptProofNode left(String left) {
    this.left = left;
    return this;
  }

   /**
   * Get left
   * @return left
  **/
  @ApiModelProperty(required = true, value = "")
  public String getLeft() {
    return left;
  }

  public void setLeft(String left) {
    this.left = left;
  }

  public ReceiptProofNode right(String right) {
    this.right = right;
    return this;
  }

   /**
   * Get right
   * @return right
  **/
  @ApiModelProperty(required = true, value = "")
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
    ReceiptProofNode receiptProofNode = (ReceiptProofNode) o;
    return Objects.equals(this.left, receiptProofNode.left) &&
        Objects.equals(this.right, receiptProofNode.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptProofNode {\n");
    
    sb.append("    left: ").append(toIndentedString(left)).append("\n");
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

