package com.javasilev.testtask.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.javasilev.testtask.R;
import com.javasilev.testtask.utils.TypicodeController;
import com.javasilev.testtask.adapters.base.CollectionAdapter;
import com.javasilev.testtask.adapters.base.SimpleViewHolder;
import com.javasilev.testtask.models.Todo;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class TodoViewHolder extends SimpleViewHolder<Todo> implements Observer<Todo> {
    @BindView(R.id.item_todo_card_text_view_caption)
    TextView mCaptionTextView;

    @BindView(R.id.item_todo_card_text_view_number)
    TextView mNumberTextView;

    @BindView(R.id.item_todo_card_text_view_text)
    TextView mTextBodyTextView;

    private Context mContext;
    private CollectionAdapter mAdapter;

    public TodoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    @Override
    public void bind(final Todo todo, CollectionAdapter adapter) {
        mAdapter = adapter;
        mCaptionTextView.setText(R.string.label_todos);
        mNumberTextView.setText(String.valueOf(todo.getId()));
        mTextBodyTextView.setText(todo.getTitle());
        toggleTaskView(todo);
        mTextBodyTextView.setOnClickListener(v -> {
            toggleTaskState(todo);
            toggleTaskView(todo);
        });
    }

    private void toggleTaskView(Todo todo) {
        if (todo.getCompleted()) {
            mTextBodyTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_box_black_24dp, 0, 0, 0);
            mTextBodyTextView.setPaintFlags(mTextBodyTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            mTextBodyTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_box_outline_blank_black_24dp, 0, 0, 0);
            mTextBodyTextView.setPaintFlags(mTextBodyTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
        }
    }

    private void toggleTaskState(Todo todo) {
        todo.setCompleted(!todo.getCompleted());
        TypicodeController.updateTodo(todo, TodoViewHolder.this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(mContext, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Todo todo) {
        Toast.makeText(mContext, R.string.text_updated, Toast.LENGTH_SHORT).show();
        mAdapter.updateItem(getAdapterPosition(), todo);
    }
}
