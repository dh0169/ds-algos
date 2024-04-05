import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class QuickSort {

    public static void main(String[] args) {
        File mergeList = new File("unsorted_list1.txt");

        //Read file
        ArrayList<Integer> intList =  readIntegersFromFile(mergeList);

        //Before Sort
        System.out.println("List before Quick Sort");
        System.out.println(intList);

        //After Sort
        quickSort(intList);
        System.out.println("List after Quick Sort");
        System.out.println(intList);

    }

    public static ArrayList<Integer> readIntegersFromFile(File intFile) {
        if (intFile == null)
            return null;

        ArrayList<Integer> intList = new ArrayList<Integer>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(intFile));
            String currentLine = br.readLine();
            while (currentLine != null) {
                Integer curInt = Integer.valueOf(currentLine);
                intList.add(curInt);
                currentLine = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found in project root.");
        } catch (NumberFormatException e) {
            System.out.println("Error, value is not an integer.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intList;
    }

    public static void quickSort(ArrayList<Integer> list){
        //Sorted
        if(list.size() <= 1)
            return;

        quickSortRecursive(list, 0, list.size()-1);
    }

    private static int partition(ArrayList<Integer> list, int lo, int hi){
        int pivot = list.get(lo);
        int m = lo;
        for(int i = lo+1; i <= hi; i++){
            if(list.get(i) < pivot){
                m++;
                swap(list, i, m);
            }
        }
        //Array should look like
        // [pivot,    S1    ,    S2    ]

        //S1 contains vals less than pivot
        //S2 contains vals greater than pivot


        swap(list, lo, m);
        return m;
    }

    private static void swap(ArrayList<Integer> list, int i, int j){
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static void quickSortRecursive(ArrayList<Integer> list, int lo, int hi){
        if(lo < hi){
            int p = partition(list, lo, hi); //partition
            quickSortRecursive(list, lo, p);
            quickSortRecursive(list, p+1, hi);
        }

    }
}
