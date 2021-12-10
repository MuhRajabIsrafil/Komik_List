package id.ac.unhas.komiklist.Network

import id.ac.unhas.komiklist.DataKomik
import retrofit2.Call
import retrofit2.http.GET

interface api {

    @GET("top/manga/1/manga")
    fun getDataKomik() : Call<DataKomik>
}