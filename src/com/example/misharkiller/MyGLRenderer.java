package com.example.misharkiller;

import java.io.IOException;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.example.misharkiller.shape.Cube;
import com.example.misharkiller.shape.DeskDraw;
import com.example.misharkiller.shape.Pyramid;
import com.example.misharkiller.shape.Square;
import com.example.misharkiller.shape.TestCube;
import com.example.misharkiller.shape.TextureCube;
import com.example.misharkiller.shape.Triangle;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class MyGLRenderer implements Renderer {

	Context context;
	Triangle triangle;
	Square quad;
	Pyramid pyramid;
	//TextureCube cube;
	DeskDraw deskdraw;
	TestCube testCube;
	

	// Rotational angle & speed
	private float angleTriangle = 0.0f;
	private float angleQuad = 0.0f;
	private float speedTriangle = 0.5f;
	private float speedQuad = -0.4f;

	private static float anglePyramid = 0;
	private static float angleCube = 0;
	private static float speedPyramid = 2.0f;
	private static float speedCube = -1.5f;

	
	
	public MyGLRenderer(Context context) {
		this.context = context;
		// triangle = new Triangle();
		// quad = new Square();
		//pyramid = new Pyramid();
		testCube = new TestCube();

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glDisable(GL10.GL_DITHER);

		try {
			testCube.loadTexture(gl, context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gl.glEnable(GL10.GL_TEXTURE_2D);
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		if (height == 0)
			height = 1;
		float aspect = (float) width / height;

		gl.glViewport(0, 0, width, height);

		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();

		GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		// openGL|ES display re-sizing code

	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		
		// openGL|ES rendering code

		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -6.0f);
		gl.glRotatef(angleCube, 0.1f, 1.0f, 0.2f);
		testCube.draw(gl);
		
		angleCube += speedCube; // (NEW)
	}

}
