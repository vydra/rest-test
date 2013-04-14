package com.testdriven.stormpath.rest

import org.scalatest.matchers.ShouldMatchers
import org.scalatest._
import com.jayway.restassured.RestAssured._
import com.jayway.restassured.matcher.RestAssuredMatchers._
import org.hamcrest.Matchers._
import com.jayway.restassured.RestAssured
import com.testdriven.stormpath.fixtures.TestConfig

class ClientRestSpec extends MyRestAssuredConfig with FlatSpec with ShouldMatchers {

  "Current tenant" should "be correct" in {
     given().   //log().all().
     expect().   //log().all().
          statusCode(200).
          header("Set-Cookie", startsWith("rememberMe=deleteMe; Path=/; Max-Age=0; Expires=")).
          body("name", equalTo( TestConfig.tenantName )).
     when().
       get("/tenants/current")
  }
}