package com.testdriven.stormpath

import org.scalatest.FlatSpec

class CleanupSpec extends FlatSpec {
  
  "All test data" should "be deleted" in {
      SampleData.deleteAll()
  }

}