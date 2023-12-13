package com.example.pokedescifrarcompose.data.entities

data class PatchNote(
    val version: String,
    val description: String,
    val changes: List<String>
) {
    override fun toString(): String {
        return "$version - $description"
    }
}



val patchNoteList = listOf(
    PatchNote("Beta 0.1", "Initial Notes", listOf("Added game logic","Added start menu","Added about menu", "Added settings menu", "Removed M̷̝̱̎̊̀̕ͅi̷̧̔͝s̵̝͓͇̉͗̊̌s̷̱̤̯̈ȉ̸̮̙̓̌͗n̴͉͖̈́͗̐̑g̴̜̜̔n̵͚̍̇ȏ̸͓̙̂")),
    PatchNote("Beta 0.2", "Sound Update", listOf("Added main music", "Added game ending screen", "Added Yu Narukami" )),
    PatchNote("Beta 0.3", "Volume Control Update", listOf("Added Volume Control", "Added Some SFX", "Fixed Patch Notes Visibility", "\uD83D\uDDFF")),
    PatchNote("Beta 0.4", "Game End Fix", listOf("Fixed Game End Screen Text", "Furret Now Walks")),
    PatchNote("Beta 0.5", "Volume Control Remove", listOf("Removed in-app volume control (now volume is adjusted with your phone volume).", "Ultra Necrozma now seeks your soul")),
    PatchNote("Beta 0.6", "Compose Update", listOf("Reworked most of the interface of the app using Jetpack Compose", "Added a bottom bar", "Were you expecting an easter egg here?"))
)

data class Credits(
    val description: String,
    val credit: String
)

val creditsList = listOf(
    Credits("Author \uD83D\uDCDD", "Kalaitos"),
    Credits("PokeAPI ©", "https://pokeapi.co/"),
    Credits("Music and SFX \uD83C\uDFB5", "The Pokemon Company, Nintendo and Atlus"),
    Credits("Thanks to my testers ✨", "Nairy89, Greenlass, Blackmore, Srmonass and Peiball"),
    Credits("License \uD83D\uDCDC", "Decodemon © 2023   by   Kalaitos is licensed under CC BY-NC-SA 4.0 ")
)