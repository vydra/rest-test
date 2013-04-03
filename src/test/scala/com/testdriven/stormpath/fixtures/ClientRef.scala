package com.testdriven.stormpath.fixtures

import com.stormpath.sdk.client.Client
import com.stormpath.sdk.client.ClientBuilder

object ClientRef {
   val client : Client = new ClientBuilder().setApiKeyFileLocation(TestConfig.apiKeyPath).build()
}