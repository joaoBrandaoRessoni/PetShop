/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Controller;

import com.mycompany.petshop.Model.DadoPersistido;
import com.mycompany.petshop.Model.PetModel;
import com.mycompany.petshop.View.Login;
import com.mycompany.petshop.resources.ConnectionResource;
import java.util.ArrayList;

/**
 *
 * @author android
 */
public class PetController {
    private PetModel modelAnimal = new PetModel(); 
    
    public ConnectionResource index(){
        int id = DadoPersistido.user.id;
        String sql = "SELECT id, nome, raca, cor, tipo FROM animal WHERE id_usuario = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(id);
        return modelAnimal.queryExecutor(sql, params, PetModel.class);  
    }
    
    public int create(String nome, String raca, String cor, String tipo){
        String sql = "INSERT INTO animal (nome, raca, cor, tipo, id_usuario) VALUES (?, ?, ?, ?, ?)";
        ArrayList<Object> params = new ArrayList<>();
        params.add(nome);
        params.add(raca);
        params.add(cor);
        params.add(tipo);
        params.add(DadoPersistido.user.id);
        return modelAnimal.updateExecuter(sql, params);
    }

    public PetModel show(int id){
        String sql = "SELECT id, nome, raca, cor, tipo FROM animal WHERE id_usuario = ? AND id = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(DadoPersistido.user.id);
        params.add(id);
        ConnectionResource result = modelAnimal.queryExecutor(sql, params, PetModel.class);
        if(result.dados.isEmpty()){
            return null;
        }else{
            return (PetModel) result.dados.get(0);
        }
    }

    public int update(int id, String nome, String raca, String cor, String tipo){
        String sql = "UPDATE animal SET nome = ?, raca = ?, cor = ?, tipo = ? WHERE id = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(nome);
        params.add(raca);
        params.add(cor);
        params.add(tipo);
        params.add(id);
        
        return modelAnimal.updateExecuter(sql, params);
    }
    
    public int delete(int id){
        String sql = "DELETE FROM animal WHERE id = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(id);
        
        return modelAnimal.updateExecuter(sql, params);
    }
}
