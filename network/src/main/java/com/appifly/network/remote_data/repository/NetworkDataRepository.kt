package com.appifly.network.remote_data.repository

import com.appifly.network.remote_data.ad_config.AdConfigResponse
import com.appifly.network.remote_data.banner.BannerResponse
import com.appifly.network.remote_data.model.category.CategoryResponse
import com.appifly.network.remote_data.model.channel.ChannelResponse
import com.appifly.network.remote_data.model.tv_shows.TvShowsResponse

interface NetworkDataRepository {

    suspend fun getAllCategory():CategoryResponse
    suspend fun getAllChannel():ChannelResponse
    suspend fun getAllBanner():BannerResponse
    suspend fun getAllTvShows():TvShowsResponse
    suspend fun getAllAddId():AdConfigResponse
}