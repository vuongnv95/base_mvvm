package com.logistic.src.main.ui.home;

import com.logistic.src.main.base.BaseViewModel;
import com.logistic.src.main.base.ListResponse;
import com.logistic.src.main.data.model.Repo;
import com.logistic.src.main.data.pref.AppPreferences;
import com.logistic.src.main.data.repository.RepoRepository;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends BaseViewModel {

    private final RepoRepository repoRepository;

    private final AppPreferences preferences;

    private final MutableLiveData<ListResponse<Repo>> loadRepos = new MutableLiveData<>();

    @Inject
    HomeViewModel(RepoRepository repository, AppPreferences preferences) {
        this.repoRepository = repository;
        this.preferences = preferences;
        mDisposable = new CompositeDisposable();
    }

    public MutableLiveData<ListResponse<Repo>> getLoadRepos() {
        return loadRepos;
    }

    public void fetchRepos() {
        mDisposable.add(
                repoRepository.getRepositories()
                        .doOnSubscribe(it -> {
                            loadRepos.setValue(new ListResponse<Repo>().loading());
                        })
                        .subscribe(repoList -> {
                            loadRepos.setValue(new ListResponse<Repo>().success(repoList));
                        }, throwable -> {
                            loadRepos.setValue(new ListResponse<Repo>().error(throwable));
                        })
        );
    }
}
