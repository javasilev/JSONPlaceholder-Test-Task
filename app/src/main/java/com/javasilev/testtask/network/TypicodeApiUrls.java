package com.javasilev.testtask.network;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
public final class TypicodeApiUrls {

    private static final String BASE_API_URL = "https://jsonplaceholder.typicode.com/";

    public static class Posts {
        public static final String GET_POST = "/posts";
    }

    public static class Comments {
        public static final String GET_COMMENT = "/comments";
    }

    public static class Users {
        public static final String GET_USER = "/users";
    }

    public static class Photos {
        public static final String GET_PHOTO = "/photos";
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static class Todos {
        public static final String GET_TODO = "/todos";
    }

    public static String getApiBaseUrl() {
        return BASE_API_URL;
    }
}
