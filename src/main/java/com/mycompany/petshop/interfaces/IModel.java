/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.petshop.interfaces;
import com.mycompany.petshop.resources.ConnectionResource;
import java.util.ArrayList;

/**
 *
 * @author joao_
 */
public interface IModel<T> {
    public ConnectionResource queryExecutor(String sql, ArrayList<Object> params, Class classe);
    public int updateExecuter(String sql, ArrayList<Object> params);
}
