package com.wanku.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel (
    val dates: Dates,
    val page: Int,
    val results: List<ResultModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
