package com.javasilev.testtask.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.javasilev.testtask.R;
import com.javasilev.testtask.adapters.base.CollectionAdapter;
import com.javasilev.testtask.adapters.base.SimpleViewHolder;
import com.javasilev.testtask.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class UserViewHolder extends SimpleViewHolder<List<User>> {
    private final Context mContext;

    @BindView(R.id.item_user_card_text_view_caption)
    TextView mCaptionTextView;

    @BindView(R.id.item_user_card_list_view_user_list)
    ListView mUserList;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    @Override
    public void bind(List<User> model, CollectionAdapter adapter) {
        mCaptionTextView.setText(R.string.label_users);
        mUserList.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, model.toArray(new User[model.size()])));
    }
}
