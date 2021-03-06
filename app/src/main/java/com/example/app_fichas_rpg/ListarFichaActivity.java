package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_fichas_rpg.adapters.FichaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListarFichaActivity extends AppCompatActivity implements View.OnClickListener{

    public ArrayList<Ficha> fichas;
    public Button btnVoltar;
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ficha);
        btnVoltar = findViewById(R.id.btn_Back_List_Main);
        txt = findViewById(R.id.txt_not_found);

        DataBase db = new DataBase(this.getApplicationContext());

        fichas = db.Listar();

        txt.setVisibility((fichas.size() == 0) ? View.VISIBLE : View.INVISIBLE);

        RecyclerView recyclerView = findViewById(R.id.fichas_lista);
        FichaAdapter adapter = new FichaAdapter(fichas, (Activity)this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        btnVoltar.setOnClickListener(this);
    }
    @Override
    public void onBackPressed(){
        this.finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Back_List_Main:
                this.finish();
                break;
            default:
                break;
        }
    }
}
