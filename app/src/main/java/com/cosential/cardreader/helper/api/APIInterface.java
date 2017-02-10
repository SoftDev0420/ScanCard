package com.cosential.cardreader.helper.api;

import com.cosential.cardreader.model.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by softdev0420 on 9/21/16.
 */

public interface APIInterface {

    //  Status

    @GET("status")
    Call<BaseResponse> checkStatus();

    //  User

    @POST("authentication")
    Call<BaseResponse> signIn(@Query("email") String email, @Query("password") String password);

//    @POST("registration")
//    Call<BaseResponse> createAccount(@Body User user);
//
//    @GET("user")
//    Call<BaseResponse> getUser();
//
//    @PUT("user")
//    Call<BaseResponse> updateUser(@Body User user);
//
//    @GET("user/client_token")
//    Call<BaseResponse> getClientToken();
//
//    //  Card
//
//    @GET("cards")
//    Call<BaseResponse> getCards();
//
//    @POST("cards")
//    Call<BaseResponse> addCard(@Query("payment_nonce") String paymentNonce, @Query("description") String description);
//
//    @DELETE("cards/{cardUuid}")
//    Call<BaseResponse> deleteCard(@Path("cardUuid") String cardUuid);
//
//    @PUT("cards/{cardUuid}")
//    Call<BaseResponse> updateCard(@Path("cardUuid") String cardUuid, @Query("description") String description);
//
//    //  Vendor
//
//    @POST("vendors")
//    Call<BaseResponse> getVendors(@Query("latitude") Double latitude, @Query("longitude") Double longitude, @Query("distance") Integer distance);
//
//    @GET("vendors/all")
//    Call<BaseResponse> getAllVendors();
//
//    @GET("vendors/{vendorUuid}/maps")
//    Call<BaseResponse> getVendorMaps(@Path("vendorUuid") String vendorUuid);
//
//    @POST("vendors/{vendorUuid}/validate_code")
//    Call<BaseResponse> validateVendorCode(@Path("vendorUuid") String vendorUuid, @Query("code") String code);
//
//    //  Menu
//
//    @POST("menu")
//    Call<BaseResponse> getMenu(@Query("location_id") String locationId);
//
//    //  Order
//
//    @POST("order")
//    Call<BaseResponse> placeOrder(@Body OrderInfo orderInfo);
//
//    @GET("orders/active")
//    Call<BaseResponse> getActiveOrders();
//
//    @GET("orders/history")
//    Call<BaseResponse> getOrderHistory();
//
//    @POST("orders/{orderUuid}/complete")
//    Call<OrderResponse> completeOrder(@Path("orderUuid") String orderUuid);
}
