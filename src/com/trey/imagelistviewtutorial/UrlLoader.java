package com.trey.imagelistviewtutorial;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class UrlLoader extends android.os.AsyncTask<String, Integer, ArrayList<Bitmap>> {

	String[] urls;
	private MainActivity mActivity;
	private ProgressDialog mProgress;
	private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
	private static String TAG = "UrlLoader";
	
	public UrlLoader(MainActivity mainActivity) {
		this.urls = mainActivity.getUrls();
		this.mActivity = mainActivity;
	}
	
	@Override
	protected void onPreExecute() {
		mProgress = new ProgressDialog(mActivity);
		mProgress.setCancelable(false);
		mProgress.setMessage("Loading bitmaps...");
		mProgress.show();
		super.onPreExecute();
	}

	@Override
	protected ArrayList<Bitmap> doInBackground(String... params) {
		URL url;
		for (int i = 0; i < urls.length; i++) {
			try {
				url = new URL(urls[i]);
				Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
				bitmaps.add(bitmap);
			}
			
			catch (MalformedURLException e) {
				Log.e(TAG, "MalformedUrlException");
				Log.e(TAG, e.getMessage());
			}
			
			catch (IOException e) {
				Log.e(TAG, "IOException");
				Log.e(TAG, e.getMessage());
			}
			
		}
		return bitmaps;
	}
	
	protected void onPostExecute(ArrayList<Bitmap> bmaps) {
		mActivity.setBitmaps(bmaps);
		mProgress.dismiss();
		super.onPostExecute(bmaps);
		
	}

}
