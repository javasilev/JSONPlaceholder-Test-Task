package com.javasilev.testtask.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.javasilev.testtask.models.Comment;
import com.javasilev.testtask.models.Post;
import com.javasilev.testtask.models.Todo;
import com.javasilev.testtask.models.User;
import com.javasilev.testtask.network.TypicodeClient;
import com.javasilev.testtask.network.TypicodeService;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class TypicodeController {

    private static TypicodeClient client = TypicodeService.getInstance().createTypicodeClient();

    private static final String POST_ID = "1";
    private static final String COMMENT_ID = "1";
    private static final int USER_COUNT = 5;
    private static final String PHOTO_ID = "3";
    private static final String TODO_ID = "";

    public static void setCollection(Observer<List<Object>> subscriber) {
        List<Observable<User>> observables = new ArrayList<>();
        for (int i = 1; i <= USER_COUNT; i++) {
            observables.add(client.getUser("" + i));
        }
        Observable.concat(
                client.getPost(POST_ID),
                client.getComment(COMMENT_ID),
                Observable.concat(observables).toList(),
                client.getPhoto(PHOTO_ID),
                client.getTodo(String.valueOf(new SecureRandom().nextInt(200) + 1)))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getPost(String id, Observer<Post> observer) {
        client.getPost(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getComment(String id, Observer<Comment> observer) {
        client.getComment(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void updateTodo(Todo todo, Observer<Todo> observer) {
        client.updateTodo(String.valueOf(todo.getId()), todo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
