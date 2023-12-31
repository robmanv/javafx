package br.com.vellasques.workshop_javafx_jdbc.model.dao.impl;

import br.com.vellasques.workshop_javafx_jdbc.db.DB;
import br.com.vellasques.workshop_javafx_jdbc.db.DbException;
import br.com.vellasques.workshop_javafx_jdbc.model.dao.DepartmentDao;
import br.com.vellasques.workshop_javafx_jdbc.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO department " +
				"(Name) " +
				"VALUES " +
				"(?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setCodigo(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE department "
                                        + "SET Name = ? "
                                        + "WHERE Id = ? ");
            
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getCodigo());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM department WHERE id = ?");

            st.setInt(1, id);
            int rows = st.executeUpdate();

            if (rows == 0) {
                throw new DbException("Não existe id para delete");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Department dep = null;

        try {
            st = conn.prepareStatement("SELECT Id, Name FROM department "
                                      + "WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                dep = new Department(rs.getInt(1), rs.getString(2));
            }
            
            return dep;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT Id, Name FROM department");
            rs = st.executeQuery();

            while (rs.next()) {
                list.add(instantiateDepartment(rs));
            }
            
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
       
    }

    public Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department(rs.getInt("Id"),
                                        rs.getString("Name"));
        return dep;
    }
    
}