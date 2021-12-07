package com.example.secondclass.module;

import android.content.Context;

import androidx.room.Room;

import com.example.secondclass.analytics.AnalyticsAdapter;
import com.example.secondclass.analytics.AnalyticsFlurry;
import com.example.secondclass.data.AppDatabase;
import com.example.secondclass.data.dao.UserDao;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
@Module
@InstallIn( SingletonComponent.class )
public class DataModule {

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter(){
        return new AnalyticsFlurry();
    }

    // Fix executor error
    @Provides
    @Singleton
    public Executor provideExecutor(){
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDataBase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "database-name").build();
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase appDatabase){
        return  appDatabase.userDao();
    }
}
