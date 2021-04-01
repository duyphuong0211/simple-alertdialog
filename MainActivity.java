package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lvName;
    ArrayList<String> arrayname;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvName = (ListView) findViewById(R.id.listviewname);
        arrayname = new ArrayList<>();
        addname();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayname);
        lvName.setAdapter(adapter);
        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                XacNhanXoa(position);
                return false;
            }
        });
    }

    private  void XacNhanXoa(int position)
    {
        AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);
        alerDialog.setTitle("Thong Bao");
        alerDialog.setIcon(R.mipmap.ic_launcher);
        alerDialog.setMessage("Ban co muon xoa hay khong");

        alerDialog.setPositiveButton("CO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayname.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alerDialog.setNegativeButton("KHONG", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerDialog.show();
    }
    private  void addname()
    {
        arrayname.add("Phuong");
        arrayname.add("Phuong1");
        arrayname.add("Phuong2");
        arrayname.add("Phuong3");
        arrayname.add("Phuong4");
        arrayname.add("Phuong5");
        arrayname.add("Phuong6");
        arrayname.add("Phuong7");
        arrayname.add("Phuong8");
        arrayname.add("Phuong9");
    }
}