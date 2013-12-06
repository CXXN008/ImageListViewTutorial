package com.trey.imagelistviewtutorial;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static String[] urls = {"https://irs3.4sqi.net/img/general/300x300/26094_vcpeqzrKM1gvZAaPKzZMX4bhpFUidOhbTZ-nGX9hwwY.jpg", 
			"https://irs3.4sqi.net/img/general/300x300/336802_FgdStv7sSVuSjauBGM-KjCEqCVizjCfz7x6Rd4ARBc4.jpg", 
			"https://irs3.4sqi.net/img/general/300x300/ixlJvrrFSq6irvdssWB8aW61VUv2tvKqQ9Z1_rBU7zc.jpg", 
			"https://irs3.4sqi.net/img/general/300x300/XTJwB2CUWsOx49TlXnvopZrNqSlwhWoryQmRyoK-asI.jpg", 
			"https://irs3.4sqi.net/img/general/300x300/XusHjuygo_UBKWKSl8k9FRx9a-nRn4vEu9v59EeaBvE.jpg"};

	ArrayList<Bitmap> bitmaps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UrlLoader urlLoader = new UrlLoader(this);
		urlLoader.execute("");
		
	}
	
	public String[] getUrls() {
		return urls;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setBitmaps(ArrayList<Bitmap> bmaps) {
		bitmaps = new ArrayList<Bitmap>(bmaps);
		populatePhotoTable();
	}

	private void populatePhotoTable() {
		// TODO Auto-generated method stub
		final PhotoListAdapter adapter = new PhotoListAdapter(this, 0, bitmaps);
		ListView myList = (ListView) findViewById(android.R.id.list);
		myList.setAdapter(adapter);
		
	}

}
