package subsystem;

public class Subsystem {
	private BaseLayer hardwareLayer;
	private Layer<?> systemLayer;
	private Layer<?> commandLayer;
	public Subsystem(BaseLayer hardwareLayer,Layer<?> systemLayer, Layer<?> commandLayer){
		this.hardwareLayer=hardwareLayer;
		this.systemLayer=systemLayer;
		this.commandLayer=commandLayer;
	}
	public void runPeriodic(){
		this.commandLayer.runPeriodic();
		this.systemLayer.runPeriodic();
		this.hardwareLayer.runPeriodic();
	}
}
