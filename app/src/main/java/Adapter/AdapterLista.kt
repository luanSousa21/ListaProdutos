package Adapter

import Controller.ProdutosController
import DataBase.ProdutosDB
import android.content.Context
import android.database.Cursor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comprasapp.R
import model.ProdutosModel

class AdapterLista (array : ArrayList<ProdutosModel>, context: Context) : RecyclerView.Adapter<AdapterLista.ViewHolder>() {

    private val listaProdutos = array
    private val c = context

     class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
         var nomeProduto : TextView = view.findViewById(R.id.txtNomeProd)
         var descricao : TextView = view.findViewById(R.id.txtDescricao)
         var quantidade : TextView = view.findViewById(R.id.txtQuantidade)
         var preco : TextView = view.findViewById(R.id.txtPreco)
     }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var itens = LayoutInflater.from(parent.context).inflate(R.layout.adapter_lista, parent, false)

        return ViewHolder(itens)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produtos   = listaProdutos.get(position)
        Log.i("Valor dos campos1", produtos.getName())
        Log.i("Valor dos campos2", produtos.getDescricao())
        Log.i("Valor dos campos3", produtos.getQuantidade().toString())
        Log.i("Valor dos campos4", produtos.getPrecoUnitario().toString())
        holder.nomeProduto.text = produtos.getName()
        holder.descricao.text = produtos.getDescricao()
        holder.quantidade.text = "Quantidade: "+ produtos.getQuantidade().toString()
        holder.preco.text = "Preço Unitário: " + produtos.getPrecoUnitario().toString()

//        holder.nomeProduto.text = "Teste"
//        holder.descricao.text = "Nognowbguwfgvn"
//        holder.quantidade.text = "Quantidade: 1000"
//        holder.preco.text = "Preço: 15.50"
    }

    override fun getItemCount(): Int {

        return listaProdutos.size
    }

}