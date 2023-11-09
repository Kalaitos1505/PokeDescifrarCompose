package com.example.pokedescifrarcompose.entities

data class Pokemon(
    val name: String,
    val types: List<PokemonType>
)

data class PokemonType(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String
)
