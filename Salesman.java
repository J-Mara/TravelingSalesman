import java.util.*;

public class Salesman {
    public static void main(String[] args) {
      
      Scanner data = new Scanner(System.in);
      int[][] table = genTable(data);
      System.out.println(Arrays.deepToString(table));
      System.out.println("By row");
      for (int[] n : table) {
        System.out.println(Arrays.toString(n));
      }
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
}
