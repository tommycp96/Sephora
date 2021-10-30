package com.tcp.sephora.di

import com.tcp.sephora.data.remote.SephoraApi
import com.tcp.sephora.repository.SephoraRepository
import com.tcp.sephora.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSephoraRepository(
        api: SephoraApi
    ) = SephoraRepository(api)

    @Singleton
    @Provides
    fun provideSephoraApi(): SephoraApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SephoraApi::class.java)
    }
}