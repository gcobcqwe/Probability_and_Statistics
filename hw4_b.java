package mathhomework;
import java.util.*;

public class hw4_b {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		//input n
		int n=21;
		double[] x=new double[41];
		double[] array_x=new double[21];
		double[] array_y=new double[21];
		
		
	    for(int i=0;i<21;i++){
	    	array_x[i]=(i*2*Math.PI)/20;
	    	array_y[i]=Math.sin((i*2*Math.PI)/20);
	    }
	    
	    for(int i=0;i<21;i++){
	    	x[2*i]=array_x[i];
	    	if(2*i+1<41){
	    	x[2*i+1]=(array_x[i+1]+array_x[i])/2;
	    	}
	    }
		//call lagramge
		Lagramge(x,n,array_x,array_y);
		//call newton
		Newton(x,n,array_x,array_y);
	}
	//lagramge
	public static void Lagramge(double[] x,int n,double[] array_x,double[] array_y){
		double[] q_value=new double[n];
		double result;
		double[] q_x_value=new double[n];
		System.out.println("Lagramge");
		
		for(int k=0;k<41;k++){
			result=0;
		for(int i=0;i<n;i++){
			q_value[i]=1;
			for(int j=0;j<n;j++){
				if(i!=j){
					q_value[i]=q_value[i]*(array_x[i]-array_x[j]);
				}
			}
			q_value[i]=array_y[i]/q_value[i];
			//System.out.println("q"+i+" = "+q_value[i]);
		}
		
		//count(x-xi)
		for(int i=0;i<n;i++){
			q_x_value[i]=1;
			for(int j=0;j<n;j++){
				if(i!=j){
			       q_x_value[i]=(x[k]-array_x[j])*q_x_value[i];
			       //System.out.println(q_x_value[i]);
				}
			}
		}
		//count last number
		for(int i=0;i<n;i++){
			result+=(q_value[i]*q_x_value[i]);
			//System.out.println(result);
		}
		System.out.println("|f(x)-Q"+k+"("+x[k]+")| = "+(Math.abs((Math.sin(x[k])-result))));
		}
	}
	//newton
	public static void Newton(double[] x,int n,double[] array_x,double[] array_y){
		String word;
		String x_word;
		double[][] f_value=new double[n][n];
		double[] f_x_value=new double[n]; 
		int count;
		double result;
		//print x
				System.out.println("\n");
				System.out.println("Newton");
		for(int l=0;l<41;l++){
			word="f";
			x_word="[x0";
			count=1;
			result=0;
		for(int j=0;j<n;j++){
			f_value[0][j]=array_y[j];
			//System.out.println(f_value[0][j]);
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<n;j++){
				if(j+1<n && j+count<n){
				f_value[i][j]=(f_value[i-1][j+1]-f_value[i-1][j])/(array_x[j+count]-array_x[j]);
				//System.out.println(f_value[i][j]);
				}
			}
			count++;
		}
		
		for(int k=0;k<n;k++){
			//System.out.println(word+x_word+"] = "+f_value[k][0]);
			x_word+=",x"+(k+1);
		}
		//count x-xi
		f_x_value[0]=1;
		for(int i=1;i<n;i++){
			f_x_value[i]=(x[l]-array_x[i-1])*f_x_value[i-1];
			//System.out.println(f_x_value[i]);
		}
		//count result
		for(int k=0;k<n;k++){
		   result+=f_value[k][0]*f_x_value[k];
		}
		   System.out.println("|f(x)-P"+l+"("+x[l]+")| = "+(Math.abs((Math.sin(x[l])-result))));
		}
	}
}
