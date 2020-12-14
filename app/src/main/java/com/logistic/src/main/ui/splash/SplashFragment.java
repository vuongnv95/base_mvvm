package com.logistic.src.main.ui.splash;

import android.os.Handler;

import com.logistic.src.main.base.BaseFragment;
import com.logistic.src.main.ui.login.LoginFragment;
import com.rikkei.kiendd.mvvmbaseproject.R;
import com.rikkei.kiendd.mvvmbaseproject.databinding.FragmentSplashBinding;

public class SplashFragment extends BaseFragment<FragmentSplashBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public void backFromAddFragment() {

    }

    @Override
    public boolean backPressed() {
        return false;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new Handler().postDelayed(() -> mViewController.replaceFragment(LoginFragment.class, null), 1000);
    }
}
