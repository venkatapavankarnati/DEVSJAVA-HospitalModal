package HospitalModel;
import simView.*;


import java.lang.*;
import genDevs.modeling.*;
import genDevs.simulation.*;
import GenCol.*;
import util.*;
import statistics.*;

public class Patient extends ViewableAtomic {
	protected int activeTime = 10;
	protected int patientCount =0,emerCount=0;
	protected rand r;
	public Patient()
	{
		this("Patient");
	}
	
	public Patient(String name){
		   super(name);
		   if(name.equals("Patient"))
			   activeTime = 10;
		   else
			   activeTime=40;
		   addInport("IN");
		   addOutport("OUT");
		}
	
	public void initialize(){
		   holdIn("active", activeTime);
		   r = new rand(123987979);
		   if(name.equals("Patient"))
		   patientCount=1;
		   else
		   emerCount=1;
		}
	
	public void  deltext(double e,message x)
	{
	   Continue(e);
	   for (int i=0; i< x.getLength();i++){
	     if (messageOnPort(x, "IN", i)) {
	       passivate();
	     }
	   }
	}
	
	public void  deltint( )
	{
		
	if(phaseIs("active")){
	   if(name.equals("Patient"))
		   		patientCount++; 
		   else
			  emerCount++;
	   holdIn("active", Math.ceil(activeTime+r.uniform(5)));
	}
	else passivate();
	}
	
	public message  out( )
	{
	   message  m = new message();
	   content con;
	   System.out.println(name);
	   if(name.equals("Patient"))
		   con = makeContent("OUT", new entity("Patient"+Integer.toString(patientCount)));
	   else
		  con = makeContent("OUT", new entity("EmergencyPatient"+Integer.toString(emerCount)));
	   m.add(con);
	  return m;
	}
	
}
