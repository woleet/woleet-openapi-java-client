/*
 * Woleet API
 * # Basics  The Woleet API is an **HTTP REST API**. It supports **CORS** and provides **Basic authentication** and **JWT authentication**, allowing an easy and secure interaction with both web clients and backend applications.   The Woleet API is specified following the [Swagger/OpenAPI](https://openapis.org/) standard. You can get the specification file at https://api.woleet.io/swagger.yaml) and, from it, **generate client code for most languages using the [Swagger Editor](http://editor.swagger.io/?import=https://api.woleet.io/v1/swagger.json) or [Swagger Codegen](http://swagger.io/swagger-codegen/)**.   Ready to use versions of the client code are provided as open source code for [JavaScript/NodeJS](https://github.com/woleet/woleet-openapi-js-client) and [Java](https://github.com/woleet/woleet-openapi-java-client).   The API base URL is **https://api.woleet.io/v1**.  # Authentication  The Woleet API provides **[Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)** over HTTPS: use your email and password to authenticate.   The Woleet API also provides **[JWT authentication](https://jwt.io/)**: generate a JWT token by doing a `GET` call on the `/token` endpoint (using Basic authentication) and then provide this token to subsequent API calls in the `Authorization` header using the `Bearer` scheme.  # Purpose  The Woleet API provides an easy and cheap way to create **timestamped proofs of existence** and **timestamped proofs of signature** for your data (which can be of any type). Proofs created are **stored in the Bitcoin blockchain** and so are independent from Woleet (an access to the Bitcoin blockchain and some client side open source code is enough to verify proofs). Using the Woleet API, you can create durable and unfalsifiable cryptographic proofs usable to prove your data existed in a given state at a given date, and optionally was signed by a given signee.   The Woleet API creates **proofs of existence** conform to the open source standard [Chainpoint](https://www.chainpoint.org/). Consequently, they can be verified using any tool compatible with this standard, without any interaction with Woleet, and so remain **verifiable forever** even if Woleet stops its operations.   The Woleet API creates **proofs of signature** that are an extension of the same standard proposed by Woleet (we are actively involved in the standardization process). Thus, the existence and timestamp of a signature is verifiable using the same tools used to verify proofs of existence. When it comes to verifying the validity of the signature and the signee's identity, some additional processing is performed: since this processing can be fully performed client side with no additional data, proofs of signature remain **verifiable forever** even if Woleet stops its operations.  # Creating proofs  To create a **proof of existence** for a file, you need to create what we call an **'anchor'**. An anchor is basically a proof of existence creation request. To do so, you only need to compute the SHA256 hash of the file client side and choose a name for the anchor. Since the platform doesn't need the actual file, there is no limitation on the size or on the type of the file, and the file is not even leaked to Woleet.   To create a **proof of signature** for a file, you also need to create an anchor, and so to compute the SHA256 hash of the file and choose a name for the anchor, but some additional data is required: your public key (the one associated with the private key used to sign the SHA256 hash of the file) and your signature itself. Optionally, you can provide a URL allowing to verify your identity by ensuring you own the public key and the TLS certificate of the URL.   Newly created **anchors are automatically collected** by the platform and **recorded in the Bitcoin blockchain**: this can take from 10 mn to a few hours, depending on the load the the Bitcoin network and the level of priority of your user account. To check the state of your anchors, you can pull them using the Woleet API, or you can associate a URL to an anchor that the platform will call whenever the anchor status changes.   Once an anchor is recorded in the Bitcoin blockchain, you can retrieve its associated **proof receipt** using the Woleet API. Proof receipts **conform to the [Chainpoint 1 or 2](https://www.chainpoint.org/) proof receipt format** (with some Woleet extensions when it comes to proofs of signature). The proof receipt is the only piece of data required to prove the existence/signature of a file at a given date (obviously the file itself is also required, since it is not included in the proof receipt). Thus, it is highly recommended you keep your proof receipts (and your files) in your own data store, so that you don't depend on the Woleet API to generate the proof receipt on-demand whenever you want to verify a file.  # Verifying proofs  Verifying a **proof of existence** using the Woleet API is straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, so you just need to check that the SHA256 hash of the file matches the proof receipt's `hash` property.   Verifying a **proof of signature** using the Woleet API is also straightforward: the API takes care of verifying that the proof receipt is valid and correctly anchored in a Bitcoin transaction, then verifies the signature, and optionally verifies that the signee owns the public key and the TLS certificate, so you just need to check that the SHA256 hash of the file matches the proof receipt's `signedHash` property.   The Woleet API can also be used to verify any Chainpoint 1 or 2 proof receipt, including those created by other providers.   Woleet also provides an open source [JavaScript library for web clients](https://github.com/woleet/woleet-weblibs) implementing the full verification process without the help of the Woleet API.  # About public and private anchors  An anchor can be public (which is the default) or private.   A **private anchor** is only discoverable by its owner (see the `/anchors` endpoint). Thus, the owner needs to provide the proof receipt *and* the data to anyone wanting to verify the proof.   A **public anchor** is discoverable by anyone knowing the hash of the data (including people with no Woleet account, see the `/anchorids` endpoint). This allows anyone to retrieve the proof receipt using only the data hash as input, and then to verify it using the Woleet API or any other mean:  - use the `/anchorids` endpoint to retrieve the anchor identifier by its hash  - use the `/receipt/{anchorid}` endpoint to retrieve the proof receipt.  - use the `/receipt/verify` endpoint (or any other Chainpoint compatible tool) to verify the proof receipt and get the data or signature timestamp.  # About the verification process  For your understanding, here is a formal description of the verification process of a **proof of existence**:  - compute the SHA256 hash of the file  - check that the `targetHash` property of the proof receipt matches the hash of the file  - check that the `proof` property of the proof receipt is a valid Merkle proof (see the [Chainpoint](https://www.chainpoint.org/) standard for this step)  - retrieve the Bitcoin transaction from the `anchors` property of the proof receipt  - check that the `OP_RETURN` field of the Bitcoin transaction matches the `merkleRoot` property of the proof receipt   For **proof of signature**, an additional verification process is performed:  - check that the SHA256 hash of the `signature` property matches its `targetHash` property  - check that the `signature` property is a valid signature of the `signedHash` property for the public key stored in the `pubKey` property  - additionally, if an `identityURL` property is available:   - call `identityURL` to make the callee sign some random data using the public key `pubKey`    - check that the returned signature is valid    - get the TLS certificates of the URL (it must be an HTTPS URL) to get insight about the signee's identity  # Using domains  If you want to use the Woleet API for a given domain (eg. the \"acme\" domain, that would be accessible at **https://`acme`.woleet.io/_**) you still have to use the base URL **https://api.woleet.io/v1**, but you need to specify the domain to use by adding a `Domain` header to your calls. Obviously, you need to authenticate using the credentials of one of the domain's users. 
 *
 * OpenAPI spec version: 1.5.0
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.woleet.api.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User
 */

