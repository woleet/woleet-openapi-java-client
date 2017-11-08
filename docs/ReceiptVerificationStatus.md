
# ReceiptVerificationStatus

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Proof receipt verification status code:&lt;br&gt; - VERIFIED: the proof receipt is verified: the receipt format is valid, the associated Bitcoin transaction is present in the blockchain, and the receipt contains a valid cryptographic proof that its &#x60;targetHash&#x60; property is anchored into the transaction&#39;s &#x60;OP_RETURN&#x60; field. The time of the Bitcoin block into which the anchoring process occurred is returned in the &#x60;timestamp&#x60; property.&lt;br&gt; Any data whose SHA256 hash matches the proof receipt&#39;s &#x60;targetHash&#x60; is proven to be existent at that time and unmodified.&lt;br&gt; - INVALID_PROOF: the receipt&#39;s &#x60;proof&#x60; property is not a valid Merkle proof&lt;br&gt; - TX_NOT_FOUND: the receipt&#39;s &#x60;anchors&#x60; property does not point to a valid Bitcoin transaction&lt;br&gt; - TX_MISMATCH_RECEIPT: the receipt&#39;s &#x60;merkleRoot&#x60; property does not match the transaction&#39;s &#x60;OP_RETURN&#x60; field&lt;br&gt; - INVALID_SIGNATURE: the receipt&#39;s &#x60;signature&#x60; property is not a valid signature&lt;br&gt;  |  [optional]
**text** | **String** | Proof receipt verification status text giving more insight about verification errors. |  [optional]
**timestamp** | **Long** | Proven timestamp of the data (for a data anchor) or of the signature (for a signature anchor).&lt;br&gt; This is actually the time of the Bitcoin block into which the anchoring process occurred (in milliseconds since Unix epoch).&lt;br&gt; Any data whose SHA256 hash equals this proof receipt&#39;s target hash property is proven to be existent at that time and unmodified.  |  [optional]
**confirmations** | **Integer** | Number of confirmations of the Bitcoin block into which the anchoring process occurred. |  [optional]
**identityVerificationStatus** | [**IdentityVerificationStatus**](IdentityVerificationStatus.md) |  |  [optional]


<a name="CodeEnum"></a>
## Enum: CodeEnum
Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
INVALID_PROOF | &quot;INVALID_PROOF&quot;
TX_NOT_FOUND | &quot;TX_NOT_FOUND&quot;
TX_MISMATCH_RECEIPT | &quot;TX_MISMATCH_RECEIPT&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;



