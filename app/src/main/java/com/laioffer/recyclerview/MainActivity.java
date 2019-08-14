package com.laioffer.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Record> records;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();

        recyclerView=findViewById(R.id.rvContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecordAdapter adapter = new RecordAdapter(this, records);
        recyclerView.setAdapter(adapter);

    }
    private void generateData(){
        records = new ArrayList<>();
        Record record = new Record();
        record.setShopName("Steam");
        record.setItemName("game 1");
        record.setLogo(R.drawable.steam);
        records.add(record);

        record = new Record();
        record.setShopName("Amazon");
        record.setItemName("food 1");
        record.setLogo(R.drawable.amazon);
        records.add(record);

        record = new Record();
        record.setShopName("Amazon");
        record.setItemName("food 2");
        record.setLogo(R.drawable.amazon);
        records.add(record);

        record = new Record();
        record.setShopName("Steam");
        record.setItemName("game 2");
        record.setLogo(R.drawable.steam);
        records.add(record);

        record = new Record();
        record.setShopName("Ebay");
        record.setItemName("item 1");
        record.setLogo(R.drawable.ebay);
        record.setPrice("$1000!!!!");
        records.add(record);

        record = new Record();
        record.setShopName("Steam");
        record.setItemName("game 3");
        record.setLogo(R.drawable.steam);
        records.add(record);

        record = new Record();
        record.setShopName("Ebay");
        record.setItemName("item 2");
        record.setPrice("$9999!!!!");
        record.setLogo(R.drawable.ebay);
        records.add(record);
    }
}
