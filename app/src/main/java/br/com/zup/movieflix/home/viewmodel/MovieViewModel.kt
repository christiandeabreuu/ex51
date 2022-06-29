package br.com.zup.movieflix.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.home.repository.MovieRepository

class MovieViewModel(): ViewModel() {
    //objeto pra acessar as funcoes que estao dentro da classe MovieRepository
    private val repository = MovieRepository()

    // lista privada mutavel dentro do ViewModel e retorna ela mesmo, mas só tem acesso a ela dentro do viewModel
    private val _response: MutableLiveData<List<Movie>> = MutableLiveData()

    //vai deixar publica a lista que criou, mas só somente leitura, nao é mutavel, e retorna uma lista privada
    val response: LiveData<List<Movie>> = _response

    fun getAllMovies(){
        try{
            _response.value = repository.getListMovie()
        }catch(ex: Exception){
            Log.i("Error", "----> ${ex.message}")
        }
    }
}