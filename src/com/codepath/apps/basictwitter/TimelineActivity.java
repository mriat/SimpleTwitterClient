package com.codepath.apps.basictwitter;

import java.util.ArrayList;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codepath.apps.basictwitter.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class TimelineActivity extends Activity {
	
	private TwitterClient client;
	private ArrayList<Tweet> tweets;
	private ArrayAdapter<Tweet> aTweets;
	private ListView lvTweets;
	private static final int RECORD_COUNT = 25;
	private static final int REQUEST_CODE = 37;
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		
		// gets an instance of the authenticated activity
		client = TwitterApplication.getRestClient();
		
		populateTimeline(25, -1, -1);
		
		lvTweets = (ListView) findViewById(R.id.lvTweets);
		tweets = new ArrayList<Tweet>();
		aTweets = new TweetArrayAdapter(this, tweets);
		lvTweets.setAdapter(aTweets);		
		
		lvTweets.setOnScrollListener(new EndlessScrollListener() {
			@Override
		    public void onLoadMore(int page, int totalItemsCount) {
                
				// Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
	    	
		    	if (totalItemsCount >= tweets.size()) {
		    		long maxId = aTweets.getItem(totalItemsCount - 1).getUid() - 1;
                    populateTimeline(RECORD_COUNT, -1, maxId);
                }
		    }
		});
	}
	
	public void populateTimeline(int count, long sinceId, long maxId) {
		client.getHomeTimeline(
			count,
			sinceId,
			maxId,
			new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONArray json) {
					//Log.d("debug", json.toString());
					aTweets.addAll(Tweet.fromJSONArray(json));
				}
		
				@Override
				public void onFailure(Throwable e, String s) {
					Log.d("debug", e.toString());
					Log.d("debug", s.toString());
				}
			}
		);
	}
	
	public void onComposeAction(MenuItem mi) {		
		// first parameter is the context, second is the class of the activity to launch
		Intent i = new Intent(TimelineActivity.this, ComposeActivity.class);
		startActivityForResult(i, REQUEST_CODE); // brings up the second activity
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// REQUEST_CODE is defined above
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			
			Tweet composeTweet = (Tweet) data.getSerializableExtra("tweet");

			tweets.add(0, composeTweet);
			lvTweets.setSelection(0);
			aTweets.notifyDataSetChanged();
		}
	}

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}