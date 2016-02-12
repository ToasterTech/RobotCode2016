package subsystem;

public interface Layer <Child extends Layer<?>> extends BaseLayer{
	public void setChild(Child c);
}
