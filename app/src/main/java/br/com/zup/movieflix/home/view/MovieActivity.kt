package br.com.zup.movieflix.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.R
import br.com.zup.movieflix.databinding.ActivityMovieBinding
import br.com.zup.movieflix.home.viewmodel.MovieViewModel

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding

    //inicializacao padrao do viewModel
    private val viewModel: MovieViewModel by lazy {
        ViewModelProvider(this)[MovieViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
    }
    private fun initViewModel(){
        viewModel.getAllMovies()

        viewModel.response.observe(this){ listMovies ->
            binding.tvMovies.text = "$listMovies"
        }
    }
}