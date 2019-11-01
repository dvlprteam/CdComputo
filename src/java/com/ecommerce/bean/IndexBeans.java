/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bean;

import com.ecommerce.bean.vo.ProductUrl;
import com.ecommerce.bo.IndexBo;
import com.ecommerce.bo.IndexImpBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author jvergara
 */
@ManagedBean(name = "indexBeans")
@ViewScoped
public class IndexBeans {

    private Client client;
    private List<ProductUrl> productUrls;
    private IndexBo indexBo;
    private List<ProductUrl> productCar;
    private  double subTotal;

    /**
     * Creates a new instance of IndexBeans
     */
    public IndexBeans() {
    }

    @PostConstruct
    public void init() {
        setClient(ClientBuilder.newClient());
        setProductUrls(new ArrayList<>());
        setProductCar(new ArrayList<>());
        setIndexBo(new IndexImpBO());
        try {
            getIndexBo().getAllProduct(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void addCar(ProductUrl  productUrl){
        try {
            getIndexBo().addCar(this,productUrl);
        } catch (Exception e) {
        }
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the productUrls
     */
    public List<ProductUrl> getProductUrls() {
        return productUrls;
    }

    /**
     * @param productUrls the productUrls to set
     */
    public void setProductUrls(List<ProductUrl> productUrls) {
        this.productUrls = productUrls;
    }

    /**
     * @return the indexBo
     */
    public IndexBo getIndexBo() {
        return indexBo;
    }

    /**
     * @param indexBo the indexBo to set
     */
    public void setIndexBo(IndexBo indexBo) {
        this.indexBo = indexBo;
    }

    /**
     * @return the productCar
     */
    public List<ProductUrl> getProductCar() {
        return productCar;
    }

    /**
     * @param productCar the productCar to set
     */
    public void setProductCar(List<ProductUrl> productCar) {
        this.productCar = productCar;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
