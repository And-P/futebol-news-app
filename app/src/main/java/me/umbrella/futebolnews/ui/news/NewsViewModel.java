package me.umbrella.futebolnews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.umbrella.futebolnews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover mock de Noticias
        List<News> news = new ArrayList<>();
            news.add(new News("Santos Joga Pelo Campeonato", "Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mim que vai caçá sua turmis!In elementis mé pra quem é amistosis."));
            news.add(new News("Ferroviária Surpreende Palmeiras", "Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mim que vai caçá sua turmis!"));
            news.add(new News("Botafogo Renovado", "Mussum Ipsum, cacilds vidis litro abertis. Quem num gosta di mim que vai caçá sua turmis!In elementis mé pra quem é amistosis quis leo."));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}