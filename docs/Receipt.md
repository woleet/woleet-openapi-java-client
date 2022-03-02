

# Receipt

A proof receipt:<br> - the proof of timestamp is provided as a Chainpoint 2.x proof receipt.<br> - the proof of signature (if applicable) is provided in the `signature` property.<br> If the proof receipt is partial (ie. does not contain the proof of timestamp) Chainpoint 2.x properties are not provided. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**targetHash** | **String** | Chainpoint 2.x: SHA256 hash of the proven data or signature.  |  [optional]
**type** | **String** | Chainpoint 2.x: Type of the proof receipt.&lt;br&gt; **Currently only &#39;ChainpointSHA256v2&#39; is supported.**  |  [optional]
**merkleRoot** | **String** | Chainpoint 2.x: Root of the Merkle tree.  |  [optional]
**proof** | [**List&lt;ReceiptProofNode&gt;**](ReceiptProofNode.md) | Chainpoint 2.x: Merkle proof (path from &#x60;targetHash&#x60; to &#x60;merkleRoot&#x60; in the Merkle tree).  |  [optional]
**anchors** | [**List&lt;ReceiptAnchorsNode&gt;**](ReceiptAnchorsNode.md) | Chainpoint 2.x: List of sources where the root of the Merkle proof is anchored.  |  [optional]
**partial** | **Boolean** | &#x60;true&#x60; if the receipt is a partial receipt (ie. does not contain the Chainpoint 2.x proof of timestamp).  |  [optional]
**signature** | [**ReceiptSignature**](ReceiptSignature.md) |  |  [optional]



