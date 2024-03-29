package com.example.kelvinlopeztorres.tcgshoppr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Card> {

    private static final String TAG = "CustomListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    private int cardTitle;
    private int cardBody;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView title;
        TextView body;
        ImageView image;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapter(Context context, int resource, ArrayList<Card> objects, int CT, int CB) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        cardTitle = CT;
        cardBody = CB;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //sets up the image loader library
        //setupImageLoader();
        //get the persons information
        String title = getItem(position).getTitle();
        String body = getItem(position).getBody();
        //String imgUrl = getItem(position).getImgURL();

        try{

            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.title = (TextView) convertView.findViewById(cardTitle);
                holder.body = (TextView) convertView.findViewById(cardBody);
               // holder.image = (ImageView) convertView.findViewById(R.id.cardImage);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

//            Animation animation = AnimationUtils.loadAnimation(mContext,
//                    (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
//            result.startAnimation(animation);
              lastPosition = position;
//
              holder.title.setText(title);
              holder.body.setText(body);
//
//            //create the imageloader object
//            ImageLoader imageLoader = ImageLoader.getInstance();
//
//            int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());
//
//            //create display options
//            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
//                    .cacheOnDisc(true).resetViewBeforeLoading(true)
//                    .showImageForEmptyUri(defaultImage)
//                    .showImageOnFail(defaultImage)
//                    .showImageOnLoading(defaultImage).build();
//
//            //download and display image from url
//            imageLoader.displayImage(imgUrl, holder.image, options);

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }
    }

    /**
     * Required for setting up the Universal Image loader Library
     */
//    private void setupImageLoader(){
//        // UNIVERSAL IMAGE LOADER SETUP
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheOnDisc(true).cacheInMemory(true)
//                .imageScaleType(ImageScaleType.EXACTLY)
//                .displayer(new FadeInBitmapDisplayer(300)).build();
//
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                mContext)
//                .defaultDisplayImageOptions(defaultOptions)
//                .memoryCache(new WeakMemoryCache())
//                .discCacheSize(100 * 1024 * 1024).build();
//
//        ImageLoader.getInstance().init(config);
//        // END - UNIVERSAL IMAGE LOADER SETUP
//    }
}