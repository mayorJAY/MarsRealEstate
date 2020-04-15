package com.example.josycom.marsrealestate.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://mars.udacity.com/"
private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

interface MarsApiService {

    @GET("realestate")
    fun getProperties(@Query("filter") type: String) : Deferred<List<MarsProperty>>
}

enum class MarsApiFilter(val value: String) {
    SHOW_RENT("rent"), SHOW_BUY("buy"), SHOW_ALL("all")
}