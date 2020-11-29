package HospitalModel;
import simView.*;import java.lang.*;
import genDevs.modeling.*;
import genDevs.simulation.*;
import GenCol.*;
import util.*;
import statistics.*;


public class Receptionist extends ViewableAtomic {
	protected int activeTime = 10;
	protected int count =0;
	
	public Receptionist()
	{
		this("Receptionist");
	}
	
	public Receptionist(String name){
		   super(name);
		   addInport("IN");
		   addOutport("OUT");
		}
	
	public void initialize(){
		   holdIn("active", activeTime);
		   count++;
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
	   count++;
	   holdIn("active",activeTime);
	}
	else passivate();
	}
	
	public message  out( )
	{
	System.out.println(" OUT count "+count);
	   message  m = new message();
	   content con = makeContent("OUT", new entity("car "+Integer.toString(count)));
	   m.add(con);
	   return m;
	}
	
}