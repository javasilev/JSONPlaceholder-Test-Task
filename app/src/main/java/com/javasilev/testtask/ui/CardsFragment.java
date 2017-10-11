package com.javasilev.testtask.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.javasilev.testtask.R;
import com.javasilev.testtask.adapters.CardAdapter;
import com.javasilev.testtask.utils.TypicodeController;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;

public class CardsFragment extends Fragment implements Observer<List<Object>> {

    public static final String KEY = "collection";

    @BindView(R.id.fragment_cards_cardlist)
    RecyclerView mRecyclerView;

    @BindView(R.id.fragment_cards_progress_bar)
    ProgressBar mProgressBar;

    private CardAdapter mAdapter;
    List<Object> mCollection = new ArrayList<>();

    public CardsFragment() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null != savedInstanceState) {
            mCollection = (List<Object>) savedInstanceState.getSerializable(KEY);
        }

        setAdapterCollection();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new CardAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, (Serializable) mAdapter.getCollection());
    }

    private void setAdapterCollection() {
        if (mCollection.isEmpty()) {
            mProgressBar.setVisibility(View.VISIBLE);
            TypicodeController.setCollection(this);
        } else {
            mAdapter.setCollection(mCollection);
        }
    }

    @Override
    public void onCompleted() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(List<Object> objects) {
        mAdapter.setCollection(objects);
    }
}
