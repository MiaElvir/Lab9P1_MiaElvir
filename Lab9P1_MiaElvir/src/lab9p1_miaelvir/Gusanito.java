
package lab9p1_miaelvir;

import java.util.Random; 

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Gusanito {
    Random ran = new Random(); 
   
    int fil; 
    int col; 
    //   ** leer esto : How  can you write cow in thirteen letters?
    ArrayList<String> insrucciones = new ArrayList<>(); 
    char [][] tablero; 
    int posx_g, posy_g, posx_m, posy_m, posx_ob, posy_ob, num_ops; 

    public Gusanito(int fil, int col) {
        char [][] tablero = new char [fil][col]; 
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' '; 
            }
        }
        int menor = fil; 
        int mayor = 0; 
        if (col == fil){
            num_ops = fil;  
        }else if (col < fil ){
            mayor = fil; 
            menor = col; 
            num_ops = ran.nextInt(menor,mayor); 
        }else if (fil < col){
            menor = fil; 
            mayor = col; 
            num_ops = ran.nextInt(menor,mayor); 
        }
        //  leer esto : ** What food lives at the beach?
        posx_g = ran.nextInt(col); 
        posy_g = ran.nextInt(fil); 
        posx_m = ran.nextInt(col); 
        posy_m = ran.nextInt(fil); 
        
        
        //asignacion del gusano y la manzana
        
        tablero [posy_g][posx_g] = 'S'; 
        tablero [posy_m][posx_m] = 'ó'; 
        
        // leer esto: ** Que hace una rata con una ametralladora?
        //generar obstaculos
        for (int i = 0; i < num_ops; i++) {
            int g1 = ran.nextInt(col); 
            int g2 = ran.nextInt(fil);
            while(tablero[g2][g1] != ' '){
                g1 = ran.nextInt(col); 
                g2 = ran.nextInt(fil);
            }
            tablero[g2][g1] = '#';
        }
        
        setTablero(tablero);
        
    }//constructor

    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public ArrayList<String> getInsrucciones() {
        return insrucciones;
    }

    public void setInsrucciones(ArrayList<String> insrucciones) {
        this.insrucciones = insrucciones;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public int getPosx_g() {
        return posx_g;
    }

    public void setPosx_g(int posx_g) {
        this.posx_g = posx_g;
    }

    public int getPosy_g() {
        return posy_g;
    }

    public void setPosy_g(int posy_g) {
        this.posy_g = posy_g;
    }

    public int getPosx_m() {
        return posx_m;
    }

    public void setPosx_m(int posx_m) {
        this.posx_m = posx_m;
    }

    public int getPosy_m() {
        return posy_m;
    }

    public void setPosy_m(int posy_m) {
        this.posy_m = posy_m;
    }

    public int getPosx_ob() {
        return posx_ob;
    }

    public void setPosx_ob(int posx_ob) {
        this.posx_ob = posx_ob;
    }

    public int getPosy_ob() {
        return posy_ob;
    }

    public void setPosy_ob(int posy_ob) {
        this.posy_ob = posy_ob;
    }

    public int getNum_ops() {
        return num_ops;
    }

    public void setNum_ops(int num_ops) {
        this.num_ops = num_ops;
    }
    
    
    
 public String matriz(char x[][]){
     //char [][] temp = new char [x.length][x[0].length];
     
     String comp = ""; 
     for (int i = 0; i < x.length; i++) {
         for (int j = 0; j < x[i].length; j++) {
             
                comp +="["+x[i][j]+"] "; 
         }
         comp += "\n"; 
     }
     return comp; 
 } 
 
 public String MostarPaso(int paso){
     String ret = ""; 
     
      //String ins = insrucciones.get(paso);
    for (int i = 0; i == paso; i++) {
        String ins = insrucciones.get(i);
        int n = Integer.parseInt(ins.substring(0, ins.length() - 2)); 
        String inst = ins.substring(1, 2); 
        if (inst.equalsIgnoreCase("UP")){
            posy_g -= n; 
        }else if(inst.equalsIgnoreCase("DN")){
            posy_g += n;  
        }else if(inst.equalsIgnoreCase("RT")){
            posx_g += n; 
        }else if (inst.equalsIgnoreCase("LT")){
            posx_g -= n; 
        }
        //** leer : si un tomate con capa y espada es un supertomate, ¿que es una papa con capa y espada? 
    }
    String mensaje = ""; 
    if (tablero[posy_g][posx_g] == 'ó'){
            mensaje = "Encontraste la Manzana"; 
         }else if(tablero[posy_g][posx_g] == '#'){
             mensaje = "Chocaste"; 
         }else if(posy_g < 0 || posy_g > tablero.length-1 || posx_g < 0 || posx_g > tablero[0].length-1){
             mensaje = "Te saliste del tablero"; 
         }
    tablero[posx_g][posy_g] = 'S'; 
    ret += "Mostrando: "+paso+"\n"; 
    ret += mensaje;  
     for (int i = 0; i < tablero.length; i++) {
         for (int j = 0; j < tablero[i].length; j++) {
             ret += "["+tablero[i][j]+"] "; 
         }
         ret += "\n"; 
     }
    
      
     //retorna todo el texto qeu ira en el ese menos las opciones
     //leer *** como se llama un perro que tiene fiebre?


    return ret; 
 }
    
    
}//clase gusanito
