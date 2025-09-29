// com/jorgromo/androidClassMp1/secondpartial/home/model/HomeModel.kt

package com.jorgeromo.androidClassMp1.secondpartial.home.model

import com.google.gson.annotations.SerializedName

data class HomeScreenResponse(
    @SerializedName("homeScreen") val homeScreen: List<HomeSection>
)

data class HomeSection(
    @SerializedName("sectionTitle") val sectionTitle: String,
    @SerializedName("listings") val listings: List<Listing>
)

data class Listing(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double?,
    @SerializedName("currency") val currency: String,
    @SerializedName("category") val category: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("postDate") val postDate: String,
    @SerializedName("user") val user: User
)

data class User(
    @SerializedName("userId") val userId: String,
    @SerializedName("name") val name: String,
    @SerializedName("avatarUrl") val avatarUrl: String,
    @SerializedName("contactInfo") val contactInfo: String
)