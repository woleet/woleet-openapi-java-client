# AnchorApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAnchor**](AnchorApi.md#createAnchor) | **POST** /anchor | Create a new anchor.
[**deleteAnchor**](AnchorApi.md#deleteAnchor) | **DELETE** /anchor/{anchorid} | Delete an existing anchor.
[**getAnchor**](AnchorApi.md#getAnchor) | **GET** /anchor/{anchorid} | Get an anchor by its identifier.
[**searchAnchorIds**](AnchorApi.md#searchAnchorIds) | **GET** /anchorids | Search for public anchors&#39; identifiers.
[**searchAnchors**](AnchorApi.md#searchAnchors) | **GET** /anchors | Search for anchors.
[**updateAnchor**](AnchorApi.md#updateAnchor) | **PUT** /anchor/{anchorid} | Update an existing anchor.


<a name="createAnchor"></a>
# **createAnchor**
> Anchor createAnchor(anchor)

Create a new anchor.

Use this operation to create a new anchor.&lt;br&gt; An anchor can be: - a data anchor (generating a proof of existence receipt) allows to prove the existence of some data at some point in time.&lt;br&gt; - a signature anchor (generating a proof of signature receipt) allows to prove the existence of the signature of some data at some point in time, the validity of the signature and the identity of the signee.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; For data anchors, only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required: the &#x60;hash&#x60; property must be the SHA256 hash of the data to anchor, and must be computed caller side. This allows not to leak the original data.&lt;br&gt; For signature anchors, only the properties &#x60;name&#x60;, &#x60;signedHash&#x60;, &#x60;signature&#x60; and &#x60;pubKey&#x60; are required (though the property &#x60;identityURL&#x60; is highly recommended): the &#x60;signedHash&#x60; property must be the SHA256 hash of the data to sign. This allows not to leak the original data and to keep the actual signed data small (signing the digest is equivalent to signing the original data).&lt;br&gt; Be sure to have at least 1 anchoring credit on your account. The &#x60;signature&#x60; property must contains a valid signature of the &#x60;data&#x60; property using the private key paired with the &#x60;pubKey&#x60; public key. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.AnchorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AnchorApi apiInstance = new AnchorApi();
Anchor anchor = new Anchor(); // Anchor | Anchor object to create.
try {
    Anchor result = apiInstance.createAnchor(anchor);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#createAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to create. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAnchor"></a>
# **deleteAnchor**
> deleteAnchor(anchorid)

Delete an existing anchor.

Use this operation to delete a given anchor.&lt;br&gt; **WARNING: You should never delete an anchor, otherwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only.** 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.AnchorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AnchorApi apiInstance = new AnchorApi();
String anchorid = "anchorid_example"; // String | Identifier of the anchor to delete.
try {
    apiInstance.deleteAnchor(anchorid);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#deleteAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **anchorid** | **String**| Identifier of the anchor to delete. |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAnchor"></a>
# **getAnchor**
> Anchor getAnchor(anchorid)

Get an anchor by its identifier.

Use this operation to retrieve an anchor by its identifier.

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.AnchorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AnchorApi apiInstance = new AnchorApi();
String anchorid = "anchorid_example"; // String | Identifier of the anchor to retrieve.
try {
    Anchor result = apiInstance.getAnchor(anchorid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#getAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **anchorid** | **String**| Identifier of the anchor to retrieve. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchAnchorIds"></a>
# **searchAnchorIds**
> AnchorIds searchAnchorIds(page, size, hash, signedHash)

Search for public anchors&#39; identifiers.

Use this operation to retrieve the identifiers of all public anchors having a given &#x60;hash&#x60; and/or &#x60;signedHash&#x60; property.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiException;
//import io.woleet.api.client.AnchorApi;


AnchorApi apiInstance = new AnchorApi();
Integer page = 0; // Integer | Index of the page to retrieve (from 0).
Integer size = 20; // Integer | Number of anchors per page.
String hash = "hash_example"; // String | `hash` to search for: all public anchors whose `hash` property is equal are returned. 
String signedHash = "signedHash_example"; // String | `signedHash` to search for: all public anchors whose `signedHash` property is equal are returned. 
try {
    AnchorIds result = apiInstance.searchAnchorIds(page, size, hash, signedHash);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#searchAnchorIds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Index of the page to retrieve (from 0). | [optional] [default to 0]
 **size** | **Integer**| Number of anchors per page. | [optional] [default to 20]
 **hash** | **String**| &#x60;hash&#x60; to search for: all public anchors whose &#x60;hash&#x60; property is equal are returned.  | [optional]
 **signedHash** | **String**| &#x60;signedHash&#x60; to search for: all public anchors whose &#x60;signedHash&#x60; property is equal are returned.  | [optional]

### Return type

[**AnchorIds**](AnchorIds.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchAnchors"></a>
# **searchAnchors**
> Anchors searchAnchors(page, size, direction, sort, name, hash, signedHash, tags)

Search for anchors.

Use this operation to retrieve all anchors having a given &#x60;name&#x60;, &#x60;hash&#x60;, &#x60;signedHash&#x60; and/or &#x60;tags&#x60; property.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.AnchorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AnchorApi apiInstance = new AnchorApi();
Integer page = 0; // Integer | Index of the page to retrieve (from 0).
Integer size = 20; // Integer | Number of anchors per page.
String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
String sort = "created"; // String | Sorting property: possible values are limited to `id`, `created`, `hash` and `signedHash`. 
String name = "name_example"; // String | `name` to search for: all anchors whose `name` property contains this sub-string are returned.<br> **WARNING: searching by name is not optimized and so is not recommended on a large anchor set.** 
String hash = "hash_example"; // String | `hash` to search for: all anchors whose `hash` property is equal are returned. 
String signedHash = "signedHash_example"; // String | `signedHash` to search for: all anchors whose `signedHash` property is equal are returned. 
List<String> tags = Arrays.asList("tags_example"); // List<String> | `tags` to search for: all anchors having all of these tags sets are returned. 
try {
    Anchors result = apiInstance.searchAnchors(page, size, direction, sort, name, hash, signedHash, tags);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#searchAnchors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Index of the page to retrieve (from 0). | [optional] [default to 0]
 **size** | **Integer**| Number of anchors per page. | [optional] [default to 20]
 **direction** | **String**| Sorting direction: ASC for ascending DESC for descending.  | [optional] [default to ASC] [enum: ASC, DESC]
 **sort** | **String**| Sorting property: possible values are limited to &#x60;id&#x60;, &#x60;created&#x60;, &#x60;hash&#x60; and &#x60;signedHash&#x60;.  | [optional] [default to created] [enum: id, created, hash, signedHash]
 **name** | **String**| &#x60;name&#x60; to search for: all anchors whose &#x60;name&#x60; property contains this sub-string are returned.&lt;br&gt; **WARNING: searching by name is not optimized and so is not recommended on a large anchor set.**  | [optional]
 **hash** | **String**| &#x60;hash&#x60; to search for: all anchors whose &#x60;hash&#x60; property is equal are returned.  | [optional]
 **signedHash** | **String**| &#x60;signedHash&#x60; to search for: all anchors whose &#x60;signedHash&#x60; property is equal are returned.  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| &#x60;tags&#x60; to search for: all anchors having all of these tags sets are returned.  | [optional]

### Return type

[**Anchors**](Anchors.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAnchor"></a>
# **updateAnchor**
> Anchor updateAnchor(anchorid, anchor)

Update an existing anchor.

Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; and &#x60;callbackURL&#x60; can be modified. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.AnchorApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

AnchorApi apiInstance = new AnchorApi();
String anchorid = "anchorid_example"; // String | Identifier of anchor to update.
Anchor anchor = new Anchor(); // Anchor | Anchor object to update.
try {
    Anchor result = apiInstance.updateAnchor(anchorid, anchor);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#updateAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **anchorid** | **String**| Identifier of anchor to update. |
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to update. |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

