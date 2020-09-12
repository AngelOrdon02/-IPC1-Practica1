
package ipc1.practica1_201905741;
        
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class code {
    
    private String text_message;
    private String file_path;

    public String getText_message() {
        return text_message;
    }

    public void setText_message(String text_message) {
        this.text_message = text_message;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
    
    // Metodo para mostrar una matriz
    public void show_matrix(int[][] matrix){
    
        for (int x=0; x < matrix.length; x++) {
            System.out.print("|");
            for (int y=0; y < matrix[x].length; y++) {
                System.out.print (matrix[x][y]);
                if (y!=matrix[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
                    
    }
    
    // Funcion - Recorre .txt y lo almacena en una matriz
    public static int[][] file_matrix(String file_path) {
        int[][] matrix_a = null;
        
        try {
            String direction = file_path;
            File file_matrix = new File (direction);
            FileReader fr = new FileReader (file_matrix);
            BufferedReader br = new BufferedReader (fr);
            
            String line;
            
            //int [][] matrix_a;
            int rows = 0;
            int columns = 0;
            
            String string_file = "";
            
            while ((line=br.readLine()) != null){
                String [] row = line.split(",");
                
                string_file += line + "\n";
                
                for(int i = 0; i < row.length; i++){
                    //System.out.print(row[i] + " ");
                }
                
                columns = row.length;
                
                rows = rows + 1;
            
            }
            fr.close();
            
            matrix_a = new int[rows][columns];
            //System.out.println("");
            //System.out.println(rows);
            //System.out.println(columns);
            
            //System.out.println(string_file);
            
            //System.out.println("-------------------------------");
            String [] lines_files = string_file.split("\n");
            
            for (int i = 0; i < lines_files.length; i++){
                //System.out.println(lines_files[i]);
                
                String current_line = lines_files[i];
                String [] numbers = current_line.split(",");                
                
                
                for (int j = 0; j < numbers.length; j++){
                    //System.out.println("El valor en la fila" + i + " en la posicion " + j + " es " + numbers[j]);
                    matrix_a[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            
            /*
            for(int i = 0; i < matrix_a.length; i++){
                for (int j = 0; j < matrix_a[i].length; j++)
                {
                    System.out.print(matrix_a[i][j]+ " ");
                }
                System.out.println("");
            }
            */
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return matrix_a;
    }
    
    // Funcion - Convierte la frase a una matriz con valores del codigo ASCII
    public static int[][]  matrix_process(String text_message){
        
        int length;
        int n;
        int value;
        
        int[][] matrix = null;
        
        length = text_message.length(); //Encontrar la longitud de la cadena de caracteres
        
        if (length % 3 == 0) {
            
            n = length / 3;
            
            //int[][] matrix = new int[3][n];
            matrix = new int[3][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            //Usando el ejemplo del auxiliar
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if(column % n ==0){
                    row++;
                    column = 0;
                }
            }
         
            /*
            System.out.println("Valores introducidos");
            for (int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    System.out.println(matrix[i][j] + " ");
                }
                System.out.println();
            }
            
            for (int x = 0; x<matrix_textMessage.length; x++){
                System.out.println("[" + x + "]" + matrix_textMessage[x]);
            }
            */
            
        }else if (length % 4 == 0){
            
            n = length / 4;
            
            //int[][] matrix = new int[4][n];
            matrix = new int[4][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if(column % n == 0) {
                    row++;
                    column = 0;
                }
            }
            
            //Para recorrer la matriz e imprimirla
            /*
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }
            */
            
        
        }else if (length % 5 == 0){
            
            n = length / 5;
            
            //int[][] matrix = new int[5][n];
            matrix = new int[5][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if(column % n == 0) {
                    row++;
                    column = 0;
                }
            }
            
        }else if (length % 7 == 0){
            
            n = length / 7;
            
            
            //int[][] matrix = new int[7][n];
            matrix = new int[7][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if(column % n == 0){
                    row++;
                    column = 0;
                }
            }
        
        }else if (length % 11 == 0){
            
            n = length / 11;
            
            //int[][] matrix = new int[11][n];
            matrix = new int[11][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if(column % n == 0){
                    row++;
                    column = 0;
                }
            }
        
        }else if (length % 13 == 0){
            
            n = length / 13;
            
            //int[][] matrix = new int[13][n];
            matrix = new int[13][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if (column % n == 0){
                    row++;
                    column = 0;
                }
            }
        
        }else if (length % 17 == 0){
            
            n = length / 17;
            
            //int[][] matrix = new int[17][n];
            matrix = new int[17][n];
            char[] matrix_textMessage = text_message.toCharArray();
            
            int row = 0; // Fila
            int column = 0; // Columna
            
            for (int i = 0; i < matrix_textMessage.length; i++){
                
                matrix[row][column] = (int) matrix_textMessage[i];
                
                column++;
                
                if (column % n == 0){
                    row++;
                    column = 0;
                }
            }
        
        }
        
        return matrix;
        
    }

    // Funcion - Multiplica la matriz llave y la matriz de ASCII
    public static int[][] product_matrix(int[][] matrix1, int[][] matrix2){
        /*
        int[][] c = new int[matrix1.length][matrix2[0].length];
        // se comprueba si las matrices se pueden multiplicar
        if (matrix1[0].length == matrix2.length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        // aquí se multiplica la matriz
                        c[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
        
         * si no se cumple la condición se retorna una matriz vacía
         
        return c;
        */
        
        int[][] product = new int[matrix1.length][matrix2[0].length];
        
        for (int i = 0; i < matrix1.length; i++){
            for (int j = 0; j < matrix2[0].length; j++){
                for (int h = 0; h < matrix1[0].length; h++){
                
                    product[i][j] += matrix1[i][h] * matrix2[h][j];
                
                }
            }
        }
        
        
            
        /*
        // Necesitamos hacer esto por cada columna de la segunda matriz (B)
        for (int a = 0; a < matrix2[0].length; a++) {
            // Dentro recorremos las filas de la primera (A)
            for (int i = 0; i < matrix1.length; i++) {
                int suma = 0;
                // Y cada columna de la primera (A)
                for (int j = 0; j < matrix1[0].length; j++) {
                    // Multiplicamos y sumamos resultado
                    suma += matrix1[i][j] * matrix2[j][a];
                }
                // Lo acomodamos dentro del producto
                producto[i][a] = suma;
            }
        }
        */
        
        return product;
    }
    
}
