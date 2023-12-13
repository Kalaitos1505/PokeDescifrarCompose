package com.example.pokedescifrarcompose.data.repositories

import android.util.Log
import com.example.pokedescifrarcompose.data.entities.Pokemon
import com.example.pokedescifrarcompose.data.entities.PokemonType
import com.example.pokedescifrarcompose.data.entities.Type
import com.example.pokedescifrarcompose.service.PokeApiService
import com.example.pokedescifrarcompose.service.RetrofitClient

class PokemonRepository {
    private val pokeApiService: PokeApiService = RetrofitClient.createService(PokeApiService::class.java)

    suspend fun getRandomPokemonList(): List<Pokemon>? {
        try {
                val randomSubset = getMaxPokemonCount()?.let { generateRandomSubset(it, 10) } //Invocación aquí
                val pokemonList = mutableListOf<Pokemon>()
                Log.e("PokeLista", "$randomSubset")

            if (randomSubset != null) {
                for (id in randomSubset) {
                    val response = pokeApiService.getPokemon(id)
                    if (response.isSuccessful) {
                        val pokemonName = response.body()?.name
                        val types: List<PokemonType> = response.body()?.types?.map { typeResponse ->
                            val slot = typeResponse.slot
                            val typeName = typeResponse.type.name
                            if (typeName.isNotBlank()) {
                                PokemonType(slot, Type(typeName))
                            } else {
                                PokemonType(slot, Type("Error en la api"))
                            }
                        } ?: emptyList()

                        if (!pokemonName.isNullOrBlank() && types.isNotEmpty()) {
                            val pokemon: Pokemon
                            if (types.size == 1) {
                                pokemon = Pokemon(pokemonName, types)
                            } else if (types.size == 2) {
                                val sortedTypes = types.sortedBy { it.slot }
                                pokemon = Pokemon(pokemonName, sortedTypes)
                            } else {
                                pokemon = Pokemon(pokemonName, types)
                            }
                            pokemonList.add(pokemon)
                        }
                    }
                }
            }
                return pokemonList

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null

    }

    private fun generateRandomSubset(maxValue: Int, count: Int): List<Int> {
        val randomSubset = mutableListOf<Int>()
        val maxValueExclusive = maxValue + 1

        while (randomSubset.size < count) {
            val randomValue = (0 until maxValueExclusive).random()
            if (randomValue !in randomSubset) {
                randomSubset.add(randomValue)
            }
        }

        return randomSubset
    }

    private suspend fun getMaxPokemonCount(): Int? {
            val response = pokeApiService.getMaxPokemonCount()
            val responseCode = response.code()
            Log.e("PokeLista","Response: $response")
            Log.e("PokeLista","ResponseCode: $responseCode")
        try {
            if (response.isSuccessful) {
                val count = response.body()?.count
                return count
            }

        } catch (e: Exception) {
            Log.e("PokeLista", "ResponseCode: ${response.code()}")
        }
        Log.e("PokeLista", "ResponseCode: ${response.code()}")
        return null
    }
}



