package isep.web.sakila.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.jpa.entities.Store;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

	public List<Inventory> findByStore(Store store);

	public Inventory findByFilm(Film film);

}
