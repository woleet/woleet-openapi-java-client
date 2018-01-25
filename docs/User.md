
# User

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | User identifier. It is allocated by the platform, and so must not be provided at creation time.  |  [optional]
**email** | **String** | Email of the user.  | 
**password** | **String** | Password of the user (it must be provided at creation time).  | 
**roles** | [**List&lt;RolesEnum&gt;**](#List&lt;RolesEnum&gt;) | The roles of the user:&lt;br&gt; - ROLE_USER: regular user&lt;br&gt; - ROLE_DOMAIN_ADMIN: domain administrator.  | 
**info** | **Map&lt;String, Object&gt;** | Object storing meta data about the user. Some property names are reserved, but properties are not limitted to the one listed here.  | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the user:&lt;br&gt; - PENDING: the user email need to be validated&lt;br&gt; - APPROVED: the user can loging&lt;br&gt; - DISABLED: the user cannot login  | 
**created** | **Long** | Date of creation (in ms since Unix epoch).  |  [optional]
**lastModified** | **Long** | Date of last modification (in ms since Unix epoch).  |  [optional]


<a name="List<RolesEnum>"></a>
## Enum: List&lt;RolesEnum&gt;
Name | Value
---- | -----
USER | &quot;ROLE_USER&quot;
DOMAIN_ADMIN | &quot;ROLE_DOMAIN_ADMIN&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;PENDING&quot;
APPROVED | &quot;APPROVED&quot;
DISABLED | &quot;DISABLED&quot;



