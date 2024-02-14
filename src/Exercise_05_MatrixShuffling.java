import java.util.Scanner;

public class Exercise_05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[][] matrix = new String[Integer.parseInt(input[0])][Integer.parseInt(input[1])]; //ucitali smo brojRedova i brojKolona

        for (int i = 0; i < matrix.length; i++) { //prolazimo kroz redove
            String[] elements = scanner.nextLine().split(" "); //ucitavamo redove
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = elements[j]; //ucitavamo elemente u matricu
            }
        }

        while(true){
            String cmd = scanner.nextLine(); //ucitavamo input svaki put u petlji
            if(cmd.equals("END")){ //petlja se vrti dok nam input nije END
                break;
            }
            String[] commands = cmd.split(" "); //dobijamo komandu koja bi trebalo da izgleda: swap oldRow oldCol newRow newCol tj. swap 0 1 1 1
            if(commands.length != 5){ //proveravamo da li komanda ima dovoljno argumenata (swap i 4 broja)
                System.out.println("Invalid input!");//ako nema javljamo gresku
                continue; //nastavljamo petlju, ucitace se opet nova komanda na pocetku petlje
            }
            if(!commands[0].equals("swap")){//proveravamo da li komanda pocinje sa swap
                System.out.println("Invalid input!");//ako nema javljamo gresku
                continue;
            }

            int oldRow = Integer.parseInt(commands[1]); //ucitavamo oldRow tj. red za poziciju prvog elementa
            int oldCol = Integer.parseInt(commands[2]); //ucitavamo oldcolumn tj. kolonu za poziciju prvog elementa
            int newRow = Integer.parseInt(commands[3]); //ucitavamo newRow tj. red za poziciju drugog elementa
            int newCol = Integer.parseInt(commands[4]); //ucitavamo newCol tj. kolonu za poziciju drugog elementa
            if(oldRow < 0 || oldCol < 0 || newRow < 0 || newCol < 0){
                System.out.println("Invalid input!");
                continue;
            }

            if(oldRow >= matrix.length || oldCol >= matrix[0].length || newRow >= matrix.length || newCol >= matrix[0].length){
                System.out.println("Invalid input!");
                continue;
            }
            String temp = matrix[oldRow][oldCol]; //zapamtimo stari (prvi) element u pommocnoj promenljivoj
            matrix[oldRow][oldCol] = matrix[newRow][newCol]; //dodelimo vrednost druge (nove) promenljive prvoj (staroj)
            matrix[newRow][newCol] = temp; //iz pomocne promenljive ucitamo vrednost u drugu tj. novu promenljivu

            for(String[] strs : matrix){ //stampanje matrice
                for(String str : strs){
                    System.out.print(str + " ");
                }
                System.out.println();
            }
        }

    }
}
