package id.ac.unhas.komiklist.UI.Home

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.komiklist.Adapter.HomeAdapter
import id.ac.unhas.komiklist.DataKomik
import id.ac.unhas.komiklist.Network.RetrofitClient
import id.ac.unhas.komiklist.komik
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    init {
        Log.d("HomeViewModel", "Created")
    }

    var listKomik : ArrayList<komik> = arrayListOf()

    interface onClickListener {
        fun onClick(komik: komik)
    }

    fun getDataFromApi(recyclerView: RecyclerView, progressBar: ProgressBar, listener: onClickListener) {
        RetrofitClient.instance.getDataKomik().enqueue(object : Callback<DataKomik>{
            override fun onResponse(call: Call<DataKomik>, response: Response<DataKomik>) {
                Log.d("HomeViewModel", "Request")
                val data = response.body()?.top
                listKomik.addAll(data as ArrayList<komik>)
                recyclerView.adapter = HomeAdapter(data as ArrayList<komik>, object : HomeAdapter.OnItemClickListener{
                    override fun onClick(komik: komik) {
                        listener.onClick(komik)
                    }
                })
            progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<DataKomik>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

        })
    }
}