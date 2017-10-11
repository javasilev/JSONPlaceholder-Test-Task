package com.javasilev.testtask.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.javasilev.testtask.R;
import com.javasilev.testtask.adapters.base.CollectionAdapter;
import com.javasilev.testtask.adapters.base.SimpleViewHolder;
import com.javasilev.testtask.models.Photo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class PhotoViewHolder extends SimpleViewHolder<Photo> {

    private final Context mContext;

    @BindView(R.id.item_photo_card_image_view_photo)
    ImageView mImageView;

    @BindView(R.id.item_photo_card_text_view_caption)
    TextView mCaptionTextView;

    @BindView(R.id.item_photo_card_text_view_body)
    TextView mBodyTextView;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    @Override
    public void bind(Photo photo, CollectionAdapter adapter) {
        mCaptionTextView.setText(R.string.label_photos);
        mBodyTextView.setText(photo.getTitle());
        Picasso.with(mContext)
                .load(photo.getUrl())
                .into(mImageView);
    }
}
