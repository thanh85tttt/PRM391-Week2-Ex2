package com.buitrungthanh.week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.buitrungthanh.week2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyViewModel model;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        model = new ViewModelProvider(this).get(MyViewModel.class);

        arrayList = model.getListHistory();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        binding.lvHistory.setAdapter(arrayAdapter);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(binding.edtA.getText().toString().trim()) +
                        Integer.parseInt(binding.edtB.getText().toString().trim());
                model.addToList(
                        binding.edtA.getText().toString() + " + " +
                                binding.edtB.getText().toString() + " = " + result
                );
                arrayAdapter.notifyDataSetChanged();
            }
        });

        binding.btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(binding.edtA.getText().toString().trim()) -
                        Integer.parseInt(binding.edtB.getText().toString().trim());
                model.addToList(
                        binding.edtA.getText().toString() + " - " +
                                binding.edtB.getText().toString() + " = " + result
                );
                arrayAdapter.notifyDataSetChanged();
            }
        });

        binding.btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(binding.edtA.getText().toString().trim()) *
                        Integer.parseInt(binding.edtB.getText().toString().trim());
                model.addToList(
                        binding.edtA.getText().toString() + " * " +
                                binding.edtB.getText().toString() + " = " + result
                );
                arrayAdapter.notifyDataSetChanged();
            }
        });

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   double result = Double.parseDouble(binding.edtA.getText().toString().trim()) /
                           Double.parseDouble(binding.edtB.getText().toString().trim());
                   model.addToList(
                           binding.edtA.getText().toString() + " / " +
                                   binding.edtB.getText().toString() + " = " + result
                   );
                   arrayAdapter.notifyDataSetChanged();
               }catch (NumberFormatException e){
                    model.addToList(e.getMessage());
                   arrayAdapter.notifyDataSetChanged();
               }
            }
        });
    }
}