package com.example.smart_tv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.ViewHolder> {

    private final static String PHOTO_URL = "http://cinema.areas.su/up/images/";
    private List<Movie> mMovie;
    private Context mContext;

    ScrollAdapter(List<Movie> movies) {
        this.mMovie = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scroll_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie movie = mMovie.get(position);


        Picasso.with(mContext)
                .load(PHOTO_URL + movie.getPoster())
                .into(holder.Image);
        holder.Name.setText(movie.getName());
    }
    @Override
    public int getItemCount() {
        if (mMovie == null) {
            return 0;
        }
        return mMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Description, TagName;
        ImageView Image;

        ViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.tvName1);
            Description = (TextView) itemView.findViewById(R.id.tvDescription);
            TagName = (TextView) itemView.findViewById(R.id.tvTag);
            Image = (ImageView) itemView.findViewById(R.id.imageView1);
        }
    }
}