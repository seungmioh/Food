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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FoodInsertActivity extends AppCompatActivity {
    Button foodOk;
    Button foodCencel;
    EditText foodNameEdit;
    EditText foodExpirationDateEdit;
    Spinner foodKategore;
    RadioButton foodLike;
    RadioButton foodUnLike;

    MainActivity mainActivity;

    private List<FoodDTO> list;

    public FoodDTO food;
    Context context;
    FoodInsertAdapter foodInsertAdapter = new FoodInsertAdapter(getBaseContext(), list);
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

        foodOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food = new FoodDTO(foodNameEdit.getText().toString(), foodExpirationDateEdit.getText().toString());
//                intent = new Intent(getApplicationContext(), MainActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("food",food);
//                intent.putExtras(bundle);
//                mainActivity.list.add(list);
                foodInsertAdapter.addItem(food);
                Log.e("foodDTO",food.getFoodName() + " "+ food.getExpirationDate());
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
