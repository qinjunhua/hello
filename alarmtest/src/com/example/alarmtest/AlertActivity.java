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
		//要把屏幕唤醒，解锁
		Window win = getWindow();
		win.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
				WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
				WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("起床闹钟");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("懒猪,懒猪,起床了,太阳晒到屁股了!!");
		builder.show();
	}
	@Override
	protected void onResume() {
		super.onResume();
		player=MediaPlayer.create(this,R.raw.happy);
		//设置播放方式---单曲循环
		player.setLooping(true);
		player.start();
	}
	//以上的操作还不能使 音乐停止，为此做以下的操作补充
	@Override
	protected void onPause() {
		super.onPause();
		if(player!=null)
		{
			if(player.isPlaying())
			{
				player.stop();
				//？？？？？？？加与不加效果一样
//				player.release();销毁MediaPlayer对象,释放资源
			}
		}
	}

}
