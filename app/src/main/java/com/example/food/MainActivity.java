package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView foodList;
    Button foodInsertBtn;
//    ScrollView food_scroll;
    Context context;
    public FoodDTO foodDTO;
    static List<FoodDTO> list;
    public FoodInsertAdapter foodInsertAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = findViewById(R.id.foodList);
        foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);

        foodInsertBtn = findViewById(R.id.foodInsertBtn);
        list = new ArrayList<FoodDTO>();

//        bundle.getSerializable("food");


//        list.add(new FoodDTO(foodInsertAdapter.foodNameEdit.getText().toString(), foodInsertAdapter.foodExpirationDateEdit.getText().toString()));
        list.add(new FoodDTO("초코","2020-04-20"));
        list.add(new FoodDTO("딸기","2020-04-24"));
        list.add(new FoodDTO("초코","2020-04-20"));
        list.add(new FoodDTO("딸기","2020-04-24"));
        list.add(new FoodDTO("딸기","2020-04-24"));
        list.add(new FoodDTO("초코","2020-04-20"));
        list.add(new FoodDTO("딸기","2020-04-24"));
        list.add(new FoodDTO("초코","2020-04-20"));
        foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);
        foodInsertAdapter.addItem(list);
        foodList.setAdapter(foodInsertAdapter);
        Log.e("list_size", String.valueOf(list.size()));
        foodInsertAdapter.notifyDataSetChanged();
        foodList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

    //  foodInsertAdapter.addItem(list);
     //   foodInsertAdapter.setContext(this);
        foodInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodInsertActivity.class);
                startActivity(intent);
            }
        });

//        food_scroll.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                food_scroll.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });


    }
}
