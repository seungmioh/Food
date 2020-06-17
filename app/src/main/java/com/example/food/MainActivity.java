package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private final String TAG = getClass().getSimpleName();
    private MyAPI myAPI;
    public ListView foodList;
    Button foodInsertBtn;


    Context context;
    public FoodDTO foodDTO;
    public List<FoodDTO> list;
    public FoodInsertAdapter foodInsertAdapter;
    String BASE_URL ="http://ddaf208b8d23.ngrok.io";

    private FoodCustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = findViewById(R.id.foodList);
        foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);

        foodInsertBtn = findViewById(R.id.foodInsertBtn);
        list = new ArrayList<FoodDTO>();

//      bundle.getSerializable("food");

//      list.add(new FoodDTO(foodInsertAdapter.foodNameEdit.getText().toString(), foodInsertAdapter.foodExpirationDateEdit.getText().toString()));
//        list.add(new FoodDTO("초코","2020-04-20"));
//        list.add(new FoodDTO("딸기","2020-04-24"));
//        list.add(new FoodDTO("초코","2020-04-20"));
//        list.add(new FoodDTO("딸기","2020-04-24"));
//        list.add(new FoodDTO("딸기","2020-04-24"));
//        list.add(new FoodDTO("초코","2020-04-20"));

        initMyAPI(BASE_URL);
        Call<List<FoodDTO>> getList = myAPI.get_food();
        getList.enqueue(new Callback<List<FoodDTO>>() {
            @Override
            public void onResponse(Call<List<FoodDTO>> call, Response<List<FoodDTO>> response) {
                if(response.isSuccessful()){
                    List<FoodDTO> fList = response.body();
                    list.clear();
                    for(FoodDTO foodDTO : fList){
                        String foodE = foodDTO.getFood_expirationDate();
                        String result = foodE.substring(0, foodE.lastIndexOf("T"));
                        list.add(new FoodDTO(foodDTO.getFood_name(), result));
                        foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);
                        foodInsertAdapter.addItem(list);
                        foodList.setAdapter(foodInsertAdapter);
                        foodInsertAdapter.notifyDataSetChanged();
//                        foodList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                    }
                }
                else{
                    Log.e(TAG,"Status Code:"+response.body());
                }
            }
            @Override
            public void onFailure(Call<List<FoodDTO>> call, Throwable t) {
                Log.d(TAG, "Fail msg: "+t.getMessage());
            }
        });
        foodList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                FoodCustomDialog customDialog = new FoodCustomDialog(MainActivity.this);

                return true;
            }
        });
//        foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);
//        foodInsertAdapter.addItem(list);
//        foodList.setAdapter(foodInsertAdapter);
//        foodInsertAdapter.notifyDataSetChanged();
//        foodList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);



    //  foodInsertAdapter.addItem(list);
        // foodInsertAdapter.setContext(this);
        foodInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodInsertActivity.class);
                startActivity(intent);
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
}
