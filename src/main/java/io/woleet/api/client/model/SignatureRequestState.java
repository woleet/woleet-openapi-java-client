/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.11.1
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.api.client.model;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * State of the signature request.&lt;br&gt; If not set, the signature request is **stateless** and can be updated at any time (eg. to add new signers on the fly).&lt;br&gt; If set to DRAFT at creation time, the signature request is **stateful** and its state can be transitioned using the &#x60;/signatureRequest/{requestId}/transition&#x60; endpoint.&lt;br&gt; Available states:&lt;br&gt; - DRAFT: the signature request is being edited (only DRAFT signature requests can be updated)&lt;br&gt; - PENDING: the signature request is awaiting for its activation date to be reached&lt;br&gt; - IN_PROGRESS: the signature request emails have been sent to the signers (if applicable) and the signatures are being collected&lt;br&gt; - COMPLETED: all signatures have been collected&lt;br&gt; - CLOSED: the signature request has been closed by the owner before all signatures could be collected&lt;br&gt; - CANCELED: the signature request has been canceled by the owner before all signatures could be collected&lt;br&gt; - EXPIRED: the deadline of the signature request has been reached before all signatures could be collected 
 */
@JsonAdapter(SignatureRequestState.Adapter.class)
public enum SignatureRequestState {
  
  DRAFT("DRAFT"),
  
  PENDING("PENDING"),
  
  IN_PROGRESS("IN_PROGRESS"),
  
  COMPLETED("COMPLETED"),
  
  CLOSED("CLOSED"),
  
  CANCELED("CANCELED"),
  
  EXPIRED("EXPIRED");

  private String value;

  SignatureRequestState(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static SignatureRequestState fromValue(String value) {
    for (SignatureRequestState b : SignatureRequestState.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<SignatureRequestState> {
    @Override
    public void write(final JsonWriter jsonWriter, final SignatureRequestState enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public SignatureRequestState read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return SignatureRequestState.fromValue(value);
    }
  }
}

