package mathhwfour;
import java.util.*;

public class hw4_c {
	public static void main(String args[]){
		double start_point=0;
		double end_point=1;
		
		Midpoint(start_point,end_point);
		Trapezoidal(start_point,end_point);
		Simpson(start_point,end_point);
	}
	
	//midpoint
	public static void Midpoint(double start_point,double end_point){
		int anser_m;
		double anser_value=0;
		double temp = 0;
		int n;
		double h;
		
		for(int m=1;;m++){
		    n=2*m-2;	
		    h=(end_point-start_point)/(n+2);
		    for(int j=0;j<=n/2;j++){
		    	temp+=Math.atan(start_point+(2*j+1)*h);
		    }	    
		    //must add abs
		    if(Math.abs(2*h*temp-anser_value)<0.000001){
		    	anser_m=m;
		    	anser_value=2*h*temp;
		    	System.out.println("midpoint:");
		    	System.out.println("m = "+anser_m);
		    	System.out.println("final approximation = "+anser_value);
		    	break;
		    }
		    anser_value=2*h*temp;
		    temp=0;
		}	
	} 
	//Trapezoidal
	public static void Trapezoidal(double start_point,double end_point){
		int anser_m;
		double anser_value=0;
		double temp = 0;
		int n;
		double h;
		
		for(int m=1;;m++){
		    n=m;	
		    h=(end_point-start_point)/n;
		    for(int j=1;j<=n-1;j++){
		    	temp+=Math.atan(start_point+(j*h));
		    }	    
		    //System.out.println(Math.abs((((2*temp)+Math.esp(start_point)+Math.esp(end_point))*h/2)));
		    if(Math.abs((((2*temp)+Math.atan(start_point)+Math.atan(end_point))*h/2)-anser_value)<0.000001 && m!=1){
		    	anser_m=m;
		    	anser_value=((2*temp)+Math.atan(start_point)+Math.atan(end_point))*h/2;
		    	System.out.println("Trapezoidal:");
		    	System.out.println("m = "+anser_m);
		    	System.out.println("final approximation = "+anser_value);
		    	break;
		    }
		    anser_value=((2*temp)+Math.atan(start_point)+Math.atan(end_point))*h/2;
		    temp=0;
		}	 
	}
	//Simpson
	public static void Simpson(double start_point,double end_point){
		int anser_m;
		double anser_value=0;
		double temp_mid = 0;
		double temp_tra = 0;
		int n;
		double h;
		
		for(int m=1;;m++){
		    n=2*m;	
		    h=(end_point-start_point)/n;
		    for(int j=1;j<=(n/2);j++){
		    	temp_mid+=Math.atan(start_point+((2*j-1)*h));
		    }	    
		    for(int j=1;j<=(n/2)-1;j++){
		    	temp_tra+=Math.atan(start_point+(2*j*h));
		    }	     
		    //must add abs
		    if(Math.abs((Math.atan(start_point)+(4*temp_mid)+(2*temp_tra)+Math.atan(end_point))*h/3-anser_value)<0.000001 && m!=1){
		    	anser_m=m;
		    	anser_value=(Math.atan(start_point)+(4*temp_mid)+(2*temp_tra)+Math.atan(end_point))*h/3;
		    	System.out.println("Simpson's:");
		    	System.out.println("m = "+anser_m);
		    	System.out.println("final approximation = "+anser_value);
		    	break;
		    }
		    anser_value=(Math.atan(start_point)+(4*temp_mid)+(2*temp_tra)+Math.atan(end_point))*h/3;
		    temp_mid=0;
		    temp_tra=0;
		}	
	} 
}
