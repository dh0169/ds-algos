import java.io.*;
import java.util.ArrayList;

public class BubbleSort {
    public static void main(String[] args) {

        //Read Integers from file
        File bubblePath = new File("unsorted_list1.txt");
        ArrayList<Integer> bubbleList = readIntegersFromFile(bubblePath);
        System.out.println("List before bubble sort: " + bubbleList);
        System.out.println();

        //Begin Sorting bubbleList and selectionList
        bubbleSort(bubbleList);
        System.out.println("List after bubble sort: " + bubbleList);
    }
    public static ArrayList<Integer> readIntegersFromFile(File intFile) {
        if (intFile == null)
            return null;

        ArrayList<Integer> intList = new ArrayList<Integer>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(intFile));
            String currentLine = br.readLine();
            while (currentLine != null) {
                Integer curInt = new Integer(Integer.valueOf(currentLine));
                intList.add(curInt);
                currentLine = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found at ");
        } catch (NumberFormatException e) {
            System.out.println("Error, value is not an integer.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intList;
    }


    public static void bubbleSort(ArrayList<Integer> list) {
        //Perform bubble Sort
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
