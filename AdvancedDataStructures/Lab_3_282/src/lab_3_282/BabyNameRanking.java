package lab_3_282;
import java.io.*;
import java.util.*;

/**
 *
 * @author Tanner Good
 */
public class BabyNameRanking {
    @SuppressWarnings("unchecked")
    private static Map<String, Integer>[] boys = new HashMap[10];
    @SuppressWarnings("unchecked")
    private static Map<String, Integer>[] girls = new HashMap[10];
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;
        try {
            readNames();
        }
        catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        do {
            System.out.print("Enter a year (2008-2017): ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Boy or Girl: ");
            String sex = input.nextLine().toLowerCase();
            System.out.print("Enter Name: ");
            String name = input.nextLine();
            switch (sex) {
                case ("boy"):
                    if (boys[year - 2008].get(name) == null) {
                        System.out.println(name + " is not within the top 1000 most common names.");
                        break;
                    }
                    System.out.println(Character.toUpperCase(sex.charAt(0)) + sex.substring(1) + " name " + Character.toUpperCase(name.charAt(0)) + name.substring(1) + " is ranked #" + boys[year - 2008].get(name.toLowerCase()) + " in " + year);
                    break;
                case ("girl"):
                    if (girls[year - 2008].get(name) == null) {
                        System.out.println(name + " is not within the top 1000 most common names.");
                        break;
                    }
                    System.out.println(Character.toUpperCase(sex.charAt(0)) + sex.substring(1) + " name " + Character.toUpperCase(name.charAt(0)) + name.substring(1) + " is ranked #" + girls[year - 2008].get(name.toLowerCase()) + " in " + year);
                    break;
                default:
                    System.out.println("Bad input!");
            }
            
            System.out.print("Do you want to check another name (Yes or No): ");
            answer = input.nextLine().toLowerCase();
        } while (answer.equals("yes"));
    }
    
    public static void readNames() throws IOException {
        File infile;
        for (int i = 0; i < 10; i++) {
            boys[i] = new HashMap<>();
            girls[i] = new HashMap<>();
        }
        for (int i = 0; i <= 9; i++) {
            String filename = "babynameranking" + (2008 + i) + ".txt";
            infile = new File(filename);
            
            int rank;
            Scanner in = new Scanner(infile);
            while (in.hasNext()) {
                rank = in.nextInt();
                boys[i].put(in.next().toLowerCase(), rank);
                in.next();
                girls[i].put(in.next().toLowerCase(), rank);
                in.nextLine();
            }
            in.close();
        }
    }
}
