package com.example.eduardmishchenkoapp.projects.rickandmorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.eduardmishchenkoapp.projects.rickandmorty.api.ApiService
import com.example.eduardmishchenkoapp.projects.rickandmorty.models.RickAndMorty

class RickAndMortyPagingSource(private val apiService: ApiService): PagingSource<Int, RickAndMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickAndMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMorty> {
        return try{
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val data = response.body()?.results?: emptyList()
            val responseData = mutableListOf<RickAndMorty>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else 1,
                nextKey = currentPage.plus(1)
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}