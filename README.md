# woleet-api-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.woleet</groupId>
    <artifactId>woleet-api-client</artifactId>
    <version>1.0.1</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.woleet:woleet-api-client:1.0.1"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/woleet-api-client-1.0.1.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.woleet.api.*;
import io.woleet.api.auth.*;
import io.woleet.api.client.model.*;
import io.woleet.api.client.AnchorApi;

import java.io.File;
import java.util.*;

public class AnchorApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        // Configure API key authorization: JWTAuth
        ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
        JWTAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //JWTAuth.setApiKeyPrefix("Token");

        AnchorApi apiInstance = new AnchorApi();
        Anchor anchor = new Anchor(); // Anchor | Anchor object to create.
        try {
            Anchor result = apiInstance.createAnchor(anchor);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AnchorApi#createAnchor");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.woleet.io/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AnchorApi* | [**createAnchor**](docs/AnchorApi.md#createAnchor) | **POST** /anchor | Create a new anchor.
*AnchorApi* | [**deleteAnchor**](docs/AnchorApi.md#deleteAnchor) | **DELETE** /anchor/{anchorid} | Delete an anchor.
*AnchorApi* | [**getAnchor**](docs/AnchorApi.md#getAnchor) | **GET** /anchor/{anchorid} | Get an anchor by its identifier.
*AnchorApi* | [**searchAnchorIds**](docs/AnchorApi.md#searchAnchorIds) | **GET** /anchorids | Search for public anchors&#39; identifiers.
*AnchorApi* | [**searchAnchors**](docs/AnchorApi.md#searchAnchors) | **GET** /anchors | Search for anchors.
*AnchorApi* | [**updateAnchor**](docs/AnchorApi.md#updateAnchor) | **PUT** /anchor/{anchorid} | Update an anchor.
*ReceiptApi* | [**getReceipt**](docs/ReceiptApi.md#getReceipt) | **GET** /receipt/{anchorid} | Get the proof receipt of an anchor.
*ReceiptApi* | [**verifyReceipt**](docs/ReceiptApi.md#verifyReceipt) | **POST** /receipt/verify | Verify a proof receipt.
*SignatureRequestApi* | [**createSignatureRequest**](docs/SignatureRequestApi.md#createSignatureRequest) | **POST** /signatureRequest | Create a new signature request.
*SignatureRequestApi* | [**deleteSignatureRequest**](docs/SignatureRequestApi.md#deleteSignatureRequest) | **DELETE** /signatureRequest/{requestId} | Delete a signature request.
*SignatureRequestApi* | [**getSignatureRequest**](docs/SignatureRequestApi.md#getSignatureRequest) | **GET** /signatureRequest/{requestId} | Get a signature request by its identifier.
*SignatureRequestApi* | [**searchSignatureRequests**](docs/SignatureRequestApi.md#searchSignatureRequests) | **GET** /signatureRequests | Search for signature requests.
*SignatureRequestApi* | [**signSignatureRequest**](docs/SignatureRequestApi.md#signSignatureRequest) | **POST** /signatureRequest/{requestId}/sign | Sign a signature request.
*SignatureRequestApi* | [**updateSignatureRequest**](docs/SignatureRequestApi.md#updateSignatureRequest) | **PUT** /signatureRequest/{requestId} | Update a signature request.
*TokenApi* | [**generateToken**](docs/TokenApi.md#generateToken) | **GET** /token | Generate a JWT token.
*TokenApi* | [**revokeToken**](docs/TokenApi.md#revokeToken) | **DELETE** /token | Revoke a JWT token.
*UserApi* | [**getCredits**](docs/UserApi.md#getCredits) | **GET** /user/credits | Get remaining anchoring credits.


## Documentation for Models

 - [Anchor](docs/Anchor.md)
 - [AnchorIds](docs/AnchorIds.md)
 - [Anchors](docs/Anchors.md)
 - [AuthorizedSignee](docs/AuthorizedSignee.md)
 - [Credits](docs/Credits.md)
 - [IdentityVerificationStatus](docs/IdentityVerificationStatus.md)
 - [Receipt](docs/Receipt.md)
 - [ReceiptAnchorsNode](docs/ReceiptAnchorsNode.md)
 - [ReceiptHeader](docs/ReceiptHeader.md)
 - [ReceiptProofNode](docs/ReceiptProofNode.md)
 - [ReceiptSignature](docs/ReceiptSignature.md)
 - [ReceiptTarget](docs/ReceiptTarget.md)
 - [ReceiptTargetProofNode](docs/ReceiptTargetProofNode.md)
 - [ReceiptVerificationStatus](docs/ReceiptVerificationStatus.md)
 - [SignatureRequest](docs/SignatureRequest.md)
 - [SignatureRequestSign](docs/SignatureRequestSign.md)
 - [SignatureRequestSignResult](docs/SignatureRequestSignResult.md)
 - [SignatureRequests](docs/SignatureRequests.md)
 - [Token](docs/Token.md)
 - [X500Name](docs/X500Name.md)
 - [X509SubjectIssuer](docs/X509SubjectIssuer.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BasicAuth

- **Type**: HTTP basic authentication

### JWTAuth

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

contact@woleet.com

