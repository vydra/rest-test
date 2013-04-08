package com.testdriven.stormpath

import scala.collection.convert.WrapAsScala._
import com.testdriven.stormpath.fixtures.ClientRef
import com.testdriven.stormpath.rest.MyRestAssuredConfig
import com.stormpath.sdk.client.DefaultApiKey
import com.stormpath.sdk.impl.http.httpclient.HttpClientRequestExecutor
import com.stormpath.sdk.impl.ds.DefaultDataStore

object SampleData extends MyRestAssuredConfig {
  
  def deleteAll() {
    val reqExec = new HttpClientRequestExecutor( new DefaultApiKey(username,password)) 
    val ds = new DefaultDataStore(reqExec)
    
    val currentTenant = ClientRef.client.getCurrentTenant
    val apps  = currentTenant.getApplications().iterator.toList.filter( _.getName != "Stormpath")
    apps.foreach{ ds.delete(_) }
    
  }
  
  def main(args: Array[String]) {
     // deleteAll()
  }

}