package com.example.news.data;

import com.example.news.pojo.Article;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




    public class NewsClient {
        private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
        private NewsIterFace postInterface;
        private static NewsClient INSTANCE;

        public NewsClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postInterface = retrofit.create(NewsIterFace.class);
        }

        public static NewsClient getINSTANCE() {
            if (null == INSTANCE){
                INSTANCE = new NewsClient();
            }
            return INSTANCE;
        }

        public Call<List<Article>> getPosts(){
            return postInterface.getPosts();
        }
    }