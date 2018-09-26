/*
 * Woleet API
 * Welcome to **Woleet API reference documentation**.<br> It is highly recommanded to read the chapters **[introducing Woleet API concepts](https://doc.woleet.io/v1.5.1/reference)** before reading this documentation. 
 *
 * OpenAPI spec version: 1.5.2
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.woleet.api.client;

import io.woleet.api.ApiException;
import io.woleet.api.client.model.Credits;
import io.woleet.api.client.model.Tokens;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

    private final UserApi api = new UserApi();

    
    /**
     * Get user&#39;s anchoriong credits.
     *
     * Use this operation to get the remaining anchoring credits of the authenticated user.&lt;br&gt; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCreditsTest() throws ApiException {
        Credits response = api.getCredits();

        // TODO: test validations
    }
    
    /**
     * Get user&#39;s tokens.
     *
     * Use this operation to get a list of tokens of the authenticated user. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTokensTest() throws ApiException {
        List<String> response = api.getTokens();

        // TODO: test validations
    }
    
    /**
     * Update user&#39;s tokens.
     *
     * Use this operation to set the list of tokens of the authenticated user. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void putTokensTest() throws ApiException {
        Tokens tokens = null;
        api.putTokens(tokens);

        // TODO: test validations
    }
    
}
