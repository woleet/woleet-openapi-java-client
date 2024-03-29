# AnchorApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAnchor**](AnchorApi.md#createAnchor) | **POST** /anchor | Create a new anchor.
[**deleteAnchor**](AnchorApi.md#deleteAnchor) | **DELETE** /anchor/{anchorId} | Delete an anchor.
[**getAnchor**](AnchorApi.md#getAnchor) | **GET** /anchor/{anchorId} | Get an anchor by its identifier.
[**getAnchorAttestation**](AnchorApi.md#getAnchorAttestation) | **GET** /anchor/{anchorId}/attestation | Download the Proof Attestation document of an anchor.
[**searchAnchorIds**](AnchorApi.md#searchAnchorIds) | **GET** /anchorIds | Search for public anchor identifiers.
[**searchAnchors**](AnchorApi.md#searchAnchors) | **GET** /anchors | Search for anchors.
[**updateAnchor**](AnchorApi.md#updateAnchor) | **PUT** /anchor/{anchorId} | Update an anchor.


<a name="createAnchor"></a>
# **createAnchor**
> Anchor createAnchor(anchor)

Create a new anchor.

Use this operation to create a new anchor of one of these two types: - a **data anchor** (to generate a *proof of timestamp* allowing to prove the existence of a data at some point in time) - a **signature anchor** (to generate a *proof of seal* allowing to prove the existence of the signature of a data at some point in time, the validity of the signature and the identity of the signer)  The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required.&lt;br&gt; Be sure to have at least 1 timestamp credit (for a data anchor) or 1 seal credit (for a signature anchor). 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    Anchor anchor = new Anchor(); // Anchor | Anchor object to create.
    try {
      Anchor result = apiInstance.createAnchor(anchor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#createAnchor");
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
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to create. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created anchor. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**402** | Insufficient credits. |  -  |

<a name="deleteAnchor"></a>
# **deleteAnchor**
> deleteAnchor(anchorId)

Delete an anchor.

Use this operation to delete an anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    String anchorId = "anchorId_example"; // String | Identifier of the anchor to delete.
    try {
      apiInstance.deleteAnchor(anchorId);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#deleteAnchor");
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
 **anchorId** | **String**| Identifier of the anchor to delete. |

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
**200** | The anchor is deleted. |  -  |
**404** | No anchor matching the given identifier. |  -  |

<a name="getAnchor"></a>
# **getAnchor**
> Anchor getAnchor(anchorId)

Get an anchor by its identifier.

Use this operation to retrieve an anchor by its identifier.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    String anchorId = "anchorId_example"; // String | Identifier of the anchor to retrieve.
    try {
      Anchor result = apiInstance.getAnchor(anchorId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#getAnchor");
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
 **anchorId** | **String**| Identifier of the anchor to retrieve. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The anchor. |  -  |
**404** | No anchor matching the given identifier. |  -  |

<a name="getAnchorAttestation"></a>
# **getAnchorAttestation**
> File getAnchorAttestation(anchorId)

Download the Proof Attestation document of an anchor.

Use this operation to retrieve the Proof Attestation document of an anchor.&lt;br&gt; This PDF file is only available once the anchor status is CONFIRMED. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    String anchorId = "anchorId_example"; // String | Identifier of the anchor.
    try {
      File result = apiInstance.getAnchorAttestation(anchorId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#getAnchorAttestation");
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
 **anchorId** | **String**| Identifier of the anchor. |

### Return type

[**File**](File.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The proof attestation. |  -  |
**400** | Proof attestation not yet available. |  -  |
**404** | Anchor not found. |  -  |

<a name="searchAnchorIds"></a>
# **searchAnchorIds**
> AnchorIds searchAnchorIds(page, size, hash, signedHash, userId)

Search for public anchor identifiers.

Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchor identifiers are returned.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to retrieve public anchor identifiers.&lt;br&gt; Paging is supported. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.woleet.io/v1");

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    Integer page = 0; // Integer | Index of the page to retrieve (from 0).
    Integer size = 20; // Integer | Number of anchor identifiers per page.
    String hash = "hash_example"; // String | `hash` to search for: all public anchors whose `hash` property is equal are returned. 
    String signedHash = "signedHash_example"; // String | `signedHash` to search for: all public anchors whose `signedHash` property is equal are returned. 
    String userId = "userId_example"; // String | User identifier to use to filter out results: only public anchors belonging to this user are returned. 
    try {
      AnchorIds result = apiInstance.searchAnchorIds(page, size, hash, signedHash, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#searchAnchorIds");
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
 **size** | **Integer**| Number of anchor identifiers per page. | [optional] [default to 20]
 **hash** | **String**| &#x60;hash&#x60; to search for: all public anchors whose &#x60;hash&#x60; property is equal are returned.  | [optional]
 **signedHash** | **String**| &#x60;signedHash&#x60; to search for: all public anchors whose &#x60;signedHash&#x60; property is equal are returned.  | [optional]
 **userId** | **String**| User identifier to use to filter out results: only public anchors belonging to this user are returned.  | [optional]

### Return type

[**AnchorIds**](AnchorIds.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array (possibly empty) of the identifiers of all public anchors matching all search criteria, plus additional paging information. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |

<a name="searchAnchors"></a>
# **searchAnchors**
> Anchors searchAnchors(page, size, direction, sort, name, hash, signedHash, tags)

Search for anchors.

Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    Integer page = 0; // Integer | Index of the page to retrieve (from 0).
    Integer size = 20; // Integer | Number of anchors per page.
    String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
    String sort = "created"; // String | Sorting property: possible values are limited to `created`, `hash` and `signedHash`. 
    String name = "name_example"; // String | `name` to search for: all anchors whose `name` property contains this sub-string are returned.<br> **WARNING: Searching by name can timeout on a large anchor set.** 
    String hash = "hash_example"; // String | `hash` to search for: all anchors whose `hash` property is equal are returned. 
    String signedHash = "signedHash_example"; // String | `signedHash` to search for: all anchors whose `signedHash` property is equal are returned. 
    List<String> tags = Arrays.asList(); // List<String> | Tags to search for: all anchors having all of these tags sets are returned. 
    try {
      Anchors result = apiInstance.searchAnchors(page, size, direction, sort, name, hash, signedHash, tags);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#searchAnchors");
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
 **sort** | **String**| Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;hash&#x60; and &#x60;signedHash&#x60;.  | [optional] [default to created] [enum: created, hash, signedHash]
 **name** | **String**| &#x60;name&#x60; to search for: all anchors whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: Searching by name can timeout on a large anchor set.**  | [optional]
 **hash** | **String**| &#x60;hash&#x60; to search for: all anchors whose &#x60;hash&#x60; property is equal are returned.  | [optional]
 **signedHash** | **String**| &#x60;signedHash&#x60; to search for: all anchors whose &#x60;signedHash&#x60; property is equal are returned.  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| Tags to search for: all anchors having all of these tags sets are returned.  | [optional]

### Return type

[**Anchors**](Anchors.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array (possibly empty) of all anchors matching all search criteria, plus additional paging and sorting information. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**504** | Can be triggered when searching by name if the request takes too long to process. |  -  |

<a name="updateAnchor"></a>
# **updateAnchor**
> Anchor updateAnchor(anchorId, anchor)

Update an anchor.

Use this operation to update an anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.AnchorApi;

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

    AnchorApi apiInstance = new AnchorApi(defaultClient);
    String anchorId = "anchorId_example"; // String | Identifier of anchor to update.
    Anchor anchor = new Anchor(); // Anchor | Anchor object to update.
    try {
      Anchor result = apiInstance.updateAnchor(anchorId, anchor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnchorApi#updateAnchor");
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
 **anchorId** | **String**| Identifier of anchor to update. |
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to update. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated anchor. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**404** | No anchor matching the given identifier. |  -  |

