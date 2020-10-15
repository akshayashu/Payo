package com.example.payo.DataModel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class PayoData(

    @SerializedName("page")
    @Expose
    var page: Int,
    @SerializedName("per_page")
    @Expose
    var perPage: Int,
    @SerializedName("total")
    @Expose
    var total: Int,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int,
    @SerializedName("data")
    @Expose
    var data:List<MainData>
)


data class MainData(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("email")
    @Expose
    var email: String,
    @SerializedName("first_name")
    @Expose
    var firstName: String,
    @SerializedName("last_name")
    @Expose
    var lastName: String,
    @SerializedName("avatar")
    @Expose
    var avatar:String
)