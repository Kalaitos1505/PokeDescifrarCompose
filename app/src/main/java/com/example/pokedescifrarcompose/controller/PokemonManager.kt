package com.example.pokedescifrarcompose.controller

import androidx.compose.ui.graphics.Color
import com.example.pokedescifrarcompose.ui.theme.PokeTypeBug
import com.example.pokedescifrarcompose.ui.theme.PokeTypeDark
import com.example.pokedescifrarcompose.ui.theme.PokeTypeDragon
import com.example.pokedescifrarcompose.ui.theme.PokeTypeElectric
import com.example.pokedescifrarcompose.ui.theme.PokeTypeFairy
import com.example.pokedescifrarcompose.ui.theme.PokeTypeFighting
import com.example.pokedescifrarcompose.ui.theme.PokeTypeFire
import com.example.pokedescifrarcompose.ui.theme.PokeTypeFlying
import com.example.pokedescifrarcompose.ui.theme.PokeTypeGhost
import com.example.pokedescifrarcompose.ui.theme.PokeTypeGrass
import com.example.pokedescifrarcompose.ui.theme.PokeTypeGround
import com.example.pokedescifrarcompose.ui.theme.PokeTypeIce
import com.example.pokedescifrarcompose.ui.theme.PokeTypeNormal
import com.example.pokedescifrarcompose.ui.theme.PokeTypePoison
import com.example.pokedescifrarcompose.ui.theme.PokeTypePsychic
import com.example.pokedescifrarcompose.ui.theme.PokeTypeRock
import com.example.pokedescifrarcompose.ui.theme.PokeTypeSteel
import com.example.pokedescifrarcompose.ui.theme.PokeTypeWater

        fun translateType(typeName: String): String {
        return when (typeName) {
            "normal" -> "NORMAL"
            "fire" -> "FUEGO"
            "water" -> "AGUA"
            "electric" -> "ELÉCTRICO"
            "grass" -> "PLANTA"
            "ice" -> "HIELO"
            "fighting" -> "LUCHA"
            "poison" -> "VENENO"
            "ground" -> "TIERRA"
            "flying" -> "VOLADOR"
            "psychic" -> "PSÍQUICO"
            "bug" -> "BICHO"
            "rock" -> "ROCA"
            "ghost" -> "FANTASMA"
            "dragon" -> "DRAGÓN"
            "dark" -> "SINIESTRO"
            "steel" -> "ACERO"
            "fairy" -> "HADA"

            else -> typeName
        }
    }
            fun getTypeColor(typeName: String): Color {
            return when (typeName) {
                "NORMAL" -> PokeTypeNormal
                "FUEGO" -> PokeTypeFire
                "AGUA" -> PokeTypeWater
                "ELÉCTRICO" -> PokeTypeElectric
                "PLANTA" -> PokeTypeGrass
                "HIELO" -> PokeTypeIce
                "LUCHA" -> PokeTypeFighting
                "VENENO" -> PokeTypePoison
                "TIERRA" -> PokeTypeGround
                "VOLADOR" -> PokeTypeFlying
                "PSÍQUICO" -> PokeTypePsychic
                "BICHO" -> PokeTypeBug
                "ROCA" -> PokeTypeRock
                "FANTASMA" -> PokeTypeGhost
                "DRAGÓN" -> PokeTypeDragon
                "SINIESTRO" -> PokeTypeDark
                "ACERO" -> PokeTypeSteel
                "HADA" -> PokeTypeFairy
                else -> Color(0xFF000000) //Default color for the sake of avoiding errors
            }
        }

