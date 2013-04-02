package com.testdriven.stormpath

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import com.testdriven.stormpath.fixtures._

class TenantSpec extends FlatSpec with ShouldMatchers {
  val conf = Config.conf
  
  "Current tenant" should "have" in {
    val currentTenant = ClientRef.client.getCurrentTenant 
    assert(currentTenant != null)
    assert(currentTenant.getHref === conf.getString("currentTenant.href"))
    assert(currentTenant.getName === conf.getString("currentTenant.name"))
  }
}