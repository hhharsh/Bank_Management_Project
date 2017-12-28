package bank;

public class Notes {
	
	
	
	
	
	
	
	
	
	
	
	/*
	 
	 
	 isAlive()
	 
	 it is a method define by Thread and utilise to get know weather a thread is still running or not.
	 it gives us boolean as a  result true if running false if suspended.
	 
	 join()
	 
	 this method waits until the thread on which it is applied terminates.
	 generally it applies on two or more threads upon which we want to terminate together and waits till then.
	 
	 final void join()throws Entrupted Exception.
	 
	 */
	
	
	/*
	 class New Thread implements Runnable{
	 String name;
	 thread t;
	 
	 
	 NewThread(String ThreadName)
	 {
	 
	 name=threadname;
	 t=new Thread(this,name);
	 sop("new thread"+t);
	 t.start();
	 }
	 
	 
	 
	 
	 
	 public void run(){
	 try
	 {
	 for(int i=5;i>0;i-)
	 {
	 sop("name
	 
	 thread.sleep(1000);
	 }
	 }
	 catch(intrupted ex){
	 sop("name+"intrupted");
	 }
	 sop("name+"exiting");
	 }
	 }
	 
	 
	 class mainclass{
	 psvm{
	 NewThread ob1=new NewThread("one")
	  NewThread ob2=new NewThread("two")
	   NewThread ob3=new NewThread("three")
	    NewThread ob4=new NewThread("four")
	     NewThread ob5=new NewThread("five")
	 
	 sop("thread one is alive:"=+ob1.t.isAlive());
	  sop("thread one is alive:"=+ob1.t.isAlive());
	   sop("thread one is alive:"=+ob1.t.isAlive());
	    sop("thread one is alive:"=+ob1.t.isAlive());
	     sop("thread one is alive:"=+ob1.t.isAlive());
	 
	 
	 try{
	 sop("waiting for thread to finish");
	 ob1.t.join();
	  ob2.t.join();
	   ob3.t.join();
	    ob4.t.join();
	     ob5.t.join();
	     }
	     catch{
	     
	     sop("main thread entrupted");
	     
	     }
	     
	     sop("thread one is alive":+ob1.t.isAlive());
	     sop("thread one is alive":+ob1.t.isAlive());
	     sop("thread one is alive":+ob1.t.isAlive());
	     sop("thread one is alive":+ob1.t.isAlive());
	     sop("thread one is alive":+ob1.t.isAlive());
	     sop("main thread exiting");
	     
	     
	     
	     synchronized:
	     
	     
	     
	     class Callme{
	     synchronized printingstring(String mag){
	     sop("{"+mag);
	     try
	     {
	     Thread.sleep(1000);
	     }
	     catch(){
	     sop("interrupted");
	     }
	     sop("}");
	     }
	     }
	     
	     class Caller implements Runnable{
	     
	     String mag;
	     Callme target;
	     Thread t;
	     
	     public Caller(Callme targ,String s){
	     
	     target=targ;
	     mag=s;
	     t=new Thread(this);
	     t.start();
	     
	     }
	     
	     pubic void run(){
	     target.printingstring(mag);
	     }
	     }
	     
	     public class test{
	     psvm(){
	     Callme Target=new Callme();
	     Caller ob1=new Caller(target,"hello");
	     Caller ob2=new Caller(target,"synchronised");
	     Caller ob3=new Caller(target,"world");
	     
	     
	     try{
	     
	     ob1.t.join();
	     ob2.t.join();
	     ob3.t.join();
	     }
	     catch()
	     {
	     sop("interrupted"):
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	 
	 
	 
	 
	 
	 
	 
	 
	 }
	 
	 
	 }
*/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  
	 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
