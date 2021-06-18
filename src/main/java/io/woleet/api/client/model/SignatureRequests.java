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
import io.woleet.api.client.model.SignatureRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SignatureRequests
 */

public class SignatureRequests {
  public static final String SERIALIZED_NAME_CONTENT = "content";
  @SerializedName(SERIALIZED_NAME_CONTENT)
  private List<SignatureRequest> content = null;

  public static final String SERIALIZED_NAME_FIRST = "first";
  @SerializedName(SERIALIZED_NAME_FIRST)
  private Boolean first;

  public static final String SERIALIZED_NAME_LAST = "last";
  @SerializedName(SERIALIZED_NAME_LAST)
  private Boolean last;

  public static final String SERIALIZED_NAME_NUMBER_OF_ELEMENTS = "numberOfElements";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_ELEMENTS)
  private Integer numberOfElements;

  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private Integer number;


  public SignatureRequests content(List<SignatureRequest> content) {
    
    this.content = content;
    return this;
  }

  public SignatureRequests addContentItem(SignatureRequest contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<SignatureRequest>();
    }
    this.content.add(contentItem);
    return this;
  }

   /**
   * Array of signature requests matching the search criteria.
   * @return content
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Array of signature requests matching the search criteria.")

  public List<SignatureRequest> getContent() {
    return content;
  }


  public void setContent(List<SignatureRequest> content) {
    this.content = content;
  }


  public SignatureRequests first(Boolean first) {
    
    this.first = first;
    return this;
  }

   /**
   * &#x60;true&#x60; if this is the first page. 
   * @return first
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if this is the first page. ")

  public Boolean getFirst() {
    return first;
  }


  public void setFirst(Boolean first) {
    this.first = first;
  }


  public SignatureRequests last(Boolean last) {
    
    this.last = last;
    return this;
  }

   /**
   * &#x60;true&#x60; if this is the last page. 
   * @return last
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if this is the last page. ")

  public Boolean getLast() {
    return last;
  }


  public void setLast(Boolean last) {
    this.last = last;
  }


  public SignatureRequests numberOfElements(Integer numberOfElements) {
    
    this.numberOfElements = numberOfElements;
    return this;
  }

   /**
   * Number of requests in the retrieved page.
   * @return numberOfElements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of requests in the retrieved page.")

  public Integer getNumberOfElements() {
    return numberOfElements;
  }


  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }


  public SignatureRequests size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Number of requests per page.
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of requests per page.")

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }


  public SignatureRequests number(Integer number) {
    
    this.number = number;
    return this;
  }

   /**
   * Index of the retrieved page (from 0).
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Index of the retrieved page (from 0).")

  public Integer getNumber() {
    return number;
  }


  public void setNumber(Integer number) {
    this.number = number;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureRequests signatureRequests = (SignatureRequests) o;
    return Objects.equals(this.content, signatureRequests.content) &&
        Objects.equals(this.first, signatureRequests.first) &&
        Objects.equals(this.last, signatureRequests.last) &&
        Objects.equals(this.numberOfElements, signatureRequests.numberOfElements) &&
        Objects.equals(this.size, signatureRequests.size) &&
        Objects.equals(this.number, signatureRequests.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, first, last, numberOfElements, size, number);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequests {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    numberOfElements: ").append(toIndentedString(numberOfElements)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

