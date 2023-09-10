package br.com.vellasques.workshop_javafx_jdbc.model.services;

import br.com.vellasques.workshop_javafx_jdbc.model.dao.DaoFactory;
import br.com.vellasques.workshop_javafx_jdbc.model.dao.DepartmentDao;
import br.com.vellasques.workshop_javafx_jdbc.model.entities.Department;

import java.util.List;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	public List<Department> findAll() {
		return dao.findAll();
				
	}

	public void saveOrUpdate(Department obj) {
		if (obj.getCodigo() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Department obj) {
		dao.deleteById(obj.getCodigo());
	}
}
