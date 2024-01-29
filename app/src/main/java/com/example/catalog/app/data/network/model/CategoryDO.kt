package net.marcoromano.catalog.app.data.network.model

data class CategoryDO (
    val categories: List<CategoryData>
)

data class CategoryData(
    val category_id: String,
    val short_name: String,
    val full_name: String,
    val orderable_count: String,
    val url: String,
    val parent_id: String,
    val unavailable_count: String,
    val featured: String,
    val popularity: String,
    val images: List<AmmoImage>,
    val has_children: Boolean
){
    data class AmmoImage(
        val url: String,
        val title: String,
        val source: String
    )
}

