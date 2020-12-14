package com.logistic.src.main.ui.detail;

import com.logistic.src.main.utils.StringUtil;
import com.logistic.src.main.base.BaseViewModel;
import com.logistic.src.main.base.ObjectResponse;
import com.logistic.src.main.data.model.Repo;
import com.logistic.src.main.data.repository.RepoRepository;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class DetailViewModel extends BaseViewModel {

    private RepoRepository repoRepository;

    private final MutableLiveData<ObjectResponse<Repo>> loadRepoDetail = new MutableLiveData<>();

    @Inject
    DetailViewModel(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public void loadRepoDetail(String owner, String name) {
        if (StringUtil.isEmpty(owner, name)) {
            return;
        }

        mDisposable.add(
                repoRepository.getRepo(owner, name)
                .doOnSubscribe(it -> loadRepoDetail.setValue(new ObjectResponse<Repo>().loading()))
                .subscribe(repo -> loadRepoDetail.setValue(new ObjectResponse<Repo>().success(repo)),
                        throwable -> loadRepoDetail.setValue(new ObjectResponse<Repo>().error(throwable)))
        );
    }
}
