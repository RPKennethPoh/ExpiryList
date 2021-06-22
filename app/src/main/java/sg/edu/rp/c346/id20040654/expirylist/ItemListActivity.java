package sg.edu.rp.c346.id20040654.expirylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    ListView lvItem;
    Spinner spinChoice;
    Button btnAction, btnFind;
    EditText etName, etDate, etIndex;
    ArrayList<String> itemList, choiceList;
    ArrayAdapter<String> aaItem, aaChoice;
    LinearLayout linearIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        lvItem = findViewById(R.id.listViewItem);
        spinChoice = findViewById(R.id.spinnerChoice);
        btnAction = findViewById(R.id.buttonAction);
        btnFind = findViewById(R.id.buttonFind);
        etName = findViewById(R.id.editTextName);
        etDate = findViewById(R.id.editTextDate);
        etIndex = findViewById(R.id.editTextIndex);
        linearIndex = findViewById(R.id.linearLayoutIndex);

        itemList = new ArrayList<String>();
        // substring = 8, 18 for date
        itemList.add("Expires 2021-06-09 \nLogitech Mouse");
        itemList.add("Expires 2022-07-12 \nLogitech Keyboard");
        itemList.add("Expires 2023-08-15 \nBenQ Monitor");
        itemList.add("Expires 2024-09-18 \nNvidia RTX 2060");
        itemList.add("Expires 2025-10-21 \nSeasonic Power Supply");
        aaItem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, itemList);
        lvItem.setAdapter(aaItem);

        choiceList = new ArrayList<String>();
        choiceList.add("Add an item");
        choiceList.add("Edit an item");
        choiceList.add("Remove an item");
        aaChoice = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, choiceList);
        spinChoice.setAdapter(aaChoice);

        spinChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    btnAction.setText(R.string.add);
                    linearIndex.setVisibility(View.GONE);
                    etName.setVisibility(View.VISIBLE);
                    etDate.setVisibility(View.VISIBLE);
                    etName.setText("");
                    etDate.setText("");
                } else if (position == 1) {
                    btnAction.setText(R.string.edit);
                    linearIndex.setVisibility(View.VISIBLE);
                    etName.setVisibility(View.VISIBLE);
                    etDate.setVisibility(View.VISIBLE);
                    etIndex.setText("");
                    etName.setText("");
                    etDate.setText("");
                } else if (position == 2) {
                    btnAction.setText(R.string.remove);
                    linearIndex.setVisibility(View.VISIBLE);
                    etName.setVisibility(View.GONE);
                    etDate.setVisibility(View.GONE);
                    etIndex.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String button = btnAction.getText().toString();
                switch (button) {
                    case "Add":
                        if(!(etName.getText().toString().trim().isEmpty() && etDate.getText().toString().trim().isEmpty())) {
                            itemList.add(String.format("Expires %s \n%s", etDate.getText().toString(), etName.getText().toString().trim()));
                            Collections.sort(itemList);
                            Toast.makeText(ItemListActivity.this, "New item successfully added", Toast.LENGTH_SHORT).show();
                            aaItem.notifyDataSetChanged();
                            etName.setText("");
                            etDate.setText("");
                        } else {
                            Toast.makeText(ItemListActivity.this, "Please fill up all the fields", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Edit":
                        break;
                    case "Remove":
                        break;
                }
                if(btnAction.getText().toString().equalsIgnoreCase("add")) {

                } else if(btnAction.getText().toString().equalsIgnoreCase("edit")) {

                } else if(btnAction.getText().toString().equalsIgnoreCase("remove")) {

                }
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etIndex.getText().toString().isEmpty()) {
                    int index = Integer.parseInt(etIndex.getText().toString());
                    boolean found = false;
                    for(int i = 0; i < itemList.size(); i++) {
                        if(i == index) {
                            etName.setText(itemList.get(i).substring(20));
                            etDate.setText(itemList.get(i).substring(8, 18));
                            found = true;
                            break;
                        }
                    }
                    if(found == false) {
                        Toast.makeText(ItemListActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ItemListActivity.this, "Please enter an index", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}