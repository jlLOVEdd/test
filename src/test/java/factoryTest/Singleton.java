package factoryTest;

public class Singleton {
	private static Singleton instance = null;
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
}
