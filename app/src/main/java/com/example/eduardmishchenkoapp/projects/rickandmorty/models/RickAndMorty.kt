package com.example.eduardmishchenkoapp.projects.rickandmorty.models

data class RickAndMorty(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
