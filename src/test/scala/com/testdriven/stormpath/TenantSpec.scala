package com.testdriven.stormpath

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import com.testdriven.stormpath.fixtures._

class TenantSpec extends BaseSpec {
  val conf = TestConfig.conf
  
  "Current tenant" should "have" in {
    val currentTenant = ClientRef.newClient.getCurrentTenant 
    assert(currentTenant != null)
    assert(currentTenant.getHref === TestConfig.tenantHref)
    assert(currentTenant.getName === TestConfig.tenantName)
  }
}