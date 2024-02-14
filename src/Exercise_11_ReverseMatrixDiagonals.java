import java.util.Arrays;
import java.util.Scanner;

public class Exercise_11_ReverseMatrixDiagonals {
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimensions[0], col = dimensions[1];

        matrix = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        row--;
        col--;

        while(row != -1){ // poslednji red ce biti 0. red
            int r = row, c = col; //pocetne pozicije, poslednji element u nizu
            while(!outOfBounds(r,c)){ //proveravamo da li su u matrici, da ne odu van
                System.out.print(matrix[r--][c++] + " "); //smanjujemo red, a povecavamo kolonu
            } // iz pozicije 2,2 idemo u poziciju 1(2--),3(2++)
            System.out.println(); //idemo u sledeci red
            col--;//smajunjemo kolonu
            if(col < 0){//ako smo dosli do kraja kolona, ali ne i redova
                col = 0; //resetujemo kolonu
                row--; //smanjujemo red
            }
        }

    }

    private static boolean outOfBounds(int r, int c) {
        return r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length;
    }
}
