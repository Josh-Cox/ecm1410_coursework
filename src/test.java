
import java.time.LocalTime;

public class test {

    public static LocalTime[] sortArray(LocalTime[] arr) {
		
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            LocalTime key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

		return arr;
	}
    

    public static void main(String[] args) {
        LocalTime[] testArray = new LocalTime[5];

        testArray [0] = LocalTime.of(0, 1, 0);
        testArray [1] = LocalTime.of(5, 7, 4);
        testArray [2] = LocalTime.of(2, 3, 3);
        testArray [3] = LocalTime.of(6, 0, 0);
        testArray [4] = LocalTime.of(0, 0, 7);

        LocalTime []newArray = sortArray(testArray);

        System.out.println(newArray[3]);
    }
}

