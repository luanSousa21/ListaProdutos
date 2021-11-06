package com.example.comprasapp

import Adapter.AdapterLista
import Controller.ProdutosController
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ListaDeProdutos = ProdutosController(this)
        var fab : FloatingActionButton = findViewById(R.id.btn_cad)

        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        var adapter = AdapterLista(ListaDeProdutos.listarProdutos(), this)

        var layoutManager : RecyclerView.LayoutManager =  LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

       recyclerView.setHasFixedSize(true)

        recyclerView.adapter = adapter

        fab.setOnClickListener(View.OnClickListener {
            cadastroProduto()
        })
    }

    private fun cadastroProduto(){
        val i = Intent(this, CadastroProduto::class.java)

        startActivity(i)

        finish()
    }
}