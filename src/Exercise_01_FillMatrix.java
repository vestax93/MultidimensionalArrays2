import java.util.Scanner;

public class Exercise_01_FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", "); // ucitavanje dimenzija i sablona (A ili B)
        int dim = Integer.parseInt(input[0]); // prvi element je dimenzija matrice (samo jedna jer je po zadatku kvadratna)
        String pattern = input[1]; //ucitavanje sablona A ili B
        int[][] matrix; //inicijalizovanje matrice
        if(pattern.equals("A")){
            matrix = fillMatrixA(dim); //pozivanje metode za A
        } else if (pattern.equals("B")){
            matrix = fillMatrixB(dim); //pozivanje metode za B
        } else {
            matrix = new int[dim][dim]; //inicijalizovanje prazne matreice, ali nece se desiti nikad jer ce uvek biti A ili B
        }
        //stampanje matrice
        for(int[] nums : matrix){ //prolazimo kroz redove
            for (int num : nums){ //prolazimo kroz konkretne elemente
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixA(int dim) {
        int[][] mat = new int[dim][dim];
        int counter = 1; //brojac za elemenete
        for (int i = 0; i < dim; i++) { //prolazimo kroz kolone
            for (int j = 0; j < dim; j++) { //prolazimo kroz vrste
                mat[j][i] = counter; //zakucana kolona, a menjeju se vrste
                counter++; //povecavamo brojac
            }
        }
        return mat;
    }
    private static int[][] fillMatrixB(int dim) {
        int[][] mat = new int[dim][dim];
        int counter = 1;
        boolean direction = true; //znak za smer (menja se pri svakom prolasku, parne kolone su na dole, neparne kolone su na gore)
        for (int i = 0; i < dim; i++) {
            if(direction){  //isto kao za A
                for (int j = 0; j < dim; j++) {
                    mat[j][i] = counter;
                    counter++;
                }
                direction = !direction; //promena smera nakon prolaska kroz petlju
            } else {
                for (int j = dim - 1; j >= 0; j--) { //prodjemo kroz vrste odozdo na gore, pocetna vrednost j = dim - 1 i posle se smanjuje
                    mat[j][i] = counter; //isti princip kao prethodno, menjaju se vrste, kolona je ista
                    counter++;
                }
                direction = !direction; //promena smera nakon prolasku kroz petlju
            }
        }
        return mat;
    }


}
