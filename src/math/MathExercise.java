package math;


import java.util.Random;

public class MathExercise {

    public static Random stream;
    public static final double PI = 3.1415927;
    public static double MeanInterArrivalTime;
    public static double MeanServiceTime;
    public static double SaveNormal;
    public static int NumNormals = 0;
    public static double SIGMA;

    public static double exponential(Random rng, double mean) {
        return -mean * Math.log( rng.nextDouble() );
    }

    public static double normal(Random rng, double mean, double sigma) {
        double ReturnNormal; // should we generate two normals?
        if(NumNormals == 0 ) {
            double r1 = rng.nextDouble();
            double r2 = rng.nextDouble();
            ReturnNormal = Math.sqrt( -2 * Math.log(r1))*Math.cos(2 * PI * r2);

            SaveNormal = Math.sqrt(-2 * Math.log(r1)) * Math.sin(2 * PI * r2);
            NumNormals = 1;
        } else
        {
            NumNormals = 0;
            ReturnNormal = SaveNormal;
        }

        return ReturnNormal * sigma + mean ;

    }

    public static void main(String argv[]){

        MeanInterArrivalTime = 4.5;
        MeanServiceTime = 3.2;
        long seed = Long.parseLong(argv[0]);
        stream = new Random(seed);
        SIGMA = 0.6;
        System.out.println("Exponential distribution: " + exponential( stream, MeanInterArrivalTime));
        System.out.println("Normal distribution: " + normal( stream, MeanServiceTime, SIGMA));

    }
}
