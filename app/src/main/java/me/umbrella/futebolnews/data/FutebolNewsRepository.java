package me.umbrella.futebolnews.data;

import androidx.room.Room;

import me.umbrella.futebolnews.App;
import me.umbrella.futebolnews.data.local.FutebolNewsDb;
import me.umbrella.futebolnews.data.remote.FutebolNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FutebolNewsRepository {

    private static final String REMOTE_API_URL = "https://and-p.github.io/futebol-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";

    //Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    private FutebolNewsApi remoteApi;
    private FutebolNewsDb localDb;

    public FutebolNewsApi getRemoteApi() {
        return remoteApi;
    }

    public FutebolNewsDb getLocalDb() {
        return localDb;
    }

    //Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private FutebolNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FutebolNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), FutebolNewsDb.class, LOCAL_DB_NAME).build();
    }

    public static FutebolNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final FutebolNewsRepository INSTANCE = new FutebolNewsRepository();
    }
}

