package com.example.news.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.news.R;
import com.example.news.pojo.Article;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    NewsViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.rcv);
        final NewsAdpter adapter = new NewsAdpter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        postViewModel.postsMutableLiveData.observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> postModels) {
                adapter.setList(postModels);
            }
        });

    }
}