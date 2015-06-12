//x 1 2 2.5 3 4 5
//f(x) 0 5 7 6.5 2 0 
package mathhomework;
import java.util.*;

public class hw2_a_b {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		//input n
		int n=6;
		double x=3.4;
		//System.out.println("Please input your n:");
		//n=input.nextInt();
		double[] array_x={1 ,2, 2.5, 3 ,4 ,5};
		double[] array_y={0 ,5 ,7 ,6.5, 2 ,0 };
	    /*input xi
		System.out.println("Please input your xi:");
		for(int i=0;i<n;i++){
			array_x[i]=input.nextDouble();
		}
		//input yi
		System.out.println("Please input your yi:");
		for(int i=0;i<n;i++){
			array_y[i]=input.nextDouble();
		}
		
		System.out.println("Please input your x:");
		double x;
		x=input.nextDouble();
		*/
		//call lagramge
		Lagramge(x,n,array_x,array_y);
		//call newton
		Newton(x,n,array_x,array_y);
	}
	//lagramge
	public static void Lagramge(double x,int n,double[] array_x,double[] array_y){
		double[] q_value=new double[n];
		double result=0;
		double[] q_x_value=new double[n];
		String[] x_func=new String[n]; 
		String x_total=""; 
		int m=0;
		for(int i=0;i<n;i++){
			q_value[i]=1;
			for(int j=0;j<n;j++){
				if(i!=j){
					q_value[i]=q_value[i]*(array_x[i]-array_x[j]);
				}
			}
			q_value[i]=array_y[i]/q_value[i];
			System.out.println("q"+i+" = "+q_value[i]);
		}
		
		//count(x-xi)
		for(int i=0;i<n;i++){
			q_x_value[i]=1;
			x_func[i]="";
			for(int j=0;j<n;j++){
				if(i!=j){
			       q_x_value[i]=(x-array_x[j])*q_x_value[i];
			       if(m<n-2){
			           x_func[i]+="(x"+(-array_x[j])+").*";
			       }
			       else{
			    	   x_func[i]+="(x"+(-array_x[j])+")";   
			       }
			       m++;
			       //System.out.println(q_x_value[i]);
				}
			}
			m=0;
		}
		//count last number
		for(int i=0;i<n;i++){
			result+=(q_value[i]*q_x_value[i]);
			//System.out.println(result);
			if(i!=n-1){
				x_total+="("+q_value[i]+".*"+x_func[i]+")"+"+";
			}
			else
				x_total+="("+q_value[i]+".*"+x_func[i]+")";
		}
		System.out.println("Q_function = "+x_total);
		System.out.println("Q("+x+") = "+result);
	}
	//newton
	public static void Newton(double x,int n,double[] array_x,double[] array_y){
		String word="f";
		String x_word="[x0";
		double[][] f_value=new double[n][n];
		double[] f_x_value=new double[n]; 
		int count=1;
		double result=0;
		String[] x_func=new String[n]; 
		String x_total=""; 
		
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
		//print x
		for(int k=0;k<n;k++){
			System.out.println(word+x_word+"] = "+f_value[k][0]);
			x_word+=",x"+(k+1);
		}
		//count x-xi
		f_x_value[0]=1;
		x_func[0]="1";
		for(int i=1;i<n;i++){
			f_x_value[i]=(x-array_x[i-1])*f_x_value[i-1];
			x_func[i]="(x"+(-array_x[i-1])+")"+".*"+x_func[i-1];
			//System.out.println(f_x_value[i]);
		}
		//count result
		for(int k=0;k<n;k++){
		   result+=f_value[k][0]*f_x_value[k];
		   if(k!=n-1){
			   x_total+="("+f_value[k][0]+".*"+x_func[k]+")"+"+";
			   }
			   else
				   x_total+="("+f_value[k][0]+".*"+x_func[k]+")";
		}
		   System.out.println("P("+x+") = "+result);
		   System.out.println("P_function ="+x_total);
	}
}
