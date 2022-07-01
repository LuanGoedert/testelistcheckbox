package com.example.testelistcheckbox.itemlist

class SeedingService {

    fun retornaListaItens(): MutableList<ItemList> {
        return mutableListOf<ItemList>(
            ItemList(
                "1",
                "Moda",
                isExpanded = true
                , itensList = mutableListOf(
                    ItemList(
                        "1.2", "masculino",
                        mutableListOf(
                            ItemList(
                                "1.2.1", "camisa",
                                mutableListOf(
                                    ItemList("1.2.1.1", "camisa brusque", null),
                                    ItemList("1.2.1.2", "camisa flamengo", null)
                                )
                            ), ItemList(
                                "1.2.2", "bermuda",
                                mutableListOf(
                                    ItemList("1.2.2.2", "bermuda jeans", null),
                                    ItemList("1.2.2.1", "bermuda tactel", null)
                                )
                            )
                        )
                    ), ItemList(
                        "1.3", "Feminino",
                        mutableListOf(
                            ItemList(
                                "1.3.1", "jeans",
                                mutableListOf(
                                    ItemList("1.3.1.1", "patricia foster", null),
                                    ItemList("1.3.1.2", "beto carreiro", null)
                                )
                            ), ItemList(
                                "1.3.2", "sandalia",
                                mutableListOf(
                                    ItemList("1.3.2.1", "havaianas", null),
                                    ItemList("1.3.2.2", "ipanema", null)
                                )
                            )
                        )
                    ), ItemList(
                        "1.4", "Infantil",
                        mutableListOf(
                            ItemList(
                                "1.4.1", "camisa",
                                mutableListOf(
                                    ItemList("1.4.1.1", "camisa ben 10", null),
                                    ItemList("1.4.1.2", "camisa hulk", null)
                                )
                            ), ItemList(
                                "1.4.2", "tenis",
                                mutableListOf(
                                    ItemList("1.4.2.1", "tenis seninha", null),
                                    ItemList("1.4.2.2", "tenis homem aranha", null)
                                )
                            )
                        )
                    )
                )
            ), ItemList(
                "2",
                "Cama",
                isExpanded = true,
                itensList = mutableListOf(
                    ItemList(
                        "2.1", "Toalha",
                        mutableListOf(
                            ItemList(
                                "2.1.1", "Toalha de banho",
                                mutableListOf(
                                    ItemList("2.1.1.1", "Toalha marrom", null),
                                    ItemList("2.1.1.2", "toalha azul", null)
                                )
                            ), ItemList(
                                "2.1.2", "Toalha de praia",
                                mutableListOf(
                                    ItemList("2.1.2.1", "toalha preta", null),
                                    ItemList("2.1.2.2", "toalha branca", null),
                                    ItemList("2.1.2.3", "toalha amarela", null),
                                    ItemList("2.1.2.4", "toalha cinza", null),
                                    ItemList("2.1.2.5", "toalha laranja", null)
                                )

                            )
                        )
                    )
                )
            )
        )
    }
}