package com.example.exibirpatrimoniosactivity.data

/**
 * Dados de exemplo. Substitua por um repositório real (Room / API) quando existir.
 * Apenas o patrimônio 1 veio da tela original; os demais são fictícios.
 */
object PatrimonioMock {

    val lista: List<Patrimonio> = listOf(
        Patrimonio(
            id = 1,
            codigo = "2-004321",
            item = "Notebook Dell i7",
            serie = "190843792432",
            descricao = "Notebook Dell i7 de 13º Geração com 16 gb ram, 1tb de armazenamento e uma rtx 4050 com mais 8gb ram.",
            localizacao = "Armazém A, Corredor 3",
            prateleira = "Seção D, Nível 2",
            tipo = TipoPatrimonio.NOTEBOOK
        ),
        Patrimonio(
            id = 2,
            codigo = "2-004322",
            item = "Computador Desktop",
            serie = "190843792433",
            descricao = "Computador desktop com 16 gb de RAM e SSD de 512 gb.",
            localizacao = "Armazém A, Corredor 4",
            prateleira = "Seção B, Nível 1",
            tipo = TipoPatrimonio.COMPUTADOR
        ),
        Patrimonio(
            id = 3,
            codigo = "2-004323",
            item = "Notebook Lenovo i5",
            serie = "190843792434",
            descricao = "Notebook Lenovo i5 com 8 gb de RAM e SSD de 256 gb.",
            localizacao = "Armazém B, Corredor 1",
            prateleira = "Seção A, Nível 3",
            tipo = TipoPatrimonio.NOTEBOOK
        ),
        Patrimonio(
            id = 4,
            codigo = "2-004324",
            item = "Notebook Acer Ryzen 5",
            serie = "190843792435",
            descricao = "Notebook Acer Ryzen 5 com 16 gb de RAM e SSD de 512 gb.",
            localizacao = "Armazém B, Corredor 2",
            prateleira = "Seção C, Nível 2",
            tipo = TipoPatrimonio.NOTEBOOK
        ),
        Patrimonio(
            id = 5,
            codigo = "2-004325",
            item = "Computador All-in-One",
            serie = "190843792436",
            descricao = "Computador all-in-one com tela de 24 polegadas, 8 gb de RAM e SSD de 256 gb.",
            localizacao = "Armazém C, Corredor 1",
            prateleira = "Seção E, Nível 1",
            tipo = TipoPatrimonio.COMPUTADOR
        )
    )

    fun buscarPorId(id: Int): Patrimonio? = lista.firstOrNull { it.id == id }
}
