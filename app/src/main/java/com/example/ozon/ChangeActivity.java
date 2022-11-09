package com.example.ozon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChangeActivity extends AppCompatActivity implements View.OnClickListener {


    EditText name;
    EditText price;
    EditText weight;
    EditText nameproz;
    EditText country;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change2);

        name = findViewById(R.id.tvname);
        price = findViewById(R.id.tvprice);
        weight = findViewById(R.id.tvweight);
        nameproz = findViewById(R.id.tvnameproz);
        country = findViewById(R.id.tvcountry);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        //loadingPB.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ngknn.ru:5001/ngknn/герасимовна/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<DataModal> call = retrofitAPI.getDATA(MainActivity.keyID);
        call.enqueue(new Callback<DataModal>() {

            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {

//                if(!response.isSuccessful())
//                {
//                    Toast.makeText(ChangeActivity.this, "При выводе данных возникла ошибка", Toast.LENGTH_SHORT).show();
//                    ;
//                }





                name.setText(response.body().getName());
                price.setText(response.body().getPrice().toString());
                weight.setText(response.body().getWeight());
                nameproz.setText(response.body().getNameProiz());
                country.setText(response.body().getCountryProiz());


//
            }
            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                Toast.makeText(ChangeActivity.this, "При выводе данных возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
                // loadingPB.setVisibility(View.INVISIBLE);
            }
        });




    }



}
