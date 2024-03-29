package com.example.catalog.app.data.network.model

import com.google.gson.annotations.SerializedName


data class ItemsDO (

    @SerializedName("total"                     ) var total                  : Int?              = null,
    @SerializedName("filtered"                  ) var filtered               : Int?              = null,
    @SerializedName("grid_size"                 ) var gridSize               : Int?              = null,
    @SerializedName("listPageGridType"          ) var listPageGridType       : String?           = null,
    @SerializedName("directDeals"               ) var directDeals            : ArrayList<String> = arrayListOf(),
    @SerializedName("gridProducts"              ) var gridProducts           : GridProducts?     = GridProducts(),

)

data class ElementDimensions (

    @SerializedName("width"  ) var width  : Int? = null,
    @SerializedName("height" ) var height : Int? = null

)

data class Values (

    @SerializedName("title" ) var title : String? = null,
    @SerializedName("uom"   ) var uom   : String? = null

)

data class Brand (

    @SerializedName("name" ) var name : String? = null

)

data class TopSpecifications (

    @SerializedName("title"            ) var title           : String?           = null,
    @SerializedName("count"            ) var count           : Int?              = null,
    @SerializedName("slug"             ) var slug            : String?           = null,
    @SerializedName("specification_id" ) var specificationId : Int?              = null,
    @SerializedName("values"           ) var values          : ArrayList<Values> = arrayListOf()

)

data class MainCategory (

    @SerializedName("popularity" ) var popularity : String? = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("lev"        ) var lev        : String? = null,
    @SerializedName("url"        ) var url        : String? = null

)

data class GridProducts (

    @SerializedName("headingName" ) var headingName : String?             = null,
    @SerializedName("url"         ) var url         : String?             = null,
    @SerializedName("elements"    ) var elements    : ArrayList<Elements> = arrayListOf()

){
    data class Elements (

        @SerializedName("url"                        ) var url                        : String?                      = null,
        @SerializedName("anchorText"                 ) var anchorText                 : String?                      = null,
        @SerializedName("elementDimensions"          ) var elementDimensions          : ElementDimensions?           = ElementDimensions(),
        @SerializedName("fullName"                   ) var fullName                   : String?                      = null,
        @SerializedName("shortName"                  ) var shortName                  : String?                      = null,
        @SerializedName("price"                      ) var price                      : Double?                      = null,
        @SerializedName("isPriceAfterRebate"         ) var isPriceAfterRebate         : Boolean?                     = null,
        @SerializedName("primaryImage"               ) var primaryImage               : String?                      = null,
        @SerializedName("productCode"                ) var productCode                : String?                      = null,
        @SerializedName("gaEcommerceName"            ) var gaEcommerceName            : String?                      = null,
        @SerializedName("reviewCount"                ) var reviewCount                : Int?                         = null,
        @SerializedName("reviewRating"               ) var reviewRating               : String?                      = null,
        @SerializedName("variantCount"               ) var variantCount               : Int?                         = null,
        @SerializedName("variantCountText"           ) var variantCountText           : Int?                         = null,
        @SerializedName("clearanceVariantCount"      ) var clearanceVariantCount      : Int?                         = null,
        @SerializedName("killerDealVariantCount"     ) var killerDealVariantCount     : Int?                         = null,
        @SerializedName("matchedVariantCount"        ) var matchedVariantCount        : Int?                         = null,
        @SerializedName("savePercent"                ) var savePercent                : Int?                         = null,
        @SerializedName("saveAmount"                 ) var saveAmount                 : Double?                      = null,
        @SerializedName("isSaveExact"                ) var isSaveExact                : Boolean?                     = null,
        @SerializedName("isSavingExact"              ) var isSavingExact              : Boolean?                     = null,
        @SerializedName("savingsText"                ) var savingsText                : String?                      = null,
        @SerializedName("showAsLowAs"                ) var showAsLowAs                : Boolean?                     = null,
        @SerializedName("popularity"                 ) var popularity                 : Double?                      = null,
        @SerializedName("highlightedDescription"     ) var highlightedDescription     : ArrayList<String>            = arrayListOf(),
        @SerializedName("topSpecifications"          ) var topSpecifications          : ArrayList<TopSpecifications> = arrayListOf(),
        @SerializedName("mainCategory"               ) var mainCategory               : MainCategory?                = MainCategory(),
        @SerializedName("brandName"                  ) var brandName                  : String?                      = null,
        @SerializedName("categoryName"               ) var categoryName               : String?                      = null,
        @SerializedName("brand"                      ) var brand                      : Brand?                       = Brand(),
        @SerializedName("categories"                 ) var categories                 : ArrayList<Category>        = arrayListOf(),
        @SerializedName("brandCategories"            ) var brandCategories            : ArrayList<String>            = arrayListOf(),
        @SerializedName("id"                         ) var id                         : Int?                         = null,
        @SerializedName("productId"                  ) var productId                  : Int?                         = null,
        @SerializedName("gridName"                   ) var gridName                   : String?                      = null,
        @SerializedName("deals"                      ) var deals                      : ArrayList<Any>            = arrayListOf(),
        @SerializedName("canAddReview"               ) var canAddReview               : Boolean?                     = null,
        @SerializedName("canCompare"                 ) var canCompare                 : Boolean?                     = null,
        @SerializedName("canAddQna"                  ) var canAddQna                  : Boolean?                     = null,
        @SerializedName("isMembersOnly"              ) var isMembersOnly              : Boolean?                     = null,
        @SerializedName("buyQtyLimit"                ) var buyQtyLimit                : Int?                         = null,
        @SerializedName("buyQtyLimitStartAt"         ) var buyQtyLimitStartAt         : Int?                         = null,
        @SerializedName("hasSellAccessoriesVariants" ) var hasSellAccessoriesVariants : Boolean?                     = null

    )
}

data class Category (

    @SerializedName("popularity" ) var popularity : String? = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("lev"        ) var lev        : String? = null,
    @SerializedName("url"        ) var url        : String? = null

)
