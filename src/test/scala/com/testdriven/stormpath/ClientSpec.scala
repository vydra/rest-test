package com.testdriven.stormpath

import org.scalatest._
import com.testdriven.stormpath.fixtures._
import com.stormpath.sdk.client._

class ClientSpec extends BaseSpec {
  
  "Client" should "have current tenant" in {
    val currentTenant = client.getCurrentTenant 
    assert(currentTenant != null)
  }
  
  it should "have a datastore" in {
    assert(client.getDataStore() != null)
  }

}