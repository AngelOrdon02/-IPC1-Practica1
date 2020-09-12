

package ipc1.practica1_201905741;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class gauss_jordan {
    
    // Metodo - Muestra una matriz
    public void show_matrix(double[][] matrix){
    
        for (int x=0; x < matrix.length; x++) {
            System.out.print("|");
            for (int y=0; y < matrix[x].length; y++) {
                System.out.print (matrix[x][y]);
                if (y!=matrix[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
                    
        System.out.println("");
                    
    }
    
    // Funcion - Recorre .txt y lo almacena en una matriz
    public static double[][] file_matrix (String file_path){
        double [][] matrix = null;
        
        try {
            
            String direction = file_path;
            File file_matrix = new File (direction);
            FileReader fr = new FileReader (file_matrix);
            BufferedReader br = new BufferedReader (fr);
            
            String line;
            
            int rows = 0;
            int columns = 0;
            
            String string_file = "";
            
            while ((line = br.readLine()) != null){
            
                String[] row = line.split(",");
                
                string_file += line + "\n";
                
                columns = row.length;
                
                rows = rows + 1;
                
            }
            fr.close();
            
            matrix = new double[rows][columns];
            
            String[] lines_files = string_file.split("\n");
            
            for (int i = 0; i < lines_files.length; i++){
            
                String current_line = lines_files[i];
                String[] numbers = current_line.split(",");
                
                for (int j = 0; j < numbers.length; j++){
                    
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                    
                }
                
            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return matrix;
    }
    
    // Metodo - Imprimir una matriz
    public static void show_matrix_augmented(double matrix[][], int n){
        
        for (int x=0; x < n; x++) {
            System.out.print("|");
            for (int y=0; y <= n; y++) {
                System.out.print (matrix[x][y]);
                if (y!=matrix[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        
    }
    
    // Metodo - Realiza la operaciones entre filas
    public static int perform_operation(double matrix[][], int n){
        int i, j, c;
        int k = 0;
        int flag = 0;
        //int m = 0;
        
        //double pro = 0;
        
        for (i = 0; i < n; i++){
            
            if (matrix[i][i] == 0){
                
                c = 1;
                
                while ((i + c) < n && matrix[i + c][i] == 0){
                
                    c++;
                    
                    if ((i + c) == n){
                        
                        flag = 1;
                        break;
                    }
                    
                    for (j = i, k = 0; k <= n; k++){
                        
                        double temp = matrix[j][k];
                        matrix[j][k] = matrix[j + c][k];
                        matrix[j + c][k] = temp;
                        
                    }
                
                }
                    
            }
            
            for (j = 0; j < n; j++){
                
                if (i != j){
                
                    double p = matrix[j][i] / matrix[i][i];
                    
                    for (k = 0; k <= n; k++){
                    
                        matrix[j][k] = matrix[j][k] - (matrix[i][k]) * p;
                    
                    }
                    
                }
                
            }
            
        }
        
        return flag;
    }
    
    // Metodo - Comprobar la consistencia
    public static int check_consistency(double matrix[][], int n, int flag){
        
        int i, j;
        double sum;
        
        flag = 3;
        
        for (i = 0; i < n; i++){
        
            sum = 0;
            
            for (j = 0; j < n; j++){
            
                sum = sum + matrix[i][j];
                
            }
            
            if (sum == matrix[i][j]){
            
                flag = 2;
                
            }
            
        }
        
        return flag;
    }
 
    // Metodo - Mostrar el resultado
    public static void show_result(double matrix[][], int n, int flag){
    
        System.out.println("El resultado es: ");
        
        if (flag == 2){
            
            System.out.println("Tiene infinitas soluciones ");
            
        } else if (flag == 3){
            
            System.out.println("No tiene solucion ");
        
        } else {
            
            System.out.println("Tiene unica solucion");
            System.out.println("");
            
            /*
            for (int i = 0; i < n; i++){
            
                System.out.print(matrix[i][n] / matrix[i][i] + "\n");
                
            }
            */
            
            System.out.println("");
            System.out.print("x = " + matrix[0][n] / matrix[0][0] + "\n");
            System.out.print("y = " + matrix[1][n] / matrix[1][1] + "\n");
            System.out.print("z = " + matrix[2][n] / matrix[2][2] + "\n");
            
        }
        
    }
    
}
