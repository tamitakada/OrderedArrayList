import java.util.Random;
import java.util.ArrayList;


public class OrderedTester {

  public static void main(String[] args) {
    testCreation();
  }

  public static void testCreation() {
    boolean[] res = new boolean[4];

    NoNullArrayList<Integer> one = new OrderedArrayList<Integer>();
    res[0] = (one.toString().equals("[]"));

    int[] oneData = {1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1};
    one = initInt(oneData);
    res[1] = (one.toString().equals(
        "[1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1]"
      )
    );

    String[] twoData = {"hi", "hello", " howdy", "Hola!", "100"};
    OrderedArrayList<String> two = initStr(twoData);
    res[2] = (two.toString().equals(
      "[hi, hello,  howdy, Hola!, 100]"
    ));

    String[] threeData = {"Helloo"};
    ArrayList<String> three = initStr(threeData);
    res[3] = (three.toString().equals(
      "[Helloo]"
    ));

    Utils.printResults(res, "Test constructors");
  }

  private static OrderedArrayList initInt(int[] data) {
    OrderedArrayList<Integer> stuff = new OrderedArrayList<Integer>(data.length);
    for (int i = 0; i < data.length; i++) {
      try {
        stuff.add(data[i]);
      } catch (IllegalArgumentException e) {
        System.out.println(":(((((((((((((((((((((((((((((((((((((((");
      }
    }
    return stuff;
  }

  private static OrderedArrayList initStr(String[] data) {
    OrderedArrayList<String> stuff = new OrderedArrayList<String>(data.length);
    for (int i = 0; i < data.length; i++) {
      try {
        stuff.add(data[i]);
      } catch (IllegalArgumentException e) {
        System.out.println(":(((((((((((((((((((((((((((((((((((((((");
      }
    }
    return stuff;
  }

}
