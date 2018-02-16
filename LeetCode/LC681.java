/*
class Solution {
    public String nextClosestTime(String time) {
        HashSet<Integer> set = new HashSet<Integer>();
        String result = "";
        // put 4 digits into a hashset
        for (char c: time.toCharArray()) {
            if (c != ':') {
                set.add(Character.getNumericValue(c));
            }
        }
        // calaulate current time
        int curr = Integer.parseInt(time.substring(0,2)) * 60;
        curr = curr + Integer.parseInt(time.substring(3,5));
        
        // for every minute, check if it is available
        while(true) {
            curr++;
            if (curr == 24 * 60) curr = 0;
            int hr_1 = (curr / 60) / 10;
            int hr_2 = (curr / 60) % 10;
            int min_1 = (curr % 60) / 10;
            int min_2 = (curr % 60) % 10;
            if (set.contains(hr_1) && set.contains(hr_2)
                && set.contains(min_1) && set.contains(min_2)) {
                result = Integer.toString(hr_1) + Integer.toString(hr_2)
                     + ":" + Integer.toString(min_1) + Integer.toString(min_2);
                break;
            }
        }
        return result;       
    }
}
*/
class Solution {
    public String nextClosestTime(String time) {
        int[] curr = new int[4];
        int index = 0;
        String result = "";
        // Generate an array to store current time
        for (int i = 0; i < 5; i++) {
            if (time.charAt(i) == ':') {
                i++;
            }
            curr[index] = time.charAt(i) - '0';
            index++;
        }
        
        // Find a next great time and check if it is valid
        curr =  findNextTime(curr);
        while(!isValidTime(curr)) {
            curr = findNextTime(curr);
        }
        result = Integer.toString(curr[0]) + Integer.toString(curr[1])
             + ":" + Integer.toString(curr[2]) + Integer.toString(curr[3]);
        return result;
    }
    
    public int[] findNextTime(int[] arr) {
        int index = 3;
        while(index > 0 && arr[index] <= arr[index-1]) {
            index--;
        }
        if (index == 0) {
            Arrays.sort(arr);
            return arr;
        }
        int max = arr[index];
        int maxIndex = index;
        for (int i = index; i < 4; i++){
            if (arr[i] < max && arr[i] > arr[index-1]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        int temp = arr[index-1];
        arr[index-1] = max;
        arr[maxIndex] = temp;
        Arrays.sort(arr, index, 4);
        return arr;
    }
    
    public boolean isValidTime(int[] curr) {
        int hr = curr[0]*10 + curr[1];
        int min = curr[2]*10 + curr[3];
        if (hr < 24 && min < 60) {
            return true;
        }
        return false;
    }
}
