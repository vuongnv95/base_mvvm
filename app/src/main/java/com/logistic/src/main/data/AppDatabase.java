package com.logistic.src.main.data;

import com.logistic.src.main.data.dao.RepoDao;
import com.logistic.src.main.data.model.Repo;
import com.logistic.src.main.data.model.User;
import com.logistic.src.main.utils.Define;
import com.logistic.src.main.data.dao.UserDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Repo.class, User.class} , version = Define.Database.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RepoDao repoDao();

    public abstract UserDao userDao();

}
