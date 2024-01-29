package net.marcoromano.catalog.app.data.utilities

class Links {

    companion object {

        //BASE URL
        const val BASE_URL = "https://www.opticsplanet.com"

        //API KEY
        const val API_KEY = "53ae2a823bbde6f79e657d38df5fb5de412236acd6e98b140ace9b45e405e3354877d6cd4452bc10b66fbfb2376733ea37f0fb7932ae6ea95d3f824334922bc1"

        //Categories URL
        const val CATEGORIES_URL = "api/0.2/categories "

        //List of products URL
        const val LIST_URL = "iv-api/0.3/catalog/{identifier}/products?_iv_include=gridProducts  "

        //Product details
        const val ITEM_URL = "api/0.3/products/{identifier} "
    }

}