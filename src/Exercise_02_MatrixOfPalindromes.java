import javax.print.DocFlavor;
import java.util.Scanner;

public class Exercise_02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" "); //razdvajamo dimenzije po space-u
        String[][] matrix = new String[Integer.parseInt(input[0])][Integer.parseInt(input[1])]; //upisujemo dimenzije i inicijalizujemo matricu
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //pravimo niz alfabeta iz kojeg cemo uzimati vrednosti kasnije

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                StringBuilder word = new StringBuilder();
                word.append(alphabet[i]); //i = 0, slovo a
                word.append(alphabet[j+i]); //0+0 -> slovo a, 0+1 -> slobo b, 0 + 2 -> slovo c
                word.append(alphabet[i]); //i = 0, slovo a
                matrix[i][j] = word.toString();
            }
        }
        for(String[] strs : matrix){ //prolazimo kroz nizove u matrici
            for(String str : strs){ //prolazimo kroz konkretne elemente thi nizova
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
