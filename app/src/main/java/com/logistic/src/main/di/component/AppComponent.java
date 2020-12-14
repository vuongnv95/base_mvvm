package com.logistic.src.main.di.component;

import android.app.Application;

import com.logistic.src.main.BaseApplication;
import com.logistic.src.main.di.module.AppModule;
import com.logistic.src.main.di.module.ActivityBindingModule;
import com.logistic.src.main.di.module.AppDatabaseModule;
import com.logistic.src.main.di.module.FragmentBindingModule;
import com.logistic.src.main.di.module.NetworkModule;
import com.logistic.src.main.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        AppDatabaseModule.class,
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        ViewModelModule.class,
        NetworkModule.class
})
public interface AppComponent {

    void inject(BaseApplication baseApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
