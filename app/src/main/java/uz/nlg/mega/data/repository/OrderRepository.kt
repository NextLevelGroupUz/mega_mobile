package uz.nlg.mega.data.repository

import uz.nlg.mega.data.remote.ApiServiceWithAuth
import uz.nlg.mega.model.Cart
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val apiService: ApiServiceWithAuth
) {
    suspend fun getCart() = apiService.getCart()
    suspend fun deleteItem(id: Int) = apiService.deleteCartItem(id)
    suspend fun saveCheque(cart: Cart) = apiService.saveCheque(cart)

}