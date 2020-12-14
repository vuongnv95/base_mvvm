package com.logistic.src.main.data.dao;

import com.logistic.src.main.data.model.Repo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import io.reactivex.Completable;

@Dao
public interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertRepo(Repo repo);
}
