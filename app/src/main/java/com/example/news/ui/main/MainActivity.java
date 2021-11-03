package com.example.news.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.news.R;
import com.example.news.pojo.NewsModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
NewsViewModel   newsViewModel;
    RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        NewsViewModel.getNews();
        rc=findViewById(R.id.rcv);
       final NewsAdpter adapter =new NewsAdpter();
       rc.setLayoutManager(new LinearLayoutManager(this));
       rc.setAdapter(adapter);

       newsViewModel.postsMutableLiveData.observe(this, new Observer<List<NewsModel>>() {
           @Override
           public void onChanged(List<NewsModel> newsModels) {
               adapter.setList(newsModels);
           }
       });
    }
}