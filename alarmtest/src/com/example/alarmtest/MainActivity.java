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
		//��ȡ���������
		manager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
	}
/**
 * ִֻ��һ�ε����ӵ��¼�����
 * @param v
 */
	public void OneTimeClick(View v)
	{
		//���ÿ�ʼʱ��
		long triggerAtTime=System.currentTimeMillis()+2000;
		//*************************�򵥵����� һ���㲥*****************************
		//����Intent,��Ҫ��ת��ҳ�� 
//		Intent intent=new Intent(AlertService.ACTION);
//		// ����Ҫִ�еĲ���
//		PendingIntent operation=PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//		//(���ͣ���ʼʱ�䣬����)
//		manager.set(AlarmManager.RTC_WAKEUP, triggerAtTime, operation);
		
		
		//*****************����Activity��,�ԶԻ������ʽ��ʾ***************************
	    Intent intent=new Intent(this,AlertActivity.class);
		manager.set(AlarmManager.RTC_WAKEUP, triggerAtTime, PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT));
	
	}
	/**
	 * �ظ��������
	 * @param v
	 */
	PendingIntent pi=null;
	public void ManyTimeClick(View v)
	{
		long triggerAtTime=System.currentTimeMillis()+2000;
		//�����ظ����õļ��ʱ��
		long interval=3000;
		Intent intent=new Intent(AlertService.ACTION);
		//����Ҫִ�еĲ���
		pi=PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		manager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtTime, interval, pi);
	}
	/**
	 * ֹͣ�ظ��Ĳ��ŵ��¼�����
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
