package test;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(Thread.currentThread().getName());
			      for(int i=0; i<10; i++){
			         new Thread("" + i){
			            public void run(){
			             System.out.println("Thread: " + getName() + "running");
			            }
			         }.start();
			      }*/
		NotThreadSafe sharedInstance = new NotThreadSafe();
			 
			new Thread(new MyRunnable(sharedInstance)).start();
			new Thread(new MyRunnable(sharedInstance)).start();
			  System.err.println(sharedInstance);
			
	}

}
 class  NotThreadSafe{
	    StringBuffer builder = new StringBuffer();
	     
	    public  void  add(String text){
	        this.builder.append(text);
	    }  
	}
 class MyRunnable implements Runnable{
	  NotThreadSafe instance = null;
	   
	  public MyRunnable(NotThreadSafe instance){
	    this.instance = instance;
	  }
	 
	  public void run(){
	    this.instance.add("some text");
	    System.err.println(this.instance.builder);
	  }
	}