//x 0.9 1.3 1.9 2.1 2.6 3.0 3.9 4.4 4.7 5.0 6.0 7.0 8.0 9.2 10.5 11.3 11.6 12.0 12.6 13.0 13.3
//f(x) 1.3 1.5 1.85 2.1 2.6 2.7 2.4 2.15 2.05 2.1 2.25 2.3 2.25 1.95 1.4 0.9 0.7 0.6 0.5 0.4 0.25
package mathhomework;
import java.util.*;

public class hw1_a {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		//input n
		int n=21;
		//System.out.println("Please input your n:");
		//n=input.nextInt();
		double[] array_x={ 0.9,1.3, 1.9 ,2.1, 2.6, 3.0, 3.9, 4.4, 4.7, 5.0, 6.0, 7.0, 8.0, 9.2, 10.5, 11.3, 11.6, 12.0, 12.6, 13.0, 13.3};
		double[] array_y={1.3 ,1.5, 1.85, 2.1, 2.6, 2.7, 2.4, 2.15, 2.05, 2.1, 2.25, 2.3, 2.25, 1.95, 1.4, 0.9, 0.7, 0.6, 0.5, 0.4, 0.25};
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
		Lagramge(n,array_x,array_y);
		//call newton
		Newton(n,array_x,array_y);
	}
	//lagramge
	public static void Lagramge(int n,double[] array_x,double[] array_y){
		double[] q_value=new double[n];
		double result=0;
		double[] q_x_value=new double[n];
		double x=1;
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
			//System.out.println(x_func[i]);
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
		System.out.println("Q_function = "+x_total);
		System.out.println("Q("+x+") = "+result);
	}
	
	//newton
	public static void Newton(int n,double[] array_x,double[] array_y){
		String word="f";
		String x_word="[x0";
		double[][] f_value=new double[n][n];
		double[] f_x_value=new double[n]; 
		int count=1;
		double result=0;
		double x=1;
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
		//print number
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
					//System.out.println(x_func[i]);
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
