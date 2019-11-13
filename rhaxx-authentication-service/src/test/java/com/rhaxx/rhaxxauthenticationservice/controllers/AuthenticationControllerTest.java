package com.rhaxx.rhaxxauthenticationservice.controllers;

import com.netflix.discovery.shared.Application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class AuthenticationControllerTest {

    // @LocalServerPort
    private int port = 8081;

    @Test
	public void testGetAllCredentials() {
		given()
			.port(port)
			.when()
			.get("/credential/all")
			.then()
			.statusCode(200);
	}

}