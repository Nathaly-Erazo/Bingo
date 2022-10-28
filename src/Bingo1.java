import java.util.Scanner;

public class Bingo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][9]; // Declarar array
        boolean flag = true;

        do {
            try {
                System.out.println("Introduce los números del 1 al 9 para la primera columna: ");
                for (int i = 0; i < a.length; i++) { // Rellenar el array
                    for (int j = 0; j < a[i].length - 8; j++) { // Restar -8 para rellenar la primera columna
                        a[i][j] = sc.nextInt();
                        if (a[i][j] < 10 && a[i][j] > 0) {
                            System.out.println("Dato válido");
                            flag = true;
                        } else {
                            throw new NumberFormatException();
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Número con formato no válido o fuera de rango");
                flag = false;
            } catch (Exception e) {
                System.out.println("Error indeterminado");
                flag = false;
            }
        } while (!flag);
        // Ordenar los númers introducidos
        int n1 = a[0][0];
        int n2 = a[1][0];
        int n3 = a[2][0];
        int aux;
        if (n1 > n3) {
            aux = n1;
            n1 = n3;
            n3 = aux;
        }
        if (n1 > n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }

        a[0][0] = n1;
        a[1][0] = n2;
        a[2][0] = n3;

        // Mostar el array
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        do {
            try {
                System.out.println("Introduce los números del 10 al 29 para la segunda columna: ");
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[i].length - 7; j++) {
                        a[i][j] = sc.nextInt();
                        if (a[i][j] < 30 && a[i][j] > 9) {
                            System.out.println("Dato válido");
                            flag = false;
                        } else {
                            throw new NumberFormatException();
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Número con formato no válido o fuera de rango");
                flag = false;
            } catch (Exception e) {
                System.out.println("Error indeterminado");
                flag = false;
            }
        } while (!flag);
        n1 = a[0][1];
        n2 = a[1][1];
        n3 = a[2][1];

        if (n1 > n3) {
            aux = n1;
            n1 = n3;
            n3 = aux;
        }
        if (n1 > n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }

        a[0][1] = n1;
        a[1][1] = n2;
        a[2][1] = n3;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

