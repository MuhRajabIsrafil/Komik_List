package id.ac.unhas.komiklist

data class DataKomik(
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val top: List<komik>
)

data class komik(
    val end_date: String,
    val image_url: String,
    val mal_id: Int,
    val members: Int,
    val rank: Int,
    val score: Double,
    val start_date: String,
    val title: String,
    val type: String,
    val url: String,
    val volumes: Int
)