package uz.nlg.mega.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.nlg.mega.R
import uz.nlg.mega.model.BottomNav
import uz.nlg.mega.model.Subcategory
import java.io.Serializable

val MainFont = FontFamily(
    Font(R.font.regular, FontWeight.Normal),
    Font(R.font.bold, FontWeight.Bold),
    Font(R.font.medium, FontWeight.Medium)
)

val PADDING_VALUE = 16.dp

enum class ScreenID {
    ChequesScreen,
    OrdersScreen,
    ProductsScreen,
    CustomersScreen,
    ProfileScreen
}

var ScreensList = listOf(
    BottomNav(
        id = ScreenID.ChequesScreen,
        route = "cheque",
        icon = R.drawable.cheques,
        title = R.string.str_cheques,
    ),
    BottomNav(
        id = ScreenID.OrdersScreen,
        route = "orders",
        icon = R.drawable.orders,
        title = R.string.str_orders
    ),
    BottomNav(
        id = ScreenID.ProductsScreen,
        route = "products",
        icon = R.drawable.products,
        title = R.string.str_products
    ),
    BottomNav(
        id = ScreenID.CustomersScreen,
        route = "customers",
        icon = R.drawable.customers,
        title = R.string.str_customers
    ),
    BottomNav(
        id = ScreenID.ProfileScreen,
        route = "profile",
        icon = R.drawable.profile,
        title = R.string.str_profile
    )
)

sealed class FilterType(val status: Boolean?) {
    data object Qarzdorlar : FilterType(status = true)
    data object Haqdorlar : FilterType(status = false)
    data object InAscendingOrder : FilterType(status = true)
    data object InDescendingOrder : FilterType(status = false)

    data object None : FilterType(status = null)
}

enum class ProductSearchType {
    ByCategory,
    ByMoreSold,
    None
}

sealed class ChequeType(val status: String) : Serializable {
    data object Pending : ChequeType("pending")
    data object Done : ChequeType("done")
    data object Returned : ChequeType("returned")
    data object None : ChequeType("")
}

sealed class PaymentType(val title: Int) : Serializable {
    data object Cash : PaymentType(title = R.string.str_cash)
    data object OnlinePayment : PaymentType(title = R.string.str_online_payment)
    data object Credit : PaymentType(title = R.string.str_credit)
    data object Humo : PaymentType(title = R.string.str_humo)

    data object UzCard: PaymentType(title = R.string.str_uzcard)
}

enum class CreditType : Serializable {
    Daily,
    Monthly
}

const val MostSoldProducts = "sales_number"

const val AccessToken = "access"
const val RefreshToken = "refresh"
const val IsSignedIn = "isSignedIn"
const val ProfileName = "profileName"
const val SellerId = "sellerId"

val TopFirstSubCategory = Subcategory(0, "Kategoriyalar", 0)

const val SomethingWentWrong = "Xatolik sodir bo'ldi"
const val ServerError = "Serverda xatolik sodir bo'ldi, Xatolik codi: "
const val OrderCustomerNullError = "Iltimos mijozni tanlang"
const val OrderNoProductError = "Savatchangiz hali bosh, iltimos uni to'ldiring"
const val PaymentNoEqualSum = "Kiritilgan summa tavorlar narxidan kam bo'lmasligi kerak"
const val AddProductQuantityError = "Tovar miqdorini kiriting"
const val AddProductPriceError = "Tovar miqdorini kiriting"
const val PaymentPriceError = "Iltimos 0 dan katta summa kiriting"
const val NoInternetError = "Iltimos internetga ulanganligingizni tekshiring"

const val FilterMinusBalance = "-balance"
const val FilterPlusBalance = "balance"
