/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.6.2
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
 * AuthorizedSignee
 */

public class AuthorizedSignee {
  public static final String SERIALIZED_NAME_PUB_KEY = "pubKey";
  @SerializedName(SERIALIZED_NAME_PUB_KEY)
  private String pubKey;

  /**
   * The type of device the authorized signee should use to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent - MOBILE: Woleet.ID Mobile or equivalent - NANO: Ledger Nano S or equivalent If set, the signature web application could only offer the corresponding signature mode. 
   */
  @JsonAdapter(DeviceEnum.Adapter.class)
  public enum DeviceEnum {
    SERVER("SERVER"),
    
    MOBILE("MOBILE"),
    
    NANO("NANO");

    private String value;

    DeviceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DeviceEnum fromValue(String value) {
      for (DeviceEnum b : DeviceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DeviceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DeviceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DeviceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DeviceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DEVICE = "device";
  @SerializedName(SERIALIZED_NAME_DEVICE)
  private DeviceEnum device;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_COUNTRY_CALLING_CODE = "countryCallingCode";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CALLING_CODE)
  private String countryCallingCode;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;

  public static final String SERIALIZED_NAME_REQUIRES_O_T_P = "requiresOTP";
  @SerializedName(SERIALIZED_NAME_REQUIRES_O_T_P)
  private Boolean requiresOTP;

  public static final String SERIALIZED_NAME_COMMON_NAME = "commonName";
  @SerializedName(SERIALIZED_NAME_COMMON_NAME)
  private String commonName;

  public static final String SERIALIZED_NAME_IDENTITY_U_R_L = "identityURL";
  @SerializedName(SERIALIZED_NAME_IDENTITY_U_R_L)
  private String identityURL;

  public static final String SERIALIZED_NAME_ANCHOR_ID = "anchorId";
  @SerializedName(SERIALIZED_NAME_ANCHOR_ID)
  private String anchorId;


  public AuthorizedSignee pubKey(String pubKey) {
    
    this.pubKey = pubKey;
    return this;
  }

   /**
   * The public key the authorized signee must use to sign.&lt;br&gt; **Currently only Bitcoin addresses are supported.**&lt;br&gt; If not set, the authorized signee can sign using any key. 
   * @return pubKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The public key the authorized signee must use to sign.<br> **Currently only Bitcoin addresses are supported.**<br> If not set, the authorized signee can sign using any key. ")

  public String getPubKey() {
    return pubKey;
  }


  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }


  public AuthorizedSignee device(DeviceEnum device) {
    
    this.device = device;
    return this;
  }

   /**
   * The type of device the authorized signee should use to sign:&lt;br&gt; - SERVER: Woleet.ID Server or equivalent - MOBILE: Woleet.ID Mobile or equivalent - NANO: Ledger Nano S or equivalent If set, the signature web application could only offer the corresponding signature mode. 
   * @return device
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of device the authorized signee should use to sign:<br> - SERVER: Woleet.ID Server or equivalent - MOBILE: Woleet.ID Mobile or equivalent - NANO: Ledger Nano S or equivalent If set, the signature web application could only offer the corresponding signature mode. ")

  public DeviceEnum getDevice() {
    return device;
  }


  public void setDevice(DeviceEnum device) {
    this.device = device;
  }


  public AuthorizedSignee email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email of the authorized signee.&lt;br&gt; If set, an email is sent by the platform to the authorized signee, and &#x60;commonName&#x60; must also be set.&lt;br&gt; If set, &#x60;pubKey&#x60; is not mandatory, to allow the authorized signee to sign using any key. 
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "john.doe@acme.com", value = "The email of the authorized signee.<br> If set, an email is sent by the platform to the authorized signee, and `commonName` must also be set.<br> If set, `pubKey` is not mandatory, to allow the authorized signee to sign using any key. ")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public AuthorizedSignee countryCallingCode(String countryCallingCode) {
    
    this.countryCallingCode = countryCallingCode;
    return this;
  }

   /**
   * The country calling code of the authorized signee. 
   * @return countryCallingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "33", value = "The country calling code of the authorized signee. ")

  public String getCountryCallingCode() {
    return countryCallingCode;
  }


  public void setCountryCallingCode(String countryCallingCode) {
    this.countryCallingCode = countryCallingCode;
  }


  public AuthorizedSignee phone(String phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * The phone of the authorized signee (not including the country calling code).&lt;br&gt; This phone must be able to receive an OTP by SMS. 
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0612345678", value = "The phone of the authorized signee (not including the country calling code).<br> This phone must be able to receive an OTP by SMS. ")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone;
  }


  public AuthorizedSignee requiresOTP(Boolean requiresOTP) {
    
    this.requiresOTP = requiresOTP;
    return this;
  }

   /**
   * &#x60;true&#x60; if the signee must provide an OTP to sign.&lt;br&gt; If &#x60;true&#x60;, &#x60;phone&#x60; must be set, since the OTP is sent by SMS. 
   * @return requiresOTP
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if the signee must provide an OTP to sign.<br> If `true`, `phone` must be set, since the OTP is sent by SMS. ")

  public Boolean getRequiresOTP() {
    return requiresOTP;
  }


  public void setRequiresOTP(Boolean requiresOTP) {
    this.requiresOTP = requiresOTP;
  }


  public AuthorizedSignee commonName(String commonName) {
    
    this.commonName = commonName;
    return this;
  }

   /**
   * The full name of the authorized signee. 
   * @return commonName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John Doe", value = "The full name of the authorized signee. ")

  public String getCommonName() {
    return commonName;
  }


  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  public AuthorizedSignee identityURL(String identityURL) {
    
    this.identityURL = identityURL;
    return this;
  }

   /**
   * Web hook to use to verify the signee&#39;s identity.&lt;br&gt; If set, it is used to verify signee&#39;s identity at signature registration time. 
   * @return identityURL
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Web hook to use to verify the signee's identity.<br> If set, it is used to verify signee's identity at signature registration time. ")

  public String getIdentityURL() {
    return identityURL;
  }


  public void setIdentityURL(String identityURL) {
    this.identityURL = identityURL;
  }


  public AuthorizedSignee anchorId(String anchorId) {
    
    this.anchorId = anchorId;
    return this;
  }

   /**
   * If the authorized signee has signed, identifier of the signature anchor created. 
   * @return anchorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If the authorized signee has signed, identifier of the signature anchor created. ")

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
    AuthorizedSignee authorizedSignee = (AuthorizedSignee) o;
    return Objects.equals(this.pubKey, authorizedSignee.pubKey) &&
        Objects.equals(this.device, authorizedSignee.device) &&
        Objects.equals(this.email, authorizedSignee.email) &&
        Objects.equals(this.countryCallingCode, authorizedSignee.countryCallingCode) &&
        Objects.equals(this.phone, authorizedSignee.phone) &&
        Objects.equals(this.requiresOTP, authorizedSignee.requiresOTP) &&
        Objects.equals(this.commonName, authorizedSignee.commonName) &&
        Objects.equals(this.identityURL, authorizedSignee.identityURL) &&
        Objects.equals(this.anchorId, authorizedSignee.anchorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pubKey, device, email, countryCallingCode, phone, requiresOTP, commonName, identityURL, anchorId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedSignee {\n");
    sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    countryCallingCode: ").append(toIndentedString(countryCallingCode)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    requiresOTP: ").append(toIndentedString(requiresOTP)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    identityURL: ").append(toIndentedString(identityURL)).append("\n");
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

