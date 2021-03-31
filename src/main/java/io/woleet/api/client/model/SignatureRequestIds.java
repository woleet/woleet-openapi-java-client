/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.8.0
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
import java.util.ArrayList;
import java.util.List;

/**
 * SignatureRequestIds
 */

public class SignatureRequestIds {
  public static final String SERIALIZED_NAME_CONTENT = "content";
  @SerializedName(SERIALIZED_NAME_CONTENT)
  private List<String> content = null;

  public static final String SERIALIZED_NAME_FIRST = "first";
  @SerializedName(SERIALIZED_NAME_FIRST)
  private Boolean first;

  public static final String SERIALIZED_NAME_LAST = "last";
  @SerializedName(SERIALIZED_NAME_LAST)
  private Boolean last;

  public static final String SERIALIZED_NAME_TOTAL_PAGES = "totalPages";
  @SerializedName(SERIALIZED_NAME_TOTAL_PAGES)
  private Integer totalPages;

  public static final String SERIALIZED_NAME_TOTAL_ELEMENTS = "totalElements";
  @SerializedName(SERIALIZED_NAME_TOTAL_ELEMENTS)
  private Integer totalElements;

  public static final String SERIALIZED_NAME_NUMBER_OF_ELEMENTS = "numberOfElements";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_ELEMENTS)
  private Integer numberOfElements;

  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private Integer number;


  public SignatureRequestIds content(List<String> content) {
    
    this.content = content;
    return this;
  }

  public SignatureRequestIds addContentItem(String contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<String>();
    }
    this.content.add(contentItem);
    return this;
  }

   /**
   * Array of identifiers of signature requests matching the search criteria.
   * @return content
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Array of identifiers of signature requests matching the search criteria.")

  public List<String> getContent() {
    return content;
  }


  public void setContent(List<String> content) {
    this.content = content;
  }


  public SignatureRequestIds first(Boolean first) {
    
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


  public SignatureRequestIds last(Boolean last) {
    
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


  public SignatureRequestIds totalPages(Integer totalPages) {
    
    this.totalPages = totalPages;
    return this;
  }

   /**
   * Total number of pages available.
   * @return totalPages
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Total number of pages available.")

  public Integer getTotalPages() {
    return totalPages;
  }


  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }


  public SignatureRequestIds totalElements(Integer totalElements) {
    
    this.totalElements = totalElements;
    return this;
  }

   /**
   * Total number of signature requests matching the search criteria.
   * @return totalElements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Total number of signature requests matching the search criteria.")

  public Integer getTotalElements() {
    return totalElements;
  }


  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }


  public SignatureRequestIds numberOfElements(Integer numberOfElements) {
    
    this.numberOfElements = numberOfElements;
    return this;
  }

   /**
   * Number of signature requests in the retrieved page.
   * @return numberOfElements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of signature requests in the retrieved page.")

  public Integer getNumberOfElements() {
    return numberOfElements;
  }


  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }


  public SignatureRequestIds size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Number of signature requests per page.
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of signature requests per page.")

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }


  public SignatureRequestIds number(Integer number) {
    
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
    SignatureRequestIds signatureRequestIds = (SignatureRequestIds) o;
    return Objects.equals(this.content, signatureRequestIds.content) &&
        Objects.equals(this.first, signatureRequestIds.first) &&
        Objects.equals(this.last, signatureRequestIds.last) &&
        Objects.equals(this.totalPages, signatureRequestIds.totalPages) &&
        Objects.equals(this.totalElements, signatureRequestIds.totalElements) &&
        Objects.equals(this.numberOfElements, signatureRequestIds.numberOfElements) &&
        Objects.equals(this.size, signatureRequestIds.size) &&
        Objects.equals(this.number, signatureRequestIds.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, first, last, totalPages, totalElements, numberOfElements, size, number);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequestIds {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
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

