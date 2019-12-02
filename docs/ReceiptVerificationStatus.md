

# ReceiptVerificationStatus

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified&lt;br&gt; The receipt format is valid, the transaction is present in the Bitcoin blockchain and confirmed at least once, the receipt contains a valid Merkle proof linking its &#x60;targetHash&#x60; property to the transaction&#39;s &#x60;OP_RETURN&#x60; field.&lt;br&gt; The creation time and the number of confirmation of the block containing the transaction is returned in the &#x60;timestamp&#x60; and &#x60;confirmations&#x60; properties.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to exist at that time and has not been modified since.&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not include a valid Bitcoin transaction&lt;br&gt; - TX_NOT_CONFIRMED: the transaction is not yet confirmed by the blockchain (ie. not yet included in a block)&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature  |  [optional]
**text** | **String** | Proof receipt verification status text giving more insight about verification errors. |  [optional]
**timestamp** | **Long** | Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).&lt;br&gt; Any data whose SHA256 hash equals this proof receipt&#39;s target hash property is proven to exist at that time and has not been modified since.  |  [optional]
**confirmations** | **Integer** | Number of confirmations of the Bitcoin block into which the anchoring process occurred. |  [optional]
**identityVerificationStatus** | [**IdentityVerificationStatus**](IdentityVerificationStatus.md) |  |  [optional]



## Enum: CodeEnum

Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
INVALID_PROOF | &quot;INVALID_PROOF&quot;
TX_NOT_FOUND | &quot;TX_NOT_FOUND&quot;
TX_NOT_CONFIRMED | &quot;TX_NOT_CONFIRMED&quot;
TX_MISMATCH_RECEIPT | &quot;TX_MISMATCH_RECEIPT&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;



