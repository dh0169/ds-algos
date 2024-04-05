import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        File mergeList = new File("unsorted_list1.txt");

        //Read file
        ArrayList<Integer> intList =  readIntegersFromFile(mergeList);

        //Before Sort
        System.out.println("List before Merge Sort");
        System.out.println(intList);

        //After Sort
        mergeSort(intList);
        System.out.println("List after Merge Sort");
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

    public static void mergeSort(ArrayList<Integer> list){

        //Sorted
        if(list.size() <= 1)
            return;

        mergeSortRecursive(list,0, list.size()-1);
    }

    private static void mergeSortRecursive(ArrayList<Integer> list, int lo, int hi){
        int mid;
        if(lo < hi) {
            mid = (hi + lo) / 2;
            mergeSortRecursive(list, lo, mid);
            mergeSortRecursive(list,mid + 1, hi);

            merge(list, lo, mid, hi);
        }

    }

    private static void merge(ArrayList<Integer> list, int lo, int mid, int hi){
        int left = lo, right = mid+1, tmpIdx = 0;
        int[] tmpA = new int[hi-lo+1];

        while(left <= mid && right <= hi){
            if(list.get(left) <= list.get(right)){
                tmpA[tmpIdx++] = list.get(left++);
            }else {
                tmpA[tmpIdx++] = list.get(right++);
            }

        }

        while(left <= mid && tmpIdx < tmpA.length){ tmpA[tmpIdx++] = list.get(left++); }
        while(right <= hi && tmpIdx < tmpA.length){ tmpA[tmpIdx++] = list.get(right++); }

        for (int i = 0; i < tmpA.length; i++){
            list.set(lo+i,tmpA[i]);
        }
    }


}
