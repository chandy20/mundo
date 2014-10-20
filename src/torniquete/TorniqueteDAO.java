/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TorniqueteDAO {

    private final Connection connection;

    public TorniqueteDAO() {
        connection = Conexion.getConnection();
    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            
        }
    }
    
    public void addContador(int id, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE torniquetes SET centradas = centradas + " + input + ", csalidas = csalidas + " + output + " WHERE id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void inOut(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contar(int id, String fecha, int input, int output) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_minutos SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inOutHora(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarHora(int id, String fecha, int input, int output) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_horas SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inOutDia(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarDia(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inOutMes(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarMes(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_meses SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inOutAnio(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_anos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarAnio(int id, String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_anos SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inOutTodosDias(String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias_parques(fecha, entradas, salidas) VALUE ('" + fecha + "'," + input + "," + output + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarTodosDias(String fecha, int input, int output) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias_parques SET entradas = entradas + " + input + ", salidas = salidas + " + output + " WHERE fecha = '" + fecha + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Esta funcion se encarga de dado el codigo de la tarjeta desbloquear el
     * torniquete
     *
     * @param codigo
     * @return 0 Si la terjeta esta registrada en la base de datos 1 si no se
     * encuentra en el sistema -1 si hay un error en la consulta
     */
    public int validarTarjeta(String codigo) { //, String torniquete_id
        System.out.println("code " + codigo);
        String sql = "SELECT id FROM bracelets WHERE cod_barras = '" + codigo +"'";
        int retornar = -1;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = 0;
                } else {
                    retornar = 1;
                }
                System.out.println("rte " + rs.getInt("id"));
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizar(int id) {
        String fecha;
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String Fecha = Formateador.format(fecaActual) + ":00";
        if (!GUI2.Fecha.equals(Fecha)) {
            GUI2.Fecha = Fecha;
            fecha = Fecha.substring(0, Fecha.length() - 2);
        } else {
            fecha = GUI2.Fecha.substring(0, GUI2.Fecha.length() - 2);
        }
        String sql = "SELECT id FROM entradas_salidas_minutos WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id;
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida por hora
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizarHora(int id) {
        String fecha;
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd HH");
        String Fecha = Formateador.format(fecaActual);
        fecha = Fecha.substring(0, Fecha.length()) + ":00";
        String sql = "SELECT id FROM entradas_salidas_horas WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id;
//      Hashtable<String, String> datos = new Hashtable<String, String>();
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizarDia(int id) {
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = Formateador.format(fecaActual);
        String sql = "SELECT id FROM entradas_salidas_dias WHERE fecha = '" + fecha + "' AND torniquete_id = " + id;
//      Hashtable<String, String> datos = new Hashtable<String, String>();
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizarMes(int id) {
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM");
        String fecha = Formateador.format(fecaActual);
        String sql = "SELECT id FROM entradas_salidas_meses WHERE fecha = '" + fecha + "' AND torniquete_id = " + id;
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizarAnio(int id) {
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy");
        String fecha = Formateador.format(fecaActual);
        String sql = "SELECT id FROM entradas_salidas_anos WHERE fecha = '" + fecha + "' AND torniquete_id = " + id;
//      Hashtable<String, String> datos = new Hashtable<String, String>();
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar
     * en la base de datos en el registro de entrada salida
     *
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos true
     * si se va a actualizar
     */
    public boolean registrarActualizarTodosDia() {
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = Formateador.format(fecaActual);
        String sql = "SELECT id FROM entradas_salidas_dias_parques WHERE fecha = '" + fecha + "'";
//      Hashtable<String, String> datos = new Hashtable<String, String>();
        boolean retornar = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    retornar = true;
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }

    public int consultarEstado(int id) {
        int estado = -1;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT estado FROM torniquetes WHERE id = " + id);
            if (rs.next()) {
                estado = rs.getInt("estado");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estado;
    }

    public int consultarReset(int id) {
        int reset = -1;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT reset FROM torniquetes WHERE id = " + id);
            if (rs.next()) {
                reset = rs.getInt("reset");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reset;
    }

    public void actualizarEstado(int id, int estado) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE torniquetes SET estado = " + estado + " WHERE id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void reset(int id) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE torniquetes SET reset = 0, centradas = 0, csalidas = 0 WHERE id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList consultarInOut(int id) throws SQLException {
        int entradas = 0;
        int salidas = 0;
        ArrayList cantidades = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT centradas, csalidas FROM torniquetes WHERE id = " + id);
            if (rs.next()) {
                cantidades = new ArrayList();
                entradas = rs.getInt("centradas");
                cantidades.add(entradas);
                salidas = rs.getInt("csalidas");
                cantidades.add(salidas);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cantidades;
    }
    
}