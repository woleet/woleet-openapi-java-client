# DomainApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDomainUser**](DomainApi.md#createDomainUser) | **POST** /domain/admin/user | Create a new domain user.
[**deleteDomainUser**](DomainApi.md#deleteDomainUser) | **DELETE** /domain/admin/user/{userId} | Delete a domain user.
[**getDomainUser**](DomainApi.md#getDomainUser) | **GET** /domain/admin/user/{userId} | Get a domain user by its identifier.
[**searchDomainUsers**](DomainApi.md#searchDomainUsers) | **GET** /domain/admin/users | Search for domain users.
[**updateDomainUser**](DomainApi.md#updateDomainUser) | **PUT** /domain/admin/user/{userId} | Update a domain user.


<a name="createDomainUser"></a>
# **createDomainUser**
> User createDomainUser(user)

Create a new domain user.

Use this operation to create a new domain user.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;info&#x60; and &#x60;status&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned user. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.DomainApi;

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

    DomainApi apiInstance = new DomainApi(defaultClient);
    User user = new User(); // User | User object to create (password must be provided).
    try {
      User result = apiInstance.createDomainUser(user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DomainApi#createDomainUser");
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
 **user** | [**User**](User.md)| User object to create (password must be provided). |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created user. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |

<a name="deleteDomainUser"></a>
# **deleteDomainUser**
> deleteDomainUser(userId)

Delete a domain user.

Use this operation to delete a domain user.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.DomainApi;

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

    DomainApi apiInstance = new DomainApi(defaultClient);
    String userId = "userId_example"; // String | Identifier of the domain user to delete.
    try {
      apiInstance.deleteDomainUser(userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DomainApi#deleteDomainUser");
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
 **userId** | **String**| Identifier of the domain user to delete. |

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
**200** | The user is deleted. |  -  |
**404** | No user matching the given identifier. |  -  |

<a name="getDomainUser"></a>
# **getDomainUser**
> User getDomainUser(userId)

Get a domain user by its identifier.

Use this operation to retrieve a domain user by its identifier.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.DomainApi;

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

    DomainApi apiInstance = new DomainApi(defaultClient);
    String userId = "userId_example"; // String | Identifier of the domain user to retrieve.
    try {
      User result = apiInstance.getDomainUser(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DomainApi#getDomainUser");
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
 **userId** | **String**| Identifier of the domain user to retrieve. |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The user. |  -  |
**404** | No user matching the given identifier. |  -  |

<a name="searchDomainUsers"></a>
# **searchDomainUsers**
> Users searchDomainUsers(page, size, direction, sort, email)

Search for domain users.

Use this operation to list all domain users or search for domain users given their email.&lt;br&gt; Paging and sorting is supported. 

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.DomainApi;

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

    DomainApi apiInstance = new DomainApi(defaultClient);
    Integer page = 0; // Integer | Index of the page to retrieve (from 0).
    Integer size = 20; // Integer | Number of users per page.
    String direction = "ASC"; // String | Sorting direction: ASC for ascending DESC for descending. 
    String sort = "created"; // String | Sorting property: possible values are `email`, `created`, `roles`, `info.firstName`, `info.lastName`, `status`. 
    String email = "email_example"; // String | `email` to search for: a sub-string of the email. 
    try {
      Users result = apiInstance.searchDomainUsers(page, size, direction, sort, email);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DomainApi#searchDomainUsers");
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
 **size** | **Integer**| Number of users per page. | [optional] [default to 20]
 **direction** | **String**| Sorting direction: ASC for ascending DESC for descending.  | [optional] [default to ASC] [enum: ASC, DESC]
 **sort** | **String**| Sorting property: possible values are &#x60;email&#x60;, &#x60;created&#x60;, &#x60;roles&#x60;, &#x60;info.firstName&#x60;, &#x60;info.lastName&#x60;, &#x60;status&#x60;.  | [optional] [default to created] [enum: email, created, roles, info.firstName, info.lastName, status]
 **email** | **String**| &#x60;email&#x60; to search for: a sub-string of the email.  | [optional]

### Return type

[**Users**](Users.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array of all users matching all search criteria, plus additional paging and sorting information. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |

<a name="updateDomainUser"></a>
# **updateDomainUser**
> User updateDomainUser(userId, user)

Update a domain user.

Use this operation to update a domain user.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.DomainApi;

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

    DomainApi apiInstance = new DomainApi(defaultClient);
    String userId = "userId_example"; // String | Identifier of the domain user to update.
    User user = new User(); // User | User object to update.
    try {
      User result = apiInstance.updateDomainUser(userId, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DomainApi#updateDomainUser");
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
 **userId** | **String**| Identifier of the domain user to update. |
 **user** | [**User**](User.md)| User object to update. |

### Return type

[**User**](User.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated user. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |
**404** | No user matching the given identifier. |  -  |

