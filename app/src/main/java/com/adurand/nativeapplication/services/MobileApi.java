package com.adurand.nativeapplication.services;

import com.adurand.nativeapplication.models.MagazineModel;
import com.adurand.nativeapplication.models.OfferModel;
import com.adurand.nativeapplication.models.OrderListModel;
import com.adurand.nativeapplication.models.OrderModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by adurand on 31/01/17.
 */

public interface MobileApi {

    // Magazine Endpoints
    @GET("magazines")
    Call<List<MagazineModel>> getMagazines();

    // Offer Endpoints
    @GET("offers")
    Call<List<OfferModel>> getOffers(@Query("page") Integer page, @Query("size") Integer size);

    // OrderList Endpoints
    @POST("order-lists")
    Call<OrderListModel> createOrderList(@Body OrderListModel orderList);

    @GET("order-lists/{id}")
    Call<OrderListModel> readOrderList(@Path("id") Integer id);

    @DELETE("order-lists/{id}")
    Call<Void> deleteOrderList(@Path("id") Integer id);

    @GET("order-lists")
    Call<List<OrderListModel>> getOrderLists(@Query("user") String user);

    @POST("order-lists/{idList}/orders")
    Call<List<OrderModel>> createOrder(@Path("idList") Integer idList, @Body OrderModel order);

    @PUT("order-lists/{idList}/orders/{idOrder}")
    Call<List<OrderModel>> updateOrder(@Path("idList") Integer idList, @Path("idOrder") Integer idOrder, @Body OrderModel order);

    @DELETE("order-lists/{idList}/orders/{idOrder}")
    Call<Void> deleteOrder(@Path("idList") Integer idList, @Path("idOrder") Integer idOrder);

    @GET("order-lists/{idList}/orders")
    Call<List<OrderModel>> getOrders(@Path("idList") Integer idList);

    @POST("order-lists/{idList}/users")
    Call<List<String>> addUserToOrderList(@Path("idList") Integer idList);

    @DELETE("order-lists/{idList}/users/{user}")
    Call<List<String>> deleteUserFromOrderList(@Path("idList") Integer idList, @Path("user") String user);

    @GET("order-lists/{idList}/users")
    Call<List<String>> getUsersFromOrderList(@Path("idList") Integer idList);


}
