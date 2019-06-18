# UserApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCallbackSecret**](UserApi.md#getCallbackSecret) | **GET** /user/callbackSecret | Get the currently used callback secret (null if not set).
[**getCredits**](UserApi.md#getCredits) | **GET** /user/credits | Get user&#39;s credits.
[**getTokens**](UserApi.md#getTokens) | **GET** /user/tokens | Get user&#39;s registered JWT tokens.
[**putTokens**](UserApi.md#putTokens) | **PUT** /user/tokens | Update user&#39;s registered JWT tokens.
[**updateCallbackSecret**](UserApi.md#updateCallbackSecret) | **PUT** /user/callbackSecret | Generates a new callback secret.


<a name="getCallbackSecret"></a>
# **getCallbackSecret**
> CallbackSecret getCallbackSecret()

Get the currently used callback secret (null if not set).

Use this operation to get the api callback secret.&lt;br&gt; 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.UserApi;

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

UserApi apiInstance = new UserApi();
try {
    CallbackSecret result = apiInstance.getCallbackSecret();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getCallbackSecret");
    e.printStackTrace();
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

<a name="getCredits"></a>
# **getCredits**
> Credits getCredits()

Get user&#39;s credits.

Use this operation to get the remaining signature and anchoring credits of the authenticated user.&lt;br&gt; 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.UserApi;

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

UserApi apiInstance = new UserApi();
try {
    Credits result = apiInstance.getCredits();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getCredits");
    e.printStackTrace();
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

<a name="getTokens"></a>
# **getTokens**
> List&lt;String&gt; getTokens()

Get user&#39;s registered JWT tokens.

Use this operation to list all JWT tokens registered for the authenticated user. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.UserApi;

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

UserApi apiInstance = new UserApi();
try {
    List<String> result = apiInstance.getTokens();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getTokens");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="putTokens"></a>
# **putTokens**
> putTokens(inlineObject)

Update user&#39;s registered JWT tokens.

Use this operation to update the list of JWT tokens registered for the authenticated user. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.UserApi;

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

UserApi apiInstance = new UserApi();
InlineObject inlineObject = new InlineObject(); // InlineObject | 
try {
    apiInstance.putTokens(inlineObject);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#putTokens");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateCallbackSecret"></a>
# **updateCallbackSecret**
> CallbackSecret updateCallbackSecret()

Generates a new callback secret.

Use this operation to generate the api callback secret.&lt;br&gt; 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.UserApi;

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

UserApi apiInstance = new UserApi();
try {
    CallbackSecret result = apiInstance.updateCallbackSecret();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#updateCallbackSecret");
    e.printStackTrace();
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

