package com.testdriven.stormpath

import scala.collection.JavaConversions._
import org.scalatest._
import com.stormpath.sdk.client.ClientBuilder
import com.testdriven.stormpath.fixtures.ClientRef

class ApplicationSpec extends FlatSpec with ShouldMatchers {
  
  "Default Stormpath Application" should "exist" in {
    val currentTenant = ClientRef.client.getCurrentTenant
    val apps  = currentTenant.getApplications().iterator.toList
    val appNames = apps.map(_.getName())
    assert(appNames.contains("Stormpath"))
    
  }

}