package isep.web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Staff;

public interface LoginRepository extends CrudRepository<Staff, Integer> {

	public Staff findByEmailAndPassword(String email, String password);

}
