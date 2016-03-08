package dashboard;

public abstract class DashboardBase {
	public abstract void init();
	public abstract void addData(String name,double val);
	public abstract double getDouble(String name);
	public abstract String getString(String name);
	public abstract void run();
}
