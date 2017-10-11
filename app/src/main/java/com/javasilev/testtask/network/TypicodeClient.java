package com.javasilev.testtask.network;

import com.javasilev.testtask.models.Comment;
import com.javasilev.testtask.models.Photo;
import com.javasilev.testtask.models.Post;
import com.javasilev.testtask.models.Todo;
import com.javasilev.testtask.models.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("SpellCheckingInspection")
public interface TypicodeClient {

    String ID = "id";
    String ID_SUFFIX = "/{" + ID + "}";

    @GET(TypicodeApiUrls.Posts.GET_POST + ID_SUFFIX)
    Observable<Post> getPost(@Path(ID) String id);

    @GET(TypicodeApiUrls.Comments.GET_COMMENT + ID_SUFFIX)
    Observable<Comment> getComment(@Path(ID) String id);

    @GET(TypicodeApiUrls.Users.GET_USER + ID_SUFFIX)
    Observable<User> getUser(@Path(ID) String id);

    @GET(TypicodeApiUrls.Photos.GET_PHOTO + ID_SUFFIX)
    Observable<Photo> getPhoto(@Path(ID) String id);

    @GET(TypicodeApiUrls.Todos.GET_TODO + ID_SUFFIX)
    Observable<Todo> getTodo(@Path(ID) String id);

    @PUT(TypicodeApiUrls.Todos.GET_TODO + ID_SUFFIX)
    Observable<Todo> updateTodo(@Path(ID) String id, @Body Todo todo);

}
