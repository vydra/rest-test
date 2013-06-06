package com.testdriven.stormpath

import scala.collection.JavaConversions.asScalaIterator
import org.scalatest.BeforeAndAfterAll
import org.scalatest.ShouldMatchers
import com.stormpath.sdk.application.Application
import com.testdriven.stormpath.fixtures.TestConfig

class ApplicationSpec extends BaseSpec {

  "Default Stormpath Application" should "exist" in {

    val apps = currentTenant.getApplications().iterator.toList
    val appNames = apps.map(_.getName)
    assert(appNames.contains("Stormpath"))

  }

  "Adding a new application" should "succeed" in {
    val application = dataStore.instantiate(classOf[Application])
    application.setName("TestAppXYZ")
    application.setDescription("Test Application XYZ")

    currentTenant.createApplication(application)
  }

  it should "throw ResourceException if duplicate" in {

    evaluating {
      val application = dataStore.instantiate(classOf[Application])
      application.setName("TestAppXYZ")
      application.setDescription("Test Application XYZ")
      currentTenant.createApplication(application)
    } should produce[com.stormpath.sdk.resource.ResourceException]
  }
  
  
}