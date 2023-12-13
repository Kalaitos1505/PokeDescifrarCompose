package com.example.pokedescifrarcompose.service

import com.example.pokedescifrarcompose.data.entities.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface
PokeApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") pokemonId: Int): Response<Pokemon>

    @GET("pokemon-species")
    suspend fun getMaxPokemonCount(): Response<PokemonSpeciesResponse>
}