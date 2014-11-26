package com.example.misharkiller.shape;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class TestCube {
	
	private FloatBuffer vertexBuffer;
	private FloatBuffer normalBuffer;
	private FloatBuffer textureBuffer;
	private int triangleNum = vertices.length / 3;
	int[] textureIDs = new int[1];   // Array for 1 texture-ID (NEW)
	
	
	private static float[] vertices = {
			1.000000f, 1.000000f, -1.000000f,
			1.000000f, -1.000000f, -1.000000f,
			-1.000000f, -1.000000f, -1.000000f,
			1.000000f, 1.000000f, -1.000000f,
			-1.000000f, -1.000000f, -1.000000f,
			-1.000000f, 1.000000f, -1.000000f,
			-1.000000f, -1.000000f, 1.000000f,
			-1.000000f, 1.000000f, 1.000000f,
			-1.000000f, 1.000000f, -1.000000f,
			-1.000000f, -1.000000f, 1.000000f,
			-1.000000f, 1.000000f, -1.000000f,
			-1.000000f, -1.000000f, -1.000000f,
			1.000000f, -1.000000f, 1.000000f,
			0.999999f, 1.000000f, 1.000001f,
			-1.000000f, -1.000000f, 1.000000f,
			0.999999f, 1.000000f, 1.000001f,
			-1.000000f, 1.000000f, 1.000000f,
			-1.000000f, -1.000000f, 1.000000f,
			1.000000f, -1.000000f, -1.000000f,
			1.000000f, 1.000000f, -1.000000f,
			1.000000f, -1.000000f, 1.000000f,
			1.000000f, 1.000000f, -1.000000f,
			0.999999f, 1.000000f, 1.000001f,
			1.000000f, -1.000000f, 1.000000f,
			1.000000f, 1.000000f, -1.000000f,
			-1.000000f, 1.000000f, -1.000000f,
			0.999999f, 1.000000f, 1.000001f,
			-1.000000f, 1.000000f, -1.000000f,
			-1.000000f, 1.000000f, 1.000000f,
			0.999999f, 1.000000f, 1.000001f,
			1.000000f, -1.000000f, -1.000000f,
			1.000000f, -1.000000f, 1.000000f,
			-1.000000f, -1.000000f, 1.000000f,
			1.000000f, -1.000000f, -1.000000f,
			-1.000000f, -1.000000f, 1.000000f,
			-1.000000f, -1.000000f, -1.000000f
		};
		private float[] texCoords = {
			0.748573f, 0.750412f, 0.749279f,
			0.749279f, 0.501284f, 0.999110f,
			0.999110f, 0.501077f, 0.748573f,
			0.748573f, 0.750412f, 0.999110f,
			0.999110f, 0.501077f, 0.999455f,
			0.999455f, 0.750380f, 0.250471f,
			0.250471f, 0.500702f, 0.249682f,
			0.249682f, 0.749677f, 0.001085f,
			0.001085f, 0.750380f, 0.250471f,
			0.250471f, 0.500702f, 0.001085f,
			0.001085f, 0.750380f, 0.001517f,
			0.001517f, 0.499994f, 0.499422f,
			0.499422f, 0.500239f, 0.500149f,
			0.500149f, 0.750166f, 0.250471f,
			0.250471f, 0.500702f, 0.500149f,
			0.500149f, 0.750166f, 0.249682f,
			0.249682f, 0.749677f, 0.250471f,
			0.250471f, 0.500702f, 0.749279f,
			0.749279f, 0.501284f, 0.748573f,
			0.748573f, 0.750412f, 0.499422f,
			0.499422f, 0.500239f, 0.748573f,
			0.748573f, 0.750412f, 0.500149f,
			0.500149f, 0.750166f, 0.499422f,
			0.499422f, 0.500239f, 0.748573f,
			0.748573f, 0.750412f, 0.748355f,
			0.748355f, 0.998230f, 0.500149f,
			0.500149f, 0.750166f, 0.748355f,
			0.748355f, 0.998230f, 0.500193f,
			0.500193f, 0.998728f, 0.500149f,
			0.500149f, 0.750166f, 0.749279f,
			0.749279f, 0.501284f, 0.499422f,
			0.499422f, 0.500239f, 0.498993f,
			0.498993f, 0.250415f, 0.749279f,
			0.749279f, 0.501284f, 0.498993f,
			0.498993f, 0.250415f, 0.748953f,
			0.748953f, 0.250920f, 0.000000f
		};
		private float[] normals = {
			0.000000f, 0.000000f, -1.000000f,
			0.000000f, 0.000000f, -1.000000f,
			0.000000f, 0.000000f, -1.000000f,
			0.000000f, 0.000000f, -1.000000f,
			0.000000f, 0.000000f, -1.000000f,
			0.000000f, 0.000000f, -1.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-1.000000f, -0.000000f, -0.000000f,
			-0.000000f, -0.000000f, 1.000000f,
			-0.000000f, -0.000000f, 1.000000f,
			-0.000000f, -0.000000f, 1.000000f,
			-0.000001f, 0.000000f, 1.000000f,
			-0.000001f, 0.000000f, 1.000000f,
			-0.000001f, 0.000000f, 1.000000f,
			1.000000f, -0.000000f, 0.000000f,
			1.000000f, -0.000000f, 0.000000f,
			1.000000f, -0.000000f, 0.000000f,
			1.000000f, 0.000000f, 0.000001f,
			1.000000f, 0.000000f, 0.000001f,
			1.000000f, 0.000000f, 0.000001f,
			0.000000f, 1.000000f, -0.000000f,
			0.000000f, 1.000000f, -0.000000f,
			0.000000f, 1.000000f, -0.000000f,
			0.000000f, 1.000000f, -0.000000f,
			0.000000f, 1.000000f, -0.000000f,
			0.000000f, 1.000000f, -0.000000f,
			-0.000000f, -1.000000f, 0.000000f,
			-0.000000f, -1.000000f, 0.000000f,
			-0.000000f, -1.000000f, 0.000000f,
			-0.000000f, -1.000000f, 0.000000f,
			-0.000000f, -1.000000f, 0.000000f,
			-0.000000f, -1.000000f, 0.000000f
		};
		public TestCube(){
			ByteBuffer vbb =  ByteBuffer.allocateDirect(vertices.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertices);
			vertexBuffer.position(0);
			
			ByteBuffer tbb =  ByteBuffer.allocateDirect(texCoords.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			textureBuffer = tbb.asFloatBuffer();
			textureBuffer.put(texCoords);
			textureBuffer.position(0);
			
			ByteBuffer nbb =  ByteBuffer.allocateDirect(normals.length * 4);
			nbb.order(ByteOrder.nativeOrder());
			normalBuffer = nbb.asFloatBuffer();
			normalBuffer.put(normals);
			normalBuffer.position(0);
			
		}
		
		// Load an image into GL texture
		   public void loadTexture(GL10 gl, Context context) throws IOException {
		      
			  gl.glGenTextures(1, textureIDs, 0); // Generate texture-ID array

		      gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[0]);   // Bind to texture ID
		      // Set up texture filters
		      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		      gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
		      
		      // Construct an input stream to texture image "res\drawable\nehe.png"
		      //InputStream istream = context.getResources().openRawResource(com.example.misharkiller.R.drawable.ic_launcher);
		      
		      InputStream istream = context.getAssets().open("paper_a.png");
		      Bitmap bitmap;
		      try {
		         // Read and decode input as bitmap
		         bitmap = BitmapFactory.decodeStream(istream);
		      } finally {
		         try {
		            istream.close();
		         } catch(IOException e) { }
		      }
		  
		      // Build Texture from loaded bitmap for the currently-bind texture ID
		      
		      GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
		      bitmap.recycle();
		      
		   }
		
		
		public void draw(GL10 gl) {
			
			
			//vertices
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
			
			//normal
			gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
			gl.glNormalPointer(GL10.GL_FLOAT, 0, normalBuffer);
			
			//texture
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
			
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, triangleNum);
			
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			
			
		}


}
