package com.example.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodInsertActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    Button foodOk;
    Button foodCencel;
    EditText foodNameEdit;
    EditText foodExpirationDateEdit;
    Spinner foodKategore;
    RadioButton foodLike;
    RadioButton foodUnLike;

    MyAPI myAPI;
    private List<FoodDTO> list;
    FoodDTO food;
    Context context;
    FoodInsertAdapter foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);
    String BASE_URL ="http://ddaf208b8d23.ngrok.io";
    Date date;

    MainActivity main = new MainActivity();
    protected void onCreate(Bundle savedInstanceSstae) {
        super.onCreate(savedInstanceSstae);
        setContentView(R.layout.activity_foodinsert);

        foodOk = findViewById(R.id.foodOk);
        foodCencel = findViewById(R.id.foodCencle);
        foodNameEdit = findViewById(R.id.foodNameEdit);
        foodExpirationDateEdit = findViewById(R.id.foodExpirationDateEdit);
        foodKategore = findViewById(R.id.foodKategore);
        foodLike = findViewById(R.id.foodLike);
        foodUnLike = findViewById(R.id.foodUnLike);
        list = new ArrayList<FoodDTO>();

        initMyAPI(BASE_URL);
        foodOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String foodN = foodNameEdit.getText().toString();
                String foodE = foodExpirationDateEdit.getText().toString();
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    date = dateFormat.parse(foodE);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                Log.e("foodInfo",foodNameEdit.getText().toString()+"  "+foodExpirationDateEdit.getText().toString());
                food = new FoodDTO();
                food.setFood_name(foodN);
                food.setFood_expirationDate(foodE);

                Call<FoodDTO> foodCall = myAPI.post_food(food);
                foodCall.enqueue(new Callback<FoodDTO>() {
                    @Override
                    public void onResponse(Call<FoodDTO> call, Response<FoodDTO> response) {
                        if(response.isSuccessful()){
                            list.add(new FoodDTO(food.getFood_name(),food.getFood_expirationDate()));
                            foodInsertAdapter.addItem(list);
                            foodInsertAdapter.notifyDataSetChanged();
                        }else{
                            Log.e("Status", "Status Code : "+response.code());
                            Log.e("response.erroBody()", response.errorBody().toString());
                            Log.e("call.request()", call.request().body().toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<FoodDTO> call, Throwable t) {
                        Log.e("Fail mag: ", t.getMessage());
                    }
                });
                Log.e("foodDTO",food.getFood_name() + " "+ food.getFood_expirationDate());
                finish();
            }
        });
        foodCencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void initMyAPI(String baseUrl){
        Log.d(TAG, "initMyAPI: "+baseUrl);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPI = retrofit.create(MyAPI.class);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
