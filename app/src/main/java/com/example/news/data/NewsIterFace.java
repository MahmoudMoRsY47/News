package com.example.news.data;


import com.example.news.pojo.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsIterFace {
    @GET("posts")
    public Call<List<Article>> getPosts();
}
