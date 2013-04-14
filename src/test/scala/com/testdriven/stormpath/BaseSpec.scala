package com.testdriven.stormpath

import org.scalatest.BeforeAndAfterAll
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

abstract class BaseSpec extends FlatSpec with ShouldMatchers with BeforeAndAfterAll  {
  
  val client = ClientRef.newClient
  val currentTenant = client.getCurrentTenant
  val dataStore = client.getDataStore
  
  override def afterAll(configMap: Map[String, Any]) {
    SampleData.deleteAll
  }
  
}