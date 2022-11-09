package com.example.ozon;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("nameofproduct/{id}")
    Call<DataModal> getDATA(@Path("id") int id);

    @POST("nameofproduct")
    Call<DataModal> createPost(@Body DataModal dataModal);

    @PUT("nameofproduct/{id}")
    Call<DataModal> updateData(@Query("id") int id, @Body DataModal dataModal);

    @DELETE("nameofproduct/{id}")
    Call<Void> deleteData(@Path("id") int id);

    @DELETE("nameofproduct")
    Call<Void> deleteBasaData();
}

