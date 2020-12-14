package com.logistic.src.main.adapter.repolist;

import com.logistic.src.main.base.BaseViewHolder;
import com.logistic.src.main.data.model.Repo;
import com.rikkei.kiendd.mvvmbaseproject.databinding.ItemRepoBinding;

public class ListRepoViewHolder extends BaseViewHolder<Repo> {

    private ItemRepoBinding binding;
    private Repo repo;

    ListRepoViewHolder(ItemRepoBinding binding, ListRepoAdapter.ItemClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.getRoot().setOnClickListener(v -> listener.onCLick(repo));
    }

    @Override
    public void bind(Repo data) {
        this.repo = data;
        binding.tvRepoName.setText(data.getName());
    }
}
