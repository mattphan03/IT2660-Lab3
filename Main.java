public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Best-case scenario: Empty pattern (instant match at index 0)
    String bestCase = "A"; 
    long startTime = System.nanoTime();
    int index = match(text, bestCase);
    long endTime = System.nanoTime();
    long elapsedTime = endTime - startTime;
    
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");   
    
    System.out.println("Best-case elapsed time: " + elapsedTime + " nanoseconds");

    // Worst-case scenario: Pattern that does not exist in text
    String worstCase = "ZZZZ"; 
    startTime = System.nanoTime();
    index = match(text, worstCase);
    endTime = System.nanoTime();
    elapsedTime = endTime - startTime;
    
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");  
    
    System.out.println("Worst-case elapsed time: " + elapsedTime + " nanoseconds");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }
    return -1;
  }
	
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
  }
}
