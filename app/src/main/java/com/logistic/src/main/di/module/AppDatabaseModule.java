package com.logistic.src.main.di.module;

import android.content.Context;

import com.logistic.src.main.data.AppDatabase;
import com.logistic.src.main.utils.Define;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class AppDatabaseModule {

    @Singleton
    @Provides
    AppDatabase provideRoomDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Define.Database.DATABASE_NAME)
                .build();
    }
}
