/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bo;

import com.ecommerce.bean.IndexBeans;
import com.ecommerce.bean.vo.ProductUrl;

/**
 *
 * @author jvergara
 */
public interface IndexBo {
    

    
    void getAllProduct(IndexBeans indexBeans) throws Exception;
    
    
    void addCar(IndexBeans indexBeans,ProductUrl productUrl)throws Exception;
    
}
