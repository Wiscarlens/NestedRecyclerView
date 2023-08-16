package com.example.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<ParentModel> parentModels = new ArrayList<>();

    ArrayList<ChildModel> childModelClassArrayList = new ArrayList<>();
    ArrayList<ChildModel> favoriteList = new ArrayList<>();
    ArrayList<ChildModel> recentlyWatched = new ArrayList<>();
    ArrayList<ChildModel> lastedList = new ArrayList<>();

    ParentAdapter parentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().hide();

        recyclerView = findViewById(R.id.rv_parent);

        lastedList.add(new ChildModel(R.drawable.prometheusposterfixed));
        lastedList.add(new ChildModel(R.drawable.chappie_poster));
        lastedList.add(new ChildModel(R.drawable.la_casa_del_papel));
        lastedList.add(new ChildModel(R.drawable.naruto));

        parentModels.add(new ParentModel("Latest Movie", lastedList));

        recentlyWatched.add(new ChildModel(R.drawable.image));
        recentlyWatched.add(new ChildModel(R.drawable.image3));
        recentlyWatched.add(new ChildModel(R.drawable.thiklikeaman));
        recentlyWatched.add(new ChildModel(R.drawable.spiderman));

        parentModels.add(new ParentModel("Recently Watched", recentlyWatched));

        parentAdapter = new ParentAdapter(parentModels, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();




    }
}