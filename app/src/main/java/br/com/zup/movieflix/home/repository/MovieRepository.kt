package br.com.zup.movieflix.home.repository

import br.com.zup.movieflix.R
import br.com.zup.movieflix.home.model.Movie

class MovieRepository {
    fun getListMovie(): List<Movie> {
        val listMovie = mutableListOf<Movie>()

        listMovie.add(
            Movie(
                title = " A era do gelo",
                "teste teste",
                R.drawable.a_era_gelo
            )
        )
        listMovie.add(
            Movie(
                "Capitão Fantastico",
                "teste teste",
                R.drawable.capitao_fantastico

            )
        )
        return listMovie
    }
}