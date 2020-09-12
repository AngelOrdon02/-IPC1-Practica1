/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.practica1_201905741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.*;

/**
 *
 * @author Angel Geovanny Ordon Colchaj - 201905741
 */

//Practica No.1 de Laboratorio IPC1
public class IPC1Practica1_201905741 {
    
    
    public static String readString(String mensaje){
        String valor=null;
        System.out.print(mensaje + "\n");
        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
        try {
            valor = entry.readLine();
        } catch (IOException ioe){
            System.out.println("Error de I/O");
            System.exit(1);
        }
        return valor;
    }

    public static void main(String[] args) {
        
        int menu = 0;
        String text_message = "";
        String file_path = "";
        String file_path2 = "";
        
        // Instancia de una clase
        code code = new code();
        decipher decipher = new decipher();
        reports reports = new reports();
        gauss_jordan gauss_jordan = new gauss_jordan();
        
        //Variables de funciones
        int length;
        
        System.out.println("----------------------------------");
        System.out.println("------------Bienvenido------------");
        System.out.println("----------------------------------" + "\n");
        
        String receive_text;
        while(menu < 4) {
            System.out.println("");
            System.out.println("*** Seleccione una opcion por favor");
            System.out.println("(1) Cifrar");
            System.out.println("(2) Descifrar");
            System.out.println("(3) Gauss-Jordan");
            System.out.println("(4) Salir");
            receive_text = readString("- Que opcion deseas: ");
            menu = Integer.parseInt(receive_text);
            System.out.println("");
            
            switch (menu){
                case 1:
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("** Seleccionaste la opcion 1 - Cifrar **");
                    receive_text = readString("-Ingrese texto a cifrar: ");
                    text_message = receive_text;
                    receive_text = readString("-Ingrese ruta del archivo de la matriz: ");
                    file_path = receive_text;
                    
                    int matrix1[][] = code.file_matrix(file_path);      // Recorrer .txt y almacenarlo en una matriz
                    int matrix2[][] = code.matrix_process(text_message);
                    int matrix3[][] = code.product_matrix(matrix1, matrix2);
                    
                    //Muestra la matriz
                    //code.show_matrix(matrix1);
                    //code.show_matrix(matrix2);
                    //code.show_matrix(matrix3);
                    
                    System.out.println("..................................................");
                    System.out.println("El mensaje cifrado es: ");
                    for (int i = 0; i < matrix3.length; i++){
                        for (int j = 0; j < matrix3[i].length; j++){
                            System.out.print(matrix3[i][j] + " ");
                        }
                    }
                    
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("");
                    
                    //Reporte
                    //reports.report_example(matrix3);
                    reports.report_code(text_message, matrix1, matrix2, matrix3);
                    
                    
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("** Seleccionaste la opcion 2 - Descifrar **");
                    receive_text = readString("-Ingrese ruta del archivo de la matriz (nxn): ");
                    file_path = receive_text;
                    receive_text = readString("-Ingrese ruta del archivo de la matriz (nxm): ");
                    file_path2 = receive_text;
                    
                    double matrix_a[][] = decipher.file_matrix(file_path);      // Recorrer .txt y almacenarlo en una matriz
                    double matrix_b[][] = decipher.file_matrix(file_path2);     // Recorrer .txt y almacenarlo en una matriz
                                        
                    double det = decipher.determinant(0, matrix_a);     // Obtener el determinante
                    double matrix_a_adj[][] = decipher.adj_matrix(matrix_a);        // Obtener la adjunta
                    double matrix_a_trans[][] = decipher.trans_matrix(matrix_a_adj);        // Obtener la transpuesta
                    double matrix_a_reverse[][] = decipher.reverse_matrix(det, matrix_a_trans);     //Obtener la inversa
                    
                    double matrix_final[][] = decipher.operate_matrix(matrix_a_reverse, matrix_b);      // Obtener la multiplicacion de las matrices
                    
                    char matrix_decipher[][] = decipher.decipher_matrix(matrix_final);      // Descifra el mensaje
                                       
                    /*
                    decipher.show_matrix(matrix_a);     // NxN
                    decipher.show_matrix(matrix_b);     // NxM
                    decipher.show_matrix(matrix_a_reverse);     // Inversa
                    
                    decipher.show_matrix(matrix_final);     // Multiplicacion
                    
                    decipher.show_matrix_str(matrix_decipher);      // Descifrada
                    */
                    
                    System.out.println("..................................................");
                    System.out.println("Mensaje descifrado es: ");
                    for (int i = 0; i < matrix_decipher.length; i++){
                        for (int j = 0; j < matrix_decipher[i].length; j++){
                            System.out.print(matrix_decipher[i][j] + " ");
                        }
                    }
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("");
                    
                    reports.report_decipher(matrix_a, matrix_b, det, matrix_a_adj, matrix_a_trans, matrix_a_reverse, matrix_final, matrix_decipher);
                    
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("** Seleccionaste la opcion 3 - Gauss-Jordan **");
                    receive_text = readString("-Ingrese ruta del archivo de la matriz: ");
                    file_path = receive_text;
                    
                    double[][] matrix_GJ = gauss_jordan.file_matrix(file_path);
                    
                    //gauss_jordan.show_matrix(matrix_GJ); // Muestra la matriz
                    
                    int n = 3;
                    int flag = 0;
                    
                    flag = gauss_jordan.perform_operation(matrix_GJ, n);
                    
                    if (flag == 1){
                        flag = gauss_jordan.check_consistency(matrix_GJ, n, flag);
                    }
                    
                    //gauss_jordan.show_matrix_augmented(matrix_GJ, n); // Muestra matriz aumentada final
                    
                    System.out.println("..................................................");
                    gauss_jordan.show_result(matrix_GJ, n, flag); // Llama al metodo - Muestra el resultado
                    
                    System.out.println("");
                    System.out.println("==================================================");
                    System.out.println("");
                    
                    reports.report_gauss_jordan(file_path, matrix_GJ);
                    
                    break;
            }
        
        }
        
        System.out.println("==================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("░██████╗░██████╗░░█████╗░░█████╗░██╗░█████╗░░██████╗\n" +
                            "██╔════╝░██╔══██╗██╔══██╗██╔══██╗██║██╔══██╗██╔════╝\n" +
                            "██║░░██╗░██████╔╝███████║██║░░╚═╝██║███████║╚█████╗░\n" +
                            "██║░░╚██╗██╔══██╗██╔══██║██║░░██╗██║██╔══██║░╚═══██╗\n" +
                            "╚██████╔╝██║░░██║██║░░██║╚█████╔╝██║██║░░██║██████╔╝\n" +
                            "░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝╚═╝░░╚═╝╚═════╝░");
        System.out.println("Por usar el programa");
        System.out.println("");
        System.out.println("            2020 - Angel Ordon - USAC - Guatemala, Guatemala ");
        
    }
    
}


//Variables que uso en ingles traducidads
// entry = entrada
// readString = leeCadena
// receive_text = recibe_texto
// text_message = mensaje_texto
// file_path = ruta_archivo
// code = cifrar
// cedipher = descifrar
// length = longitud
// matrix = matriz
// row = fila
// column = columna
// fileMatrix = archivo de matriz
// direction = direccion
// file_matrix = archivo de matriz
// line = linea
// matrix_a = matriz_a "Para la matriz del archivo"
// rows = filas
// columns = columnas
// string_file = cadena_archivo
// lines_files = lineas_archivos
// current_line = actual_linea
// numbers = numeros