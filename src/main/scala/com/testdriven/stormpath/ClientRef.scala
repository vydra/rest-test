package com.testdriven.stormpath

import com.stormpath.sdk.client.Client
import com.stormpath.sdk.client.ClientBuilder
import com.testdriven.stormpath.fixtures.TestConfig

object ClientRef {
   def client = new ClientBuilder().setApiKeyFileLocation(TestConfig.apiKeyPath).build()
}