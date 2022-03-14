

# SignatureRequestEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**signeeId** | **String** | Secret identifier of the signer (provided by email). | 
**type** | [**TypeEnum**](#TypeEnum) | Type of the event to report: - DATA_VERIFIED: the signer verified the integrity (ie. hash) of the data to sign - DATA_REVIEWED: the signer reviewed and acceted the data to sign - TCU_ACCEPTED: the signer reviewed and accepted the TCU - TCU_REFUSED: the signer refused the TCU - SIGN_ACCEPTED: the signer accepted to sign the data - SIGN_REFUSED: the signer refused to sign the data  | 
**comment** | **String** | Comment related to the event to report. |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
DATA_VERIFIED | &quot;DATA_VERIFIED&quot;
DATA_REVIEWED | &quot;DATA_REVIEWED&quot;
TCU_ACCEPTED | &quot;TCU_ACCEPTED&quot;
TCU_REFUSED | &quot;TCU_REFUSED&quot;
SIGN_ACCEPTED | &quot;SIGN_ACCEPTED&quot;
SIGN_REFUSED | &quot;SIGN_REFUSED&quot;



