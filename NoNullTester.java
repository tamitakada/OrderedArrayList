public class NoNullTester {

  public static void main(String[] args) {
    testCreation();
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
