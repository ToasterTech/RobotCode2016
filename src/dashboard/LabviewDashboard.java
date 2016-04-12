package dashboard;

import java.util.HashMap;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LabviewDashboard extends DashboardBase{
	private static LabviewDashboard instance=null;
	private HashMap<String,Double> doubleValMap;
	private NetworkTable datatable;
	@Override
	public void addData(String name, double val) {
		// TODO Auto-generated method stub
		doubleValMap.put(name, val);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		doubleValMap=new HashMap<String,Double>();
		datatable = NetworkTable.getTable("Datatable");
		System.out.println("NT Connected: "+datatable.isConnected());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(String key:doubleValMap.keySet()){
			datatable.putNumber(key, doubleValMap.get(key));
		}
	}
 
	
	public static DashboardBase getDashboard() {
		if(instance==null)
			instance=new LabviewDashboard();
		return instance;
	}

	@Override
	public double getDouble(String name) {
		// TODO Auto-generated method stub
		return datatable.getNumber(name, 0);
	}

	@Override
	public String getString(String name) {
		// TODO Auto-generated method stub
		return datatable.getString(name, "Not Found");
	}
	
	@Override
	public boolean getBoolean(String name) {
		// TODO Auto-generated method stub
		return datatable.getBoolean(name, false);
	}
	
}
