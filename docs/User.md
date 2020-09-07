

# User

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | User identifier. It is allocated by the platform, and so must not be provided at creation time. |  [optional] [readonly]
**created** | **Long** | Date of creation (in milliseconds since Unix epoch). |  [optional] [readonly]
**lastModified** | **Long** | Date of last modification (in milliseconds since Unix epoch). |  [optional] [readonly]
**email** | **String** | Email of the user. | 
**password** | **String** | Password of the user (it must be provided at creation time). | 
**roles** | [**List&lt;RolesEnum&gt;**](#List&lt;RolesEnum&gt;) | Array of user roles. | 
**info** | [**Info**](Info.md) |  | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the user:&lt;br&gt; - PENDING: the user email need to be validated&lt;br&gt; - APPROVED: the user can loging&lt;br&gt; - DISABLED: the user cannot login  | 



## Enum: List&lt;RolesEnum&gt;

Name | Value
---- | -----
USER | &quot;ROLE_USER&quot;
DOMAIN_ADMIN | &quot;ROLE_DOMAIN_ADMIN&quot;



## Enum: StatusEnum

Name | Value
---- | -----
PENDING | &quot;PENDING&quot;
APPROVED | &quot;APPROVED&quot;
DISABLED | &quot;DISABLED&quot;



