/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Controller;
import com.mycompany.petshop.Model.DadoPersistido;
import com.mycompany.petshop.Model.UserModel;
import com.mycompany.petshop.resources.ConnectionResource;
import java.util.ArrayList;

/**
 *
 * @author joao_
 */
public class UserController {
    public int login(String usuario, String senha){
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
        ArrayList<String> lista = new ArrayList<>();
        lista.add(usuario);
        lista.add(senha);
        UserModel user = new UserModel();
        ConnectionResource<UserModel> result = user.queryExecutor(sql, lista, UserModel.class);
        if(result.error != null){
            System.out.println(result.error);
            return 0;
        }
        if(!result.dados.isEmpty()){
            DadoPersistido.user = result.dados.get(0);
        }
        return result.dados.size();
    }
    
    public int cadastrar(String usuario, String senha){
        String sql = "SELECT * FROM usuario WHERE usuario = ?";
        UserModel user = new UserModel();
            
        ArrayList<String> params = new ArrayList<>();
        params.add(usuario);
            
        ConnectionResource result = user.queryExecutor(sql, params, UserModel.class);
        if(result.error != null){
            return 500;
        }else if(!result.dados.isEmpty()){
            return 401;
        }else{
            sql = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";
            params.add(senha);
            int criado = user.updateExecuter(sql, params);
            if(criado == 0){
                return 500;
            }else{
                return 200;
            }
        }
    }
}
