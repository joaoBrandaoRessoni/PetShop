/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Model;

import com.mycompany.petshop.Connection.DataBase;
import com.mycompany.petshop.interfaces.IModel;
import com.mycompany.petshop.resources.ConnectionResource;
import java.util.ArrayList;

/**
 *
 * @author joao_
 */
//Abstract neste caso serve apenas para impedir que sejam instaciadas classes do tipo Model, apenas as filhas poderão ser instaciadas
public abstract class Model<T> implements IModel<T> {

    @Override
    public ConnectionResource queryExecutor(String sql, ArrayList<Object> params, Class classe){
        ConnectionResource result = DataBase.runExecuteQuery(sql, classe, params);
        return result;
    }

    @Override
    public int updateExecuter(String sql, ArrayList<Object> params) {
        return DataBase.runExecuteUpdate(sql, params);
    }
}
