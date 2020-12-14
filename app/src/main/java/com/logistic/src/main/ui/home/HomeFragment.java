package com.logistic.src.main.ui.home;

import android.os.Bundle;

import com.logistic.src.main.base.BaseFragment;
import com.logistic.src.main.ui.detail.DetailFragment;
import com.logistic.src.main.utils.Define;
import com.logistic.src.main.utils.DialogUtil;
import com.rikkei.kiendd.mvvmbaseproject.R;
import com.logistic.src.main.adapter.repolist.ListRepoAdapter;
import com.logistic.src.main.base.ListResponse;
import com.logistic.src.main.data.model.Repo;
import com.rikkei.kiendd.mvvmbaseproject.databinding.FragmentHomeBinding;

import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private HomeViewModel homeViewModel;
    private ListRepoAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
    }

    @Override
    public void onStart() {
        super.onStart();

        fetchRepos();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        adapter = new ListRepoAdapter(repo -> {
            if (mViewController != null) {
                HashMap<String, Object> data = new HashMap<>();
                data.put(Define.Intent.REPO_OWNER, repo.getFullName());
                data.put(Define.Intent.REPO_NAME, repo.getName());

                mViewController.addFragment(DetailFragment.class, data);
            }
        });
    }

    private void fetchRepos() {
        homeViewModel.fetchRepos();
        homeViewModel.getLoadRepos().observe(getViewLifecycleOwner(), this::fetchReposHandle);
    }

    private void fetchReposHandle(ListResponse<Repo> repoListResponse) {
        switch (repoListResponse.getStatus()) {
            case Define.ResponseStatus.LOADING:
                DialogUtil.getInstance(getContext()).show();
                break;
            case Define.ResponseStatus.SUCCESS:
                adapter.setData(repoListResponse.getData());
                binding.rvRepos.setAdapter(adapter);
                DialogUtil.getInstance(getContext()).hidden();
                break;
            case Define.ResponseStatus.ERROR:
                DialogUtil.getInstance(getContext()).hidden();
        }
    }

    @Override
    public void backFromAddFragment() {

    }

    @Override
    public boolean backPressed() {
        return false;
    }
}
