package com.example.news.data;

import com.example.news.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsIterFace {
    @GET("v2/top-headlines?country=us&category=business&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<List<NewsModel>> getNews();
}
