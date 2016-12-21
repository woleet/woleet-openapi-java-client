# TokenApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getToken**](TokenApi.md#getToken) | **GET** /token | Get a JWT authentication token.


<a name="getToken"></a>
# **getToken**
> Token getToken()

Get a JWT authentication token.

Use this operation to retrieve a JWT authentication token. Then, use this token to authenticate using the &#x60;Bearer&#x60; scheme of the &#x60;Authorization&#x60; header, like:  &#x60;Authorization: Bearer {JWT token value}&#x60; 

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

TokenApi apiInstance = new TokenApi();
try {
    Token result = apiInstance.getToken();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TokenApi#getToken");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Token**](Token.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

