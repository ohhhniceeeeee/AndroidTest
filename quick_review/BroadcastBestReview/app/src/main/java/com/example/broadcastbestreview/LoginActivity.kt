package com.example.broadcastbestreview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastbestreview.databinding.ActivityLoginBinding
import kotlin.math.log

class LoginActivity : BaseActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val isRemember = pref.getBoolean("remember_password", false)
        if (isRemember) {
            val account = pref.getString("account", "")
            val password = pref.getString("password", "")
            if (!account.isNullOrEmpty()) {
                loginBinding.accountEdit.setText(account)
                loginBinding.accountEdit.setSelection(account.length)
            }
            if (!password.isNullOrEmpty()) {
                loginBinding.passwordEdit.setText(password)
                loginBinding.passwordEdit.setSelection(password.length)
            }
            loginBinding.rememberPass.isChecked = true
        }
        loginBinding.login.setOnClickListener {
            val account = loginBinding.accountEdit.text.toString()
            val password = loginBinding.passwordEdit.text.toString()
            if (account == "admin" && password == "123456") {
                val editor = pref.edit()
                if (loginBinding.rememberPass.isChecked) {
                    editor.apply {
                        putString("account", account)
                        putString("password", password)
                        putBoolean("remember_password", true)
                    }
                } else {
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or the password error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}