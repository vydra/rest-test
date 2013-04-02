package com.testdriven

import com.stormpath.sdk.client._
object Main extends App {
  println("user.home: " + System.getProperty("user.home"))

  val path = System.getProperty("user.home") + "/.stormpath/apiKey.properties"
  val client = new ClientBuilder().setApiKeyFileLocation(path).build()
  val tenant = client.getCurrentTenant()
  println("Current tenant: " + tenant)
  
  val applications = tenant.getApplications()
  val iter = applications.iterator()
  while(iter.hasNext) {
        val app = iter.next
        val desc = app.getDescription
        println("'"+desc+"'")
        if(desc == "") {
          app.setDescription("foo")
          app.save()
        }
  }
}