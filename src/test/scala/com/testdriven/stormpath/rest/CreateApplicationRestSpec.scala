package com.testdriven.stormpath.rest

import org.scalatest.matchers.ShouldMatchers
import org.scalatest._
import com.jayway.restassured.RestAssured._
import com.jayway.restassured.matcher.RestAssuredMatchers._
import org.hamcrest.Matchers._
import com.jayway.restassured.RestAssured
import com.testdriven.stormpath.fixtures.TestConfig
import scala.util.Random

class CreateApplicationRestSpec extends MyRestAssuredConfig with FlatSpec with ShouldMatchers {
  /*
   * POST https://api.stormpath.com/v1/applications
  Content-Type: application/json

  {
    "name": "Best application ever",
    "description": "A new description.",
    "status": "enabled"
  }
   */
  
  //Note: application name must be unique
  "creating and application" should "return 201" in {
    val appName = "App" +  new Random().nextInt
    given().
         body("""{
                  "name": """" + appName + """",
                  "description": "A new description.",
                  "status": "enabled"
                 }""").
    expect().
         statusCode(201).
    when().
         post("/applications")
  }
  
  "creating and application" should "return 409" in {
    val appName = "Stormpath"
    given().
         body("""{
                  "name": """" + appName + """",
                  "description": "A new description.",
                  "status": "enabled"
                 }""").
    expect().
         statusCode(409).
         body("code", equalTo( 409 )).
    when().
         post("/applications")
  }
  
  "creating and application with malformed req body" should "return 500. Really?" in {
    val appName = "Stormpath"
    given().
         body("""
                  "name": """" + appName + """",
                  "description": "A new description.",
                  "status": "enabled"
                 """).
    expect().
         statusCode(500).
         body("code", equalTo( 500 )).
    when().
         post("/applications")
  }
  
  "creating and application with params instead of request body w/Json" should "return 400" in {
    val appName = "Stormpath"
    given().
         params("name", appName,
                "description", "A new description.",
                "status", "enabled").
    expect().
         statusCode(400).
         body("code", equalTo( 400 )).
    when().
         post("/applications")
  }

}