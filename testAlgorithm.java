import java.util.*;

public class testAlgorithm {
    public static void main(String[] args) {

      // Scanner data = new Scanner(System.in);
      // int[][] table = genTable(data);
      // System.out.println(Arrays.deepToString(table));
      // System.out.println("By row");
      // for (int[] n : table) {
      //   System.out.println(Arrays.toString(n));
      // }

      //Algorithm testing

      System.out.println(fact(5));

      ArrayList<String> cities = new ArrayList<String>(4);
      cities.add("0"); cities.add("1"); cities.add("2"); cities.add("3");
      String[] path = numberToPath(16, cities);
      System.out.println(Arrays.toString(path));
    }

    public static int[][] genTable(Scanner data) {
      ArrayList<String> cities = new ArrayList<String>();
      int[][] tempTable = new int[2][10];
      int index = 0;
      int row = 0;
      while (data.hasNextLine()) {
        String newScan = data.nextLine();
        Scanner line = new Scanner(newScan);
        String city1 = line.next();
        if (!cities.contains(city1)) {
          cities.add(city1);
        }
        if (cities.contains(city1)) {
          line.next();
          String city2 = line.next();
          line.next();
          int num = line.nextInt();
          if (!cities.contains(city2)) {
            cities.add(city2);
            tempTable[row][index] = num;
            index++;
          } else {
            row++;
            tempTable[row][0] = num;
            break;
          }
        }
      }
      System.out.println(cities.toString());

      int l = cities.size();

      int[][] table = new int[l][l];
      for (int i = 0; i<table[0].length-1; i++) {
        table[0][i+1] = tempTable[0][i];
      }
      table[1][2] = tempTable[1][0];
      while (data.hasNextLine()) {
        String lineStr = data.nextLine();
        Scanner line = new Scanner(lineStr);
        String startCity = line.next();
        line.next();
        String endCity = line.next();
        line.next();
        int num = line.nextInt();
        int startIndex = cities.indexOf(startCity);
        int endIndex = cities.indexOf(endCity);
        //System.out.print(startCity + ", " + endCity + ", ");

        //System.out.println(startIndex + ", " + endIndex);
        table[startIndex][endIndex] = num;
      }
      return table;
    }

    public static int fact(int n) {
      int product = 1;
      while (n!= 1) {
        product *= n;
        n--;
      }
      return product;
    }

    /*gives the path for the nth permutation in array form 
    i.e. if there are 5 cities (0,1,2,3,4) then the 
    1st permutation is [0,1,2,3,4];
    2nd permutation is [0,1,2,4,3];
    and the last is [4,3,2,1,0];
    basically if you were to treat the permutations as just simply numbers
    (i.e. 01234, 01243, 43210, etc.), then permutations are listed in ascending order
    */

    public static String[] numberToPath(int number, ArrayList<String> cities) {
      int numberOfCities = cities.size();

      String[] path = new String[numberOfCities];

      int base = fact(numberOfCities-1);
      int factorialBase = numberOfCities-1;

      for (int i = 0; i < numberOfCities; i++) {
        int quotient = number / base;
        int remainder = number % base;

        path[i] = cities.remove(quotient);

        number = remainder;

        if (base > 1) {
          base /= factorialBase;
          factorialBase--;
        }
      }
      return path;
    }
}