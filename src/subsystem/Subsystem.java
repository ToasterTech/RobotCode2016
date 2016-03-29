package subsystem;

public class Subsystem<H extends BaseLayer,S extends Layer<H>,C extends Layer<S>> {
	private H hardwareLayer;
	private S systemLayer;
	private C commandLayer;
	public Subsystem(H hardwareLayer,S systemLayer, C commandLayer){
		this.hardwareLayer=hardwareLayer;
		this.systemLayer=systemLayer;
		this.commandLayer=commandLayer;
		this.systemLayer.setChild(this.hardwareLayer);
		this.commandLayer.setChild(this.systemLayer);

	}
	public void runPeriodic(){
		this.commandLayer.runPeriodic();
		this.systemLayer.runPeriodic();
		this.hardwareLayer.runPeriodic();
	}
	public void setCommandLayer(C c){
		commandLayer=c;
		this.commandLayer.setChild(this.systemLayer);
		this.commandLayer.robotInit();
	}
	public void robotInit(){
		commandLayer.robotInit();
		systemLayer.robotInit();
		hardwareLayer.robotInit();
	}
}
