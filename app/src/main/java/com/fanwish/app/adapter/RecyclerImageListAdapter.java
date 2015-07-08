package com.fanwish.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.fanwish.app.model.ImageModel;

import java.util.ArrayList;

import app.fanwish.com.fanwish.R;

/**
 * Created by mdfaroque on 7/5/15.
 */
public class RecyclerImageListAdapter extends RecyclerView.Adapter<RecyclerImageListAdapter.ImageHolder> {



    private ArrayList<ImageModel> imageList;
    private ImageLoader mLoader;

    public RecyclerImageListAdapter(ArrayList<ImageModel> images,ImageLoader imageLoader){
        this.imageList=images;
        this.mLoader=imageLoader;
    }

    /*
    * used to create the layout for the view holder
    * */
    @Override
    public RecyclerImageListAdapter.ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerImageListAdapter.ImageHolder holder, int position) {
        ImageModel imageModel=imageList.get(position);
        holder.imageView.setImageUrl(imageModel.getUrl(),mLoader);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        private NetworkImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);
            imageView= (NetworkImageView) itemView.findViewById(R.id.image);

        }
    }
}
