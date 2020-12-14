package com.logistic.src.main.ui.login;

import android.os.Handler;

import com.logistic.src.main.base.BaseFragment;
import com.rikkei.kiendd.mvvmbaseproject.R;
import com.rikkei.kiendd.mvvmbaseproject.databinding.FragmentLoginBinding;
import com.logistic.src.main.ui.home.HomeFragment;

public class LoginFragment extends BaseFragment<FragmentLoginBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
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
        new Handler().postDelayed(() -> mViewController.replaceFragment(HomeFragment.class, null), 0);
    }
}
