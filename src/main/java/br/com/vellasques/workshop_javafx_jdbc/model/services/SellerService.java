package br.com.vellasques.workshop_javafx_jdbc.model.services;

import br.com.vellasques.workshop_javafx_jdbc.model.dao.DaoFactory;
import br.com.vellasques.workshop_javafx_jdbc.model.dao.SellerDao;
import br.com.vellasques.workshop_javafx_jdbc.model.entities.Seller;

import java.util.List;

public class SellerService {
	
	private SellerDao dao = DaoFactory.createSellerDao();

	public List<Seller> findAll() {
		return dao.findAll();
				
	}

	public void saveOrUpdate(Seller obj) {
		if (obj.getCodigo() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Seller obj) {
		dao.deleteById(obj.getCodigo());
	}
}
