package com.example.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodInsertAdapter extends BaseAdapter {
    private Context context;
    ImageView foodImg;
    TextView foodName, foodExpirationDate, foodDday;
    EditText foodNameEdit, foodExpirationDateEdit;
    FoodDTO foodDTO;
    private List<FoodDTO> list;

    private ArrayList<FoodDTO> items = new ArrayList<FoodDTO>();
    LayoutInflater inflater;

    public FoodInsertAdapter(Context context, ArrayList<FoodDTO> list) {
        this.context = context;
        this.list = list;
    }


    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if(items == null){
            return 0;
        }else return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_foodinsert,null);

            viewHolder = new ViewHolder();
            viewHolder.foodName = convertView.findViewById(R.id.foodName);
            viewHolder.foodExpirationDate = convertView.findViewById(R.id.foodExpirationDate);
            viewHolder.foodNameEdit = convertView.findViewById(R.id.foodNameEdit);
            viewHolder.foodExpirationDateEdit = convertView.findViewById(R.id.foodExpirationDateEdit);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

//        viewHolder.foodName.setText(items.get(position).getFoodName());
//        viewHolder.foodExpirationDate.setText(items.get(position).getExpirationDate());

        return convertView;
    }
    public void addItem(FoodDTO food){
        items.add(food);

    }
    static class ViewHolder{
        TextView foodName;
        TextView foodExpirationDate;
        EditText foodNameEdit, foodExpirationDateEdit;
    }
}
