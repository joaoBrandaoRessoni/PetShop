/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Model;

/**
 *
 * @author android
 */
public class AgendamentoModel extends Model {
    public int id;
    public String data;
    public String procedimento;
    public String status;

    public AgendamentoModel(int id, String data, String procedimento, String status) {
        this.id = id;
        this.data = data;
        this.procedimento = procedimento;
        this.status = status;
    }
    
    public AgendamentoModel(){}

    @Override
    public String toString() {
        return "ID: " + this.id +
                "\nData: " + this.data +
                "\nProcedimento: " + this.procedimento;
    }
    
    
}
