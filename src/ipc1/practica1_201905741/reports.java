
package ipc1.practica1_201905741;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reports {
    
    public void report_example(int matrix[][]){
        
        Date objDate = new Date();
        
        String strDateFormat = "hh: mm: ss a dd-MMM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        
        String current_date = objSDF.format(objDate);
        
        try {
            
            String ruta = "./resources/reports/Reporte_Ejemplo_" + current_date + ".html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            //writer.println("");
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            
            writer.println("<head>");
            writer.println("<meta charset=\"utf-8\">");
            writer.println("<title> Reporte </title>");
            writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            writer.println("</head>");
            
            writer.println("<body>");
            writer.println("<h1> Reporte </h1>");
            
            writer.println("<table>");
            
            for (int i = 0; i< matrix.length; i++){
                writer.println("<tr>");
                
                for (int j = 0; j < matrix[i].length; j++){
                    
                    writer.println("<th>");
                    writer.println(matrix[i][j]);
                    writer.println("</th>");
                    
                }
                
                writer.println("</tr>");
            }
            
            writer.println("</table>");
            
            writer.println("</body>");
            writer.println("</html>");
            
            
            writer.close();
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void report_code(String text_message, int matrix1[][], int matrix2[][], int matrix3[][]){
        
        Date objDate = new Date();
        
        String strDateFormat = "hh: mm: ss a dd-MMM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        
        String current_date = objSDF.format(objDate);
        
        String title = "Reporte cifrar";
        
        try {
            
            String ruta = "./resources/reports/Code_" + current_date + ".html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            //writer.println("");
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"en\" dir=\"ltr\">");
            
            writer.println("<head>");
            writer.println("    <meta charset=\"utf-8\">");
            writer.println("    <title>" + title + "</title>");
            writer.println("");
            writer.println("    <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" crossorigin=\"anonymous\"></script>");
            writer.println("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css\">");
            writer.println("    <script src=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js\"></script>");
            writer.println("");
            writer.println("    <link rel=\"stylesheet\" href=\"./css/style.css\">");
            writer.println("");
            writer.println("    <link rel=\"shortcut icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("    <link rel=\"icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("");
            writer.println("    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>");
            writer.println("</head>");
            
            writer.println("<body>");
            writer.println("    <div class=\"ui large top fixed hidden menu\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <a class=\"active item\">" + title + "</a>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical masthead center aligned segment\" id=\"fondo_usac\">");
            writer.println("        <div class=\"ui text container\">");
            writer.println("            <h1 class=\"ui inverted header\">" + title + "</h1>");
            writer.println("            <h2>" + current_date + "</h2>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    <div class=\"ui vertical stripe\">");
            writer.println("        <div class=\"ui middle aligned stackable grid container\">");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Mensaje a cifrar: </h3>");
            writer.println("                    <p>" + text_message + "</p>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz A</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix1.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix1[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix1[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz B</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix2.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix2[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix2[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"ui horizontal divider\"> Multiplicacion de matrices </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz cifrada</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix3.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix3[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix3[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"ui horizontal divider\"> Resultado </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h2>El mensaje cifrado es: </h2>");
            writer.println("                    <p>");
                                                for (int i = 0; i < matrix3.length; i++){
                                                    for (int j = 0; j < matrix3[i].length; j++){
                                                        writer.print(matrix3[i][j]);
                                                        writer.print(" ");
                                                    }
                                                }
            writer.println("                    </p>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical footer segment\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <div class=\"ui stackable inverted divided equal height stackable grid\">");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">USAC</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">IPC 1 \"D\"</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"seven wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">Practica 1</h4>");
            writer.println("                    <p>Angel Geovanny Ordon Colchaj  -  201905741</p>");
            writer.println("                </div>");
            writer.println("                ");
            writer.println("                ");
            writer.println("            </div>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("</body>");
            
            writer.println("</html>");
            
            
            writer.close();
        
        } catch (Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void report_decipher(double matrix_a[][], double matrix_b[][], double det, double matrix_a_adj[][], double matrix_a_trans[][], double matrix_a_reverse[][], double matrix_final[][], char matrix_decipher[][]){
        
        Date objDate = new Date();
        
        String strDateFormat = "hh: mm: ss a dd-MMM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        
        String current_date = objSDF.format(objDate);
        
        String title = "Reporte descifrar";
        
        try {
            
            String ruta = "./resources/reports/Decipher_" + current_date + ".html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            //writer.println("");
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"en\" dir=\"ltr\">");
            
            writer.println("<head>");
            writer.println("    <meta charset=\"utf-8\">");
            writer.println("    <title>" + title + "</title>");
            writer.println("");
            writer.println("    <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" crossorigin=\"anonymous\"></script>");
            writer.println("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css\">");
            writer.println("    <script src=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js\"></script>");
            writer.println("");
            writer.println("    <link rel=\"stylesheet\" href=\"./css/style.css\">");
            writer.println("");
            writer.println("    <link rel=\"shortcut icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("    <link rel=\"icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("");
            writer.println("    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>");
            writer.println("</head>");
            
            writer.println("<body>");
            writer.println("    <div class=\"ui large top fixed hidden menu\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <a class=\"active item\">" + title + "</a>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical masthead center aligned segment\" id=\"fondo_usac\">");
            writer.println("        <div class=\"ui text container\">");
            writer.println("            <h1 class=\"ui inverted header\">" + title + "</h1>");
            writer.println("            <h2>" + current_date + "</h2>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    <div class=\"ui vertical stripe\">");
            writer.println("        <div class=\"ui middle aligned stackable grid container\">");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz A nxn : llave</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_a.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_a[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_a[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz B nxm : mensaje</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_b.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_b[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_b[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"ui horizontal divider\"> Operando </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Determinante: </h3>");
            writer.println("                    <p>" + det + "</p>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz adjunta de A</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_a_adj.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_a_adj[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_a_adj[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz transpuesta</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_a_trans.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_a_trans[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_a_trans[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
//            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"sixteen wide column\">");
            writer.println("                    <h3>Matriz inversa de A</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_a_reverse.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_a_reverse[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_a_reverse[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
//            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"ui horizontal divider\"> Multiplicacion de matrices </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"one wide column\"></div>");
            writer.println("                <div class=\"fiveteen wide column\">");
            writer.println("                    <h3>Matriz final</h3>");
            writer.println("                    <table class=\"ui blue table\"");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_final.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_final[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_final[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"one wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"ui horizontal divider\"> Matriz resultado </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz descifrada</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_decipher.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_decipher[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_decipher[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h2>El mensaje descifrado es: </h2>");
            writer.println("                    <p>");
                                                for (int i = 0; i < matrix_decipher.length; i++){
                                                    for (int j = 0; j < matrix_decipher[i].length; j++){
                                                        writer.print(matrix_decipher[i][j] + " ");
                                                        writer.print(" ");
                                                    }
                                                }
            writer.println("                    </p>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical footer segment\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <div class=\"ui stackable inverted divided equal height stackable grid\">");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">USAC</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">IPC 1 \"D\"</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"seven wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">Practica 1</h4>");
            writer.println("                    <p>Angel Geovanny Ordon Colchaj  -  201905741</p>");
            writer.println("                </div>");
            writer.println("                ");
            writer.println("                ");
            writer.println("            </div>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("</body>");
            
            writer.println("</html>");
            
            
            writer.close();
        
        } catch (Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void report_gauss_jordan(String file_path, double matrix_GJ[][]){
        
        Date objDate = new Date();
        
        String strDateFormat = "hh: mm: ss a dd-MMM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        
        String current_date = objSDF.format(objDate);
        
        String title = "Reporte Gauss-Jordan";
        
        try {
            
            String ruta = "./resources/reports/Gauss_Jordan_" + current_date + ".html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            //writer.println("");
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"en\" dir=\"ltr\">");
            
            writer.println("<head>");
            writer.println("    <meta charset=\"utf-8\">");
            writer.println("    <title>" + title + "</title>");
            writer.println("");
            writer.println("    <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" crossorigin=\"anonymous\"></script>");
            writer.println("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css\">");
            writer.println("    <script src=\"https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js\"></script>");
            writer.println("");
            writer.println("    <link rel=\"stylesheet\" href=\"./css/style.css\">");
            writer.println("");
            writer.println("    <link rel=\"shortcut icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("    <link rel=\"icon\" href=\"./img/favicon.ico\" type=\"image/x-icon\">");
            writer.println("");
            writer.println("    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>");
            writer.println("</head>");
            
            writer.println("<body>");
            writer.println("    <div class=\"ui large top fixed hidden menu\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <a class=\"active item\">" + title + "</a>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical masthead center aligned segment\" id=\"fondo_usac\">");
            writer.println("        <div class=\"ui text container\">");
            writer.println("            <h1 class=\"ui inverted header\">" + title + "</h1>");
            writer.println("            <h2>" + current_date + "</h2>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    <div class=\"ui vertical stripe\">");
            writer.println("        <div class=\"ui middle aligned stackable grid container\">");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Direccion del archivo: </h3>");
            writer.println("                    <p>" + file_path + "</p>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("            <div class=\"row\">");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("                <div class=\"twelve wide column\">");
            writer.println("                    <h3>Matriz aumentada</h3>");
            writer.println("                    <table class=\"ui blue table\">");
            writer.println("                        <tbody>");
                                                    for (int i = 0; i < matrix_GJ.length; i++){
            writer.println("                            <tr>");
                                                        for (int j = 0; j < matrix_GJ[i].length; j++){
            writer.println("                                <th>");
                                                            writer.print(matrix_GJ[i][j]);
            writer.println("                                </th>");
                                                        }
            writer.println("                            </tr>");
                                                    }
            writer.println("                        </tbody>");
            writer.println("                    </table>");
            writer.println("                </div>");
            writer.println("                <div class=\"two wide column\"></div>");
            writer.println("            </div>");
            writer.println("            ");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("    ");
            writer.println("    <div class=\"ui inverted vertical footer segment\">");
            writer.println("        <div class=\"ui container\">");
            writer.println("            <div class=\"ui stackable inverted divided equal height stackable grid\">");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">USAC</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"three wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">IPC 1 \"D\"</h4>");
            writer.println("                </div>");
            writer.println("                <div class=\"seven wide column\">");
            writer.println("                    <h4 class=\"ui inverted header\">Practica 1</h4>");
            writer.println("                    <p>Angel Geovanny Ordon Colchaj  -  201905741</p>");
            writer.println("                </div>");
            writer.println("                ");
            writer.println("                ");
            writer.println("            </div>");
            writer.println("        </div>");
            writer.println("    </div>");
            writer.println("</body>");
            
            writer.println("</html>");
            
            
            writer.close();
        
        } catch (Exception e){
            e.printStackTrace();
        }
    
    }
}
