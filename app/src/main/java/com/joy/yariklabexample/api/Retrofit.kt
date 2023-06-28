package com.joy.yariklabexample.api

import retrofit2.Retrofit

var retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build()