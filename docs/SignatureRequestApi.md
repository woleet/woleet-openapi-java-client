# SignatureRequestApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSignatureRequest**](SignatureRequestApi.md#createSignatureRequest) | **POST** /signatureRequest | Create a new signature request.
[**delegateSignSignatureRequest**](SignatureRequestApi.md#delegateSignSignatureRequest) | **POST** /signatureRequest/{requestId}/delegate | Sign a signature request by delegating the signature.
[**deleteSignatureRequest**](SignatureRequestApi.md#deleteSignatureRequest) | **DELETE** /signatureRequest/{requestId} | Delete a signature request.
[**downloadSignatureRequestFile**](SignatureRequestApi.md#downloadSignatureRequestFile) | **GET** /signatureRequest/{requestId}/file | Download the file to sign.
[**getSignatureRequest**](SignatureRequestApi.md#getSignatureRequest) | **GET** /signatureRequest/{requestId} | Get a signature request by its identifier.
[**getSignatureRequestAttestation**](SignatureRequestApi.md#getSignatureRequestAttestation) | **GET** /signatureRequest/{requestId}/attestation | Download the Signature Attestation document of a signature request.
[**getSignatureRequestProofBundle**](SignatureRequestApi.md#getSignatureRequestProofBundle) | **GET** /signatureRequest/{requestId}/proofbundle | Get the proof bundle of a signature request.
[**reportSignatureRequestEvent**](SignatureRequestApi.md#reportSignatureRequestEvent) | **POST** /signatureRequest/{requestId}/event | Report an event on a signature request.
[**reportSignatureRequestFeedback**](SignatureRequestApi.md#reportSignatureRequestFeedback) | **POST** /signatureRequest/{requestId}/feedback | Report a feedback about a signature request.
[**searchSignatureRequestIds**](SignatureRequestApi.md#searchSignatureRequestIds) | **GET** /signatureRequestIds | Search for public signature request identifiers.
[**searchSignatureRequests**](SignatureRequestApi.md#searchSignatureRequests) | **GET** /signatureRequests | Search for signature requests.
[**sendSignatureRequestOTP**](SignatureRequestApi.md#sendSignatureRequestOTP) | **GET** /signatureRequest/{requestId}/otp/{signeeId} | Generate and send an OTP to a signer of a signature request.
[**sendSignatureRequestReminder**](SignatureRequestApi.md#sendSignatureRequestReminder) | **POST** /signatureRequest/{requestId}/remind | Send a reminder email to a set of signers of a signature request.
[**signSignatureRequest**](SignatureRequestApi.md#signSignatureRequest) | **POST** /signatureRequest/{requestId}/sign | Sign a signature request by registering a signature.
[**transitionSignatureRequest**](SignatureRequestApi.md#transitionSignatureRequest) | **POST** /signatureRequest/{requestId}/transition | Change the state of a signature request.
[**updateSignatureRequest**](SignatureRequestApi.md#updateSignatureRequest) | **PUT** /signatureRequest/{requestId} | Update a signature request.
[**uploadSignatureRequestFile**](SignatureRequestApi.md#uploadSignatureRequestFile) | **POST** /signatureRequest/{requestId}/file | Upload the file to sign.


<a name="createSignatureRequest"></a>
# **createSignatureRequest**
> SignatureRequest createSignatureRequest(signatureRequest)

Create a new signature request.

Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the file to sign.&lt;br&gt; Be sure to have at least 1 signature request credit and enough signature and anchoring credits on your account to fulfill the signature request (each registered signature costs you 1 signature and 1 anchoring credit).&lt;br&gt; 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    SignatureRequest signatureRequest = new SignatureRequest(); // SignatureRequest | SignatureRequest object to create.
    try {
      SignatureRequest result = apiInstance.createSignatureRequest(signatureRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#createSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **signatureRequest** | [**SignatureRequest**](SignatureRequest.md)| SignatureRequest object to create. |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created signature request. |  -  |
**400** | Invalid request. More details are returned in the responsebody as a JSON object. |  -  |

<a name="delegateSignSignatureRequest"></a>
# **delegateSignSignatureRequest**
> SignatureRequestSignResult delegateSignSignatureRequest(requestId, signatureRequestDelegate)

Sign a signature request by delegating the signature.

A signer can use this operation to sign a signature request by delegating the signature to the platform.&lt;br&gt; When using this signature mode, the signature key of the signer is controled by the platform, which acts as a trusted third party.&lt;br&gt; The signature is automatically anchored on behalf of the owner of the signature request.&lt;br&gt; The signature anchor created is added to the list of signature anchors of the signature request.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to delegate a signature (authentication of the signer rely on the knowledge of his secret identifier and OTP). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    SignatureRequestDelegate signatureRequestDelegate = new SignatureRequestDelegate(); // SignatureRequestDelegate | Authentication information about the signer.
    try {
      SignatureRequestSignResult result = apiInstance.delegateSignSignatureRequest(requestId, signatureRequestDelegate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#delegateSignSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **signatureRequestDelegate** | [**SignatureRequestDelegate**](SignatureRequestDelegate.md)| Authentication information about the signer. |

### Return type

[**SignatureRequestSignResult**](SignatureRequestSignResult.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Signature succesfully delegated. The signature anchor created is returned. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**401** | Unauthorized. The signer is not an authorized signer (secret signer identifier not found, or invalid OTP). |  -  |
**402** | Insufficient credits. The owner of the signature request runs out of signature or anchoring credit. |  -  |
**403** | Forbidden. The signature request is not in progress, the maximum number of signatures has been reached or the OTP has expired. |  -  |
**404** | Signature request not found. |  -  |
**409** | Conflict. The signer has already signed. |  -  |
**429** | Too many requests. A minimum delay of 1 second is required after providing an invalid OTP. |  -  |

<a name="deleteSignatureRequest"></a>
# **deleteSignatureRequest**
> deleteSignatureRequest(requestId)

Delete a signature request.

Use this operation to delete a signature request.&lt;br&gt; **WARNING: You should never delete a signature request, otherwise you will no longer be able to download its proof bundle or Signature Attestation document.&lt;br&gt; Use this for test purpose only.** 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request to delete.
    try {
      apiInstance.deleteSignatureRequest(requestId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#deleteSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request to delete. |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The signature request is deleted. |  -  |
**404** | No signature request matching the given identifier. |  -  |

<a name="downloadSignatureRequestFile"></a>
# **downloadSignatureRequestFile**
> File downloadSignatureRequestFile(requestId, amended)

Download the file to sign.

Use this operation to download the file to be signed for a signature request.&lt;br&gt; If the signature request is CLOSED or COMPLETED and the signed file is a PDF document that was uploaded to Woleet, this operation can also be used to download the amended document: this document is basically the signed file concatenated with the Signature Attestation document. The amended document contains the proof bundle as attachement, and is certified by Woleet.&lt;br&gt; The name of the file is included in the &#x60;Content-Disposition&#x60; header (see https://www.ietf.org/rfc/rfc6266.txt).&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to download the file to be signed for a signature request (but its identifier needs to be known). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    Boolean amended = false; // Boolean | `true` if the amended version of the document is to be returned. 
    try {
      File result = apiInstance.downloadSignatureRequestFile(requestId, amended);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#downloadSignatureRequestFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **amended** | **Boolean**| &#x60;true&#x60; if the amended version of the document is to be returned.  | [optional] [default to false]

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The file to sign. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**404** | Signature request not found. |  -  |

<a name="getSignatureRequest"></a>
# **getSignatureRequest**
> SignatureRequest getSignatureRequest(requestId, signeeId)

Get a signature request by its identifier.

Use this operation to retrieve a signature request by its identifier.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve a signature request (but its identifier needs to be known).&lt;br&gt; Nevertheless, if the caller is authenticated as the owner of the signature request, additional information is returned. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request to retrieve.
    String signeeId = "signeeId_example"; // String | Secret identifier of the signer wanting to retrieve the signature request.<br> If set, information related to this signer is guaranteed to be returned in `authorizedSignees[0]`.<br> **This secret identifier is generated by the platform and provided by email to the signer only. It allows the platform to authenticate the signer and verify his email address.** 
    try {
      SignatureRequest result = apiInstance.getSignatureRequest(requestId, signeeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#getSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request to retrieve. |
 **signeeId** | **String**| Secret identifier of the signer wanting to retrieve the signature request.&lt;br&gt; If set, information related to this signer is guaranteed to be returned in &#x60;authorizedSignees[0]&#x60;.&lt;br&gt; **This secret identifier is generated by the platform and provided by email to the signer only. It allows the platform to authenticate the signer and verify his email address.**  | [optional]

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The signature request. |  -  |
**404** | No signature request matching the given identifier. |  -  |

<a name="getSignatureRequestAttestation"></a>
# **getSignatureRequestAttestation**
> File getSignatureRequestAttestation(requestId)

Download the Signature Attestation document of a signature request.

Use this operation to retrieve the Signature Attestation document of a signature request.&lt;br&gt; This PDF file summarizes the signature request and includes the proof bundle as an attachement.&lt;br&gt; The proof bundle is a JSON file containing all the pieces of evidence: - the audit trail - the proof receipt of the signature of the audit trail by the platform - the proof receipts of the signature of the file by the signers  Consequently, the signature attestation is only available once all the following conditions are met: - the signature request is COMPLETED (by the platform) or CLOSED (by the requester) - all the proof receipts are available (ie. all signatures have been anchored) - the audit trail is generated and signed by the platform and its proof receipt is available (ie. its signature has been anchored)  Once these conditions are met, the platform sets the &#x60;proofBundleComplete&#x60; property to &#x60;true&#x60;.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve the signature attestation of a signature request (but its identifier needs to be known). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    try {
      File result = apiInstance.getSignatureRequestAttestation(requestId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#getSignatureRequestAttestation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The Signature Attestation document. |  -  |
**400** | Signature Attestation document not yet available. |  -  |
**404** | Signature request not found. |  -  |

<a name="getSignatureRequestProofBundle"></a>
# **getSignatureRequestProofBundle**
> SignatureRequestProofBundle getSignatureRequestProofBundle(requestId)

Get the proof bundle of a signature request.

Use this operation to retrieve the proof bundle of a signature request.&lt;br&gt; The proof bundle is a JSON file containing all the pieces of evidence: - the audit trail - the proof receipt of the signature of the audit trail by the platform - the proof receipts of the signature of the file by the signers  Consequently, the proof bundle is only available once all the following conditions are met: - the signature request is COMPLETED (by the platform) or CLOSED (by the requester) - all the proof receipts are available (ie. all signatures have been anchored) - the audit trail is generated and signed by the platform and its proof receipt is available (ie. its signature has been anchored)  Once these conditions are met, the platform sets the &#x60;proofBundleComplete&#x60; property to &#x60;true&#x60;.&lt;br&gt; If this endpoint is called before all these conditions are met, it returns only the available proof receipts (with a 202 status).&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve the proof bundle of a signature request (but its identifier needs to be known). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    try {
      SignatureRequestProofBundle result = apiInstance.getSignatureRequestProofBundle(requestId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#getSignatureRequestProofBundle");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |

### Return type

[**SignatureRequestProofBundle**](SignatureRequestProofBundle.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The proof bundle of the signature request. |  -  |
**202** | A partial proof bundle of the signature request (some signature are missing or not all receipts are yet available). |  -  |
**404** | Signature request not found. |  -  |

<a name="reportSignatureRequestEvent"></a>
# **reportSignatureRequestEvent**
> reportSignatureRequestEvent(requestId, signatureRequestEvent)

Report an event on a signature request.

A signer can use this operation to report an event on a signature request.&lt;br&gt; Events reported are included in the audit trail of the signature request.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to report an event (authentication of the signer rely on the knowledge of his secret identifier). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    SignatureRequestEvent signatureRequestEvent = new SignatureRequestEvent(); // SignatureRequestEvent | Event to report.
    try {
      apiInstance.reportSignatureRequestEvent(requestId, signatureRequestEvent);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#reportSignatureRequestEvent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **signatureRequestEvent** | [**SignatureRequestEvent**](SignatureRequestEvent.md)| Event to report. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Event succesfully reported. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**401** | Unauthorized. The signer is not an authorized signer (secret signer identifier not found). |  -  |
**404** | Signature request not found. |  -  |

<a name="reportSignatureRequestFeedback"></a>
# **reportSignatureRequestFeedback**
> reportSignatureRequestFeedback(requestId, signatureRequestFeedback)

Report a feedback about a signature request.

A signer can use this operation to report a feedback to the owner of a signature request.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to report a feedback (authentication of the signer rely on the knowledge of his secret identifier). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    SignatureRequestFeedback signatureRequestFeedback = new SignatureRequestFeedback(); // SignatureRequestFeedback | Feedback to report.
    try {
      apiInstance.reportSignatureRequestFeedback(requestId, signatureRequestFeedback);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#reportSignatureRequestFeedback");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **signatureRequestFeedback** | [**SignatureRequestFeedback**](SignatureRequestFeedback.md)| Feedback to report. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Feedback succesfully reported. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**401** | Unauthorized. The signer is not an authorized signer (secret signer identifier not found). |  -  |
**404** | Signature request not found. |  -  |

<a name="searchSignatureRequestIds"></a>
# **searchSignatureRequestIds**
> SignatureRequestIds searchSignatureRequestIds(hashToSign, page, size, userId)

Search for public signature request identifiers.

Use this operation to retrieve the identifiers of all public signature requests having a given &#x60;hashToSign&#x60; property.&lt;br&gt; Only public signature request identifiers are returned.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve public signature request identifiers.&lt;br&gt; Paging is supported. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String hashToSign = "hashToSign_example"; // String | `hashToSign` to search for: all public signature requests whose `hashToSign` property is equal are returned. 
    Integer page = 0; // Integer | Index of the page to retrieve (from 0).
    Integer size = 20; // Integer | Number of signature request identifiers per page.
    String userId = "userId_example"; // String | User identifier to use to filter out results: only public signature requests belonging to this user are returned. 
    try {
      SignatureRequestIds result = apiInstance.searchSignatureRequestIds(hashToSign, page, size, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#searchSignatureRequestIds");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashToSign** | **String**| &#x60;hashToSign&#x60; to search for: all public signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  |
 **page** | **Integer**| Index of the page to retrieve (from 0). | [optional] [default to 0]
 **size** | **Integer**| Number of signature request identifiers per page. | [optional] [default to 20]
 **userId** | **String**| User identifier to use to filter out results: only public signature requests belonging to this user are returned.  | [optional]

### Return type

[**SignatureRequestIds**](SignatureRequestIds.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array (possibly empty) of the identifiers of all public signature requests matching all search criteria, plus additional paging information. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |

<a name="searchSignatureRequests"></a>
# **searchSignatureRequests**
> SignatureRequests searchSignatureRequests(page, size, direction, sort, name, hashToSign, states)

Search for signature requests.

Use this operation to retrieve all signature requests having a given &#x60;name&#x60; and/or &#x60;hashToSign&#x60; property.&lt;br&gt; Only requests belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    Integer page = 0; // Integer | Index of the page to retrieve (from 0).
    Integer size = 20; // Integer | Number of anchors per page.
    String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
    String sort = "created"; // String | Sorting property: possible values are limited to `created` and `hashToSign`. 
    String name = "name_example"; // String | `name` to search for: all signature requests whose `name` property contains this sub-string are returned.<br> **WARNING: Searching by name can timeout on a large signature request set.** 
    String hashToSign = "hashToSign_example"; // String | `hashToSign` to search for: all signature requests whose `hashToSign` property is equal are returned. 
    List<String> states = Arrays.asList(); // List<String> | States to search for: all signature requests whose `state` property is part of theses states are returned. 
    try {
      SignatureRequests result = apiInstance.searchSignatureRequests(page, size, direction, sort, name, hashToSign, states);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#searchSignatureRequests");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Index of the page to retrieve (from 0). | [optional] [default to 0]
 **size** | **Integer**| Number of anchors per page. | [optional] [default to 20]
 **direction** | **String**| Sorting direction: ASC for ascending DESC for descending.  | [optional] [default to ASC] [enum: ASC, DESC]
 **sort** | **String**| Sorting property: possible values are limited to &#x60;created&#x60; and &#x60;hashToSign&#x60;.  | [optional] [default to created] [enum: created, hashToSign]
 **name** | **String**| &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: Searching by name can timeout on a large signature request set.**  | [optional]
 **hashToSign** | **String**| &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  | [optional]
 **states** | [**List&lt;String&gt;**](String.md)| States to search for: all signature requests whose &#x60;state&#x60; property is part of theses states are returned.  | [optional] [enum: DRAFT, PENDING, IN_PROGRESS, COMPLETED, CLOSED, CANCELED, EXPIRED]

### Return type

[**SignatureRequests**](SignatureRequests.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array (possibly empty) of all signature requests matching all search criteria, plus additional paging and sorting information. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**504** | Can be triggered when searching by name if the request takes too long to process. |  -  |

<a name="sendSignatureRequestOTP"></a>
# **sendSignatureRequestOTP**
> sendSignatureRequestOTP(requestId, signeeId)

Generate and send an OTP to a signer of a signature request.

Use this operation to generate and send a new OTP (One Time Password) by SMS to a signer of a signature request.&lt;br&gt; This OTP can be used to sign during a maximum period of 10 mn. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    String signeeId = "signeeId_example"; // String | Secret identifier of the signer wanting to retrieve his OTP.<br> **This secret identifier is generated by the platform and provided by email to the signer only. It allows the platform to authenticate the signer and verify his email address.** 
    try {
      apiInstance.sendSignatureRequestOTP(requestId, signeeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#sendSignatureRequestOTP");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **signeeId** | **String**| Secret identifier of the signer wanting to retrieve his OTP.&lt;br&gt; **This secret identifier is generated by the platform and provided by email to the signer only. It allows the platform to authenticate the signer and verify his email address.**  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OTP succesfully generated and sent by SMS to the signer. |  -  |
**401** | Unauthorized. The signer is not an authorized signer (secret signer identifier not found). |  -  |
**403** | Forbidden. The signature request is not in progress, or the signer does not require an OTP. |  -  |
**404** | Signature request not found. |  -  |
**429** | Too many requests. A minimum delay of 1 second is required between two OTP generation. |  -  |

<a name="sendSignatureRequestReminder"></a>
# **sendSignatureRequestReminder**
> sendSignatureRequestReminder(requestId, requestBody)

Send a reminder email to a set of signers of a signature request.

Use this operation to send a reminder email to a set of signers of a signature request.&lt;br&gt; This email reminds them that they have a document to sign. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    List<String> requestBody = Arrays.asList(); // List<String> | The list of emails of the authorized signers who will receive the reminder email. 
    try {
      apiInstance.sendSignatureRequestReminder(requestId, requestBody);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#sendSignatureRequestReminder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **requestBody** | [**List&lt;String&gt;**](String.md)| The list of emails of the authorized signers who will receive the reminder email.  |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Reminder email succesfully sent to the signers. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**403** | Forbidden. The signature request is not in progress, or at least one of the signers already signed. |  -  |
**404** | Signature request not found. |  -  |
**429** | Too many requests. A minimum delay of 1 hours is required between two reminder emails. |  -  |

<a name="signSignatureRequest"></a>
# **signSignatureRequest**
> SignatureRequestSignResult signSignatureRequest(requestId, signatureRequestSign)

Sign a signature request by registering a signature.

A signer can use this operation to sign a signature request by registering a signature he procuded on his own.&lt;br&gt; The signature is automatically anchored on behalf of the owner of the signature request.&lt;br&gt; The signature anchor created is added to the list of signature anchors of the signature request.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to register a signature (authentication of the signer rely on the knowledge of his secret identifier and OTP, or on the control of his public key). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    SignatureRequestSign signatureRequestSign = new SignatureRequestSign(); // SignatureRequestSign | Signature to register.
    try {
      SignatureRequestSignResult result = apiInstance.signSignatureRequest(requestId, signatureRequestSign);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#signSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **signatureRequestSign** | [**SignatureRequestSign**](SignatureRequestSign.md)| Signature to register. |

### Return type

[**SignatureRequestSignResult**](SignatureRequestSignResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Signature succesfully registered. The signature anchor created is returned. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**401** | Unauthorized. The signer is not an authorized signer (public key or secret signer identifier not found, or invalid OTP). |  -  |
**402** | Insufficient credits. The owner of the signature request runs out of signature or anchoring credit. |  -  |
**403** | Forbidden. The signature request is not in progress, the maximum number of signatures has been reached or the OTP has expired. |  -  |
**404** | Signature request not found. |  -  |
**409** | Conflict. The signer has already signed. |  -  |
**429** | Too many requests. A minimum delay of 1 second is required after providing an invalid OTP. |  -  |

<a name="transitionSignatureRequest"></a>
# **transitionSignatureRequest**
> SignatureRequest transitionSignatureRequest(requestId, body)

Change the state of a signature request.

Use this operation to transition a **stateful** signature request to a new state.&lt;br&gt; Possible transitions are: - from DRAFT to PENDING: start the signature request: the platform waits for the activation date (only if set) and transitions the signature request to IN_PROGRESS automatically - from PENDING to DRAFT: suspend the signature request so that it can be updated - from PENDING to CANCELED: cancel the signature request without waiting for the activation date - from IN_PROGRESS to CLOSED: close the signature request before all signatures get colleted - from IN_PROGRESS to CANCELED: cancel the signature request before all signatures get colleted  Note that **stateless** signature requests can only be transitioned to CLOSED or CANCELED, which triggers the generation of the audit trail and its signature by the platform. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    String body = "body_example"; // String | New state of the signature request.
    try {
      SignatureRequest result = apiInstance.transitionSignatureRequest(requestId, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#transitionSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **body** | **String**| New state of the signature request. |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The transitioned signature request. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**403** | Forbidden. Invalid transition. |  -  |
**404** | Signature request not found. |  -  |

<a name="updateSignatureRequest"></a>
# **updateSignatureRequest**
> SignatureRequest updateSignatureRequest(requestId, signatureRequest)

Update a signature request.

Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;callbackURL&#x60;, &#x60;activation&#x60;, &#x60;deadline&#x60;, &#x60;identityURL&#x60;, &#x60;fileName&#x60;, &#x60;fileURL&#x60;, &#x60;lang&#x60;, &#x60;vars&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; Only **stateless** signature requests or **stateful** signature request in DRAFT state can be updated. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of signature request to update.
    SignatureRequest signatureRequest = new SignatureRequest(); // SignatureRequest | SignatureRequest object to update.
    try {
      SignatureRequest result = apiInstance.updateSignatureRequest(requestId, signatureRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#updateSignatureRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of signature request to update. |
 **signatureRequest** | [**SignatureRequest**](SignatureRequest.md)| SignatureRequest object to update. |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated signature request. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**403** | Forbidden. The signature request cannot be updated. |  -  |
**404** | No signature request matching the given identifier. |  -  |

<a name="uploadSignatureRequestFile"></a>
# **uploadSignatureRequestFile**
> SignatureRequest uploadSignatureRequestFile(requestId, file)

Upload the file to sign.

Use this operation to upload the file to be signed for a signature request.&lt;br&gt; The SHA256 hash of the uploaded file must be equal to the &#x60;hashToSign&#x60; property of the signature request or the upload fails.&lt;br&gt; Once uploaded, the file is stored and the &#x60;fileURL&#x60; property of the signature request is set, so that it can be used by a signature application to download and present the file to the signers.&lt;br&gt; Only **stateless** signature requests or **stateful** signature request in DRAFT state can be updated. **WARNING: the storage of the file to be signed is provided for convenience only: it is not required, and you should never upload a file if you have any concern about its privacy.** 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.SignatureRequestApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");
    
    // Configure HTTP basic authorization: BasicAuth
    HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
    BasicAuth.setUsername("YOUR USERNAME");
    BasicAuth.setPassword("YOUR PASSWORD");

    // Configure API key authorization: JWTAuth
    ApiKeyAuth JWTAuth = (ApiKeyAuth) defaultClient.getAuthentication("JWTAuth");
    JWTAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //JWTAuth.setApiKeyPrefix("Token");

    SignatureRequestApi apiInstance = new SignatureRequestApi(defaultClient);
    String requestId = "requestId_example"; // String | Identifier of the signature request.
    File file = new File("/path/to/file"); // File | The file to sign.
    try {
      SignatureRequest result = apiInstance.uploadSignatureRequestFile(requestId, file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SignatureRequestApi#uploadSignatureRequestFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Identifier of the signature request. |
 **file** | **File**| The file to sign. |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | File succesfully uploaded and linked to signature request. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**403** | Forbidden. The file cannot be uploaded. |  -  |
**404** | Signature request not found. |  -  |

