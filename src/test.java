
import java.time.LocalTime;

public class test {

    public static int[] sortArray() {
		int[] main = {5, 3, 7, 8, 2};
        LocalTime[] arr = {LocalTime.of(0, 1, 0), LocalTime.of(5, 7, 4), LocalTime.of(2, 3, 3), LocalTime.of(6, 0, 0),
            LocalTime.of(0, 0, 7)};

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    LocalTime temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    int mainTemp = main[j];
                    main[j] = main[j + 1];
                    main[j + 1] = mainTemp;
                }
            }        
        }
        return main;
    }

    public static void main(String[] args) {
 

        int []newArray = sortArray();
         for (int i = 0; i < 5; i++) {
            System.out.println(newArray[i]);
         }

    }
}

