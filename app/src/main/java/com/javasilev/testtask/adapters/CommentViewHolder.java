package com.javasilev.testtask.adapters;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.javasilev.testtask.R;
import com.javasilev.testtask.utils.TypicodeController;
import com.javasilev.testtask.adapters.base.CollectionAdapter;
import com.javasilev.testtask.adapters.base.SimpleViewHolder;
import com.javasilev.testtask.models.Comment;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class CommentViewHolder extends SimpleViewHolder<Comment> implements Observer<Comment> {

    public static final int MAX_ID = 500;
    private final Context mContext;

    @BindView(R.id.item_text_card_text_view_caption)
    TextView mCaptionTextView;

    @BindView(R.id.item_post_card_edit_text_number)
    EditText mNumberEditText;

    @BindView(R.id.item_post_card_button_get)
    Button mGetButton;

    @BindView(R.id.item_post_card_text_view_text)
    TextView mTextBodyTextView;

    @BindView(R.id.item_text_card_frame_layout_progress)
    FrameLayout mProgressFrameLayout;

    private CollectionAdapter mAdapter;

    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    @Override
    public void bind(Comment comment, CollectionAdapter adapter) {
        mAdapter = adapter;
        mCaptionTextView.setText(R.string.label_comments);
        mNumberEditText.setText(String.valueOf(comment.getId()));
        mTextBodyTextView.setText(comment.getBody());
        mGetButton.setOnClickListener(v -> {
            int id = Integer.parseInt(mNumberEditText.getText().toString());
            if (id == 0 || id > MAX_ID) {
                Toast.makeText(mContext, mContext.getString(R.string.text_exceeding_warning, "comment", MAX_ID), Toast.LENGTH_SHORT).show();
                return;
            }
            mGetButton.setEnabled(false);
            mProgressFrameLayout.setVisibility(View.VISIBLE);
            TypicodeController.getComment(mNumberEditText.getText().toString(), CommentViewHolder.this);
        });
    }

    @Override
    public void onCompleted() {
        hideProgress();
    }

    @Override
    public void onError(Throwable e) {
        hideProgress();
        Toast.makeText(mContext, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Comment comment) {
        mNumberEditText.setText(String.valueOf(comment.getId()));
        mTextBodyTextView.setText(comment.getBody());
        mAdapter.updateItem(getAdapterPosition(), comment);
    }

    private void hideProgress() {
        mProgressFrameLayout.setVisibility(View.GONE);
        mGetButton.setEnabled(true);
    }
}
