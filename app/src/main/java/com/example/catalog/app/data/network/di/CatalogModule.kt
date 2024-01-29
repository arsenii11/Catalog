package net.marcoromano.catalog.app.data.network.di

import net.marcoromano.catalog.app.data.network.api.CatalogApiClient
import net.marcoromano.catalog.app.data.network.api.CatalogApiManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.marcoromano.catalog.app.data.network.api.CatalogApiConfig
import net.marcoromano.catalog.app.data.network.api.RetrofitInstance
import net.marcoromano.catalog.app.domain.GetCategoriesUseCase
import retrofit2.Retrofit
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


