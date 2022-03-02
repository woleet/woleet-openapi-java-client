

# ReceiptVerificationStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Proof receipt verification status code:&lt;br&gt; - VERIFIED: success: the proof receipt is verified: both the proof of timestamp AND the proof of signature (if applicable) are valid (but the proof of identity may be invalid)&lt;br&gt; - INVALID_SIGNATURE: error: the proof of signature is invalid&lt;br&gt; - any other verification status code: the proof of timestamp is not ready or invalid  |  [optional]
**text** | **String** | Proof receipt verification status text giving more insight about verification errors. |  [optional]
**timestamp** | **Long** | Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).  |  [optional]
**confirmations** | **Integer** | Number of confirmations of the Bitcoin block into which the anchoring process occurred. |  [optional]
**timestampVerificationStatus** | [**TimestampVerificationStatus**](TimestampVerificationStatus.md) |  |  [optional]
**signatureVerificationStatus** | [**SignatureVerificationStatus**](SignatureVerificationStatus.md) |  |  [optional]
**identityVerificationStatus** | [**IdentityVerificationStatus**](IdentityVerificationStatus.md) |  |  [optional]



## Enum: CodeEnum

Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
TX_NOT_SENT | &quot;TX_NOT_SENT&quot;
TX_NOT_CONFIRMED | &quot;TX_NOT_CONFIRMED&quot;
INVALID_PROOF | &quot;INVALID_PROOF&quot;
TX_NOT_FOUND | &quot;TX_NOT_FOUND&quot;
TX_MISMATCH_RECEIPT | &quot;TX_MISMATCH_RECEIPT&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;



