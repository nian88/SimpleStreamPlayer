package com.rubit.simplestreamplayer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.rubit.simplestreamplayer.R;
import com.rubit.simplestreamplayer.utilties.DemoUtil;

public class MainActivity extends Activity {

	private Context context;
	private String contentUri;
	private TextView liveStreamingTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getApplicationContext();
		setContentView(R.layout.activity_main);
		contentUri = "http://abclive.abcnews.com/i/abc_live4@136330/index_1200_av-b.m3u8?sd=10&b=1200&rebase=on";
		// contentType = DemoUtil.TYPE_HLS;
		final Intent intent = new Intent(context, VideoPlayerActivity.class).setData(Uri.parse(contentUri))
				.putExtra(VideoPlayerActivity.CONTENT_ID_EXTRA, -1)
				//Change the type according to the live streaming extension.
				.putExtra(VideoPlayerActivity.CONTENT_TYPE_EXTRA, DemoUtil.TYPE_HLS);
		liveStreamingTv =(TextView)findViewById(R.id.mainActivity_liveStreamingTv);
		liveStreamingTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
}
