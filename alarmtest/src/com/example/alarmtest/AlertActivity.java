package com.example.alarmtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class AlertActivity extends Activity{
	
	private MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Ҫ����Ļ���ѣ�����
		Window win = getWindow();
		win.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
				WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
				WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("������");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("����,����,����,̫��ɹ��ƨ����!!");
		builder.show();
	}
	@Override
	protected void onResume() {
		super.onResume();
		player=MediaPlayer.create(this,R.raw.happy);
		//���ò��ŷ�ʽ---����ѭ��
		player.setLooping(true);
		player.start();
	}
	//���ϵĲ���������ʹ ����ֹͣ��Ϊ�������µĲ�������
	@Override
	protected void onPause() {
		super.onPause();
		if(player!=null)
		{
			if(player.isPlaying())
			{
				player.stop();
				//�����������������벻��Ч��һ��
//				player.release();����MediaPlayer����,�ͷ���Դ
			}
		}
	}

}
