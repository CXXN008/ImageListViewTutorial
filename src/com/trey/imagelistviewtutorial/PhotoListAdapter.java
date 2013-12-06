package com.trey.imagelistviewtutorial;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class PhotoListAdapter extends ArrayAdapter<Bitmap> {
	
	List<Bitmap> bitmaps;
	Context context;
	int resource;
	public PhotoListAdapter(Context context, int resource, List<Bitmap> bitmaps) {
		super(context, resource, bitmaps);
		this.context = context;
		this.resource = resource;
		this.bitmaps = bitmaps;
		
	}
	
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	    View rowView = convertView;
	    if (rowView == null) {
	      LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	      rowView = inflater.inflate(R.layout.tablephoto, null);
	      //ImageView imageView = (ImageView) rowView.findViewById(R.id.tablePhoto);
	    }

	    final ImageView imageView = (ImageView) rowView.findViewById(R.id.tablePhoto);
	    final int pos = position;
	    ((Activity) context).runOnUiThread(new Runnable() {
			public void run() {
			    imageView.setImageBitmap(bitmaps.get(pos));

			}
		});
	    return rowView;
	  }


}
