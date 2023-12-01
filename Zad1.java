import java.util.Scanner;
public class Zad1{
    static void det2(){
        int[][] table = new int[2][2];
        Scanner input = new Scanner(System.in);
        int determinant;
        int matrixCount = 0;
        System.out.println("A1x = B1y = C1");
        System.out.println("A2x = B2y = C2");
        System.out.println("Podaj wartośći kolejno do A1 A2 B1 B2 oddzielając spacja");
        String matrix = input.nextLine();
        String[] arrMatrix = matrix.split(" ", 4);
        for(int i = 0 ;i < 2;i++){
            for(int o = 0 ;o < 2;o++){
                table[i][o] = Integer.parseInt(arrMatrix[matrixCount]);
                matrixCount ++;
                System.out.print("[" +table[i][o] +"]");
            }
            System.out.print("\n");
        }
        determinant = table[0][0] * table[1][1]- table[0][1]*table[1][0];
        System.out.println(determinant);
    }



    static public void main(String args[]) {
        int choice;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Witaj w programie do obliczanie wyznacznika macierzy");
            System.out.println("Wybierz opcje");
            System.out.println("1. Macierz 2x2");
            System.out.println("2. Macierz 3x3");
            System.out.println("3. Zakończenie programu");
            choice = input.nextInt();
        }while (choice<0 || choice>3);
        switch (choice){
            case 1:
                det2();
        }
    }
}
