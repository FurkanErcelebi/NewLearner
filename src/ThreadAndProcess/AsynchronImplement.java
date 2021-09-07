package ThreadAndProcess;

interface TestInteface {

    void testInterfaceImpl();

}

class SubClassofAsynchronImpl implements TestInteface{

    @Override
    public void testInterfaceImpl() {
        
        System.out.println("Implemetation of test interface");

    }

}

class AsynchronImplement /* implements Runnable */ /* extends Thread */{

    private TestInteface testInteface;

    public void setSubClassofAsynchronImpl(TestInteface testInteface){
        this.testInteface = testInteface;
    }

    public void runTheProcess(){
           
        new Thread(new Runnable(){

            public void run(){
                
                System.out.println("Thread is running...");

                if(testInteface != null){

                    testInteface.testInterfaceImpl();

                }
                System.out.printf("Sequance...");
                for(int i = 0;i < 5;i++){
                    System.out.printf(String.valueOf(i));
                    if(i == 4)  
                        System.out.print("\n");
                }

            }

        }).start();
    
    }

    public static void preInitialize(){

        AsynchronImplement asynchronImplement = new AsynchronImplement();
        TestInteface tInteface = new SubClassofAsynchronImpl();
        asynchronImplement.runTheProcess();
        asynchronImplement.setSubClassofAsynchronImpl(tInteface);

    }

    public static void postInitialize(){

        AsynchronImplement asynchronImplement = new AsynchronImplement();
        TestInteface tInteface = new SubClassofAsynchronImpl();
        asynchronImplement.setSubClassofAsynchronImpl(tInteface);
        asynchronImplement.runTheProcess();
        
    }

    public static void main(String[] args) {
        
        //This is preInitialize...
        preInitialize();

        //This is postInitialize...
        postInitialize();
        //thread.start();
        //asynchronImplement.start();

    }

}