package com.logistic.src.main.di.module;

import com.logistic.src.main.ui.detail.DetailFragment;
import com.logistic.src.main.ui.home.HomeFragment;
import com.logistic.src.main.ui.login.LoginFragment;
import com.logistic.src.main.ui.splash.SplashFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract SplashFragment bindSplashFragment();

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();

    @ContributesAndroidInjector
    abstract HomeFragment bindHomeFragment();

    @ContributesAndroidInjector
    abstract DetailFragment bindDetailFragment();
}
