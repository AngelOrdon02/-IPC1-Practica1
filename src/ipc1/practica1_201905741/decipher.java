
package ipc1.practica1_201905741;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class decipher {
    
    private String file_path;
    private String file_path2;

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_path2() {
        return file_path2;
    }

    public void setFile_path2(String file_path2) {
        this.file_path2 = file_path2;
    }
    
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
    
    // Metodo - Recorre la matriz descifrada para mostrar el mensaje
    public void show_matrix_str(char[][] matrix){
    
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
    public static double[][] file_matrix(String file_path) {
        double[][] matrix = null;
        
        try{
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
                
                rows = rows +1;
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
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return matrix;
    }
    
    // Funcion - Calcula el determinante de la matriz cuadrada
    public double determinant(int i, double[][]matrix){
        
        if (matrix.length == 2) {
            double deter = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            
            return deter;
        } else {
            double deter = 0;
            
            for (int j = 0; j < matrix.length; j++){
                double[][] temp = this.sub_matrix(i, j, matrix);
                
                deter = deter + Math.pow(-1, i+j) * matrix[i][j] * this.determinant(0, temp);
            }
            
            return deter;
        }
        
    }
    
    // Funcion - Obtiene la sub-matriz
    public double[][] sub_matrix(int i, int j, double[][]matrix){
        
        double[][] temp = new double[matrix.length - 1][matrix.length - 1];
        
        int count1 = 0;
        int count2 = 0;
        
        for (int k = 0; k < matrix.length; k++){
            
            if (k != i){
                count2 = 0;
                for (int l = 0; l < matrix.length; l++){
                    
                    if (l != j){
                        temp[count1][count2] = matrix[k][l];
                        
                        count2++;
                    }
                    
                }
                
                count1++;
            }
            
        }
        
        return temp;
        
    }
    
    // Funcion - Encuentra la Adjunta de la matriz
    public double[][] adj_matrix(double [][]matrix){
        
        double[][] temp_adj = new double[matrix.length][matrix.length];
        
        for (int i = 0; i < temp_adj.length; i++){
            
            for (int j = 0; j < temp_adj.length; j++){
                
                double[][]temp = this.sub_matrix(i, j, matrix);
            
                double elemnt_adj = Math.pow(-1, i+j) * this.determinant(0, temp);
            
                temp_adj[i][j] = elemnt_adj;
                
            }
            
        }
        
        return temp_adj;
        
    }
    
    // Funcion - Encuentra la transpuesta de la matriz
    public double[][] trans_matrix(double[][] matrix){
        
        double[][] temp_trans = new double[matrix.length][matrix.length];
        
        for (int i = 0; i < temp_trans.length; i++){
        
            for (int j = 0; j < temp_trans.length; j++){
            
                temp_trans[i][j] = matrix[j][i];
                
            }
            
        }
        
        return temp_trans;
        
    }
    
    // Funcion - Encuentra la inversa de la matriz
    public double[][] reverse_matrix(double det, double[][] matrix){
        
        double[][] temp_reverse = new double[matrix.length][matrix.length];
        
        for (int i = 0; i < matrix.length; i++){
        
            for (int j = 0; j < matrix.length; j++) {
            
                temp_reverse [i][j] = ((matrix[i][j] / det));
                
            }
            
        }
        
        return temp_reverse;
    }
    
    // Funcion - Multiplica las matrices
    public static double[][] operate_matrix(double matrix1[][], double matrix2[][]){
        
        double[][] product = new double[matrix1.length][matrix2[0].length];
        
        for (int i = 0; i < matrix1.length; i++){
        
            for (int j = 0; j < matrix2[0].length; j++){
            
                for (int h = 0; h < matrix1[0].length; h++){
                
                    product[i][j] += matrix1[i][h] * matrix2[h][j];
                    
                }
                
            }
            
        }
        
        
        return product;
        
    }
    
    // Funcion - Decifra la matriz y lo ingrasa a una martiz char
    public static char[][] decipher_matrix(double matrix[][]){
        
        char[][] temp_matrix = new char[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++){
        
            for (int j = 0; j < matrix[i].length; j++){
                
                // Redondea el valor double y lo convierte a un int
                int code_ascii = (int) Math.round(matrix[i][j]);
                
                // Convierte el valor de int a un char, ASCII
                char character = (char) code_ascii;
                
                temp_matrix[i][j] = character;
                
            }
            
        }
        
        return temp_matrix;
        
    }
    
    /*
    public void show_message(char matrix[][]){
        
        for (int i = 0; i < matrix.length; i++){
        
            for (int j = 0; j < matrix[i].length; j++){
                
                System.out.print(matrix[i][j]);
                
            }
            
        }
        
    }
    */
    
    /*
    public static String decipher_message(char matrix[][]){
    
        String message = "";
        
        message = String.valueOf(matrix);
        
        return message;
    }
    */
    
}
