import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        String strIn = new Scanner(System.in).nextLine();
        List<String> array = Arrays.asList(strIn.split(""));
        int i = 0;
        while (true){
            if (array.contains("[")) {
                if (!array.get(i).equals("[") && !array.get(i).matches("[a-zA-Z]")) {
                    int n = Integer.parseInt(array.get(i));
                    int s = 0;
                    int d = 0;
                    for (int k = i + 2; k < array.size(); k++) {
                        if (array.get(k).equals("["))
                            s++;
                        else if (array.get(k).equals("]")) {
                            if (s == 0) {
                                d = k;
                                break;
                            } else {
                                s--;
                            }
                        }
                    }
                    ArrayList<String> newArray = new ArrayList();
                    for (int p = 0; p < n; p++)
                        for (int j = i + 2; j < d; j++)
                            newArray.add(array.get(j));
                    for (int j = d + 1; j < array.size(); j++)
                        newArray.add(array.get(j));
                    List<String> subList = array.subList(0, i);
                    if (subList.size() == 0) {
                        array = newArray;
                        i = 0;
                    }
                    else {
                        subList.addAll(newArray);
                        array = subList;
                        i = 0;
                    }
                }
                else
                    i ++;
            }
            else
                break;
        }
        String lastString = String.join("", array);
        System.out.println(lastString);
    }
}