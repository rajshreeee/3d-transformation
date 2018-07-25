package rrassi3;

import rrassi4.Eventlistener;

import com.jogamp.opengl.GL2;

public class rotation {
	

	
	public static void drawTriangle(){
		
		 
		  GL2 gl = eventlistener.gl;
			gl.glColor3d(0, 0, 0);
			gl.glBegin(GL2.GL_LINES);
			gl.glVertex3f(1, 0, 0);
			gl.glVertex3f(-1, 0, 0);
			gl.glVertex3f(0, 1, 0);
			gl.glVertex3f(0, -1, 0);
			gl.glVertex3f(0, 0, -1);
			gl.glVertex3f(0, 0, 1);
			gl.glEnd();
			rotate(x1, y1, z1, x2, y2, z2, x3, y3, z3);
			matrixMultiply(x1, y1, z1, x2, y2, z2, x3, y3, z3, O);
	}
	

		
		public static void rotate(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
			 GL2 gl = eventlistener.gl;
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glVertex3f((float)a / 100, (float)b / 100, (float)c / 100);
			gl.glVertex3f((float)d / 100, (float)e / 100, (float)f / 100);
			gl.glVertex3f((float)g / 100, (float)h / 100, (float)i / 100);
			gl.glEnd();

		
	
		

		
		 		
	}
		
		//Matrix multiplication
		public static void matrixMultiply(int[] x1, int[] y1, int[] z1, int[] x2, int[] y2, int[] z2, int[] x3, int[] y3, int z3, float O)
		{
			int [][]A = { cos(O), -sin(O), 0, 0, sin(O), cos(O), 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 };
			int [][]B = { x1, y1, z1, 1 };
			int [][]C = { x2, y2, z2, 1 };
			int [][]D = { x3, y3, z3, 1 };

			GL2 gl = eventlistener.gl;
			int i, j, k;
			
			for (i = 0; i < 4; i++)
			{
				for (j = 0; j < 1; j++)
				{
					D[i][j] = 0;
					E[i][j] = 0;
					F[i][j] = 0;
					for (k = 0; k < 4; k++)
					{
						D[i][j] += A[i][k] * B[k][j];
						E[i][j] += A[i][k] * C[k][j];
						F[i][j] += A[i][k] * P[k][j];
					}
				}
			}
			
			
			gl.glColor3f(0.0f, 0.f, 1.0f);
			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glVertex3f((float)D[0][0] / 100, (float)D[1][0] / 100, (float)D[2][0] / 100);
			gl.glVertex3f((float)E[0][0] / 100, (float)E[1][0] / 100, (float)E[2][0] / 100);
			gl.glVertex3f((float)F[0][0] / 100, (float)F[1][0] / 100, (float)F[2][0] / 100);
			
			gl.glEnd();
		}



		private static int[] sin(float o) {
			// TODO Auto-generated method stub
			return 0;
		}



		private static int[] cos(float o) {
			// TODO Auto-generated method stub
			return null;
		}

	

}
