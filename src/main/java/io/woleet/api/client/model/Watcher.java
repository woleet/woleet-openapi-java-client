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
import java.io.IOException;

/**
 * A watcher of the signature request.
 */
@ApiModel(description = "A watcher of the signature request.")

public class Watcher {
  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_COMMON_NAME = "commonName";
  @SerializedName(SERIALIZED_NAME_COMMON_NAME)
  private String commonName;

  public static final String SERIALIZED_NAME_VARS = "vars";
  @SerializedName(SERIALIZED_NAME_VARS)
  private Object vars;

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private String lang;


  public Watcher email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email of the watcher.
   * @return email
  **/
  @ApiModelProperty(example = "john.doe@acme.com", required = true, value = "The email of the watcher.")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public Watcher commonName(String commonName) {
    
    this.commonName = commonName;
    return this;
  }

   /**
   * The full name of the watcher.
   * @return commonName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John Doe", value = "The full name of the watcher.")

  public String getCommonName() {
    return commonName;
  }


  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  public Watcher vars(Object vars) {
    
    this.vars = vars;
    return this;
  }

   /**
   * A set of variables (key/value pairs) that can be used to customize the signature request workflow for this watcher.&lt;br&gt; Values must be of type null, boolean, string or number: nested JSON objects are not allowed.&lt;br&gt; Variables defined here overwrites the ones defined at signature request level when emailing the watcher. 
   * @return vars
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"key\":\"value\"}", value = "A set of variables (key/value pairs) that can be used to customize the signature request workflow for this watcher.<br> Values must be of type null, boolean, string or number: nested JSON objects are not allowed.<br> Variables defined here overwrites the ones defined at signature request level when emailing the watcher. ")

  public Object getVars() {
    return vars;
  }


  public void setVars(Object vars) {
    this.vars = vars;
  }


  public Watcher lang(String lang) {
    
    this.lang = lang;
    return this;
  }

   /**
   * The preferred language (provided as an ISO 639-1 string) to use when emailing the watcher.&lt;br&gt; If set, this property overwrites the &#x60;lang&#x60; property defined at signature request level. 
   * @return lang
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "fr", value = "The preferred language (provided as an ISO 639-1 string) to use when emailing the watcher.<br> If set, this property overwrites the `lang` property defined at signature request level. ")

  public String getLang() {
    return lang;
  }


  public void setLang(String lang) {
    this.lang = lang;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Watcher watcher = (Watcher) o;
    return Objects.equals(this.email, watcher.email) &&
        Objects.equals(this.commonName, watcher.commonName) &&
        Objects.equals(this.vars, watcher.vars) &&
        Objects.equals(this.lang, watcher.lang);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, commonName, vars, lang);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Watcher {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    vars: ").append(toIndentedString(vars)).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
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

