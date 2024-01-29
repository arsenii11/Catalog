package net.marcoromano.catalog.app.data.network.api

import net.marcoromano.catalog.app.data.utilities.Links
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Singleton
class RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Links.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CatalogApiConfig by lazy {
        retrofit.create(CatalogApiConfig::class.java)
    }
}
