package com.ghostapps.androidexample.model
import com.google.gson.annotations.SerializedName

class UserModel (
    @SerializedName("name")
    val name: String,
    @SerializedName("user_thumb")
    val thumb: String
)