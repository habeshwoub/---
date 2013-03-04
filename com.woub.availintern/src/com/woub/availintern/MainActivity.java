package com.woub.availintern;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button checkbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		checkbtn = (Button) findViewById(R.id.button1);

		checkbtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (isInternetOn()) {
					Toast.makeText(getBaseContext(), "Connected",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getBaseContext(), "Not connected",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

	public final boolean isInternetOn() {

		ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		if ((connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED)
				|| (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING)
				|| (connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING)
				|| (connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)) {
			return true;
		}

		else if ((connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED)
				|| (connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED)) {
			return false;
		}

		return false;
	}

}
