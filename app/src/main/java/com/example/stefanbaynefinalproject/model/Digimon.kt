package com.example.stefanbaynefinalproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Data class for Digimon from API
// Parcelable to
@Parcelize
data class Digimon
    (
    val name: String,
    val img: String,
    val level: String
            ) : Parcelable
