package com.joe.camera2recorddemo.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.view.TextureView;
import android.view.View;

import com.joe.camera2recorddemo.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

	private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}; //array w/ permissions from manifest
	private int REQUEST_CODE_PERMISSIONS = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onClick(View v) {
		if (allPermissionsGranted()) {
			switch (v.getId()){
				case R.id.go_camera:
					startActivity(new Intent(MainActivity.this,CameraActivity.class));
					break;
				case R.id.go_mp4:
					startActivity(new Intent(MainActivity.this,MP4Activity.class));
					break;
				case R.id.go_pic:
					startActivity(new Intent(MainActivity.this,AdjustActivity.class));
					break;
			}
		} else {
			ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
		}


	}

	private boolean allPermissionsGranted() {
		//check if req permissions have been granted
		for (String permission : REQUIRED_PERMISSIONS) {
			if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}
}
