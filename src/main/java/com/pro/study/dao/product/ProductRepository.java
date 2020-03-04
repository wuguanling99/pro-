package com.pro.study.dao.product;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pro.study.po.product.Product;

/** 
* @author: wgl
* @date: 2020年3月5日上午2:30:21 
* @version:1.0
* @Description: 产品数据层
*/
public interface ProductRepository extends JpaSpecificationExecutor<Product>, CrudRepository<Product, Long> {

}
