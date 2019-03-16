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
import java.io.IOException;

/**
 * SignatureRequestSignResult
 */

public class SignatureRequestSignResult {
  public static final String SERIALIZED_NAME_ANCHOR_ID = "anchorId";
  @SerializedName(SERIALIZED_NAME_ANCHOR_ID)
  private String anchorId;

  public SignatureRequestSignResult anchorId(String anchorId) {
    this.anchorId = anchorId;
    return this;
  }

   /**
   * Identifier of the signature anchor created. 
   * @return anchorId
  **/
  @ApiModelProperty(value = "Identifier of the signature anchor created. ")
  public String getAnchorId() {
    return anchorId;
  }

  public void setAnchorId(String anchorId) {
    this.anchorId = anchorId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureRequestSignResult signatureRequestSignResult = (SignatureRequestSignResult) o;
    return Objects.equals(this.anchorId, signatureRequestSignResult.anchorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(anchorId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequestSignResult {\n");
    
    sb.append("    anchorId: ").append(toIndentedString(anchorId)).append("\n");
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

