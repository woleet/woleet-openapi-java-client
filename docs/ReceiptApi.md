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

Use this operation to retrieve the Chainpoint proof receipt associated to a given anchor. This is a publicly accessible endpoint: authentication is not required to retrieve a proof receipt (but the anchor identifier need to be known). 

### Example
```java
// Import classes:
//import io.woleet.api.ApiException;
//import io.woleet.api.client.ReceiptApi;


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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="verifyReceipt"></a>
# **verifyReceipt**
> ReceiptVerificationStatus verifyReceipt(receipt)

Verify a proof receipt.

Use this operation to verify a Chainpoint proof receipt.&lt;br&gt; This is a publicly accessible endpoint: authentication is not required to verify a proof receipt. 

### Example
```java
// Import classes:
//import io.woleet.api.ApiException;
//import io.woleet.api.client.ReceiptApi;


ReceiptApi apiInstance = new ReceiptApi();
Receipt receipt = new Receipt(); // Receipt | Chainpoint proof receipt to verify.
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
 **receipt** | [**Receipt**](Receipt.md)| Chainpoint proof receipt to verify. |

### Return type

[**ReceiptVerificationStatus**](ReceiptVerificationStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

