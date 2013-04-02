package com.testdriven.stormpath.fixtures

import com.typesafe.config.ConfigFactory
import java.io.File

object Config {
    val stormPath = System.getProperty("user.home") + "/.stormpath"
    val apiKeyPath = stormPath + "/apiKey.properties"
    val conf = ConfigFactory.parseFile( new File(stormPath + "/test-application.conf"))
}