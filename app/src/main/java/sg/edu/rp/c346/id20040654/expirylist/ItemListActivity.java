package sg.edu.rp.c346.id20040654.expirylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    ListView lvItem;
    ArrayList<String> itemList;
    ArrayAdapter<String> aaItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        lvItem = findViewById(R.id.listViewItem);

        itemList = new ArrayList<String>();
        itemList.add("Expires 2021-8-6 \nLogitech Mouse");
        itemList.add("Expires 2022-9-7 \nLogitech Keyboard");
        itemList.add("Expires 2023-10-8 \nBenQ Monitor");
        itemList.add("Expires 2024-11-9 \nNvidia RTX 2060");
        itemList.add("Expires 2025-12-10 \nSeasonic Power Supply");

        aaItem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, itemList);

        lvItem.setAdapter(aaItem);
    }
}