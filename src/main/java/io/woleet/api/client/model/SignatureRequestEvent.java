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
 * SignatureRequestEvent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SignatureRequestEvent {
  public static final String SERIALIZED_NAME_SIGNEE_ID = "signeeId";
  @SerializedName(SERIALIZED_NAME_SIGNEE_ID)
  private String signeeId;

  /**
   * Type of the event to report: - DATA_VERIFIED: the signer verified the integrity (ie. hash) of the data to sign - DATA_REVIEWED: the signer reviewed and acceted the data to sign - TCU_ACCEPTED: the signer reviewed and accepted the TCU - TCU_REFUSED: the signer refused the TCU - SIGN_ACCEPTED: the signer accepted to sign the data - SIGN_REFUSED: the signer refused to sign the data 
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    DATA_VERIFIED("DATA_VERIFIED"),
    
    DATA_REVIEWED("DATA_REVIEWED"),
    
    TCU_ACCEPTED("TCU_ACCEPTED"),
    
    TCU_REFUSED("TCU_REFUSED"),
    
    SIGN_ACCEPTED("SIGN_ACCEPTED"),
    
    SIGN_REFUSED("SIGN_REFUSED");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_COMMENT = "comment";
  @SerializedName(SERIALIZED_NAME_COMMENT)
  private String comment;


  public SignatureRequestEvent signeeId(String signeeId) {
    
    this.signeeId = signeeId;
    return this;
  }

   /**
   * Secret identifier of the signer (provided by email).
   * @return signeeId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "abcdef01-2345-6789-abcd-ef0123456789", required = true, value = "Secret identifier of the signer (provided by email).")

  public String getSigneeId() {
    return signeeId;
  }


  public void setSigneeId(String signeeId) {
    this.signeeId = signeeId;
  }


  public SignatureRequestEvent type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Type of the event to report: - DATA_VERIFIED: the signer verified the integrity (ie. hash) of the data to sign - DATA_REVIEWED: the signer reviewed and acceted the data to sign - TCU_ACCEPTED: the signer reviewed and accepted the TCU - TCU_REFUSED: the signer refused the TCU - SIGN_ACCEPTED: the signer accepted to sign the data - SIGN_REFUSED: the signer refused to sign the data 
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Type of the event to report: - DATA_VERIFIED: the signer verified the integrity (ie. hash) of the data to sign - DATA_REVIEWED: the signer reviewed and acceted the data to sign - TCU_ACCEPTED: the signer reviewed and accepted the TCU - TCU_REFUSED: the signer refused the TCU - SIGN_ACCEPTED: the signer accepted to sign the data - SIGN_REFUSED: the signer refused to sign the data ")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public SignatureRequestEvent comment(String comment) {
    
    this.comment = comment;
    return this;
  }

   /**
   * Comment related to the event to report.
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Event comment", value = "Comment related to the event to report.")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignatureRequestEvent signatureRequestEvent = (SignatureRequestEvent) o;
    return Objects.equals(this.signeeId, signatureRequestEvent.signeeId) &&
        Objects.equals(this.type, signatureRequestEvent.type) &&
        Objects.equals(this.comment, signatureRequestEvent.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signeeId, type, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureRequestEvent {\n");
    sb.append("    signeeId: ").append(toIndentedString(signeeId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

