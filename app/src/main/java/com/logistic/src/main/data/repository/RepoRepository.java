package com.logistic.src.main.data.repository;

import com.logistic.src.main.data.network.ApiInterface;
import com.logistic.src.main.data.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepoRepository {

    private final ApiInterface apiInterface;

    @Inject
    RepoRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Single<List<Repo>> getRepositories() {
        return apiInterface.getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Repo> getRepo(String owner, String name) {
        return apiInterface.getRepo(owner, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
