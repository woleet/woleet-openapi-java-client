# TokenApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateToken**](TokenApi.md#generateToken) | **GET** /token | Generate a JWT token.
[**revokeToken**](TokenApi.md#revokeToken) | **DELETE** /token | Revoke a JWT token.


<a name="generateToken"></a>
# **generateToken**
> Token generateToken(cdata)

Generate a JWT token.

Use this operation to generate a new JWT token.&lt;br&gt; JWT tokens can be used to authenticate to the API, using the &#x60;Bearer&#x60; scheme of the &#x60;Authorization&#x60; header, like:&lt;br&gt; &#x60;Authorization: Bearer {JWT token}&#x60; 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.TokenApi;

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

TokenApi apiInstance = new TokenApi();
String cdata = "cdata_example"; // String | Client data to inject into the generated JWT token (64 characters max).<br> This data is not processed by the platform, and can be easily retrieved from the token by BASE64 decoding its `payload`. 
try {
    Token result = apiInstance.generateToken(cdata);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TokenApi#generateToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cdata** | **String**| Client data to inject into the generated JWT token (64 characters max).&lt;br&gt; This data is not processed by the platform, and can be easily retrieved from the token by BASE64 decoding its &#x60;payload&#x60;.  | [optional]

### Return type

[**Token**](Token.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revokeToken"></a>
# **revokeToken**
> revokeToken(token)

Revoke a JWT token.

Use this operation to revoke a JWT token.&lt;br&gt; JWT tokens have no expiration date so are always valid: if you need to invalidate a token (eg. because you think it is compromised) you need to use this endpoint to inform the platform that this token must no longer be accepted. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.TokenApi;

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

TokenApi apiInstance = new TokenApi();
String token = "token_example"; // String | JWT token to revoke.
try {
    apiInstance.revokeToken(token);
} catch (ApiException e) {
    System.err.println("Exception when calling TokenApi#revokeToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| JWT token to revoke. |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

