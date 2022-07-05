package me.umbrella.futebolnews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.umbrella.futebolnews.data.FutebolNewsRepository;
import me.umbrella.futebolnews.domain.News;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return FutebolNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> FutebolNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}