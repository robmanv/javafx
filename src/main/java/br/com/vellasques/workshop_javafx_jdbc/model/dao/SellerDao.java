package br.com.vellasques.workshop_javafx_jdbc.model.dao;

import br.com.vellasques.workshop_javafx_jdbc.model.entities.Department;
import br.com.vellasques.workshop_javafx_jdbc.model.entities.Seller;

import java.util.List;

public interface SellerDao {  // É IMPORTANTE IMPLEMENTAR O DAO DE INTERFACE, PORQUE SE A TECNOLOGIA MUDA DE MYSQL PRA SQL OU OUTRO BANCO, NÃO TEM ALTERAÇÕES
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}