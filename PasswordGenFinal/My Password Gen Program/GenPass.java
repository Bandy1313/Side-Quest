import java.util.Scanner;

public class GenPass {
    public static int passLength;
    public static boolean upperCase = false;
    public static boolean numbers = false;
    public static boolean uniqueCharacters = false;
    public static String userspassword = "";
    public static int numberOfPasswords;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PassRandom pr = new PassRandom();
        System.out.println();
        System.out.println("Welcome to Bandys PassWordGenerator!!!!");
        System.out.println("First we will need you to answer some questions");

        System.out.println("Enter Desired Password Length");
        while(!scan.hasNextInt()) {
            System.err.println("Your input must be an Integer, and less then 20");
            scan.next();
        }
        passLength = scan.nextInt();
        if(passLength > 20) {
            passLength = 20;
        }

        System.out.println("Would you like and upperCase(true/false)\n");
        while(!scan.hasNextBoolean()) {
            System.err.println("Your input must be an boolean\n");
            System.out.println("upperCase(true/false)?\n");
            scan.next();
        }
        upperCase = scan.nextBoolean();
        

        System.out.println("Would you like and Numbers(true/false)\n");
        while(!scan.hasNextBoolean()) {
            System.err.println("Your input must be an boolean\n");
            System.out.println("Numbers(true/false)?\n");
            scan.next();
        }
        numbers = scan.nextBoolean();

        System.out.println("would you like any uniqueCharacters(true/false)\n");
        while(!scan.hasNextBoolean()) {
            System.err.println("Your input must be an boolean\n");
            System.out.println("uniqueCharacters(true/false?)\n");
            scan.next();
        }
        uniqueCharacters = scan.nextBoolean();

        System.out.println("How Many Passwords would you like?");
        while(!scan.hasNextInt()) {
            System.err.println("Must Be an Integer.");
            scan.next();
        }
        numberOfPasswords = scan.nextInt();
        if(numberOfPasswords > 3) {
            numberOfPasswords = 3;
        }
        long start = System.nanoTime();
        for(int i = 1; i <= numberOfPasswords; i++) {
            Thread thread = new Thread(() -> {
                String password = pr.generatePassword(passLength, upperCase, uniqueCharacters, numbers, userspassword);
                System.out.println(password);
                System.out.println();
            });
            thread.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        long end = System.nanoTime();
        double timeInSeconds = (end - start) / 1000000000.0;
        System.out.println("program time = " + timeInSeconds + " seconds");
        
    }
}