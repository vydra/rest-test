package com.testdriven.stormpath

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import com.testdriven.stormpath.fixtures._
import com.testdriven.stormpath.ClientRef

class TenantSpec extends FlatSpec with ShouldMatchers {
  val conf = TestConfig.conf
  
  "Current tenant" should "have" in {
    val currentTenant = ClientRef.client.getCurrentTenant 
    assert(currentTenant != null)
    assert(currentTenant.getHref === TestConfig.tenantHref)
    assert(currentTenant.getName === TestConfig.tenantName)
  }
}