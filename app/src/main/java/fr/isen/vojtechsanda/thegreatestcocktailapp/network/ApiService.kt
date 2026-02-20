package fr.isen.vojtechsanda.thegreatestcocktailapp.network

import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.CategoriesResponse
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.DrinkDetailResponse
import fr.isen.vojtechsanda.thegreatestcocktailapp.dtos.DrinksListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("random.php")
    suspend fun getRandomDrink(): DrinkDetailResponse

    @GET("list.php?c=list")
    suspend fun getCategories(): CategoriesResponse

    @GET("filter.php")
    suspend fun getDrinksForCategory(
        @Query("c") category: String
    ): DrinksListResponse

    @GET("lookup.php")
    suspend fun getDrinkDetail(
        @Query("i") drinkId: String
    ): DrinkDetailResponse
}
