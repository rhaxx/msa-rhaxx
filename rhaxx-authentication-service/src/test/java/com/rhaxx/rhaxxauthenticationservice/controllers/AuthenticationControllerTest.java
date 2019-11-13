package com.rhaxx.rhaxxauthenticationservice.controllers;

import com.netflix.discovery.shared.Application;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

// import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = { Application.class })
public class AuthenticationControllerTest {

    @Test
	public void testGetplayerById() {
		when().request("GET", "http://localhost:8082/authentication/player/all").then().statusCode(200);
		/*
		get("http://localhost:8082/authentication/player/1000")
		.then()
		.statusCode(200)
		.assertThat()
		.body("playerId", equalTo(1000));
		*/
	}
	
}