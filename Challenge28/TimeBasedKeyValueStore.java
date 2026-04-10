/* Challenge description: Implement a time-based key-value data structure that supports:

Storing multiple values for the same key at specified time stamps
Retrieving the key's value at a specified timestamp
Implement the TimeMap class:

TimeMap() Initializes the object.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns the most recent value of key if set was previously called on it and the most recent timestamp for that key prev_timestamp is less than or equal to the given timestamp (prev_timestamp <= timestamp). If there are no values, it returns "".
Note: For all calls to set, the timestamps are in strictly increasing order.

*/

class TimeMap {

    class Pair { // Auxiliary class to use in the HashMap, store the values in a existent key
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> map; // HashMap with the key and list of auxiliary class

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(map.containsKey(key)){ // If the map already contains the key
            List<Pair> list = map.get(key);            
            list.add(new Pair(timestamp, value)); // Add the pair in the map
        }
        else{ // If the key is a new value, create a new list and put in the map
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        String lastValue = "";

        if (!map.containsKey(key)) { // If the map doesn't contains the key, return null
            return "";
        }
        else{
            List<Pair> list = map.get(key);
            int left = 0; 
            int right = list.size() - 1; 

            while(left <= right){ // Binary search
                int mid = left + (right - left)/2;

                if(list.get(mid).timestamp > timestamp){
                    right = mid - 1; 
                }
                else if(list.get(mid).timestamp < timestamp){
                    left = mid + 1;
                    lastValue = list.get(mid).value; // If already exists an other value for this key, store until find the mid value
                }
                else{
                    return list.get(mid).value;
                }
            }
            return lastValue; // if the mid value was empty, return the last value found
        }

    }
}
