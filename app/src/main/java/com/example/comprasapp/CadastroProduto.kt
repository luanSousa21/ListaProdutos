package com.example.comprasapp

import Controller.ProdutosController
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CadastroProduto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)
        var btnCadProd : Button = findViewById(R.id.btnCadProd)

        btnCadProd.setOnClickListener {
            var dbProdutos = ProdutosController(baseContext)
            var nomeProd : EditText = findViewById(R.id.nomeProd)
            var descricaoProd : EditText = findViewById(R.id.descricaoProd)
            var quantidadeProd : EditText = findViewById(R.id.quantidadeProd)
            var precoProd : EditText = findViewById(R.id.precoProd)

            var resultado = dbProdutos.addProduto(nomeProd.text.toString(), descricaoProd.text.toString(), quantidadeProd.text.toString(),precoProd.text.toString() )
            Log.i("AddProduto", resultado)

            val i  = Intent(this, MainActivity::class.java)

            startActivity(i)

            finish()
        }
    }

}