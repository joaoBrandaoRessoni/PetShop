/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Controller;

import com.mycompany.petshop.Model.AgendamentoModel;
import com.mycompany.petshop.resources.ConnectionResource;
import java.util.ArrayList;

/**
 *
 * @author joao_
 */
public class AgendamentoController {
    private AgendamentoModel agendamento = new AgendamentoModel(); 
    
    public ConnectionResource index(int id){
        String sql = "SELECT id, DATE_FORMAT(data, '%d/%m/%Y') as data, procedimento, IF(curdate() > data, 'Realizado', 'Não realizado') as status" + 
                "FROM agendamento WHERE id_pet = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(id);
        return agendamento.queryExecutor(sql, params, AgendamentoModel.class);  
    }
    
    public int create(String data, String procedimento, int id_pet){
        String sql = "INSERT INTO agendamento (data, procedimento, id_pet) VALUES (?, ?, ?)";
        ArrayList<Object> params = new ArrayList<>();
        params.add(data);
        params.add(procedimento);
        params.add(id_pet);
        return agendamento.updateExecuter(sql, params);
    }

    public AgendamentoModel show(int id){
        String sql = "SELECT id, DATE_FORMAT(data, '%d/%m/%Y') as data, procedimento, id_pet FROM agendamento WHERE id = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(id);
        ConnectionResource result = agendamento.queryExecutor(sql, params, AgendamentoModel.class);
        if(result.dados.isEmpty()){
            return null;
        }else{
           System.out.println(result.toString());
            return (AgendamentoModel) result.dados.get(0);
        }
    }

    public int update(int id, String data, String procedimento){
        String sql = "UPDATE agendamento SET data = ?, procedimento = ? WHERE id = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(data);
        params.add(procedimento);
        params.add(id);
        
        return agendamento.updateExecuter(sql, params);
    }
    
    public int delete(int id){
        String sql = "DELETE FROM agendamento WHERE id = ?";
        ArrayList<Integer> params = new ArrayList<>();
        params.add(id);
        
        return agendamento.updateExecuter(sql, params);
    }
}
