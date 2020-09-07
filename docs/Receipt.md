

# Receipt

A Chainpoint 2.x proof receipt
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **String** | Type of proof receipt. |  [optional]
**targetHash** | **String** | SHA256 hash of the proven data or signature. |  [optional]
**merkleRoot** | **String** | Root of the Merkle tree. |  [optional]
**proof** | [**List&lt;ReceiptProofNode&gt;**](ReceiptProofNode.md) | Merkle proof (path from &#x60;targetHash&#x60; to &#x60;merkleRoot&#x60; in the Merkle tree). |  [optional]
**anchors** | [**List&lt;ReceiptAnchorsNode&gt;**](ReceiptAnchorsNode.md) | List of sources where the root of the Merkle proof is anchored. |  [optional]
**signature** | [**ReceiptSignature**](ReceiptSignature.md) |  |  [optional]



