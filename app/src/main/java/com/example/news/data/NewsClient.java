package com.example.news.data;

import com.example.news.pojo.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




    public class NewsClient {
        private NewsIterFace postInterface;
        private static NewsClient INSTANCE;

        public NewsClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
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

        public Call<List<NewsModel>> getNews(){
            return postInterface.getNews();
        }
}
