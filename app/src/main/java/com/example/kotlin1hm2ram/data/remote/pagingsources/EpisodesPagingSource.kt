package com.example.kotlin1hm2ram.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodesApiService
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import retrofit2.HttpException
import java.io.IOException

const val EPISODES_KEY = 1
class EpisodesPagingSource(private val service: EpisodesApiService) :
    PagingSource<Int, RickAndMortyEpisodes>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyEpisodes> {
        val page = params.key ?: EPISODES_KEY
        return try {
            val response = service.fetchEpisodes(page)
            val nextPageNumber = if (response.info.next == null){
                null
            }else Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = response.result,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RickAndMortyEpisodes>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

