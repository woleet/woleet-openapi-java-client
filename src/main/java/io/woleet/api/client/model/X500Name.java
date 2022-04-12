/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.13.0
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
 * X500 Distinguished Name.
 */
@ApiModel(description = "X500 Distinguished Name.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class X500Name {
  public static final String SERIALIZED_NAME_C = "C";
  @SerializedName(SERIALIZED_NAME_C)
  private String C;

  public static final String SERIALIZED_NAME_S_T = "ST";
  @SerializedName(SERIALIZED_NAME_S_T)
  private String ST;

  public static final String SERIALIZED_NAME_L = "L";
  @SerializedName(SERIALIZED_NAME_L)
  private String L;

  public static final String SERIALIZED_NAME_O = "O";
  @SerializedName(SERIALIZED_NAME_O)
  private String O;

  public static final String SERIALIZED_NAME_O_U = "OU";
  @SerializedName(SERIALIZED_NAME_O_U)
  private String OU;

  public static final String SERIALIZED_NAME_C_N = "CN";
  @SerializedName(SERIALIZED_NAME_C_N)
  private String CN;

  public static final String SERIALIZED_NAME_E_M_A_I_L_A_D_D_R_E_S_S = "EMAILADDRESS";
  @SerializedName(SERIALIZED_NAME_E_M_A_I_L_A_D_D_R_E_S_S)
  private String EMAILADDRESS;


  public X500Name C(String C) {
    
    this.C = C;
    return this;
  }

   /**
   * Country code
   * @return C
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FR", value = "Country code")

  public String getC() {
    return C;
  }


  public void setC(String C) {
    this.C = C;
  }


  public X500Name ST(String ST) {
    
    this.ST = ST;
    return this;
  }

   /**
   * State or Province
   * @return ST
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Britanny", value = "State or Province")

  public String getST() {
    return ST;
  }


  public void setST(String ST) {
    this.ST = ST;
  }


  public X500Name L(String L) {
    
    this.L = L;
    return this;
  }

   /**
   * Locality
   * @return L
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Rennes", value = "Locality")

  public String getL() {
    return L;
  }


  public void setL(String L) {
    this.L = L;
  }


  public X500Name O(String O) {
    
    this.O = O;
    return this;
  }

   /**
   * Organization
   * @return O
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ACME Corp.", value = "Organization")

  public String getO() {
    return O;
  }


  public void setO(String O) {
    this.O = O;
  }


  public X500Name OU(String OU) {
    
    this.OU = OU;
    return this;
  }

   /**
   * Organizational Unit
   * @return OU
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sales Dept.", value = "Organizational Unit")

  public String getOU() {
    return OU;
  }


  public void setOU(String OU) {
    this.OU = OU;
  }


  public X500Name CN(String CN) {
    
    this.CN = CN;
    return this;
  }

   /**
   * Common Name
   * @return CN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "John Doe", value = "Common Name")

  public String getCN() {
    return CN;
  }


  public void setCN(String CN) {
    this.CN = CN;
  }


  public X500Name EMAILADDRESS(String EMAILADDRESS) {
    
    this.EMAILADDRESS = EMAILADDRESS;
    return this;
  }

   /**
   * Email address
   * @return EMAILADDRESS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "john.doe@acme.com", value = "Email address")

  public String getEMAILADDRESS() {
    return EMAILADDRESS;
  }


  public void setEMAILADDRESS(String EMAILADDRESS) {
    this.EMAILADDRESS = EMAILADDRESS;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    X500Name x500Name = (X500Name) o;
    return Objects.equals(this.C, x500Name.C) &&
        Objects.equals(this.ST, x500Name.ST) &&
        Objects.equals(this.L, x500Name.L) &&
        Objects.equals(this.O, x500Name.O) &&
        Objects.equals(this.OU, x500Name.OU) &&
        Objects.equals(this.CN, x500Name.CN) &&
        Objects.equals(this.EMAILADDRESS, x500Name.EMAILADDRESS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(C, ST, L, O, OU, CN, EMAILADDRESS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class X500Name {\n");
    sb.append("    C: ").append(toIndentedString(C)).append("\n");
    sb.append("    ST: ").append(toIndentedString(ST)).append("\n");
    sb.append("    L: ").append(toIndentedString(L)).append("\n");
    sb.append("    O: ").append(toIndentedString(O)).append("\n");
    sb.append("    OU: ").append(toIndentedString(OU)).append("\n");
    sb.append("    CN: ").append(toIndentedString(CN)).append("\n");
    sb.append("    EMAILADDRESS: ").append(toIndentedString(EMAILADDRESS)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

