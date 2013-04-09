package com.testdriven.stormpath.rest

import org.scalatest.Suites
import com.testdriven.stormpath._
import org.scalatest.BeforeAndAfter

class AllSuites extends Suites (
  new ClientRestSpec,
  new CreateApplicationRestSpec,
  /*Java SDK Tests*/
  new ApplicationSpec,
  new ClientSpec,
  new TenantSpec,
  //This is a bit of a hack, but seems to work for now.
  new CleanupSpec
)