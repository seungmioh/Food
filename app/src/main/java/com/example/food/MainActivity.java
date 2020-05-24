package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView foodList;
    Button foodInsertBtn;
    Context context;
    private FoodDTO foodDTO;
    public ArrayList<FoodDTO> list;
    private FoodInsertAdapter foodInsertAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = findViewById(R.id.foodList);
        foodInsertBtn = findViewById(R.id.foodInsertBtn);
        list = new ArrayList<>();

//        Bundle bundle = getIntent().getExtras();
//        bundle.getSerializable("food");
        list.add(new FoodDTO("딸기","2020-04-24"));
//        list.add(new FoodDTO(foodInsertAdapter.foodNameEdit.getText().toString(), foodInsertAdapter.foodExpirationDateEdit.getText().toString()));

        foodInsertAdapter = new FoodInsertAdapter(context, list);
        foodList.setAdapter(foodInsertAdapter);
        foodList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        foodInsertAdapter.addItem(foodDTO);
        foodInsertAdapter.setContext(this);
        foodInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FoodInsertActivity.class);
                startActivity(intent);
            }
        });


    }
}
