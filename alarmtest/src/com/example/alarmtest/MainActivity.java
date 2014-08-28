package com.example.alarmtest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	AlarmManager manager=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取服务管理器
		manager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
	}
/**
 * 只执行一次的闹钟的事件处理
 * @param v
 */
	public void OneTimeClick(View v)
	{
		//设置开始时间
		long triggerAtTime=System.currentTimeMillis()+2000;
		//*************************简单的跳到 一个广播*****************************
		//设置Intent,即要跳转的页面 
//		Intent intent=new Intent(AlertService.ACTION);
//		// 设置要执行的操作
//		PendingIntent operation=PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//		//(类型，开始时间，操作)
//		manager.set(AlarmManager.RTC_WAKEUP, triggerAtTime, operation);
		
		
		//*****************跳到Activity中,以对话框的形式显示***************************
	    Intent intent=new Intent(this,AlertActivity.class);
		manager.set(AlarmManager.RTC_WAKEUP, triggerAtTime, PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT));
	
	}
	/**
	 * 重复响的闹钟
	 * @param v
	 */
	PendingIntent pi=null;
	public void ManyTimeClick(View v)
	{
		long triggerAtTime=System.currentTimeMillis()+2000;
		//设置重复调用的间隔时间
		long interval=3000;
		Intent intent=new Intent(AlertService.ACTION);
		//定义要执行的操作
		pi=PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		manager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtTime, interval, pi);
	}
	/**
	 * 停止重复的播放的事件操作
	 * @param v
	 */
	public void stopClick(View v)
	{
		if(pi!=null)
		{
			manager.cancel(pi);
		}
	}

}
