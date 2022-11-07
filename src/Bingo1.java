import java.util.Arrays;
import java.util.Scanner;

public class Bingo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] carton = new int[3][9]; // Crear el array
        boolean flag = true;
        int[] columna = new int[3]; // Crear el array en la que se van a guardar las columnas
        int num1 = 0; // Inicio del rango
        int num2 = 10; // Final de rango
        int posicion = 0; // Variable para ir aumentando la posición de las columnas y recorrer el cartón

        do {
            for (int j = 0; j < 9; j++) { // for para recorrer el cartón
                for (int i = 0; i < 3; i++) {
                    do {
                        try {
                            System.out.println("Introduce los números del " + num1 + " al " + num2 + ": ");
                            columna[i] = sc.nextInt();
                            if (columna[i] != 0 && columna[i] <= num2 && columna[i] > num1) { // Validar que el número no es 0 y que esté dentro del rango
                                System.out.println("Número válido");
                                flag = true;
                            } else {
                                System.out.println("Número fuera de rango");
                                flag = false;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Número con formato no válido");
                            flag = false;
                        } catch (Exception e) {
                            System.out.println("Error indeterminado");
                            flag = false;
                        }
                    } while (!flag);
                }
                do {
                    for (int i = 0; i < 3; i++) { // For para recorrer la columna y verificar que no hay números repetidos
                        if (columna[0] == columna[1]) {
                            flag = false;
                            System.out.println("Número repetido: " + Arrays.toString(columna) + ", vuelva a introducir un número:");
                            columna[0] = sc.nextInt();
                        } else if (columna[0] == columna[2]) {
                            System.out.println("Número repetido: " + Arrays.toString(columna) + ", vuelva a introducir un número:");
                            columna[0] = sc.nextInt();
                        } else if (columna[1] == columna[2]){
                            System.out.println("Número repetido: " + Arrays.toString(columna) + ", vuelva a introducir un número:");
                            columna[1] = sc.nextInt();
                        } else {
                            flag = true;
                        }
                    }
                } while (!flag);

                System.out.println(Arrays.toString(columna)); //Muestra el array columna
                Arrays.sort(columna); //Ordenada el array columna

                // Aquí introducimos en el cartón los números de la columna en  la posición que corresponda
                carton[0][posicion] = columna[0];
                carton[1][posicion] = columna[1];
                carton[2][posicion] = columna[2];

                // Mostar el array
                for (int i = 0; i < carton.length; i++) {
                    for (j = 0; j < carton[i].length; j++) {
                        System.out.print(carton[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            //Aumentamos el valor de las siguientes variables para que recorra el cartón.
            num1 += 10; //Aumentamos el rango
            num2 += 10;
            posicion++; //Aumentamos la posición para pasar a la siguiente columna.
        } while (posicion < 9);
    }
}

