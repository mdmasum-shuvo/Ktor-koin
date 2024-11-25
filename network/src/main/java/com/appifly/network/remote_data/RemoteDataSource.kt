package com.appifly.network.remote_data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class RemoteDataSource(private val client: HttpClient) {

    suspend fun getCategoryDataList(): HttpResponse =
        client.get {
            url(HttpParam.CATEGORY)
        }


    suspend fun getChannelList(): HttpResponse =
        client.get {
            url(HttpParam.CHANNEL_LIST)
        }
}