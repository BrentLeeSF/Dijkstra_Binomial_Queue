package project4;


public class HashEntry {

	
    private String key;
    private int value;

    HashEntry(String key, int value) {
    	
          this.key = key;
          this.value = value;
          
    }     

    public String getKey() {
          return key;
    }

    public int getValue() {
          return value;
    }
}