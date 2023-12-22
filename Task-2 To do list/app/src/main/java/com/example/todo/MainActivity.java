package com.example.todo;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private EditText editText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextText);
        addButton = findViewById(R.id.button);

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            items.remove(position);
            itemsAdapter.notifyDataSetChanged();
            showToast("Item Removed");
            return true;
        });
    }

    private void addItem() {
        String newItem = editText.getText().toString().trim();

        if (!newItem.isEmpty()) {
            items.add(newItem);
            itemsAdapter.notifyDataSetChanged();
            editText.setText("");
        } else {
            showToast("Please enter a task");
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
