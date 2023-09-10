package br.com.vellasques.workshop_javafx_jdbc.model.dao;

import br.com.vellasques.workshop_javafx_jdbc.db.DB;
import br.com.vellasques.workshop_javafx_jdbc.model.dao.impl.DepartmentDaoJDBC;
import br.com.vellasques.workshop_javafx_jdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() { // RETORNA O TIPO DA INTERFACE INSTANCIANDO UM OBJETO DE IMPLEMENTAÇÃO, CAMUFLA A IMPLEMENTAÇÃO
        return new SellerDaoJDBC(DB.getConnection());
    }
    
    public static DepartmentDao createDepartmentDao() { // RETORNA O TIPO DA INTERFACE INSTANCIANDO UM OBJETO DE IMPLEMENTAÇÃO, CAMUFLA A IMPLEMENTAÇÃO
        return new DepartmentDaoJDBC(DB.getConnection());
    }
    
}