package com.testdriven.stormpath

import org.scalatest._
import com.testdriven.stormpath.fixtures._
import com.stormpath.sdk.client._
import com.testdriven.stormpath.ClientRef

class ClientSpec extends FlatSpec with ShouldMatchers {
  
  val conf = TestConfig.conf
  val client =  ClientRef.client
   
  "Client" should "have current tenant" in {
    val currentTenant = client.getCurrentTenant 
    assert(currentTenant != null)
  }
  
  it should "have a datastore" in {
    assert(client.getDataStore() != null)
  }

}