package com.testdriven.stormpath

import scala.collection.convert.WrapAsScala._

import com.stormpath.sdk.client.DefaultApiKey
import com.stormpath.sdk.application._
import com.stormpath.sdk.impl.ds.DefaultDataStore
import com.stormpath.sdk.impl.http.httpclient.HttpClientRequestExecutor
import com.testdriven.stormpath.fixtures.ClientRef
import com.testdriven.stormpath.rest.MyRestAssuredConfig

object SampleData extends MyRestAssuredConfig {

  val currentTenant = ClientRef.client.getCurrentTenant

  def load() {

    val application = ClientRef.client.getDataStore().instantiate(classOf[Application])
    application.setName("TestAppOne")
    application.setDescription("Test Application")

    currentTenant.createApplication(application)
  }

  def deleteAll() {
    val reqExec = new HttpClientRequestExecutor(new DefaultApiKey(username, password))
    val ds = new DefaultDataStore(reqExec)

    val apps = currentTenant.getApplications().iterator.toList.
      //filter( _.getName != "Stormpath")
      filterNot(List("Stormpath", "TestAppOne") contains _.getName)
    apps.foreach { ds.delete(_) }

  }

  def main(args: Array[String]) {
//    deleteAll()
//    load()
  }

}