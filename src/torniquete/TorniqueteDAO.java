/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TorniqueteDAO {

    private Connection connection;

    public TorniqueteDAO() {
        connection = Conexion.getConnection();
    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            
        }
    }
    
    public void addContadorIn(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE torniquetes SET centradas = centradas + 1 WHERE id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addContadorOut(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE torniquetes SET csalidas = csalidas + 1 WHERE id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entrada(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salida(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntrada(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_minutos SET entradas = entradas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalida(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_minutos SET salidas = salidas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void entradaHora(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salidaHora(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaHora(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_horas SET entradas = entradas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaHora(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length() - 2);
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_horas SET salidas = salidas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void entradaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salidaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void entradaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salidaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_meses SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_meses SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void entradaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_anos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salidaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_anos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_anos SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_anos SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void entradaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias_parques(fecha, entradas, salidas) VALUE ('" + fecha + "',1,0)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salidaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias_parques(fecha, entradas, salidas) VALUE ('" + fecha + "',0,1)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias_parques SET entradas = entradas + 1 WHERE fecha = '" + fecha + "'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias_parques SET salidas = salidas + 1 WHERE fecha = '" + fecha + "'");
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
        String sql = "SELECT id FROM bracelets WHERE cod_barras = " + codigo;
//      Hashtable<String, String> datos = new Hashtable<String, String>();
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
        System.out.println("estado " + estado);
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
        System.out.println("reset " + reset);
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
    
//    public void actualizarInOut(int inputs, int outputs, int id, String fecha) throws SQLException {
//        int entradas = 0;
//        int salidas = 0;
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT centradas, csalidas FROM torniquetes WHERE id = " + id);
//            if (rs.next()) {
//                entradas = rs.getInt("centradas");
//                salidas = rs.getInt("csalidas");
//            }
//            rs.close();
//            statement.close();
//            boolean verif = registrarActualizar(id);
//            boolean verifHora = registrarActualizarHora(id);
//            boolean verifDia = registrarActualizarDia(id);
//            boolean verifMes = registrarActualizarMes(id);
//            boolean verifAnio = registrarActualizarAnio(id);
//            boolean verifTodosDia = registrarActualizarTodosDia();
//            if (entradas < inputs) {
//                statement = connection.createStatement();
//                statement.execute("UPDATE torniquetes SET centradas = " + inputs + " WHERE id = " + id);
//                statement.close();
//                int in = inputs - entradas;
//                if (verif) {
//                    statement = connection.createStatement();
//                    statement.execute("UPDATE entradas_salidas_minutos SET entradas = entradas + " + in + " WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
//                    statement.close();
//                } else {
//                    statement = connection.createStatement();
//                    statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + in + ",0)");
//                    statement.close();
//                }
//                if (verifHora) {
//                    fecha = fecha.substring(0, fecha.length() - 2);
//                    statement = connection.createStatement();
//                    statement.execute("UPDATE entradas_salidas_horas SET entradas = entradas + " + in + " WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
//                    statement.close();
//                } else {
//                    statement = connection.createStatement();
//                    statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + in + ",0)");
//                    statement.close();
//                }
//                if (verifDia) {
//                    statement = connection.createStatement();
//                    statement.execute("UPDATE entradas_salidas_dias SET entradas = entradas + " + in + " WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
//                    statement.close();
//                } else {
//                    statement = connection.createStatement();
//                    statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + in + ",0)");
//                    statement.close();
//                }
//                if (verifMes) {
//                    statement = connection.createStatement();
//                    statement.execute("UPDATE entradas_salidas_meses SET entradas = entradas + " + in + " WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
//                    statement.close();
//                } else {
//                    statement = connection.createStatement();
//                    statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "'," + in + ",0)");
//                    statement.close();
//                }
//                if (verifAnio) {
//                    dao.contarEntradaAnio(window.torniquete_id, GUI2.Fecha.substring(0, GUI2.Fecha.length() - 15));
//                } else {
//                    dao.entradaAnio(window.torniquete_id, GUI2.Fecha.substring(0, GUI2.Fecha.length() - 15));
//                }
//                if (verifTodosDia) {
//                    dao.contarEntradaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length() - 9));
//                } else {
//                    dao.entradaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length() - 9));
//                }
//            }
//            if (salidas != outputs) {
//                statement = connection.createStatement();
//                statement.execute("UPDATE torniquetes SET csalidas = " + outputs + " WHERE id = " + id);
//            }
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
}