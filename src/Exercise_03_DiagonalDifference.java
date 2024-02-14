import java.util.Scanner;

public class Exercise_03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n]; //inicijalizacija matrice
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" "); //ucitavamo red po red (stringova)
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]); //pretvaramo elemente u int i stavljamo ih u matricu
            }
        }
        int mainDiag = 0; //inicijalizujemo zbir za glavnu dijagonalu
        int secDiag = 0; //inicijalizujemo zbir za sporednu (secondary) dijagonalu
        for (int i = 0; i < n; i++) { //prolazimo kroz matricu, ali zbog pravila koja smo uocili ne moramo da imamo j, nego ga izrazavamo preko i
            mainDiag += matrix[i][i]; //pravilo za glavnu dijagonalu i = j
            secDiag += matrix[i][n - 1 - i]; //pravilo za sporednu dijagonalu j = n - 1 - i
        }

        if(mainDiag >= 0 && secDiag >= 0 || mainDiag < 0 && secDiag < 0){ //kada su istog znaka
            System.out.println(Math.abs(mainDiag - secDiag)); //Math.abs() vraca apsolutnu vrednost |-a| = a
        } else {                                                // kada su razlicitog znaka
            mainDiag *= -1; //pretvaramo u isti znak
            System.out.println(Math.abs(mainDiag + secDiag)); //sabiramo
        }
    }
}
