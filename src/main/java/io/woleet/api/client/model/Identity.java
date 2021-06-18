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
 * Signer&#39;s identity provided as a set of X.500 attributes (see https://www.ietf.org/rfc/rfc4519.txt).
 */
@ApiModel(description = "Signer's identity provided as a set of X.500 attributes (see https://www.ietf.org/rfc/rfc4519.txt).")

public class Identity {
  public static final String SERIALIZED_NAME_COMMON_NAME = "commonName";
  @SerializedName(SERIALIZED_NAME_COMMON_NAME)
  private String commonName;

  public static final String SERIALIZED_NAME_ORGANIZATION = "organization";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION)
  private String organization;

  public static final String SERIALIZED_NAME_ORGANIZATIONAL_UNIT = "organizationalUnit";
  @SerializedName(SERIALIZED_NAME_ORGANIZATIONAL_UNIT)
  private String organizationalUnit;

  public static final String SERIALIZED_NAME_LOCALITY = "locality";
  @SerializedName(SERIALIZED_NAME_LOCALITY)
  private String locality;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;


  public Identity commonName(String commonName) {
    
    this.commonName = commonName;
    return this;
  }

   /**
   * commonName (CN) (2.5.4.3)
   * @return commonName
  **/
  @ApiModelProperty(example = "Jim Smith", required = true, value = "commonName (CN) (2.5.4.3)")

  public String getCommonName() {
    return commonName;
  }


  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  public Identity organization(String organization) {
    
    this.organization = organization;
    return this;
  }

   /**
   * organizationName (O) (2.5.4.10)
   * @return organization
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Woleet", value = "organizationName (O) (2.5.4.10)")

  public String getOrganization() {
    return organization;
  }


  public void setOrganization(String organization) {
    this.organization = organization;
  }


  public Identity organizationalUnit(String organizationalUnit) {
    
    this.organizationalUnit = organizationalUnit;
    return this;
  }

   /**
   * organizationalUnitName (OU) (2.5.4.11)
   * @return organizationalUnit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sales", value = "organizationalUnitName (OU) (2.5.4.11)")

  public String getOrganizationalUnit() {
    return organizationalUnit;
  }


  public void setOrganizationalUnit(String organizationalUnit) {
    this.organizationalUnit = organizationalUnit;
  }


  public Identity locality(String locality) {
    
    this.locality = locality;
    return this;
  }

   /**
   * localityName (L) (2.5.4.7)
   * @return locality
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Rennes", value = "localityName (L) (2.5.4.7)")

  public String getLocality() {
    return locality;
  }


  public void setLocality(String locality) {
    this.locality = locality;
  }


  public Identity country(String country) {
    
    this.country = country;
    return this;
  }

   /**
   * countryName (C) (2.5.4.6)
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FR", value = "countryName (C) (2.5.4.6)")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return Objects.equals(this.commonName, identity.commonName) &&
        Objects.equals(this.organization, identity.organization) &&
        Objects.equals(this.organizationalUnit, identity.organizationalUnit) &&
        Objects.equals(this.locality, identity.locality) &&
        Objects.equals(this.country, identity.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonName, organization, organizationalUnit, locality, country);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identity {\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    organizationalUnit: ").append(toIndentedString(organizationalUnit)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

