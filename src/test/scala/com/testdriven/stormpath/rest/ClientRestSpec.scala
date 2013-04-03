package com.testdriven.stormpath.rest

import org.scalatest.matchers.ShouldMatchers
import org.scalatest._
import com.jayway.restassured.RestAssured._
import com.jayway.restassured.matcher.RestAssuredMatchers._
import org.hamcrest.Matchers._
import com.jayway.restassured.RestAssured
import com.testdriven.stormpath.fixtures.TestConfig

class ClientRestSpec extends RestSpec with FlatSpec with ShouldMatchers {

  "test1" should "do" in {
     given().
        expect().statusCode(200).
        body("name", equalTo( TestConfig.tenantName )).
     when().
       get("/tenants/current")
  }

}