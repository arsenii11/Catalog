package net.marcoromano.catalog.app.data.network.model

data class ItemsDO(
    val products: List<Product>
)

data class Product(
    val anchorText: String,
    val freeShipping: Int,
    val maxGridSavings: Map<String, Double>,
    val reviewCount: Int,
    val isExtraCashback: Boolean,
    val isBestRated: Int,
    val productId: Int,
    val maxFinalSalePrices: Map<String, Double>,
    val totalVariantCount: Int,
    val areMinPricesAfterRebate: Map<String, Boolean>,
    val brand: Brand,
    val minFinalGridSalePrices: Map<String, Double>,
    val isSale: Int,
    val variantCount: Int,
    val maxSavings: Map<String, Double>,
    val isCallToOrder: Int,
    val isNew: Int,
    val topSpecifications: List<TopSpecification>,
    val savePercents: Map<String, Int>,
    val allVariantsAreShed: Boolean,
    val gridSavePercents: Map<String, Int>,
    val minFinalSalePricesPerUomNumber: Map<String, Double>,
    val fullName: String,
    val isShed: Boolean,
    val isRebate: Int,
    val hasFreeGifts: Int,
    val shortName: String,
    val minSalePrices: Map<String, Double>,
    val allVariantsAreOutlet: Boolean,
    val primaryImage: String,
    val cashbackPercentage: Int,
    val minFinalSalePriceUomLabels: Map<String, String>,
    val hasSellAccessoriesVariants: Boolean,
    val flags: List<String>,
    val hasCoupons: Int,
    val productCode: String,
    val isDemo: Int,
    val isBest: Int,
    val reviewRating: String,
    val minSavings: Map<String, Int>,
    val popularity: Double,
    val maxFinalSalePricesPerUomNumber: Map<String, Double>,
    val isClearance: Int,
    val isOrderable: Boolean,
    val categories: List<Category>,
    val promos: List<Any>,
    val minFinalSalePrices: Map<String, Double>,
    val isSecondDayAir: Int,
    val areSegmentSalePricesHidden: Map<String, Int>,
    val isMadeInUsa: Int,
    val cashbackFlatAmount: Int,
    val hasOptions: Int,
    val minGridSavings: Map<String, Int>,
    val listPrice: Double,
    val isUsePricePerUomCalculation: Boolean,
    val url: String,
    val unorderableTypeId: String,
    val areSavingsExact: Map<String, Boolean>,
    val isOutlet: Boolean,
    val maxSalePrices: Map<String, Double>,
    val displayMailInRebateGrid: Boolean,
    val displayInstantRebateGrid: Boolean,
    val displayCouponInGrid: Boolean,
    val displayKillerDealInGrid: Boolean,
    val rebateAmount: Int,
    val minFinalSalePrice: Double,
    val minSalePrice: Double,
    val maxFinalSalePrice: Double,
    val maxSalePrice: Double,
    val minFinalGridSalePrice: Double,
    val isMinPriceAfterRebate: Boolean,
    val isSegmentSalePriceHidden: Boolean,
    val whole: String,
    val cents: String,
    val wholeTo: String,
    val centsTo: String,
    val radEligible: Boolean,
    val ribbonFlags: List<Any>,
    val minSaving: Int,
    val maxSaving: Double,
    val savePercent: Int,
    val minGridSaving: Int,
    val maxGridSaving: Double,
    val gridSavePercent: Int,
    val isSavingExact: Boolean,
    val elementDimensions: ElementDimensions,
    val hasVideo: Boolean,
    val imageHeight: String,
    val imageWidth: String,
    val stores: List<Any>,
    val promotion: List<Any>,
    val bundleData: List<Any>,
    val isBuyDirect: Boolean,
    val price: Double,
    val isPriceAfterRebate: Boolean,
    val gaEcommerceName: String,
    val variantCountText: Int,
    val clearanceVariantCount: Int,
    val killerDealVariantCount: Int,
    val matchedVariantCount: Int,
    val saveAmount: Double,
    val isSaveExact: Boolean,
    val savingsText: String,
    val showAsLowAs: Boolean,
    val highlightedDescription: List<Any>,
    val mainCategory: MainCategory,
    val brandName: String,
    val categoryName: String,
    val brandCategories: List<Any>,
    val id: Int,
    val specialOffers: Any,
    val gridItemName: String,
    val gridName: String,
    val deals: List<Any>,
    val canAddReview: Boolean,
    val canCompare: Boolean,
    val canAddQna: Boolean,
    val isMembersOnly: Boolean,
    val buyQtyLimit: Int,
    val buyQtyLimitStartAt: Int
)

data class Brand(
    val name: String
)

data class TopSpecification(
    val title: String,
    val count: Int,
    val slug: String,
    val specificationId: Int,
    val values: List<Value>
)

data class Value(
    val title: String,
    val uom: String
)

data class Category(
    val popularity: String,
    val name: String,
    val lev: String,
    val url: String
)

data class ElementDimensions(
    val width: Int,
    val height: Int
)

data class MainCategory(
    val popularity: String,
    val name: String,
    val lev: String,
    val url: String
)


