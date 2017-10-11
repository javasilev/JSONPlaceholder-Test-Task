package com.javasilev.testtask.adapters.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected LayoutInflater mInflater;
    private Context mContext;
    private final List<Object> mList = new ArrayList<>();

    public CollectionAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setCollection(Collection<Object> collection) {
        mList.clear();

        if (collection != null) {
            mList.addAll(collection);
        }

        notifyDataSetChanged();
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    public void updateItem(int position, Object item) {
        mList.set(position, item);
        notifyDataSetChanged();
    }

    public void clearCollection() {
        mList.clear();
        notifyDataSetChanged();
    }

    public void removeItem(Object item) {
        mList.remove(item);
        notifyDataSetChanged();
    }

    public void removeItem(int itemId) {
        mList.remove(itemId);
        notifyItemRemoved(itemId);
    }

    public void addItem(Object item) {
        mList.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    public List<Object> getCollection() {
        return mList;
    }

    protected Context getContext() {
        return mContext;
    }
}
