/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class TorniqueteDAO {

    private Connection connection;

    public TorniqueteDAO() {
        connection = Conexion.getConnection();
    }

    public void entrada(int id, String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salida(int id, String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_minutos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntrada(int id, String fecha) {
    	fecha = fecha.substring(0, fecha.length()-2); 
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_minutos SET entradas = entradas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalida(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length()-2); 
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_minutos SET salidas = salidas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entradaHora(int id, String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salidaHora(int id, String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_horas(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaHora(int id, String fecha) {
    	fecha = fecha.substring(0, fecha.length()-2); 
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_horas SET entradas = entradas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaHora(int id, String fecha) {
        fecha = fecha.substring(0, fecha.length()-2); 
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_horas SET salidas = salidas + 1 WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entradaDia(int id, String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salidaDia(int id, String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaDia(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entradaMes(int id, String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salidaMes(int id, String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_meses(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_meses SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaMes(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_meses SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entradaAnio(int id, String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_anos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salidaAnio(int id, String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_anos(torniquete_id, fecha, entradas, salidas) VALUE (" + id + ",'" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_anos SET entradas = entradas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaAnio(int id, String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_anos SET salidas = salidas + 1 WHERE fecha = '" + fecha + "' AND torniquete_id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void entradaTodosDias(String fecha) {
   	try {	    	
            Statement statement = connection.createStatement();
	    statement.execute("INSERT INTO entradas_salidas_dias_parques(fecha, entradas, salidas) VALUE ('" + fecha + "',1,0)");       
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void salidaTodosDias(String fecha) {
    	try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO entradas_salidas_dias_parques(fecha, entradas, salidas) VALUE ('" + fecha + "',0,1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarEntradaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias_parques SET entradas = entradas + 1 WHERE fecha = '" + fecha + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contarSalidaTodosDias(String fecha) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE entradas_salidas_dias_parques SET salidas = salidas + 1 WHERE fecha = '" + fecha + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Esta funcion se encarga de dado el codigo de la tarjeta desbloquear
     * el torniquete
     * @param codigo
     * @return 0 Si la terjeta esta registrada en la base de datos
     * 1 si no se encuentra en el sistema
     * -1 si hay un error en la consulta
     */
    public int validarTarjeta(String codigo, String torniquete_id) {
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
//                registrarLog(retornar, torniquete_id, "-1",statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return retornar;
    }

    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
     */
    public boolean registrarActualizar(int id) {
        String fecha;
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String Fecha = Formateador.format(fecaActual) + ":00";
        if (!GUI2.Fecha.equals(Fecha)) {
            GUI2.Fecha = Fecha;
            fecha = Fecha.substring(0, Fecha.length()-2);
        } else
            fecha = GUI2.Fecha.substring(0, GUI2.Fecha.length()-2);
        String sql = "SELECT id FROM entradas_salidas_minutos WHERE fecha LIKE '" + fecha + "%' AND torniquete_id = " + id;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida por hora
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
     */
    public boolean registrarActualizarMes(int id) {
        Date fecaActual = new Date();
        SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM");
        String fecha = Formateador.format(fecaActual);
        String sql = "SELECT id FROM entradas_salidas_meses WHERE fecha = '" + fecha + "' AND torniquete_id = " + id;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    /**
     * Esta funcion se encarga de verificar si se va a registrar o a actualizar 
     * en la base de datos en el registro de entrada salida
     * @param id
     * @return false Si se va a crear un registro nuevo en la base de datos
     * true si se va a actualizar
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornar;
    }
    
    
    /**
     * Determina la cantidada de ingresos se han realizado con una tarjeta en
     * especifico
     *
     * @param input_id Id de la entrada que tiene asociada la tarjeta
     * @return Cantidad de ingresos
     */
    public int cantidadIngresos(String input_id, Statement statement) {
        int retornar = -1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println("Fecha Sistema: " + dateFormat.format(date));
        String sql = "select SUM(ingresos) as cantidad from entradas_inputs where  input_id=" + input_id + " and fecha='" + dateFormat.format(date) + "'";
        System.out.println("Sql: " + sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                //Si ya hay un registro en la base de datos, tomo los ingresos y valido si no ha excedido el limite
                if (rs.next()) {
                    retornar = rs.getInt("cantidad");
                }

            } else {
                //Si no hay un registro lo ingreso a la base de datos
                retornar = 0;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return retornar;
    }

    /**
     * Registra el ingreso en el sistema
     *
     * @param input_id Id del input que tiene asociada la tarjeta
     * @param entrada_id Id del torniquete por donde se ingresa
     * @param ingresos Cantidad de ingresos que ha reali
     * @param statement
     * @return
     */
    public int registrarIngresos(String input_id, String entrada_id, int ingresos, Statement statement) {
        int retornar = -1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String sql = "";
        if (ingresos > 0) {
            sql = "update entradas_inputs set ingresos=" + (ingresos + 1) + " where entrada_id=" + entrada_id + " and input_id=" + input_id;
        } else {
            sql = "insert into entradas_inputs (entrada_id,input_id,fecha,ingresos) values(" + entrada_id + "," + input_id + ",'" + dateFormat.format(date) + "',1)";
        }
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return retornar;
    }

    /**
     * Determina la cantidad de ingresos maximo permitidos a una categoria
     * especifica en la fecha actual
     *
     * @param category_id Id de la categoria a consultar
     * @return La cantidad de ingresos maximos
     */
    public int getCantidadIngresosByValidation(String category_id, Statement statement) {
        int retornar = -1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println("Fecha Sistema: " + dateFormat.format(date));
        String sql = "select cantidad_reingresos from validations where ('" + dateFormat.format(date) + "' BETWEEN fechainicio and fechafin) and categoria_id=" + category_id;
//        System.out.println("sql: "+sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    //Si ya hay un registro en la base de datos, tomo los ingresos y valido si no ha excedido el limite
                    retornar = rs.getInt("cantidad_reingresos");
                }

            } else {
                //Si no hay un registro lo ingreso a la base de datos
                retornar = -2;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            retornar = -1;
        }
        return retornar;
    }

    public void registrarLog(int tipo,String torniquete_id, String input_id, Statement statement)
    {
        String descripcion="";
        String type="";
        switch(tipo)
        {
            case -4:
                descripcion="Tarjeta no pertenece al evento";
                type="RECHAZO";
                break;
            case -3:
                descripcion="La tarjeta no se encuentra en el sistema";
                type="RECHAZO";
                break;
            case -2:
                descripcion="Entrada no permite esa tarjeta";
                type="RECHAZO";
                break;
            case -1:
                descripcion="Se excedio el limite de entradas";
                type="RECHAZO";
                break;
            case 0:
                descripcion="";
                type="INGRESO";
                break;
        }
        String sql="insert into logs_torniquetes (torniquete_id, input_id, tipo, descripcion) values($1,$2,'$3','$4')";
        sql=sql.replace("$1", torniquete_id);
        sql=sql.replace("$2", input_id);
        sql=sql.replace("$3", type);
        sql=sql.replace("$4", descripcion);
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public String obtenerUltimoIngreso(String codigo)
    {
        String sql="select l_t.fecha from logs_torniquetes l_t, inputs i where i.entr_codigo=$1 and i.id=l_t.input_id and l_t.tipo='INGRESO' order by l_t.fecha DESC LIMIT 1";
        sql=sql.replace("$1", codigo);
        System.out.println("sql: "+sql);
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("fecha");
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
