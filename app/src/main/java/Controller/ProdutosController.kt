package Controller

import DataBase.ProdutosDB
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import model.ProdutosModel


class ProdutosController (context : Context) {

    private lateinit var dataBase : SQLiteDatabase
    private var produtos = ProdutosDB(context)

    fun addProduto(nome: String, descricao: String, quantidade : String, preco: String): String{
        dataBase = produtos.writableDatabase

        Log.i("Teste", dataBase.toString())
        var dados = ContentValues()

        dados.put("preco", preco)
        dados.put("nome", nome)
        dados.put("descricao", descricao)
        dados.put("quantidade", quantidade)


        var result  = dataBase.insert("produto", null, dados)
        dataBase.close()
        if (result < 0)
            return "erro ao inserir registro"
        else
            return "registro inserido com sucesso"

    }

    fun listarProdutos() : ArrayList<ProdutosModel>{

        val cursor : Cursor
        val campos = arrayOf(ProdutosDB.NOME_PRODUTO, ProdutosDB.DESCRICAO, ProdutosDB.PRECO_UNITARIO, ProdutosDB.QUANTIDADE)
        val array  =  ArrayList<ProdutosModel>()
        dataBase = produtos.readableDatabase

        cursor =  dataBase.query("produto", campos,null, null, null, null, null, null)

        if(cursor!=null){
            if (cursor.moveToFirst())
            {

                do {
                    val indexNome = cursor.getColumnIndex(ProdutosDB.NOME_PRODUTO)
                    val indexDesc = cursor.getColumnIndex(ProdutosDB.DESCRICAO)
                    val indexquantidade = cursor.getColumnIndex(ProdutosDB.QUANTIDADE)
                    val indexPreco = cursor.getColumnIndex(ProdutosDB.PRECO_UNITARIO)
                    val prod = ProdutosModel(
                        cursor.getString(indexNome),
                        cursor.getString(indexDesc),
                        cursor.getDouble(indexquantidade),
                        cursor.getDouble(indexPreco)
                    )
                    array.add(prod)
                }while (cursor.moveToNext())
            }
        }
        dataBase.close();

        return array
    }
}