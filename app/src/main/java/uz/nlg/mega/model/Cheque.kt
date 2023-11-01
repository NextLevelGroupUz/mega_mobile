package uz.nlg.mega.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cheque(
    @SerializedName("cheque_sum")
    val chequeSum: Long,
    @SerializedName("client")
    val client: Client,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("items_count")
    val itemsCount: Int,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("serial_number")
    val serialNumber: Int,
    @SerializedName("status")
    val status: String
): Serializable

data class Seller(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
): Serializable

data class Client(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("phone_number")
    val phoneNumber: String
): Serializable