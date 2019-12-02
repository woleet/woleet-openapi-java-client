# SignatureRequestApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSignatureRequest**](SignatureRequestApi.md#createSignatureRequest) | **POST** /signatureRequest | Create a new signature request.
[**deleteSignatureRequest**](SignatureRequestApi.md#deleteSignatureRequest) | **DELETE** /signatureRequest/{requestId} | Delete a signature request.
[**getSignatureRequest**](SignatureRequestApi.md#getSignatureRequest) | **GET** /signatureRequest/{requestId} | Get a signature request by its identifier.
[**searchSignatureRequests**](SignatureRequestApi.md#searchSignatureRequests) | **GET** /signatureRequests | Search for signature requests.
[**sendSignatureRequestOTP**](SignatureRequestApi.md#sendSignatureRequestOTP) | **GET** /signatureRequest/{requestId}/otp/{signeeId} | Generate and send an OTP to a signee of a signature request.
[**signSignatureRequest**](SignatureRequestApi.md#signSignatureRequest) | **POST** /signatureRequest/{requestId}/sign | Sign a signature request.
[**updateSignatureRequest**](SignatureRequestApi.md#updateSignatureRequest) | **PUT** /signatureRequest/{requestId} | Update a signature request.


<a name="createSignatureRequest"></a>
# **createSignatureRequest**
> SignatureRequest createSignatureRequest(signatureRequest)

Create a new signature request.

Use this operation to create a new signature request.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60; and &#x60;lastModified&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned request.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hashToSign&#x60; are required: the &#x60;hashToSign&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have enough signature and anchoring credits on your account to fulfill the signature request (each registered signature will cost you 1 signature and 1 anchoring credit).&lt;br&gt; 

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
**400** | Invalid signature request object. More details are returned in the response body as a JSON object. |  -  |

<a name="deleteSignatureRequest"></a>
# **deleteSignatureRequest**
> deleteSignatureRequest(requestId)

Delete a signature request.

Use this operation to delete a signature request.&lt;br&gt; 

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

<a name="getSignatureRequest"></a>
# **getSignatureRequest**
> SignatureRequest getSignatureRequest(requestId, signeeId)

Get a signature request by its identifier.

Use this operation to retrieve a signature request by its identifier.&lt;br&gt; When accessed with no authentication, only public attributes of the signature request are returned. 

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
    String signeeId = "signeeId_example"; // String | Secret identifier of the signee wanting to retrieve the signature request.<br> If set, information related to this signee is returned in `authorizedSignees[0]`.<br> **This secret identifier is generated by the platform and only included in the email sent to the signee, allowing the platform to authenticate the signee.** 
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
 **signeeId** | **String**| Secret identifier of the signee wanting to retrieve the signature request.&lt;br&gt; If set, information related to this signee is returned in &#x60;authorizedSignees[0]&#x60;.&lt;br&gt; **This secret identifier is generated by the platform and only included in the email sent to the signee, allowing the platform to authenticate the signee.**  | [optional]

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

<a name="searchSignatureRequests"></a>
# **searchSignatureRequests**
> SignatureRequests searchSignatureRequests(page, size, direction, sort, name, hashToSign)

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
    String sort = "created"; // String | Sorting property: possible values are limited to `id`, `created` and `hashToSign`. 
    String name = "name_example"; // String | `name` to search for: all signature requests whose `name` property contains this sub-string are returned.<br> **WARNING: Searching by name can timeout on a large signature request set.** 
    String hashToSign = "hashToSign_example"; // String | `hashToSign` to search for: all signature requests whose `hashToSign` property is equal are returned. 
    try {
      SignatureRequests result = apiInstance.searchSignatureRequests(page, size, direction, sort, name, hashToSign);
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
 **sort** | **String**| Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60; and &#x60;hashToSign&#x60;.  | [optional] [default to created] [enum: id, created, hashToSign]
 **name** | **String**| &#x60;name&#x60; to search for: all signature requests whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: Searching by name can timeout on a large signature request set.**  | [optional]
 **hashToSign** | **String**| &#x60;hashToSign&#x60; to search for: all signature requests whose &#x60;hashToSign&#x60; property is equal are returned.  | [optional]

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
**504** | Can be triggered when searching by name if the request takes too long to process. |  -  |

<a name="sendSignatureRequestOTP"></a>
# **sendSignatureRequestOTP**
> sendSignatureRequestOTP(requestId, signeeId)

Generate and send an OTP to a signee of a signature request.

Use this operation to generate and send a new OTP (One Time Password) by SMS to a signee of a signature request.&lt;br&gt; This OTP can be used to sign during a maximum period of 10 mn. 

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
    String signeeId = "signeeId_example"; // String | Secret identifier of the signee wanting to retrieve his OTP.<br> **This secret identifier is generated by the platform and only included in the email sent to the signee, allowing the platform to authenticate the signee.** 
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
 **signeeId** | **String**| Secret identifier of the signee wanting to retrieve his OTP.&lt;br&gt; **This secret identifier is generated by the platform and only included in the email sent to the signee, allowing the platform to authenticate the signee.**  |

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
**200** | OTP succesfully generated and sent by SMS to the signee. |  -  |
**401** | Unauthorized. The signee is not an authorized signee (signee identifier not found). |  -  |
**403** | Forbidden. The signature request is suspended, the deadline has been reached, or the signee does not require an OTP. |  -  |
**404** | Signature request or signee not found. |  -  |
**429** | Too many requests. A minimum delay of 1 second is required between two OTP generation. |  -  |

<a name="signSignatureRequest"></a>
# **signSignatureRequest**
> SignatureRequestSignResult signSignatureRequest(requestId, signature)

Sign a signature request.

Use this operation to register a signature in a signature request.&lt;br&gt; The signature is automatically anchored (on behalf of the owner of the signature request).&lt;br&gt; The signature anchor created is added to the list of signature anchors of the signature request.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to register a signature. 

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
    SignatureRequestSign signature = new SignatureRequestSign(); // SignatureRequestSign | Signature to register.
    try {
      SignatureRequestSignResult result = apiInstance.signSignatureRequest(requestId, signature);
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
 **signature** | [**SignatureRequestSign**](SignatureRequestSign.md)| Signature to register. |

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
**200** | Signature succesfully registered. The signature anchor created is returned. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**401** | Unauthorized. The signee is not an authorized signee (public key or signee identifier not found, or invalid OTP). |  -  |
**402** | Insufficient credits. The owner of the signature request runs out of signature or anchoring credit. |  -  |
**403** | Forbidden. The signature request is suspended, the deadline has been reached, the maximum number of signatures has been reached or the OTP has expired. |  -  |
**404** | Signature request not found. |  -  |
**409** | Conflict. The signee has already signed. |  -  |
**429** | Too many requests. A minimum delay of 1 second is required after providing an invalid OTP. |  -  |

<a name="updateSignatureRequest"></a>
# **updateSignatureRequest**
> SignatureRequest updateSignatureRequest(requestId, request)

Update a signature request.

Use this operation to update a signature request.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;suspended&#x60;, &#x60;deadline&#x60;, &#x60;maxSignatures&#x60; and &#x60;authorizedSignees&#x60; can be modified.&lt;br&gt; 

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
    SignatureRequest request = new SignatureRequest(); // SignatureRequest | SignatureRequest object to update.
    try {
      SignatureRequest result = apiInstance.updateSignatureRequest(requestId, request);
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
 **request** | [**SignatureRequest**](SignatureRequest.md)| SignatureRequest object to update. |

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
**400** | Invalid signature request object. More details are returned in the response body as a JSON object. |  -  |
**404** | No signature request matching the given identifier. |  -  |

