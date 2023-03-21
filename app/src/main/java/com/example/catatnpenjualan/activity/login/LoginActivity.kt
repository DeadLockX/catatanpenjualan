package com.example.catatnpenjualan.activity.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.catatnpenjualan.MainActivity
import com.example.catatnpenjualan.R
import com.example.catatnpenjualan.base.BaseActivity
import com.example.catatnpenjualan.model.User



class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var btnLogin: Button
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText>(R.id.etLoginUsername)
        etPassword = findViewById<EditText>(R.id.etLoginPassword)
        btnLogin=findViewById<Button>(R.id.btn_login)

        initActionButton()
//        btnLogin.setOnClickListener {
//
//            Intent(this@LoginActivity, MainActivity::class.java).also { it.putExtra(MainActivity) }


        }
     fun initActionButton(){
        btnLogin.setOnClickListener {
            val user = User()
            user.username = etUsername.text.toString().trim()
            user.password = etPassword.text.toString().trim()

            LoginPresenter(this@LoginActivity).login(user)

        }
    }

    override fun onSuccessLogin(user:User?){
        Toast.makeText(this, "Berhasil Login nichh", Toast.LENGTH_SHORT).show()

    val intent = Intent(this, MainActivity::class.java).apply { putExtra(BaseActivity.TAGS.USER, user) }
        finish()
        startActivity(intent)
    }

    override fun onErrorLogin(msg:String?){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    }
