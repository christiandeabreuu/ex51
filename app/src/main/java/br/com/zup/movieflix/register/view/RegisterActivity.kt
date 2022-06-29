package br.com.zup.movieflix.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.home.view.MovieActivity
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerConpleted()
        observer()
    }

    private fun registerConpleted() {
        binding.bvLogin.setOnClickListener {
            if (passwordValidation()) {
                val user = getInformation()
                viewModel.getRegistration(user)
            }
        }
    }

    private fun observer() {
        viewModel.response.observe(this) {
            startActivity(Intent(this, MovieActivity::class.java))
        }
    }

    private fun getInformation(): RegisterModel {
        val userName = binding.etUserNameRegister.text.toString()
        val userEmail = binding.etEmailRegister.text.toString()
        val password = binding.etPasswordRegister.text.toString()


        return RegisterModel(
            userName = userName,
            userEmail = userEmail,
            password = password
        )
    }

    private fun passwordValidation(): Boolean {
        val password = binding.etPasswordRegister.text.toString()
        val passwordConfirmation = binding.etConfirmPasswordRegister.text.toString()

        return if (password == passwordConfirmation) {

            true
        } else {
            Toast.makeText(this, "As senhas devem ser iguais", Toast.LENGTH_LONG).show()
            false
        }
    }
}