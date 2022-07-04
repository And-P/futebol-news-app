package me.umbrella.futebolnews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.umbrella.futebolnews.data.remote.FutebolNewsApi;
import me.umbrella.futebolnews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final FutebolNewsApi api;


    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://and-p.github.io/futebol-news-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(FutebolNewsApi.class);

        this.findNews();
    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {

            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()) {
                    news.setValue(response.body());
                } else {
                    //TODO Pensar em uma estratégia de tratamento de erros.
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO Pensar em uma estratégia de tratamento de erros.
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}








