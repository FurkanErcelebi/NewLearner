package ThreadAndProcess;

/**
 * RunTimeExample
 */
public class RunTimeExample1 {

    /**
     * InnerRunTimeExample
     */
    static class InnerRunTimeExample extends Thread{
    
        public void run() {
            System.out.println("Program running");
        }
        
    }

    public static void main(String[] args) {

        Runtime jvm = Runtime.getRuntime();

        System.out.println("Free memory in JVM: " + jvm.freeMemory());
        System.out.println("Maximum memory in JVM: " + jvm.maxMemory());
        System.out.println("Total memory in JVM: " + jvm.totalMemory());
        System.out.println("Number of available processors: " + jvm.availableProcessors());

        //Runtime.getRuntime().traceInstructions(true);
        //Runtime.getRuntime().traceMethodCalls(true);

        try {

            Process process = Runtime.getRuntime().exec("cmd /c dir");
            System.out.println("List files in this directory");

            InnerRunTimeExample iExample = new InnerRunTimeExample();
            Runtime.getRuntime().addShutdownHook(iExample);

            System.out.println("Waiting for 5 seconds...");
            Thread.sleep(5000);

            Runtime.getRuntime().removeShutdownHook(iExample);

            Runtime.getRuntime().gc();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Runtime.getRuntime().traceInstructions(false);

        Runtime.getRuntime().exit(0);

        System.out.println("Program exiting...");

    }
}