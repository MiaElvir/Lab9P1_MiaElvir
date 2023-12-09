
package lab9p1_miaelvir;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Lab9P1_MiaElvir {
    static Scanner papoy = new Scanner(System.in); 
    static Random ran = new Random(); 
    public static void main(String[] args) {
       
        
        Object [] opciones = {"Gusanito Hambriento", "Salir del Menu"};
        int boton = JOptionPane.showOptionDialog(null, "Lab9P1 - Q4.2023\nMia Elvir", "Menu",JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]); 
        switch (boton){
            case 0: 
                String dimensiones = JOptionPane.showInputDialog(null, "Ingrese las dimensiones del tablero en formato: ancho, alto", "Dimensiones", JOptionPane.DEFAULT_OPTION);
               
                int dim_x = dimensiones.charAt(0)-48; 
                int dim_y = dimensiones.charAt(2)-48; 
                
                while (dim_x < 4 || dim_y < 4 || dim_x > 10 || dim_y > 10){
                    dimensiones = JOptionPane.showInputDialog(null, "Las dimensiones deben ser en el rango de 4 a 10\nIngrese las dimensiones del tablero en formato: ancho, alto", "Dimensiones", JOptionPane.DEFAULT_OPTION); 
                    dim_x = dimensiones.charAt(0)-48; 
                    dim_y = dimensiones.charAt(2)-48; 
                }
                
                Gusanito gusan = new Gusanito(dim_x, dim_y);
                char [][] mat = gusan.getTablero(); 
                String pp = gusan.matriz(mat); 
                String elec1 = JOptionPane.showInputDialog(null, "Mapa\n"+pp+"\n1. Ingresar Instruccion\n2.Ejecutar instrucciones");
                int elec_int = Integer.parseInt(elec1);
                while (elec_int == 1){
                    String instruc = JOptionPane.showInputDialog(null, "Mapa\n"+pp+"\nIngrese la instruccion de la forma magnitudDireccion (ej.2UP)"); 
                    gusan.getInsrucciones().add(instruc); 
                    elec1 = JOptionPane.showInputDialog(null, pp+"\n1. Ingresar Instruccion\n2.Ejecutar instrucciones");
                    elec_int = Integer.parseInt(elec1);  
                }
                if (elec_int == 2){
                    int cont = 0; 
                    int paso = Integer.parseInt(JOptionPane.showInputDialog(null, gusan.MostarPaso(cont)+"\n1.Ver siguiente paso\n" +
"//                            + \n2.Ver paso anterior\n3.Seleccionar Paso\n4. Volver al Menu"));
                    
//                    String paso1 = JOptionPane.showInputDialog(null, "Mapa\n"+pp+"\n1.Ver siguiente paso"
//                            + "\n2.Ver paso anterior\n3.Seleccionar Paso\n4. Volver al Menu"); 
//                    int paso = Integer.parseInt(paso1); 
                    
                    
                    
                    
                    //llamar la funcion mostrar paso 
                    
                    
                }
                 
            
        }
        
        
        
        
    }
    
}
