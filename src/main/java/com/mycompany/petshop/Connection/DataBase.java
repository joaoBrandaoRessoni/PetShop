/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Connection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.petshop.resources.ConnectionResource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author joao_
 */
public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/petshop";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    public static String startDatabase(String tabela, String sqlTable){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = ? AND table_name = ?";
            // Criar um Statement para executar a consulta
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "petshop");
            statement.setString(2, tabela);
            
            try {
                // Executar a consulta e obter o resultado
                ResultSet result = statement.executeQuery();
                
                //Se a tabela existir fecha o statement e retorna true
                if(result.next() && result.getInt(1) > 0){
                    statement.close();
                    return "A tabela ja existe";
                //Caso não existir a tabela a mesma é criada 
                }else{
                    statement.close();
                    List<Object> lista = new ArrayList<>();
                    int tabelaCriada = DataBase.runExecuteUpdate(sqlTable, lista);
                    return "Tabela "+tabela+" criada";
                }
                
            } catch(Exception e){
                statement.close();
                return "Ocorreu um erro";
            }
        }catch (SQLException e) {
            return "Ocorreu um erro";
        }
    }
    
    public static <T> ConnectionResource runExecuteQuery(String sql, Class<T> tipoClasse, List<Object> params){
        ArrayList<T> data = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Criar um Statement para executar a consulta
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //Roda parametro por parametro para adcionar no sql
            for(int i = 0; i < params.size(); i++){
                statement.setObject(i + 1, params.get(i));
            }
            try { 
                // Executar a consulta e obter o resultado
                ResultSet result = statement.executeQuery();

                
                while(result.next()){
                    //Utilizando a reflection para criar uma instância de um tipo genérico
                    T objeto = tipoClasse.getDeclaredConstructor().newInstance();
                    
                    for(Field campo : tipoClasse.getDeclaredFields()){
                        try{
                            //Aqui ele vai pegar o valor da coluna que tenha o mesmo nome do objeto
                            Object valorColuna = result.getObject(campo.getName());
                            
                            //Aqui é definido o valor da propriedade no objeto criado
                            campo.set(objeto, valorColuna);
                        }catch(SQLException e) {
                            campo.set(objeto, null);
                        }
                    }
                    //Após ter criado o objeto com seus campos é adicionado ao arrayList para ser retornado
                    data.add(objeto);
                }
                // Fechar o statement e result
                result.close();
                statement.close();
                return new ConnectionResource(null, data, true);
            } catch(Exception e){
                statement.close();
                return new ConnectionResource(e.getMessage(), null, false);
            }
        }catch (SQLException e) {
            return new ConnectionResource(e.getMessage(), null, false);
        }
    }
    
    public static int runExecuteUpdate(String sql, List<Object> params){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Criar um Statement para executar a consulta
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //Roda parametro por parametro para adcionar no sql
            for(int i = 0; i < params.size(); i++){
                statement.setObject(i + 1, params.get(i));
            }
            
            try {
                // Executar a consulta
                statement.execute();
               
                //Verifica o número de linhas afetadas
                int result = statement.getUpdateCount();
                
                //Fecha o statement e retonar o número de linhas afetadas
                statement.close();
                return result;
            } catch(Exception e){
                statement.close();
                return 0;
            }
        }catch (SQLException e) {
            return 0;
        }
    }
}
