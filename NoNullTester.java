import java.util.Random;
import java.util.ArrayList;


public class NoNullTester {

  public static void main(String[] args) {
    testCreation();
    testAdd();
  }

  public static void testCreation() {
    boolean[] res = new boolean[3];

    NoNullArrayList<Integer> one = new NoNullArrayList<Integer>();
    res[0] = (one.toString().equals("[]"));

    int[] oneData = {1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1};
    one = initIntArray(oneData);
    res[1] = (one.toString().equals(
        "[1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1]"
      )
    );

    String[] twoData = {"hi", "hello", " howdy", "Hola!", "100"};
    NoNullArrayList<String> two = initStringArray(twoData);
    res[2] = (two.toString().equals(
      "[hi, hello,  howdy, Hola!, 100]"
    ));

    printResults(res, "Test constructors");
  }

  public static void testAdd() {
    boolean[] res = new boolean[3];

    int[] oneData = {-2, 3, -1, 1000};
    ArrayList<Integer> one = initIntArray(oneData);

    try {
      one.add(-4545);
      res[0] = true;
    } catch (IllegalArgumentException e) {
      res[0] = false;
    }

    try {
      one.add(null);
      res[1] = false;
    } catch (IllegalArgumentException e) {
      res[1] = true;
    }

    res[2] = true;
    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int test = rng.nextInt();

      NoNullArrayList<Integer> testArr = new NoNullArrayList<Integer>();
      try {
        testArr.add(test);
      } catch (IllegalArgumentException e) {
        res[2] = false;
        break;
      }
    }

    printResults(res, "Test add");
  }

  private static NoNullArrayList<String> initStringArray(String[] data) {
    NoNullArrayList<String> stuff = new NoNullArrayList<String>(data.length);
    for (int i = 0; i < data.length; i++) {
      stuff.add(data[i]);
    }
    return stuff;
  }

  private static NoNullArrayList<Integer> initIntArray(int[] data) {
    NoNullArrayList<Integer> stuff = new NoNullArrayList<Integer>(data.length);
    for (int i = 0; i < data.length; i++) {
      stuff.add(data[i]);
    }
    return stuff;
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }

}
