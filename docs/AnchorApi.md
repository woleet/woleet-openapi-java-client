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

Use this operation to create a new anchor.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;status&#x60;, &#x60;timestamp&#x60; and &#x60;confirmations&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned anchor.&lt;br&gt; Only the properties &#x60;name&#x60; and &#x60;hash&#x60; are required. 

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
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to create.  |

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

Use this operation to delete a given anchor.&lt;br&gt; *WARNING*: You should never delete an anchor, overwise you will no longer be able to download its proof receipt.&lt;br&gt; Use this for test purpose only. 

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
> AnchorIds searchAnchorIds(hash, page, size)

Search for public anchors&#39; identifiers.

Use this operation to retreive the identifiers of all public anchors having a given hash.&lt;br&gt; Only public anchors&#39; identifiers are returned.&lt;br&gt; Paging is supported. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiException;
//import io.woleet.api.client.AnchorApi;


AnchorApi apiInstance = new AnchorApi();
String hash = "hash_example"; // String | Hash to search for: all anchors whose hash is exactly the same are returned. 
Integer page = 0; // Integer | Index of the page to retreive (from 0). 
Integer size = 20; // Integer | Number of anchors per page. 
try {
    AnchorIds result = apiInstance.searchAnchorIds(hash, page, size);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#searchAnchorIds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **String**| Hash to search for: all anchors whose hash is exactly the same are returned.  |
 **page** | **Integer**| Index of the page to retreive (from 0).  | [optional] [default to 0]
 **size** | **Integer**| Number of anchors per page.  | [optional] [default to 20]

### Return type

[**AnchorIds**](AnchorIds.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchAnchors"></a>
# **searchAnchors**
> Anchors searchAnchors(page, size, direction, sort, name, hash, tags)

Search for anchors.

Use this operation to retreive all anchors having a given name, hash and/or tags.&lt;br&gt; Only anchors belonging to the authenticated user are returned.&lt;br&gt; Paging and sorting is supported. 

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
Integer page = 0; // Integer | Index of the page to retreive (from 0). 
Integer size = 20; // Integer | Number of anchors per page. 
String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
String sort = "created"; // String | Sorting property: possbile values are `created`, `lastModified`, `name`, `hash`. 
String name = "name_example"; // String | Name to search for: a sub-string like `My file` or a regex like `/[mM]y.*file/` can be used. All anchors whose name contains the sub-string or match the regex are returned. 
String hash = "hash_example"; // String | Hash to search for: all anchors whose hash is exactly the same are returned. 
List<String> tags = Arrays.asList("tags_example"); // List<String> | List of tags to search for. Only anchors having all these tags sets are returned. 
try {
    Anchors result = apiInstance.searchAnchors(page, size, direction, sort, name, hash, tags);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AnchorApi#searchAnchors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Index of the page to retreive (from 0).  | [optional] [default to 0]
 **size** | **Integer**| Number of anchors per page.  | [optional] [default to 20]
 **direction** | **String**| Sorting direction: ASC for ascending DESC for descending.  | [optional] [default to ASC] [enum: ASC, DESC]
 **sort** | **String**| Sorting property: possbile values are &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;name&#x60;, &#x60;hash&#x60;.  | [optional] [default to created] [enum: created, lastModified, name, hash]
 **name** | **String**| Name to search for: a sub-string like &#x60;My file&#x60; or a regex like &#x60;/[mM]y.*file/&#x60; can be used. All anchors whose name contains the sub-string or match the regex are returned.  | [optional]
 **hash** | **String**| Hash to search for: all anchors whose hash is exactly the same are returned.  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| List of tags to search for. Only anchors having all these tags sets are returned.  | [optional]

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

Use this operation to update a given anchor.&lt;br&gt; Only the properties &#x60;name&#x60;, &#x60;public&#x60;, &#x60;tags&#x60;, &#x60;metadata&#x60; &#x60;targetURI&#x60; and &#x60;callbackURL&#x60; can be modified. 

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
 **anchorid** | **String**| Identifier of anchor to update.  |
 **anchor** | [**Anchor**](Anchor.md)| Anchor object to update.  |

### Return type

[**Anchor**](Anchor.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