public class User {
  @SerializedName("id")
  private String id = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("password")
  private String password = null;

  /**
   * Gets or Sets roles
   */
  @JsonAdapter(RolesEnum.Adapter.class)
  public enum RolesEnum {
    USER("ROLE_USER"),
    
    DOMAIN_ADMIN("ROLE_DOMAIN_ADMIN");

    private String value;

    RolesEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RolesEnum fromValue(String text) {
      for (RolesEnum b : RolesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RolesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RolesEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RolesEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RolesEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("roles")
  private List<RolesEnum> roles = new ArrayList<RolesEnum>();

  @SerializedName("info")
  private Map<String, Object> info = new HashMap<String, Object>();

  /**
   * The status of the user:&lt;br&gt; - PENDING: the user email need to be validated&lt;br&gt; - APPROVED: the user can loging&lt;br&gt; - DISABLED: the user cannot login 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("PENDING"),
    
    APPROVED("APPROVED"),
    
    DISABLED("DISABLED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = StatusEnum.PENDING;

  @SerializedName("created")
  private Long created = null;

  @SerializedName("lastModified")
  private Long lastModified = null;

   /**
   * User identifier. It is allocated by the platform, and so must not be provided at creation time. 
   * @return id
  **/
  @ApiModelProperty(value = "User identifier. It is allocated by the platform, and so must not be provided at creation time. ")
  public String getId() {
    return id;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email of the user. 
   * @return email
  **/
  @ApiModelProperty(required = true, value = "Email of the user. ")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password of the user (it must be provided at creation time). 
   * @return password
  **/
  @ApiModelProperty(required = true, value = "Password of the user (it must be provided at creation time). ")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User roles(List<RolesEnum> roles) {
    this.roles = roles;
    return this;
  }

  public User addRolesItem(RolesEnum rolesItem) {
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * The roles of the user:&lt;br&gt; - ROLE_USER: regular user&lt;br&gt; - ROLE_DOMAIN_ADMIN: domain administrator. 
   * @return roles
  **/
  @ApiModelProperty(required = true, value = "The roles of the user:<br> - ROLE_USER: regular user<br> - ROLE_DOMAIN_ADMIN: domain administrator. ")
  public List<RolesEnum> getRoles() {
    return roles;
  }

  public void setRoles(List<RolesEnum> roles) {
    this.roles = roles;
  }

  public User info(Map<String, Object> info) {
    this.info = info;
    return this;
  }

  public User putInfoItem(String key, Object infoItem) {
    this.info.put(key, infoItem);
    return this;
  }

   /**
   * Object storing meta data about the user. Some property names are reserved, but properties are not limitted to the one listed here. 
   * @return info
  **/
  @ApiModelProperty(required = true, value = "Object storing meta data about the user. Some property names are reserved, but properties are not limitted to the one listed here. ")
  public Map<String, Object> getInfo() {
    return info;
  }

  public void setInfo(Map<String, Object> info) {
    this.info = info;
  }

  public User status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the user:&lt;br&gt; - PENDING: the user email need to be validated&lt;br&gt; - APPROVED: the user can loging&lt;br&gt; - DISABLED: the user cannot login 
   * @return status
  **/
  @ApiModelProperty(required = true, value = "The status of the user:<br> - PENDING: the user email need to be validated<br> - APPROVED: the user can loging<br> - DISABLED: the user cannot login ")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

   /**
   * Date of creation (in ms since Unix epoch). 
   * @return created
  **/
  @ApiModelProperty(value = "Date of creation (in ms since Unix epoch). ")
  public Long getCreated() {
    return created;
  }

   /**
   * Date of last modification (in ms since Unix epoch). 
   * @return lastModified
  **/
  @ApiModelProperty(value = "Date of last modification (in ms since Unix epoch). ")
  public Long getLastModified() {
    return lastModified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.roles, user.roles) &&
        Objects.equals(this.info, user.info) &&
        Objects.equals(this.status, user.status) &&
        Objects.equals(this.created, user.created) &&
        Objects.equals(this.lastModified, user.lastModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password, roles, info, status, created, lastModified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
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

