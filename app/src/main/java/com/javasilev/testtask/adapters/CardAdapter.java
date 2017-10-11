package com.javasilev.testtask.adapters;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.javasilev.testtask.R;
import com.javasilev.testtask.adapters.base.CollectionAdapter;
import com.javasilev.testtask.models.Comment;
import com.javasilev.testtask.models.Photo;
import com.javasilev.testtask.models.Post;
import com.javasilev.testtask.models.Todo;
import com.javasilev.testtask.models.User;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("SpellCheckingInspection")
public class CardAdapter extends CollectionAdapter {

    private static final int POST_VIEWHOLDER = 0;
    private static final int COMMENT_VIEWHOLDER = 1;
    private static final int USER_VIEWHOLDER = 2;
    private static final int PHOTO_VIEWHOLDER = 3;
    private static final int TODO_VIEWHOLDER = 4;

    public CardAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case POST_VIEWHOLDER:
                return new PostViewHolder(mInflater.inflate(R.layout.item_text_card, parent, false));
            case COMMENT_VIEWHOLDER:
                return new CommentViewHolder(mInflater.inflate(R.layout.item_text_card, parent, false));
            case USER_VIEWHOLDER:
                return new UserViewHolder(mInflater.inflate(R.layout.item_user_card, parent, false));
            case PHOTO_VIEWHOLDER:
                return new PhotoViewHolder(mInflater.inflate(R.layout.item_photo_card, parent, false));
            case TODO_VIEWHOLDER:
                return new TodoViewHolder(mInflater.inflate(R.layout.item_todo_card, parent, false));
            default:
                return new PostViewHolder(mInflater.inflate(R.layout.item_text_card, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case POST_VIEWHOLDER:
                PostViewHolder postViewHolder = (PostViewHolder) holder;
                postViewHolder.bind((Post) getItem(position), this);
                break;
            case COMMENT_VIEWHOLDER:
                CommentViewHolder commentViewHolder = (CommentViewHolder) holder;
                commentViewHolder.bind((Comment) getItem(position), this);
                break;
            case USER_VIEWHOLDER:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                //noinspection unchecked
                userViewHolder.bind((List<User>) getItem(position), this);
                break;
            case PHOTO_VIEWHOLDER:
                PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
                photoViewHolder.bind((Photo) getItem(position), this);
                break;
            case TODO_VIEWHOLDER:
                TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
                todoViewHolder.bind((Todo) getItem(position), this);
                break;
        }
    }
}
