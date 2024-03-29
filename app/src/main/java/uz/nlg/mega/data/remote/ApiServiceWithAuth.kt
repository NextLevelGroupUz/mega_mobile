package uz.nlg.mega.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import uz.nlg.mega.model.Cart
import uz.nlg.mega.model.CartAddProduct
import uz.nlg.mega.model.CartClient
import uz.nlg.mega.model.CartResponse
import uz.nlg.mega.model.Category
import uz.nlg.mega.model.Cheque
import uz.nlg.mega.model.ChequeDetailResponse
import uz.nlg.mega.model.Client
import uz.nlg.mega.model.Credit
import uz.nlg.mega.model.Pagination
import uz.nlg.mega.model.Payment
import uz.nlg.mega.model.PendingCheque
import uz.nlg.mega.model.Product
import uz.nlg.mega.model.Profile
import uz.nlg.mega.model.Refresh
import uz.nlg.mega.model.SearchClientResponse
import uz.nlg.mega.model.Subcategory

interface ApiServiceWithAuth {

    @GET("cheques/")
    suspend fun getAllCheques(
        @Query("status") status: String = "",
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 15,
    ): Response<Pagination<Cheque>>


    @DELETE("cheques/{id}/")
    suspend fun deleteCheque(
        @Path("id") id: Int,
    ): Response<Unit>

    @GET("cheques/{id}/")
    suspend fun getChequeById(
        @Path("id") id: Int
    ): Response<ChequeDetailResponse>

    @POST("cheques/pending-change/")
    suspend fun addChequeToCart(
        @Body body: PendingCheque
    ): Response<Unit>

    @GET("profile/")
    suspend fun getProfile(): Response<Profile>

    @POST("auth/logout/")
    suspend fun profileLogOut(
        @Body refresh: Refresh
    ): Response<Unit>

    @GET("products-for-mobile/")
    suspend fun getProducts(
        @Query("search") search: String = "",
        @Query("ordering") ordering: String = "",
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 15
    ): Response<Pagination<Product>>

    @GET("products-for-mobile/")
    suspend fun getProductsBySubcategory(
        @Query("subcategory") subcategoryId: Int,
        @Query("page_size") pageSize: Int = 15
    ): Response<Pagination<Product>>

    @GET("categories/")
    suspend fun getCategories(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 15
    ): Response<Pagination<Category>>

    @GET("subcategories/")
    suspend fun getSubcategories(
        @Query("category_ids") categoryId: Int,
        @Query("page_size") pageSize: Int = 15
    ): Response<Pagination<Subcategory>>

    @GET("clients/")
    suspend fun searchClient(
        @Query("search") search: String = "",
        @Query("is_debt") isDebt: Boolean? = null,
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int = 20,
    ): Response<SearchClientResponse>

    @POST("clients/")
    suspend fun addClient(
        @Body client: Client
    ): Response<Client>

    @PUT("clients/{id}/")
    suspend fun editClient(
        @Path("id") id: Int,
        @Body client: Client
    ): Response<Client>


    @GET("payments/")
    suspend fun getPaymentHistoryByClient(
        @Query("client") client: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int = 20,
        //@Query("payment_type") paymentType: String = "debt",
    ): Response<Pagination<Payment>>

    @GET("cart/")
    suspend fun getCart(): Response<CartResponse>

    @DELETE("cart-items/{id}/")
    suspend fun deleteCartItem(
        @Path("id") id: Int
    ): Response<Unit>

    @PATCH("cart/")
    suspend fun addCustomer(
        @Body client: CartClient = CartClient(null)
    ): Response<CartResponse>

    @POST("cart-items/")
    suspend fun addProductToCart(
        @Body product: CartAddProduct
    ): Response<CartAddProduct>

    @POST("cheques/")
    suspend fun saveCheque(
        @Body cart: Cart
    ): Response<Cart>

    @POST("payments/")
    suspend fun returnCredits(
        @Body credit: Credit
    ): Response<Credit>

    @GET("payments/")
    suspend fun getDebtByDayOrMonth(
        @Query("search") search: String,
        @Query("seller") seller: String,
        @Query("created_at_min") createdAtMin: String,
        @Query("created_at_max") createdAtMax: String,
        @Query("payment_type") paymentType: String = "debt",
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int = 20,
    ): Response<Pagination<Payment>>


    @GET("clients/{id}/")
    suspend fun getClientById(
        @Path("id") id: Int,
    ): Response<Client>

}