package com.ing.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ing.IngUserManagementApplication;
import com.ing.model.dto.UserDto;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {IngUserManagementApplication.class})
public class UserManagementControllerTest {
	@Rule
	public PactProviderRuleMk2 mockProvider
	  = new PactProviderRuleMk2("test_provider", "localhost", 8080, this);
	
	@Pact(consumer = "test_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return builder
          .given("test GET")
            .uponReceiving("GET REQUEST")
            .path("/pact")
            .method("GET")
          .willRespondWith()
            .status(200)
            .headers(headers)
            .body("{\"condition\": true, \"name\": \"tom\"}")
          .given("test POST")
            .uponReceiving("POST REQUEST")
            .method("POST")
            .headers(headers)
            .body("{\"username\": \"test-user\"}")
            .path("/users/save")
          .willRespondWith()
            .status(201)
          .toPact();
    }
	
	@Test
	@PactVerification
	public void givenDatabaseIsDownJMSBrokerIsInvoked() {
//		mockProvider.
	    ResponseEntity response = new RestTemplate()
	      .postForEntity(mockProvider.getUrl() + "/users/save", new UserDto(), ResponseEntity.class);
	    //  Should get a 200 regardless
	    Assert.assertEquals(200, response.getStatusCode().value());
	}
	
}
