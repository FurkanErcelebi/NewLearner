package ThreadAndProcess;

public class RunTimeExample2 {

    public static void main(String[] args) {
        
        Runtime jvm = Runtime.getRuntime();

        System.out.println("Free memory in JVM: " + jvm.freeMemory());
        System.out.println("Maximum memory in JVM: " + jvm.maxMemory());
        System.out.println("Total memory in JVM: " + jvm.totalMemory());
        System.out.println("Number of available processors: " + jvm.availableProcessors());

        Runtime.getRuntime().runFinalization();

        String[] cmd = new String[2];
        cmd[0] = "notepad";
        cmd[1] = "src\\ThreadAndProcess\\RunTimeExample1.java";

        try {
            Process process = Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        System.out.println("RunTimeExample1.java file is opening...");

        Runtime.getRuntime().halt(0);

    }

}
