package org.ibda.myfragment.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import org.ibda.myfragment.Task

interface ApiService {
    @POST("tasks/save")
    fun saveTask(@Body task: Task): Call<Void>
}
