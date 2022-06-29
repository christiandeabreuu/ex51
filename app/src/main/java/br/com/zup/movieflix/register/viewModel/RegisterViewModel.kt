package br.com.zup.movieflix.register.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel() : ViewModel() {
    private val repository = RegisterRepository()
    private val _response: MutableLiveData<List<RegisterModel>> = MutableLiveData()
    val response: LiveData<List<RegisterModel>> = _response

    fun getRegistration(user: RegisterModel){
        try {
            _response.value = repository.registration(user)
        }catch (ex: Exception){
            Log.i("Error", "------> ${ex.message}")
        }
    }
}