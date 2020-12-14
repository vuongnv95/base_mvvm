package com.logistic.src.main.di.module;

import android.app.Application;
import android.content.Context;

import com.logistic.src.main.utils.ResourceProvider;
import com.logistic.src.main.utils.IResourceProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(Application application);

    @Binds
    @Singleton
    abstract IResourceProvider provideResourceProvider(ResourceProvider resourceProvider);
}
