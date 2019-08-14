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
        record.setShopName("Robert");
        record.setItemName("New York");
        record.setPrice("+61234456");
        records.add(record);

        record = new Record();
        record.setShopName("Tom");
        record.setItemName("California");
        record.setDate("tom_frank@gmail.com");
        records.add(record);

        record = new Record();
        record.setShopName("Smith");
        record.setItemName("Philadelphia");
        record.setDate("smith_carrol@gmail.com");
        records.add(record);

        record = new Record();
        record.setShopName("Ryan");
        record.setItemName("Canada");
        record.setPrice("+612001456");
        records.add(record);

        record = new Record();
        record.setShopName("Mark");
        record.setItemName("Boston");
        record.setDate("mark_walmerd@gmail.com");
        records.add(record);

        record = new Record();
        record.setShopName("Adam");
        record.setItemName("Brooklyn");
        record.setPrice("+61211780");
        records.add(record);

        record = new Record();
        record.setShopName("Kevin");
        record.setItemName("New Jersey");
        record.setPrice("+94221035");
        records.add(record);
    }
}
