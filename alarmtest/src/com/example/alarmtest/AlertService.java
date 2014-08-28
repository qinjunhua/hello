package com.example.alarmtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlertService extends BroadcastReceiver{
public static final String ACTION="com.example.action.ACTION_1";
	@Override
	public void onReceive(Context context, Intent intent) {

		if(intent.getAction().equals(ACTION))
		{
			Toast.makeText(context, "起床了！起床了！", Toast.LENGTH_SHORT).show();
		}
	}

}
