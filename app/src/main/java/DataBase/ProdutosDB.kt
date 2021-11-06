package DataBase

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log

class ProdutosDB (context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private val DB_NAME = "produtos.db"
        private val DB_VERSION = 2
        private const val TABLE_NAME = "produto"
         val ID = "_id"
         val NOME_PRODUTO = "nome"
         val DESCRICAO = "descricao"
         val QUANTIDADE =  "quantidade"
         val PRECO_UNITARIO = "preco"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("Primeiro", db.toString())
        val sql = "CREATE TABLE "+TABLE_NAME+"(" +
               ID+" integer primary key autoincrement,"+
               NOME_PRODUTO+" text,"+
               DESCRICAO+" text,"+
               QUANTIDADE+" text,"+
               PRECO_UNITARIO+" text"+")"

        db?.execSQL(sql)

        Log.i("Segundo", db.toString())

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

}


