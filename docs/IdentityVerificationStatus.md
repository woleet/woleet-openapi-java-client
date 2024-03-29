

# IdentityVerificationStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Identity verification status code: - VERIFIED: success: the signature key is controlled by the identity server (ie. the server provided a valid proof of ownership of the key),&lt;br&gt; and/or the signature key matches an identity on the identity server (ie. the server claimed the signer identity),&lt;br&gt; and/or the identity is signed (ie. the signer claimed his identity by including it in the signed data),&lt;br&gt; and/or the signed identity matches the one on the identity server (both the signer and the identity server claim the identity) - HTTP_ERROR: error: the identity URL cannot be called or returned an HTTP error other than 404 - IDENTITY_NOT_FOUND: error: the key does not match any identity on the identity server (ie. the identity URL returned a HTTP error 404) - IDENTITY_MISMATCH: error: the signed identity mismatches the identity on the identity server - INVALID_SIGNATURE: error: the identity server returned an invalid signature (ie. the server failed to provide a valid proof of ownership of the key) - DEPRECATED_KEY: error: the key expired or was revoked before the signature timestamp  |  [optional]
**text** | **String** | Identity verification status text (gives more insights about the verification process). |  [optional]
**certificates** | [**List&lt;X509SubjectIssuer&gt;**](X509SubjectIssuer.md) | Array of subjects and issuers of the certificates extracted from the identity URL&#39;s TLS certificate. |  [optional]
**identity** | [**Identity**](Identity.md) |  |  [optional]
**signedIdentity** | [**SignedIdentity**](SignedIdentity.md) |  |  [optional]
**key** | [**Key**](Key.md) |  |  [optional]



## Enum: CodeEnum

Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
HTTP_ERROR | &quot;HTTP_ERROR&quot;
IDENTITY_NOT_FOUND | &quot;IDENTITY_NOT_FOUND&quot;
IDENTITY_MISMATCH | &quot;IDENTITY_MISMATCH&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;
DEPRECATED_KEY | &quot;DEPRECATED_KEY&quot;



