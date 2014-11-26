package com.example.misharkiller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyGLActivity extends Activity {

	private GLSurfaceView glView;
	
	
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		glView = new GLSurfaceView(this);
		glView.setRenderer(new MyGLRenderer(this));
		this.setContentView(glView);
	}

	@Override
	protected void onPause(){
		super.onPause();
		glView.onPause();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		glView.onResume();
	}

}
