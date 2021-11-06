package model

class ProdutosModel {
    private lateinit var nome_produto: String
    private lateinit var descricao: String
    private var quantidade: Double = 0.0
    private var preco_unitario: Double = 0.0

    constructor(
        nome_produto: String,
        descricao: String,
        quantidade: Double,
        preco_unitario: Double
    ) {
        this.nome_produto = nome_produto
        this.descricao = descricao
        this.quantidade = quantidade
        this.preco_unitario = preco_unitario
    }

    fun getName() : String{
        return nome_produto
    }

    fun getDescricao() : String
    {
        return descricao
    }

    fun getQuantidade() : Double
    {
        return quantidade
    }

    fun getPrecoUnitario() : Double
    {
        return preco_unitario
    }


}