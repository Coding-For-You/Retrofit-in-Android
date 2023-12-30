package com.example.retrofilt1.api;

import com.example.retrofilt1.model.UserModel;
import com.example.retrofilt1.model.UserModelItem;
import com.example.retrofilt1.model.productList.ProductListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("posts")
    Call<List<UserModelItem>> getUserData();

    @GET("products")
    Call<ProductListResponse> getProdutData();
}
