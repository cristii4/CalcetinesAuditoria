package calcetinesauditoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gestor {
    public int Nivel(String direccion, String nombre) {
        int nivel=4;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                String[] parts = bfRead.split("-");
                String NombreLinea = parts[0];
                String NivelLinea = parts[1]; // 1 2 o 3
                if(NombreLinea.equals(nombre)){
                    nivel = Integer.parseInt(NivelLinea);
                }
                
            }
            
        } catch(IOException e) {
            System.err.println("Archivo no encontrado");
        }
        return nivel;
    }
    
    public String leer(String direccion){
        
        String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                
                temp = temp + bfRead +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        
        return texto;
    }
    
    public String leerNombres(String direccion){
        
        String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                String[] parts = bfRead.split("-");
                String NombreLinea = parts[0];
                temp = temp + NombreLinea +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        
        return texto;
    }
    
    public String leerVentas(String direccion, int identificadorVenta, int posicion){

        String trozos[] = null;
        String nombre = "";

        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                trozos = bfRead.split(";");
                if(identificadorVenta == Integer.parseInt(trozos[0])) {
                    nombre = trozos[posicion]; // devuelve el nombre y el producto cuando se modifican las ventas
                } 
            }
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        
        return nombre;
    }
    
    public String Modificar(String direccion, String antiguo, String nuevo ) throws IOException{
        
        String texto = "";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                if(bfRead.equals(antiguo)){
                }
                else {
                temp = temp + bfRead +"\n";
                }
                
            }
            temp = temp + nuevo +"\n";
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return nuevo;
    }
    
    public String Eliminar(String direccion, String numeroVenta ) throws IOException{
        
        String texto = " ";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                if(bfRead.equals(numeroVenta)){
                }
                else {
                    temp = temp + bfRead +"\n";
                }
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return numeroVenta;
    }
    
    public String Agregar(String direccion, String nuevo) throws IOException{
        
        String texto = " ";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead +"\n";
            }
            temp = temp + nuevo +"\n";
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return nuevo;
    }
    
    public String Registrar(String direccion, String dato) throws IOException{
        
        String texto = "";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead +"\n";
            }
            texto = temp + dato;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return "";
    }
    
} // CLASS
