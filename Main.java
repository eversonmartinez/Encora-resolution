import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final int quartersValue = 25;
    public static final int dimesValue = 10;
    public static final int nickelsValue = 5;
    public static final int penniesValues = 1;

    public static ArrayList<Integer> verifyQuarterPossibilities(Integer number){
        ArrayList<Integer> quarters = new ArrayList<>();
        int countQuarter = 0;

        while(countQuarter*quartersValue <= number ){
            quarters.add(countQuarter);
            countQuarter++;
        }

        return quarters;
    }

    public static ArrayList<Integer> verifyDimesPossibilities(Integer number){
        ArrayList<Integer> dimes = new ArrayList<>();

        int countDime = 0;

        while(countDime*dimesValue <= number ){
            dimes.add(countDime);
            countDime++;
        }

        return dimes;
    }

    public static ArrayList<Integer> verifyNickelsPossibilities(Integer number){
        ArrayList<Integer> nickels = new ArrayList<>();

        int countNickel = 0;

        while(countNickel*nickelsValue <= number ){
            nickels.add(countNickel);
            countNickel++;
        }

        return nickels;
    }

    public static ArrayList<Integer> verifyPenniesPossibilities(Integer number){
        ArrayList<Integer> pennies = new ArrayList<>();

        int countPennie = 0;

        while(countPennie*penniesValues <= number ){
            pennies.add(countPennie);
            countPennie++;
        }

        return pennies;
    }

    public static Set<int[]> createGroups(Integer number, ArrayList<Integer> quarterPossibilities, ArrayList<Integer> dimesPossibilities, ArrayList<Integer> nickelsPossibilities, ArrayList<Integer> penniesPossibilities){
        Set<int[]> result = new HashSet<>();
        for (Integer quarter: quarterPossibilities){
            for(Integer dime: dimesPossibilities){
                for(Integer nickel: nickelsPossibilities){
                    for(Integer penny: penniesPossibilities){
                        if ((quarter*quartersValue + dime*dimesValue + nickel*nickelsValue + penny*penniesValues) == number){
                            int[] array = {quarter, dime, nickel, penny};
                            result.add(array);
                        }
                    }
                }
            }
        }

        return result;
    }



    public static Set<int[]> makeChange(Integer number){
        ArrayList<Integer> quarters= verifyQuarterPossibilities(number);
        ArrayList<Integer> dimes= verifyDimesPossibilities(number);
        ArrayList<Integer> nickels= verifyNickelsPossibilities(number);
        ArrayList<Integer> pennies= verifyPenniesPossibilities(number);
        return createGroups(number, quarters, dimes, nickels, pennies);
    }

    public static void printSet(Set<int[]> conjunto){
        for (int[] arr : conjunto) {
            System.out.print("[ ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter with the number of cents you want to verify: ");
        Integer number = Integer.valueOf(sc.nextInt());

        Set<int[]> coins = makeChange(number);
        printSet(coins);

    }

}
