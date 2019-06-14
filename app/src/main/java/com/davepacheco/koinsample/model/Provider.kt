package com.davepacheco.koinsample.model

interface Provider {
    fun provide(id: String, qualifier: String): TileViewModel
}