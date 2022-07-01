package com.example.testelistcheckbox.itemlist

class SeedingService {

    fun retornaListaItens(): MutableList<ProdutoFamilia> {
        return mutableListOf<ProdutoFamilia>(
            ProdutoFamilia(
                "1",
                "Moda",
                isExpanded = true
                , itensList = mutableListOf(
                    ProdutoFamilia(
                        "1.2", "masculino",
                        isChecked = false,
                        mutableListOf(
                            ProdutoFamilia(
                                "1.2.1", "camisa",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.2.1.1", "camisa brusque", itensList = null, isChecked = false),
                                    ProdutoFamilia("1.2.1.2", "camisa flamengo", itensList = null, isChecked = false)
                                )
                            ), ProdutoFamilia(
                                "1.2.2", "bermuda",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.2.2.2", "bermuda jeans", itensList = null, isChecked = false),
                                    ProdutoFamilia("1.2.2.1", "bermuda tactel", itensList = null, isChecked = false)
                                )
                            )
                        )
                    ), ProdutoFamilia(
                        "1.3", "Feminino",
                        isChecked = false,
                        mutableListOf(
                            ProdutoFamilia(
                                "1.3.1", "jeans",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.3.1.1", "patricia foster",  isChecked = false, itensList = null),
                                    ProdutoFamilia("1.3.1.2", "beto carreiro", itensList = null, isChecked = false)
                                )
                            ), ProdutoFamilia(
                                "1.3.2", "sandalia",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.3.2.1", "havaianas", itensList = null, isChecked = false),
                                    ProdutoFamilia("1.3.2.2", "ipanema", itensList = null, isChecked = false)
                                )
                            )
                        )
                    ), ProdutoFamilia(
                        "1.4", "Infantil",
                        isChecked = false,
                        mutableListOf(
                            ProdutoFamilia(
                                "1.4.1", "camisa",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.4.1.1", "camisa ben 10", itensList = null, isChecked = false),
                                    ProdutoFamilia("1.4.1.2", "camisa hulk", itensList = null, isChecked = false)
                                )
                            ), ProdutoFamilia(
                                "1.4.2", "tenis",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("1.4.2.1", "tenis seninha", itensList = null, isChecked = false),
                                    ProdutoFamilia("1.4.2.2", "tenis homem aranha", itensList = null, isChecked = false)
                                )
                            )
                        )
                    )
                )
            ), ProdutoFamilia(
                "2",
                "Cama",
                isExpanded = true,
                itensList = mutableListOf(
                    ProdutoFamilia(
                        "2.1", "Toalha",
                        isChecked = false,
                        mutableListOf(
                            ProdutoFamilia(
                                "2.1.1", "Toalha de banho",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("2.1.1.1", "Toalha marrom", itensList = null, isChecked = false),
                                    ProdutoFamilia("2.1.1.2", "toalha azul", itensList = null, isChecked = false)
                                )
                            ), ProdutoFamilia(
                                "2.1.2", "Toalha de praia",
                                isChecked = false,
                                mutableListOf(
                                    ProdutoFamilia("2.1.2.1", "toalha preta", itensList = null, isChecked = false),
                                    ProdutoFamilia("2.1.2.2", "toalha branca", itensList = null, isChecked = false),
                                    ProdutoFamilia("2.1.2.3", "toalha amarela", itensList = null, isChecked = false),
                                    ProdutoFamilia("2.1.2.4", "toalha cinza", itensList = null, isChecked = false),
                                    ProdutoFamilia("2.1.2.5", "toalha laranja", itensList = null, isChecked = false
                                    )
                                )

                            )
                        )
                    )
                )
            )
        )
    }
}