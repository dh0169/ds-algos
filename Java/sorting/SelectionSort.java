import java.util.ArrayList;
import java.io.*;

public class SelectionSort {
    public static void main(String[] args) {

        //Read Integers from file
        File selectionPath = new File("unsorted_list1.txt");
        ArrayList<Integer> selectionList = readIntegersFromFile(selectionPath);


        //Before Sort
        System.out.println("List before selection sort: " + selectionList);
        System.out.println();

        //Perform selection sort
        selectionSort(selectionList);

        //After sort;
        System.out.println("List after selection sort: " + selectionList);
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
            System.out.println("File not found. File must be in project root.");
        } catch (NumberFormatException e) {
            System.out.println("Error, value is not an integer.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intList;
    }

    public static void selectionSort(ArrayList<Integer> list) {
        //Perform Selection Sort
        int minIndex;
        for (int i = 0; i < list.size(); i++) {
            minIndex = i;
            for (int j = minIndex + 1; j < list.size(); j++) {
                if (list.get(minIndex) > list.get(j)) {
                    //swap
                    minIndex = j;
                }
            }

            Integer tmp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, tmp);
        }
    }
}
