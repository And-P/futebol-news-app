package me.umbrella.futebolnews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.umbrella.futebolnews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class FutebolNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}
