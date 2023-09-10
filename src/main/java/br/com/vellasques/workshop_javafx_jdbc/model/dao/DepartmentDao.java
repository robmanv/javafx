package br.com.vellasques.workshop_javafx_jdbc.model.dao;

import br.com.vellasques.workshop_javafx_jdbc.model.entities.Department;

import java.util.List;

public interface DepartmentDao {  // É IMPORTANTE IMPLEMENTAR O DAO DE INTERFACE, PORQUE SE A TECNOLOGIA MUDA DE MYSQL PRA SQL OU OUTRO BANCO, NÃO TEM ALTERAÇÕES
    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}