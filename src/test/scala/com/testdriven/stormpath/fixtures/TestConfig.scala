package com.testdriven.stormpath.fixtures

import com.typesafe.config.ConfigFactory
import java.io.File

object TestConfig {
    val stormPath = System.getProperty("user.home") + "/.stormpath"
    val apiKeyPath = stormPath + "/apiKey.properties"
    val conf = ConfigFactory.parseFile( new File(stormPath + "/test-application.conf"))
    val apiKeyConf = ConfigFactory.parseFile( new File(apiKeyPath))
    
    def tenantHref = conf.getString("currentTenant.href")
    def tenantName = conf.getString("currentTenant.name")
}