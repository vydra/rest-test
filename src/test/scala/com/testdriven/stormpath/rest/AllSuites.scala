package com.testdriven.stormpath.rest

import org.scalatest.Suites
import com.testdriven.stormpath._
import org.scalatest.BeforeAndAfter
import org.scalatest.BeforeAndAfterAll

class AllSuites extends Suites(
  new ClientRestSpec,
  new CreateApplicationRestSpec,
  /*Java SDK Tests*/
  new ApplicationSpec,
  new ClientSpec,
  new TenantSpec
)  
with BeforeAndAfterAll {
  override def afterAll(configMap: Map[String, Any]) {
    SampleData.deleteAll
  }
}