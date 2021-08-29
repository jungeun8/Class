package com.sample.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sample.util.MybatisUtils;
import com.sample.vo.Product;

public class ProductDao {

private SqlSessionFactory sqlSessionFactory;
private static ProductDao instance = new ProductDao();
private ProductDao() {
this.sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
}
/**
* 미리 생성된 productDao 반
* @return
*/
public static ProductDao getInstance() {
return instance;
}
/**
* 새 상품정보를 전달받아서 Sample_products 테이블에 저장한다.
* @param product 새 상품정보 
*/
public void insertProduct(Product product) {
SqlSession session = sqlSessionFactory.openSession(true);
session.insert("insertProduct", product);
session.close();
}
/**
* 전달받은 상품번호에 해당하는 상품정보를 SAMPLE_PRODUCTS 테이블에서 삭제한다.
* @param no 삭제할 상품번호, 해당 상픔을 참조하는 지식 레코드가 있으면 예외가 발생한다.
*/
public void deleteProduct(int no) {
SqlSession session = sqlSessionFactory.openSession(true);
session.delete("deleteProduct", no);
session.close();
}
/**
* 변경할 상품정보를 전달받아서 sample_products에서  해당 상품의 정보를 변경한다.
* @param product 변경할 상품정보 
*/
public void updateProduct(Product product) {
SqlSession session = sqlSessionFactory.openSession(true);
session.update("updateProduct", product);
session.close();
}
/**
* sample_products 테이블의 모든 상품정보를 반환한다.
* @return 상품정보가 여러개포함된 List객체, 언제나 null 아니다.
*/
public List<Product> getAllProducts(){
SqlSession session = sqlSessionFactory.openSession();
List<Product> products = session.selectList("getAllProducts");
session.close();
return products;
}
public void getProductByNo(int no) {
SqlSession session = sqlSessionFactory.openSession(true);
session.update("getProductByNo", no);
session.close();
}
public List<Product> getProductByName(String name){
SqlSession session = sqlSessionFactory.openSession();
List<Product> products = session.selectList("getProductByName", name);
session.close();
return products;
}
}

