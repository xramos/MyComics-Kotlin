package com.xramos.mycomics.di

import android.net.Network
import com.xramos.mycomics.data.network.client.NetworkAPI
import com.xramos.mycomics.data.network.client.NetworkClient
import com.xramos.mycomics.data.network.client.Repository
import com.xramos.mycomics.data.network.client.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: NetworkClient): HttpClient = httpClient.getClient()

    @Provides
    fun getRepository(impl: RepositoryImpl): Repository = impl

    @Provides
    @Singleton
    fun getNetworkClient(client: NetworkClient): NetworkAPI = NetworkAPI(client.getClient())
}