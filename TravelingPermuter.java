import java.util.*;
public class TravelingPermuter{
  public static int[] permute(int[] cities) {
  List<Integer> list = new ArrayList<>();
  for (int i : cities) {
    list.add(i);
  }
  Collections.shuffle(list);
  for (int i = 0; i < list.size(); i++) {
    cities[i] = list.get(i);
  }
  return cities;
}
  public static void main(String[] args) {
    int[] test1 = {0, 1, 2};
    for(int i = 0; i < 6; i++){
      System.out.println(Arrays.toString(permute(test1)));
    }
  }
}
