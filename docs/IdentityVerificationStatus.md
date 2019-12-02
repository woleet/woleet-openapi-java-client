

# IdentityVerificationStatus

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Identity verification status code:&lt;br&gt; - VERIFIED: the key is controlled by the identity server,&lt;br&gt; and/or the key is associated to an identity on the identity server,&lt;br&gt; and/or the identity is included in the anchored signature,&lt;br&gt; and/or the signed identity matches the one claimed by the identity server,&lt;br&gt; - IDENTITY_MISMATCH: the identity included in the anchored signature mismatch the identity claimed by the identity server&lt;br&gt; - INVALID_SIGNATURE: the identity URL returned an invalid signature (ie. the identity server failed to prove that it owns the private part of key pair)&lt;br&gt; - HTTP_ERROR: the identity URL returned an HTTP error - DEPRECATED_KEY: the key expired or was revoked before the signature timestamp.  |  [optional]
**text** | **String** | Identity verification status text (gives more insights about the verification process). |  [optional]
**certificates** | [**List&lt;X509SubjectIssuer&gt;**](X509SubjectIssuer.md) | Array of subjects and issuers of the certificates extracted from the identity URL&#39;s TLS certificate. |  [optional]
**identity** | [**Identity**](Identity.md) |  |  [optional]
**signedIdentity** | [**Identity**](Identity.md) |  |  [optional]
**signedIssuerDomain** | **String** | Domain name of the identity issuer (ie. of the organization who verified the identity). |  [optional]
**key** | [**Key**](Key.md) |  |  [optional]



## Enum: CodeEnum

Name | Value
---- | -----
VERIFIED | &quot;VERIFIED&quot;
HTTP_ERROR | &quot;HTTP_ERROR&quot;
IDENTITY_MISMATCH | &quot;IDENTITY_MISMATCH&quot;
INVALID_SIGNATURE | &quot;INVALID_SIGNATURE&quot;
DEPRECATED_KEY | &quot;DEPRECATED_KEY&quot;



