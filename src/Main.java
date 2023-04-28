import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your data separated with spaces(FIRSTNAME LASTNAME COMPANY DEPARTMENT)");
        Scanner dataRead = new Scanner(System.in); // create a scanner object(read input)
        String buffer = dataRead.nextLine();
        String[] data = buffer.split("\\s+"); // regex delimiter " "
        dataRead.close();
        EmailApplication myapp = new EmailApplication(data);
        myapp.setPassword("kasjf@1Jl");
        myapp.setAlternateEmail("test.test@dev.java.com");
        myapp.printInfo();
    }
}