/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.6.2
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
import io.woleet.api.client.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Users
 */

public class Users {
  public static final String SERIALIZED_NAME_CONTENT = "content";
  @SerializedName(SERIALIZED_NAME_CONTENT)
  private List<User> content = null;

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

  public Users content(List<User> content) {
    this.content = content;
    return this;
  }

  public Users addContentItem(User contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<User>();
    }
    this.content.add(contentItem);
    return this;
  }

   /**
   * Array of users matching the search criteria.
   * @return content
  **/
  @ApiModelProperty(value = "Array of users matching the search criteria.")
  public List<User> getContent() {
    return content;
  }

  public void setContent(List<User> content) {
    this.content = content;
  }

  public Users first(Boolean first) {
    this.first = first;
    return this;
  }

   /**
   * &#x60;true&#x60; if this is the first page. 
   * @return first
  **/
  @ApiModelProperty(value = "`true` if this is the first page. ")
  public Boolean getFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public Users last(Boolean last) {
    this.last = last;
    return this;
  }

   /**
   * &#x60;true&#x60; if this is the last page. 
   * @return last
  **/
  @ApiModelProperty(value = "`true` if this is the last page. ")
  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public Users numberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
    return this;
  }

   /**
   * Number of users in the retrieved page.
   * @return numberOfElements
  **/
  @ApiModelProperty(value = "Number of users in the retrieved page.")
  public Integer getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  public Users size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Number of users per page.
   * @return size
  **/
  @ApiModelProperty(value = "Number of users per page.")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Users number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Index of the retrieved page (from 0).
   * @return number
  **/
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
    Users users = (Users) o;
    return Objects.equals(this.content, users.content) &&
        Objects.equals(this.first, users.first) &&
        Objects.equals(this.last, users.last) &&
        Objects.equals(this.numberOfElements, users.numberOfElements) &&
        Objects.equals(this.size, users.size) &&
        Objects.equals(this.number, users.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, first, last, numberOfElements, size, number);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Users {\n");
    
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

