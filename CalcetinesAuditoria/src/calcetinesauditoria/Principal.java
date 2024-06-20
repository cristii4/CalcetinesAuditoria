package calcetinesauditoria;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {

    public static void main(String[] args) throws IOException {
        
         
    Gestor a = new Gestor();
    String opcion = "0";
    Scanner scan = new Scanner(System.in);
    int Nivel; //1=(Administrador) 2(Asistente) 3(Vendedor)
    
    String textoAuditoria;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    textoAuditoria =("\nUn usuario ha accedido al sistema: "+dtf.format(LocalDateTime.now())+"\n");
    System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
    
    System.out.print("Hola! Introduce tu nombre\n" );
    System.out.println(a.leerNombres("Usuarios.txt"));
    String nombre = scan.nextLine();
    System.out.print("Hola " + nombre +"\n");
    Nivel =(a.Nivel("Usuarios.txt",nombre));
    textoAuditoria = ("\n El usuario: " + nombre + " con nivel " + Nivel + " es quien ha accedido al sistema.\n");
    a.Registrar("Auditoria.txt",textoAuditoria);
    System.out.print("\nTienes nivel: " + Nivel +"\n");
    
    while (Nivel == 3) { // El gestor es un vendedor
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n");
        opcion = scan.nextLine();

        if (opcion.equals("1")){
            System.out.print("Lista de productos\n");
            break;
        }else{
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    while (Nivel == 2){ // El gestor es un asistente
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n");
        System.out.print("2.Agregar producto: \n");
        System.out.print("3.Modificar venta: \n");
        System.out.print("4.Desactivar producto: \n");
        System.out.print("5.Crear venta: \n");
        opcion = scan.nextLine();
        if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")){
            break;
        }else {
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    while (Nivel == 1){ // El gestor es un administrador
        System.out.print("\nSeleccione una:\n");
        System.out.print("1.Listar productos: \n"); 
        System.out.print("2.Agregar producto: \n"); 
        System.out.print("3.Modificar venta: \n"); 
        System.out.print("4.Desactivar producto: \n"); 
        System.out.print("5.Crear venta: \n"); 
        System.out.print("6.Eliminar venta: \n"); 
        System.out.print("7.Agregar usuario: \n"); 
        opcion = scan.nextLine();
        if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")||opcion.equals("6")||opcion.equals("7")){
            break;
        }else {
            System.out.print("Esa no es una opcion\n");
        }
    }
    
    // Registramos la entrada en el archivo de auditoria
    int op = Integer.parseInt(opcion);
    if(op == 1){
        textoAuditoria =(nombre + " ha accedido con la opción 'Listar productos'\n");
    }
    if(op == 2){
        textoAuditoria =(nombre + " ha accedido con la opción 'Agregar producto'\n");
    }
    if(op == 3){
        textoAuditoria =(nombre + " ha accedido con la opción 'Modificar venta'\n");
    }
    if(op == 4){
        textoAuditoria =(nombre + " ha accedido con la opción 'Desactivar producto'\n");
    }
    if(op == 5){
        textoAuditoria =(nombre + " ha accedido con la opción 'Crear venta'\n");
    }
    if(op == 6){
        textoAuditoria =(nombre + " ha accedido con la opción 'Eliminar venta'\n");
    }
    if(op == 7){
        textoAuditoria =(nombre + " ha accedido con la opción 'Agregar usuario'\n");
    }
    a.Registrar("Auditoria.txt",textoAuditoria);
    

    if (Nivel < 4){
        if ("1".equals(opcion)) { // Listar productos
            System.out.println(a.leer("Productos.txt"));
            textoAuditoria =(nombre + " ha listado los productos de 'Productos.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
        }
    }
    
    if (Nivel < 3) {
        if ("2".equals(opcion)) { // Agregar productos
            String estampado = "";
            String color = "";
            int precio;
            String activo = "";
            System.out.print("Introduce el estampado del calcetin: ");
            estampado = scan.nextLine();
            System.out.print("Introduce el color del calcetin: ");
            color = scan.nextLine();
            System.out.print("Introduce el precio del calcetin: ");
            precio = Integer.parseInt(scan.nextLine());
            System.out.print("¿Se encuentra activo? Si / No");
            activo = scan.nextLine();
            
            Random r = new Random();
            int idProducto = r.nextInt(9000) + 1000;
            
            String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
            System.out.print("El producto: ");
            System.out.println(a.Agregar("Productos.txt",nuevo));
            System.out.print(" ha sido creado.\n");
            
            textoAuditoria =(nombre + " ha agregado el producto: " + nuevo + " a 'Productos.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
            
        }
        
        if ("3".equals(opcion)) { // Modificar venta
            System.out.print("\nIntroduce el identificador de la venta que deseas modificar: \n");
            System.out.println(a.leer("Ventas.txt"));
            int idVenta;
            idVenta = Integer.parseInt(scan.nextLine());
            
            System.out.print("¿Como deseas modificarla?\n");
            
            System.out.print("¿Quieres cambiar el nombre? Si / No\n");
            String cambiarNombre = scan.nextLine();
            String nombreAntiguo = "";
            String nombreNuevo = "";
            String productoAntiguo = "";
            String productoNuevo = "";
            
            if( cambiarNombre.equals("si") || cambiarNombre.equals("Si") ) {
                nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                System.out.print("Introduce el nuevo nombre: ");
                nombreNuevo = scan.nextLine();
            } else if ( cambiarNombre.equals("no") || cambiarNombre.equals("No") ) {
                nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
                nombreNuevo = nombreAntiguo;
            }
            
            System.out.print("¿Quieres cambiar el producto? Si / No\n");
            String cambiarCalcetin = scan.nextLine();
            String calcetinNuevo = "";
            if( cambiarCalcetin.equals("si") || cambiarCalcetin.equals("Si") ) {
                productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                System.out.print("Introduce el nuevo producto: ");
                productoNuevo = scan.nextLine();
            } else if ( cambiarCalcetin.equals("no") || cambiarCalcetin.equals("No") ) {
                productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);
                productoNuevo = productoAntiguo;
            }
            
            String antiguo = "";
            String nuevo = "";
            
            antiguo = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
            nuevo = idVenta + ";" + nombreNuevo + ";" + productoNuevo;
  
            System.out.print("La venta: ' " + antiguo + " ' ha sido modificada a:");
            System.out.println(a.Modificar("Ventas.txt",antiguo,nuevo));
            
            textoAuditoria =("\n" + nombre + " ha modificado la venta: " + antiguo + " a : " + nuevo +" en el archivo 'Ventas.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
            
        }
    
        if ("5".equals(opcion)) { // Crear venta
            System.out.print("\nIntroduce el nombre del comprador: \n");
            String nombreComprador = scan.nextLine();
            
            System.out.print("\nIntroduce el estampado del producto: \n");
            String estampadoProducto = scan.nextLine();
            
            Random r = new Random();
            int idVenta = r.nextInt(9000) + 1000;

            String nuevo = idVenta + ";" + nombreComprador + ";" + estampadoProducto;
            System.out.print("La venta: ");
            System.out.println(a.Agregar("Ventas.txt",nuevo));
            System.out.print(" ha sido creada.");
            
            textoAuditoria =("\n" + nombre + " ha creado la venta: " + nuevo + " en 'Ventas.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
        }
        
        if ("4".equals(opcion)) { // Desactivar productos
            System.out.print("\nIntroduce el identificador del producto: \n");
            int idProducto = Integer.parseInt(scan.nextLine());
            
            String estampado = "";
            String color = "";
            String precio = "";
            String activo = "";
            
            estampado =  a.leerVentas("Productos.txt",idProducto,1);
            color =  a.leerVentas("Productos.txt",idProducto,2);
            precio =  a.leerVentas("Productos.txt",idProducto,3);
            activo =  a.leerVentas("Productos.txt",idProducto,4);
            
            String antiguo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
            
            if( activo.equals("si") || activo.equals("Si") ) {
                System.out.print("El producto se encuentra: " + activo + "\n"); // activado
                System.out.print("¿Quieres desactivarlo? Si / No ");
                String ActivoNuevo = scan.nextLine();
                if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                    activo = "No";
                } else {
                    activo = "Si";
                }
                
            } else {
                System.out.print("El producto se encuentra: " + activo + "\n"); // desactivado
                System.out.print("¿Quieres activarlo? Si / No ");
                String ActivoNuevo = scan.nextLine();
                if( ActivoNuevo.equals("si") || activo.equals("Si") ) {
                    activo = "Si";
                } else {
                    activo = "No";
                }
            }
                String nuevo = idProducto + ";" + estampado + ";" + color + ";" + precio + ";" + activo;
                
                System.out.print("El estado del producto: ");
                System.out.println(a.Modificar("Productos.txt",antiguo,nuevo));
                System.out.print(" ha sido modoficado.");
                
                textoAuditoria =("\n" + nombre + " ha cambiado la disponibilidad del producto: " + idProducto + " en 'Productos.txt'\n");
                a.Registrar("Auditoria.txt",textoAuditoria);
                
        }
        
    }

    if (Nivel < 2){
        if ("6".equals(opcion)) { // Eliminar venta
            System.out.print("\nIntroduce el identificador de la venta que deseas eliminar: \n");
            System.out.println(a.leer("Ventas.txt"));
            int idVenta;
            idVenta = Integer.parseInt(scan.nextLine());

            String borrar = "";
            String nombreAntiguo = "";;
            String productoAntiguo = "";
            nombreAntiguo =  a.leerVentas("Ventas.txt",idVenta,1);
            productoAntiguo =  a.leerVentas("Ventas.txt",idVenta,2);

            borrar = idVenta + ";" + nombreAntiguo + ";" + productoAntiguo;
            System.out.print("La venta:  ");
            System.out.println(a.Eliminar("Ventas.txt",borrar));
            System.out.print(" ha sido eliminada.");
            
            textoAuditoria =("\n" + nombre + " ha eliminado la venta: " + borrar + " de 'Ventas.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
            
        }   
        
        if ("7".equals(opcion)) { // Crear usuario
            System.out.print("\nIntroduce el nombre del usuario: ");
            String nombreUsuario = scan.nextLine();
            System.out.print("\nIntroduce el cargo a asignar:\n");
            System.out.println("1- Administrador");
            System.out.println("2- Asistente");
            System.out.println("3- Vendedor");
            int nivelUser = Integer.parseInt(scan.nextLine());
            String nuevo = nombreUsuario + "-" + nivelUser;
            System.out.println("El usuario ");
            System.out.println(a.Agregar("Usuarios.txt",nuevo));
            System.out.print("El usuario ha sido creado.");
            
            textoAuditoria =("\n" + nombre + " ha creado el usuario: " + nuevo + " en el archivo 'Usuarios.txt'\n");
            a.Registrar("Auditoria.txt",textoAuditoria);
        }

    }
        
    } // MAIN
    
} // CLASS
