package com.example.notepad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notepad.apiClient.RetrofitClient
import com.example.notepad.model.AddNotes
import com.example.notepad.model.Content

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotesViewModel:ViewModel() {
    private var patientObservable: MutableLiveData<AddNotes?>? = null
    private var patientlbservable: MutableLiveData<AddNotes?>? = null

    fun addNewNotes(contents: Content): LiveData<AddNotes?>? {

        patientObservable = MutableLiveData()
        getNotesresponse(contents)
        return  patientObservable


    }

    private fun getNotesresponse(contents: Content) {
      val call:Call<AddNotes?>?= RetrofitClient().getApiClient()?.getNewNotes(contents)
        call?.enqueue(object :Callback<AddNotes?>{
            override fun onResponse(call: Call<AddNotes?>, response: Response<AddNotes?>) {
            if(response.isSuccessful){
             if(patientObservable==null){
               patientObservable=MutableLiveData<AddNotes?>()
             }
                patientObservable?.value = response.body()
            }
                else{
                 val commonResponse=AddNotes()
                 commonResponse.setMessage("Api Called failed")
            }
            }

            override fun onFailure(call: Call<AddNotes?>, t: Throwable) {

            }
        })
    }



    fun readNotes(): LiveData<AddNotes?>? {

        patientlbservable = MutableLiveData()
        getReadNotes()
        return  patientlbservable


    }

    private fun getReadNotes() {
        val call:Call<AddNotes?>?= RetrofitClient().getApiClient()?.getReadNotes()
        call?.enqueue(object :Callback<AddNotes?>{
            override fun onResponse(call: Call<AddNotes?>, response: Response<AddNotes?>) {
                if(response.isSuccessful){
                    if(patientObservable==null){
                        patientlbservable=MutableLiveData<AddNotes?>()
                    }
                    patientlbservable?.value = response.body()
                }
                else{
                    val commonResponse=AddNotes()
                    commonResponse.setMessage("Api Called failed")
                }
            }

            override fun onFailure(call: Call<AddNotes?>, t: Throwable) {

            }
        })
    }


}