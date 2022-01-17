package com.example.e_sports_app.adminpages;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_sports_app.R;
import com.example.e_sports_app.adapters.FeedbackAdapter;
import com.example.e_sports_app.adapters.GamesAdapter;
import com.example.e_sports_app.data.Feedback;
import com.example.e_sports_app.data.Game;
import com.example.e_sports_app.helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class ManageGames extends Activity implements GamesAdapter.UserListener{
GamesAdapter adapter;
    List<Game> list = new ArrayList<>();
    RecyclerView recyclerView;
    DbHelper helper;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_games);

        adapter = new GamesAdapter(list,this,this);
        recyclerView = findViewById(R.id.my_recycler_view);
        toolbar = findViewById(R.id.toolBar);
        helper = new DbHelper(this);

        LinearLayoutManager manager =new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        setActionBar(toolbar);
        getActionBar().setTitle("Manage Games");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        getGames();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }
    private void getGames() {
        DbHelper helper = new DbHelper(this);
        helper.getGames(list,adapter);
    }
    @Override
    public void onEditGameClick(int position) {
        Toast.makeText(getApplicationContext(), "Edit Game Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteGameClick(int position) {
        Toast.makeText(getApplicationContext(), "Delete Game Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResultsBtnClick(int position) {
        Toast.makeText(getApplicationContext(), "Results Button Clicked", Toast.LENGTH_SHORT).show();
    }
}