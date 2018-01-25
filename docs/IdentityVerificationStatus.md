
# IdentityVerificationStatus

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Identity verification status code:&lt;br&gt; - VERIFIED: the identity is verified: the identity URL succeeded to sign a secret using the proof receipt&#39;s &#x60;pubKey&#x60; public key&lt;br&gt; - HTTP_ERROR: the identity URL returned an HTTP error&lt;br&gt; - INVALID_SIGNATURE: the identity URL returned an invalid signature (and thus failed to prove the ownership of the proof receipt&#39;s &#x60;pubKey&#x60; public key)  |  [optional]
**text** | **String** | Identity verification status text giving more insight about verification errors. |  [optional]
**certificates** | [**List&lt;X509SubjectIssuer&gt;**](X509SubjectIssuer.md) | Array of X500 subject and issuer distinguished names of all X509 certificates of the identity URL. |  [optional]


<a name="CodeEnum"></a>
## Enum: CodeEnum
Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
HTTP_ERROR | &quot;HTTP_ERROR&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;


