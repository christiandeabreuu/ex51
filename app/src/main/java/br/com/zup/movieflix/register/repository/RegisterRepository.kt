package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {
    private val listRegister = mutableListOf<RegisterModel>()

    fun registration(user: RegisterModel): List<RegisterModel> {
        listRegister.add(user)
        return listRegister
    }
}