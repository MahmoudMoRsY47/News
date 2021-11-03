package com.example.news.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.data.NewsClient;
import com.example.news.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
  static   MutableLiveData<List<NewsModel>> postsMutableLiveData = new MutableLiveData<>();
  static   MutableLiveData<String> posts = new MutableLiveData<>();

    public static void getNews() {
        NewsClient.getINSTANCE().getNews().enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                posts.setValue("errr");

            }
        });

    }
}