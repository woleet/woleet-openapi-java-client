# DomainApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDomainUser**](DomainApi.md#createDomainUser) | **POST** /domain/admin/user | Create a new domain user.
[**deleteDomainUser**](DomainApi.md#deleteDomainUser) | **DELETE** /domain/admin/user/{userid} | Delete a user.
[**getDomainUser**](DomainApi.md#getDomainUser) | **GET** /domain/admin/user/{userid} | Get a user by its identifier.
[**getDomainUsers**](DomainApi.md#getDomainUsers) | **GET** /domain/admin/users | Search for users.
[**updateDomainUser**](DomainApi.md#updateDomainUser) | **PUT** /domain/admin/user/{userid} | Update a user.


<a name="createDomainUser"></a>
# **createDomainUser**
> User createDomainUser(user)

Create a new domain user.

Use this operation to create a new user for a domain.

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.DomainApi;

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

DomainApi apiInstance = new DomainApi();
User user = new User(); // User | User object to create (password must be provided).
try {
    User result = apiInstance.createDomainUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DomainApi#createDomainUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**User**](User.md)| User object to create (password must be provided). |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteDomainUser"></a>
# **deleteDomainUser**
> deleteDomainUser(userid)

Delete a user.

Use this operation to delete a user.

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.DomainApi;

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

DomainApi apiInstance = new DomainApi();
String userid = "userid_example"; // String | Identifier of the user to delete.
try {
    apiInstance.deleteDomainUser(userid);
} catch (ApiException e) {
    System.err.println("Exception when calling DomainApi#deleteDomainUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| Identifier of the user to delete. |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDomainUser"></a>
# **getDomainUser**
> User getDomainUser(userid)

Get a user by its identifier.

Use this operation to retrieve a user by its identifier.

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.DomainApi;

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

DomainApi apiInstance = new DomainApi();
String userid = "userid_example"; // String | Identifier of the user to retrieve.
try {
    User result = apiInstance.getDomainUser(userid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DomainApi#getDomainUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| Identifier of the user to retrieve. |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDomainUsers"></a>
# **getDomainUsers**
> Users getDomainUsers(page, size, direction, sort, email)

Search for users.

Use this operation to retrieve all users having a given &#x60;email&#x60; property.&lt;br&gt; Paging and sorting is supported. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.DomainApi;

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

DomainApi apiInstance = new DomainApi();
Integer page = 0; // Integer | Index of the page to retrieve (from 0).
Integer size = 20; // Integer | Number of users per page.
String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
String sort = "created"; // String | Sorting property: possible values are limited to `created`, `email`, `status` and `roles`. 
String email = "email_example"; // String | email to search for: a sub-string or regex of the email. 
try {
    Users result = apiInstance.getDomainUsers(page, size, direction, sort, email);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DomainApi#getDomainUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Index of the page to retrieve (from 0). | [optional] [default to 0]
 **size** | **Integer**| Number of users per page. | [optional] [default to 20]
 **direction** | **String**| Sorting direction: ASC for ascending DESC for descending.  | [optional] [default to ASC] [enum: ASC, DESC]
 **sort** | **String**| Sorting property: possible values are limited to &#x60;created&#x60;, &#x60;email&#x60;, &#x60;status&#x60; and &#x60;roles&#x60;.  | [optional] [default to created] [enum: email, created, roles, status]
 **email** | **String**| email to search for: a sub-string or regex of the email.  | [optional]

### Return type

[**Users**](Users.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateDomainUser"></a>
# **updateDomainUser**
> User updateDomainUser(userid, user)

Update a user.

Use this operation to update a user.

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.DomainApi;

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

DomainApi apiInstance = new DomainApi();
String userid = "userid_example"; // String | Identifier of the user to update.
User user = new User(); // User | User object to update.
try {
    User result = apiInstance.updateDomainUser(userid, user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DomainApi#updateDomainUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| Identifier of the user to update. |
 **user** | [**User**](User.md)| User object to update. |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

