# UserApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCallbackSecret**](UserApi.md#getCallbackSecret) | **GET** /user/callbackSecret | Get the current callback secret (null if not set).
[**getCredits**](UserApi.md#getCredits) | **GET** /user/credits | Get user&#39;s credits.
[**getTokens**](UserApi.md#getTokens) | **GET** /user/tokens | Get user&#39;s registered JWT tokens.
[**putTokens**](UserApi.md#putTokens) | **PUT** /user/tokens | Update user&#39;s registered JWT tokens.
[**updateCallbackSecret**](UserApi.md#updateCallbackSecret) | **PUT** /user/callbackSecret | Generates a new callback secret.


<a name="getCallbackSecret"></a>
# **getCallbackSecret**
> CallbackSecret getCallbackSecret()

Get the current callback secret (null if not set).

Use this operation to get the API callback secret.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.UserApi;

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

    UserApi apiInstance = new UserApi(defaultClient);
    try {
      CallbackSecret result = apiInstance.getCallbackSecret();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#getCallbackSecret");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CallbackSecret**](CallbackSecret.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The current callback secret. |  -  |

<a name="getCredits"></a>
# **getCredits**
> Credits getCredits()

Get user&#39;s credits.

Use this operation to get the remaining signature and anchoring credits of the authenticated user.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.UserApi;

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

    UserApi apiInstance = new UserApi(defaultClient);
    try {
      Credits result = apiInstance.getCredits();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#getCredits");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Credits**](Credits.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The remaining signature and anchoring credits. |  -  |

<a name="getTokens"></a>
# **getTokens**
> Tokens getTokens()

Get user&#39;s registered JWT tokens.

Use this operation to list all JWT tokens registered for the authenticated user.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.UserApi;

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

    UserApi apiInstance = new UserApi(defaultClient);
    try {
      Tokens result = apiInstance.getTokens();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#getTokens");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Tokens**](Tokens.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The list of JWT tokens of the user, possibly empty. |  -  |

<a name="putTokens"></a>
# **putTokens**
> putTokens(tokens)

Update user&#39;s registered JWT tokens.

Use this operation to update the list of JWT tokens registered for the authenticated user.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.UserApi;

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

    UserApi apiInstance = new UserApi(defaultClient);
    Tokens tokens = new Tokens(); // Tokens | The list of JWT tokens to update.
    try {
      apiInstance.putTokens(tokens);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#putTokens");
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
 **tokens** | [**Tokens**](Tokens.md)| The list of JWT tokens to update. |

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
**200** | The list of JWT tokens has been successfully updated. |  -  |
**400** | Invalid request. More details are returned in the response body as a JSON object. |  -  |

<a name="updateCallbackSecret"></a>
# **updateCallbackSecret**
> CallbackSecret updateCallbackSecret()

Generates a new callback secret.

Use this operation to generate the API callback secret.

### Example
```java
// Import classes:
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.Configuration;
import io.woleet.api.auth.*;
import io.woleet.api.models.*;
import io.woleet.api.client.UserApi;

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

    UserApi apiInstance = new UserApi(defaultClient);
    try {
      CallbackSecret result = apiInstance.updateCallbackSecret();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#updateCallbackSecret");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CallbackSecret**](CallbackSecret.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The newly generated callback secret. |  -  |

