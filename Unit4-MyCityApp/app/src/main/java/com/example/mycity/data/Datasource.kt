package com.example.mycity.data

import com.example.mycity.R

object Datasource {

    private val restaurantsCategory = Category(
        name = R.string.restaurants_category,
        icon = R.drawable.restaurant_icon,
        list = listOf(
            Place(
                name = R.string.leces_title,
                description = R.string.leces_description,
                address = R.string.leces_address,
                photo = R.drawable.leces
            ),
            Place(
                name = R.string.teko_title,
                description = R.string.teko_description,
                address = R.string.teko_address,
                photo = R.drawable.teko
            ),
        )
    )



    private val shopsCategory=Category(
        name=R.string.shops_category,
        icon=R.drawable.shops_icon,
        list = listOf(
            Place(
                name = R.string.aspla_title,
                description = R.string.aspla_description,
                address = R.string.aspla_address,
                photo = R.drawable.aspla
            ),
            Place(
                name = R.string.jatos_title,
                description = R.string.jatos_description,
                address = R.string.jatos_address,
                photo = R.drawable.jatos
            ),
        )
    )

    private val attractionsCategory= Category(
        name = R.string.attractions_category,
        icon = R.drawable.attractions_icon,
        list = listOf(
            Place(
                name = R.string.cadas_pangeran_title,
                description = R.string.cadas_pangeran_description,
                address = R.string.cadas_pangeran_address,
                photo = R.drawable.cadas
            ),
            Place(
                name = R.string.jatigede_title,
                description = R.string.jatigede_description,
                address = R.string.jatigede_address,
                photo = R.drawable.jatigede
            ),
        )

    )
    val listOfCategories = listOf(restaurantsCategory, shopsCategory, attractionsCategory)

}