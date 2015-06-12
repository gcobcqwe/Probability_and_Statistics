
package mathhomework;
import java.util.*;

public class hw3_a {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		//input n
		int n=11;
		double[] array_x=new double[11];
		double[] array_y=new double[11];
	    for(int i=0;i<11;i++){
	    	array_x[i]=(i*2*Math.PI)/10;
	    	array_y[i]=Math.sin((i*2*Math.PI)/10);
	    }
		
		
		//System.out.println("Please input your x:");
		double x=1;
		//x=input.nextDouble();
		
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
		System.out.println("Lagramge");
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
			if(i!=n-1){
				x_total+="("+q_value[i]+".*"+x_func[i]+")"+"+";
			}
			else
				x_total+="("+q_value[i]+".*"+x_func[i]+")";
			//System.out.println(result);
		}
		System.out.println("Q("+x+") = "+result);
		System.out.println("Q_function = "+x_total);
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
		System.out.println("\n");
		System.out.println("Newton");
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
