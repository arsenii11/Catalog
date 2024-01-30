package com.example.catalog.app.data.network.di

import com.example.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.data.network.api.CatalogApiManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.catalog.app.data.network.api.RetrofitInstance
import net.marcoromano.catalog.app.domain.GetCategoriesUseCase
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object CatalogModule{
    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(apiClient: CatalogApiClient): GetCategoriesUseCase {
        return GetCategoriesUseCase(apiClient)
    }
    @Provides
    @Singleton
    fun provideRetrofitInstance(): RetrofitInstance {
        return RetrofitInstance()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CatalogBindings {

    @Binds
    @Singleton
    abstract fun bindsCatalogApiClient(apiManager: CatalogApiManager): CatalogApiClient
}


