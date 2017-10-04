# ReceiptApi

All URIs are relative to *https://api.woleet.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getReceipt**](ReceiptApi.md#getReceipt) | **GET** /receipt/{anchorid} | Get the proof receipt of an anchor.
[**verifyReceipt**](ReceiptApi.md#verifyReceipt) | **POST** /receipt/verify | Verify a proof receipt.


<a name="getReceipt"></a>
# **getReceipt**
> Receipt getReceipt(anchorid)

Get the proof receipt of an anchor.

Use this operation to retrieve the ChainPoint standard receipt associated to a given anchor. This endpoint can be accessed publicly: authentication is required only to retrieve private anchors&#39; receipts. Public anchors&#39; receipts can be retrieved with or without authentication. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiClient;
//import io.woleet.api.ApiException;
//import io.woleet.api.Configuration;
//import io.woleet.api.auth.*;
//import io.woleet.api.client.ReceiptApi;

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

ReceiptApi apiInstance = new ReceiptApi();
String anchorid = "anchorid_example"; // String | Identifier of the anchor for which to build the proof receipt.
try {
    Receipt result = apiInstance.getReceipt(anchorid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReceiptApi#getReceipt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **anchorid** | **String**| Identifier of the anchor for which to build the proof receipt. |

### Return type

[**Receipt**](Receipt.md)

### Authorization

[BasicAuth](../README.md#BasicAuth), [JWTAuth](../README.md#JWTAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="verifyReceipt"></a>
# **verifyReceipt**
> ReceiptVerificationStatus verifyReceipt(receipt)

Verify a proof receipt.

Use this operation to verify a ChainPoint standard receipt.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiException;
//import io.woleet.api.client.ReceiptApi;


ReceiptApi apiInstance = new ReceiptApi();
Receipt receipt = new Receipt(); // Receipt | Chainpoint standard receipt to verify.
try {
    ReceiptVerificationStatus result = apiInstance.verifyReceipt(receipt);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReceiptApi#verifyReceipt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **receipt** | [**Receipt**](Receipt.md)| Chainpoint standard receipt to verify. |

### Return type

[**ReceiptVerificationStatus**](ReceiptVerificationStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

