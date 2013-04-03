package com.testdriven.stormpath.rest

import com.jayway.restassured.RestAssured
import com.jayway.restassured.RestAssured._
import com.testdriven.stormpath.fixtures.TestConfig

trait RestSpec {
  
  val username = TestConfig.apiKeyConf.getString("apiKey.id")
  val password = TestConfig.apiKeyConf.getString("apiKey.secret")
  
  RestAssured.baseURI = "https://api.stormpath.com"
  RestAssured.basePath = "/v1"
  RestAssured.authentication = basic(username, password)
  RestAssured.requestContentType("application/json")

}