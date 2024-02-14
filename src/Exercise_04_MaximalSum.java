import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(" "); //niz dimenzija matrice (dva broja, ne moraju da budu ista)
        int dimRow = Integer.parseInt(sizes[0]); //unosimo broj redova
        int dimColumns = Integer.parseInt(sizes[1]); //unosimo broj kolona
        int[][] matrix = new int[dimRow][dimColumns]; //inicijalizujemo matricu za upisivanje

        for (int i = 0; i < dimRow; i++) {
            String[] elements = scanner.nextLine().split(" "); //ucitavamo red po red
            for (int j = 0; j < dimColumns; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]); //upisujemo element po element
            }
        }

        int bestSum = Integer.MIN_VALUE; //inicijalizujemo maksimalnu sumu (bestSum) na najmanju mogucu vrednost
        int[][] result = new int[3][3]; //inicijalizujemo matricu 3x3 za taj rezultat

        for (int row = 0; row < dimRow - 2; row++) { //krecemo se kroz redove matrice, ali ne do kraja, UVEK ostavljamo dva elementa do kraja, kako bismo im posle pristupili
            for (int col = 0; col < dimColumns - 2; col++) { //krecemo kroz kolone matrice, ali opet ne do kraja, nego do 2 pred kraj
                int sum = 0; //trenutna suma ove 3x3 matrice se inicijalizuje na 0
                ArrayList<Integer> resultList = new ArrayList<>(); //upisacemo rezultat u LISTU, ali tako da ide red za redom
                for (int currentRow = row; currentRow <= row + 2 ; currentRow++) { //ovde trazimo 3x3 matricu, pocevsi od trenutnog red i i pomeramo se za jos dva mesta
                    for (int currentColumn = col; currentColumn <= col + 2; currentColumn++) { ///ovde trazimo 3x3 matricu, pocevsi od trenutne kolone i i pomeramo se za jos dva mesta
                        sum += matrix[currentRow][currentColumn]; //sabiramo elemente
                        resultList.add(matrix[currentRow][currentColumn]); //dodajemo elemente u listu
                    }
                }
                if(bestSum < sum){ //trazenje maksimuma
                    bestSum = sum;
                    for (int i = 0; i < result.length; i++) { //upisivanje iz liste u matricu
                        for (int j = 0; j < result[0].length; j++) { //upisivanje iz liste u matricu
                            result[i][j] = resultList.get(i * result[0].length + j); // idemo red po red, i = 0 pa j = 0,1,2, pa i = 1, pa j = 0,1,2 sto su pozicije 3,4,5
                        } // result[0].length = 3
                    }
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        for(int[] nums : result){
            for(int num : nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
