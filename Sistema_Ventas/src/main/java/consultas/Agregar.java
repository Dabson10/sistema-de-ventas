package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Agregar {

    public void agregar(JTextField pr) {
        /*
        Para mostrar en la tabla los datos de los productos que comprara se dividira en varios sectores o consultas 
        la primera verifica si el producto que ingresa la persona esta en la tabla de productos, si esta el producto lo agregara en la tabla 
        de ventas esto para despues mostrarlo en la tabla de la interfaz, antes de mostrarlo se actualizara la tabla 
        1.Verificara si el producto esta en la base de datos del almacen o productos
        2.Si esta el producto entonces procedera y quitara de la base de datos de productos 1 y lo agregara a la tabla ventas que es ventas
        
         */

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexiones.Conexion objetoConexion = new Conexiones.Conexion();
            String consulta1 = "SELECT idproductos,producto,disponibles,Precio FROM sistema_ventas.productos WHERE producto =?;";
            ps = objetoConexion.establecerConexion().prepareStatement(consulta1);

            ps.setString(1, pr.getText());

            rs = ps.executeQuery();

            if (rs.next()) {
                //Variables de la tabla de productos 
                String id = rs.getString("idproductos");
                String produ = rs.getString("producto");
                String cantidadProdu = rs.getString("disponibles");
                String precioProducto = rs.getString("Precio");

                //Consulta para verificar si el producto ya esta en la tabla de ventas
                if (Integer.valueOf(cantidadProdu) > 0) {
                    String consultaVenta = "SELECT producto,cantidad,precio FROM sistema_ventas.venta WHERE producto=?;";
                    ps = objetoConexion.establecerConexion().prepareStatement(consultaVenta);

                    ps.setString(1, pr.getText());

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String produVentas = rs.getString("producto");
                        String cantidadVentas = rs.getString("cantidad");
                        String precioVenta = rs.getString("precio");

                        if (pr.getText().equals(produVentas)) {
                            int sumaPrecio = Integer.valueOf(precioProducto) + Integer.valueOf(precioVenta);
                            String sumaTot = String.valueOf(sumaPrecio);

                            int cantidadVenta = Integer.valueOf(cantidadVentas) + 1;
                            String sumaProdu = String.valueOf(cantidadVenta);

                            String updVentas = "UPDATE sistema_ventas.venta SET cantidad=? ,precio=? WHERE producto=?; ";
                            ps = objetoConexion.establecerConexion().prepareStatement(updVentas);

                            ps.setString(1, sumaProdu);
                            ps.setString(2, sumaTot);
                            ps.setString(3, pr.getText());

                            int numF = ps.executeUpdate();
                            if (numF > 0) {
                                //En esta parte si no funciona agregarlo desde aqui al jframe , despues de esta linea se agregara la variable para la suma del 
                                //textfield, si no funciona con clase hacerlo dentro del  mismo boton.

                                //Consulta para actualizar la base de datos de los productos 
                                int productos = Integer.valueOf(cantidadProdu);
                                productos = productos - 1;
                                String updProducto = "UPDATE sistema_ventas.productos SET disponibles=? WHERE producto=?;";
                                ps = objetoConexion.establecerConexion().prepareStatement(updProducto);

                                ps.setString(1, String.valueOf(productos));
                                ps.setString(2, pr.getText());

                                int numFilas = ps.executeUpdate();

                                if (numFilas > 0) {
                                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente: ");
                                }

                            }

                        }

                    } else {
                        //Este else es por si no se habia agregado algun producto en la base de datos 

                        if (Integer.valueOf(cantidadProdu) > 0) {
                            //Consulta para agregar datos en la base de datos de ventas 
                            String agregarVentas = "INSERT INTO sistema_ventas.venta(producto,cantidad,precio) VALUES (?,?,?);";
                            ps = objetoConexion.establecerConexion().prepareStatement(agregarVentas);
                            String canti = "1";
                            ps.setString(1, pr.getText());
                            ps.setString(2, canti);
                            ps.setString(3, precioProducto);

                            int numF = ps.executeUpdate();
                            if (numF > 0) {
                                int productos = Integer.valueOf(cantidadProdu);
                                productos = productos - 1;
                                String updProducto = "UPDATE sistema_ventas.productos SET disponibles=? WHERE producto=?;";
                                ps = objetoConexion.establecerConexion().prepareStatement(updProducto);

                                ps.setString(1, String.valueOf(productos));
                                ps.setString(2, pr.getText());

                                int numFilas = ps.executeUpdate();

                                if (numFilas > 0) {
                                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente: ");
                                }

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay productos disponibles ");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No hay productos en almacen ");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esta mal");
        }

    }

}
