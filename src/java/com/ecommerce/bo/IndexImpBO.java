/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bo;

import com.ecommerce.bean.IndexBeans;
import com.ecommerce.bean.vo.ProductUrl;
import com.ecommerce.dao.ConsultasDao;
import com.ecommerce.dao.ConsultasIT;
import com.ecommerce.utility.HibernateUtil;
import java.util.Base64;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author jvergara
 */
public class IndexImpBO implements IndexBo {
    
    private ConsultasIT consultasDAO = new ConsultasDao();

    @Override
    public void addCar(IndexBeans indexBeans, ProductUrl productUrl) throws Exception {
        indexBeans.setSubTotal(indexBeans.getSubTotal() + Double.valueOf(productUrl.getArti_precioventa1()));
        indexBeans.getProductCar().add(productUrl);

    }

    @Override
    public void getAllProduct(IndexBeans indexBeans) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String pWareHouse = "001";
        String pDate = "2019-10-30";
        final String URI = "http://3.225.134.78:8000/services/inventory/getExistencesByWarehouseAndDate?Pwarehouse=" + pWareHouse + "&Pdate=" + pDate;
        final String TYPE = "Basic ";
        Client client = indexBeans.getClient();
        WebTarget baseTarget = client.target(URI);
        final String encoding = Base64.getEncoder().encodeToString("admin:password".getBytes("UTF-8"));
        if (baseTarget.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
                TYPE + encoding).get().getStatus() == 200) {
            String data = baseTarget.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
                    TYPE + encoding).get(String.class);
            JSONArray jSONArray = new JSONArray(data);
            for (int i = 0; i < jSONArray.length(); i++) {
                ProductUrl productUrl = new ProductUrl();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                productUrl.setArti_bodega(jSONObject.getString("arti_bodega"));
                productUrl.setArti_cantidad(jSONObject.getString("arti_cantidad"));
                productUrl.setArti_codigo(jSONObject.getString("arti_codigo"));
                productUrl.setArti_descripcion(jSONObject.getString("arti_descripcion"));
                productUrl.setArti_precioventa1(jSONObject.getString("arti_precioventa1"));
                productUrl.setArti_precioventa2(jSONObject.getString("arti_precioventa2"));
                productUrl.setArti_precioventa3(jSONObject.getString("arti_precioventa3"));
                productUrl.setArti_precioventa4(jSONObject.getString("arti_precioventa4"));
                String url = getConsultasDAO().getUrl(productUrl.getArti_codigo(), session);
                productUrl.setUrl(url);
                indexBeans.getProductUrls().add(productUrl);

            }
        }

    }

    /**
     * @return the consultasDAO
     */
    public ConsultasIT getConsultasDAO() {
        return consultasDAO;
    }

    /**
     * @param consultasDAO the consultasDAO to set
     */
    public void setConsultasDAO(ConsultasIT consultasDAO) {
        this.consultasDAO = consultasDAO;
    }

}
