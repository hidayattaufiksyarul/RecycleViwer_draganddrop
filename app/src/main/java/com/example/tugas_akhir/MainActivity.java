package com.example.tugas_akhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildData();
        iniRecyclerView();
    }

    private void iniRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        adapter.setDataList(list);

        ItemTouchHelper.Callback callback = new RecyclerRowMoveCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);
    }

    private void buildData(){
        list.add(new DataModel("1. Tunggu Sampai Air Mendidih"));
        list.add(new DataModel("2. Ambil Panci"));
        list.add(new DataModel("3. Hidupkan Kompor"));
        list.add(new DataModel("4. Letakkan Panci berisi air di atas kompor"));
        list.add(new DataModel("5. Tampung Air Bersih"));
    }

}