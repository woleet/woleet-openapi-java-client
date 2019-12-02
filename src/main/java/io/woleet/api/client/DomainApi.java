/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/reference)** before reading this documentation. 
 *
 * The version of the OpenAPI document: 1.6.2
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.api.client;

import io.woleet.api.ApiCallback;
import io.woleet.api.ApiClient;
import io.woleet.api.ApiException;
import io.woleet.api.ApiResponse;
import io.woleet.api.Configuration;
import io.woleet.api.Pair;
import io.woleet.api.ProgressRequestBody;
import io.woleet.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.woleet.api.client.model.User;
import io.woleet.api.client.model.Users;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainApi {
    private ApiClient localVarApiClient;

    public DomainApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DomainApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createDomainUser
     * @param user User object to create (password must be provided). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The created user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createDomainUserCall(User user, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/domain/admin/user";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createDomainUserValidateBeforeCall(User user, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling createDomainUser(Async)");
        }
        

        okhttp3.Call localVarCall = createDomainUserCall(user, _callback);
        return localVarCall;

    }

    /**
     * Create a new domain user.
     * Use this operation to create a new domain user.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;info&#x60; and &#x60;status&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned user. 
     * @param user User object to create (password must be provided). (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The created user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public User createDomainUser(User user) throws ApiException {
        ApiResponse<User> localVarResp = createDomainUserWithHttpInfo(user);
        return localVarResp.getData();
    }

    /**
     * Create a new domain user.
     * Use this operation to create a new domain user.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;info&#x60; and &#x60;status&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned user. 
     * @param user User object to create (password must be provided). (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The created user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<User> createDomainUserWithHttpInfo(User user) throws ApiException {
        okhttp3.Call localVarCall = createDomainUserValidateBeforeCall(user, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a new domain user. (asynchronously)
     * Use this operation to create a new domain user.&lt;br&gt; The properties &#x60;id&#x60;, &#x60;created&#x60;, &#x60;lastModified&#x60;, &#x60;info&#x60; and &#x60;status&#x60; are read-only and so must not be provided: they are managed by the platform and added to the returned user. 
     * @param user User object to create (password must be provided). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The created user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createDomainUserAsync(User user, final ApiCallback<User> _callback) throws ApiException {

        okhttp3.Call localVarCall = createDomainUserValidateBeforeCall(user, _callback);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteDomainUser
     * @param userId Identifier of the domain user to delete. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user is deleted. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteDomainUserCall(String userId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userId}"
            .replaceAll("\\{" + "userId" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteDomainUserValidateBeforeCall(String userId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling deleteDomainUser(Async)");
        }
        

        okhttp3.Call localVarCall = deleteDomainUserCall(userId, _callback);
        return localVarCall;

    }

    /**
     * Delete a domain user.
     * Use this operation to delete a domain user.
     * @param userId Identifier of the domain user to delete. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user is deleted. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public void deleteDomainUser(String userId) throws ApiException {
        deleteDomainUserWithHttpInfo(userId);
    }

    /**
     * Delete a domain user.
     * Use this operation to delete a domain user.
     * @param userId Identifier of the domain user to delete. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user is deleted. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteDomainUserWithHttpInfo(String userId) throws ApiException {
        okhttp3.Call localVarCall = deleteDomainUserValidateBeforeCall(userId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete a domain user. (asynchronously)
     * Use this operation to delete a domain user.
     * @param userId Identifier of the domain user to delete. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user is deleted. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteDomainUserAsync(String userId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteDomainUserValidateBeforeCall(userId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getDomainUser
     * @param userId Identifier of the domain user to retrieve. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getDomainUserCall(String userId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userId}"
            .replaceAll("\\{" + "userId" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getDomainUserValidateBeforeCall(String userId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling getDomainUser(Async)");
        }
        

        okhttp3.Call localVarCall = getDomainUserCall(userId, _callback);
        return localVarCall;

    }

    /**
     * Get a domain user by its identifier.
     * Use this operation to retrieve a domain user by its identifier.
     * @param userId Identifier of the domain user to retrieve. (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public User getDomainUser(String userId) throws ApiException {
        ApiResponse<User> localVarResp = getDomainUserWithHttpInfo(userId);
        return localVarResp.getData();
    }

    /**
     * Get a domain user by its identifier.
     * Use this operation to retrieve a domain user by its identifier.
     * @param userId Identifier of the domain user to retrieve. (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<User> getDomainUserWithHttpInfo(String userId) throws ApiException {
        okhttp3.Call localVarCall = getDomainUserValidateBeforeCall(userId, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a domain user by its identifier. (asynchronously)
     * Use this operation to retrieve a domain user by its identifier.
     * @param userId Identifier of the domain user to retrieve. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The user. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getDomainUserAsync(String userId, final ApiCallback<User> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDomainUserValidateBeforeCall(userId, _callback);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for searchDomainUsers
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are &#x60;email&#x60;, &#x60;created&#x60;, &#x60;roles&#x60;, &#x60;info.firstName&#x60;, &#x60;info.lastName&#x60;, &#x60;status&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string of the email.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> An array of all users matching all search criteria, plus additional paging and sorting information. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call searchDomainUsersCall(Integer page, Integer size, String direction, String sort, String email, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/domain/admin/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (size != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("size", size));
        }

        if (direction != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("direction", direction));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (email != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("email", email));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call searchDomainUsersValidateBeforeCall(Integer page, Integer size, String direction, String sort, String email, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = searchDomainUsersCall(page, size, direction, sort, email, _callback);
        return localVarCall;

    }

    /**
     * Search for domain users.
     * Use this operation to list all domain users or search for domain users given their email.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are &#x60;email&#x60;, &#x60;created&#x60;, &#x60;roles&#x60;, &#x60;info.firstName&#x60;, &#x60;info.lastName&#x60;, &#x60;status&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string of the email.  (optional)
     * @return Users
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> An array of all users matching all search criteria, plus additional paging and sorting information. </td><td>  -  </td></tr>
     </table>
     */
    public Users searchDomainUsers(Integer page, Integer size, String direction, String sort, String email) throws ApiException {
        ApiResponse<Users> localVarResp = searchDomainUsersWithHttpInfo(page, size, direction, sort, email);
        return localVarResp.getData();
    }

    /**
     * Search for domain users.
     * Use this operation to list all domain users or search for domain users given their email.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are &#x60;email&#x60;, &#x60;created&#x60;, &#x60;roles&#x60;, &#x60;info.firstName&#x60;, &#x60;info.lastName&#x60;, &#x60;status&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string of the email.  (optional)
     * @return ApiResponse&lt;Users&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> An array of all users matching all search criteria, plus additional paging and sorting information. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Users> searchDomainUsersWithHttpInfo(Integer page, Integer size, String direction, String sort, String email) throws ApiException {
        okhttp3.Call localVarCall = searchDomainUsersValidateBeforeCall(page, size, direction, sort, email, null);
        Type localVarReturnType = new TypeToken<Users>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Search for domain users. (asynchronously)
     * Use this operation to list all domain users or search for domain users given their email.&lt;br&gt; Paging and sorting is supported. 
     * @param page Index of the page to retrieve (from 0). (optional, default to 0)
     * @param size Number of users per page. (optional, default to 20)
     * @param direction Sorting direction: ASC for ascending DESC for descending.  (optional, default to ASC)
     * @param sort Sorting property: possible values are &#x60;email&#x60;, &#x60;created&#x60;, &#x60;roles&#x60;, &#x60;info.firstName&#x60;, &#x60;info.lastName&#x60;, &#x60;status&#x60;.  (optional, default to created)
     * @param email email to search for: a sub-string of the email.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> An array of all users matching all search criteria, plus additional paging and sorting information. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call searchDomainUsersAsync(Integer page, Integer size, String direction, String sort, String email, final ApiCallback<Users> _callback) throws ApiException {

        okhttp3.Call localVarCall = searchDomainUsersValidateBeforeCall(page, size, direction, sort, email, _callback);
        Type localVarReturnType = new TypeToken<Users>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateDomainUser
     * @param userId Identifier of the domain user to update. (required)
     * @param user User object to update. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateDomainUserCall(String userId, User user, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = user;

        // create path and map variables
        String localVarPath = "/domain/admin/user/{userId}"
            .replaceAll("\\{" + "userId" + "\\}", localVarApiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "BasicAuth", "JWTAuth" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateDomainUserValidateBeforeCall(String userId, User user, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling updateDomainUser(Async)");
        }
        
        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException("Missing the required parameter 'user' when calling updateDomainUser(Async)");
        }
        

        okhttp3.Call localVarCall = updateDomainUserCall(userId, user, _callback);
        return localVarCall;

    }

    /**
     * Update a domain user.
     * Use this operation to update a domain user.
     * @param userId Identifier of the domain user to update. (required)
     * @param user User object to update. (required)
     * @return User
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public User updateDomainUser(String userId, User user) throws ApiException {
        ApiResponse<User> localVarResp = updateDomainUserWithHttpInfo(userId, user);
        return localVarResp.getData();
    }

    /**
     * Update a domain user.
     * Use this operation to update a domain user.
     * @param userId Identifier of the domain user to update. (required)
     * @param user User object to update. (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<User> updateDomainUserWithHttpInfo(String userId, User user) throws ApiException {
        okhttp3.Call localVarCall = updateDomainUserValidateBeforeCall(userId, user, null);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update a domain user. (asynchronously)
     * Use this operation to update a domain user.
     * @param userId Identifier of the domain user to update. (required)
     * @param user User object to update. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated user. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid user object. More details are returned in the response body as a JSON object. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No user matching the given identifier. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateDomainUserAsync(String userId, User user, final ApiCallback<User> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateDomainUserValidateBeforeCall(userId, user, _callback);
        Type localVarReturnType = new TypeToken<User>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
