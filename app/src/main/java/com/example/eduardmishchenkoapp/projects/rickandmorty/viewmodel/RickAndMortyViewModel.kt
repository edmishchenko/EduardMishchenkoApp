package com.example.eduardmishchenkoapp.projects.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.eduardmishchenkoapp.projects.rickandmorty.api.ApiService
import com.example.eduardmishchenkoapp.projects.rickandmorty.paging.RickAndMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RickAndMortyViewModel
@Inject constructor(private val apiService: ApiService): ViewModel(){

    val listData = Pager(PagingConfig(pageSize = 1)){
        RickAndMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}