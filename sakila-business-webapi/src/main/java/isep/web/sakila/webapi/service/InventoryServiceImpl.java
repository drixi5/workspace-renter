package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.dao.repositories.InventoryRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.jpa.entities.Store;
import isep.web.sakila.webapi.model.InventoryWO;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private FilmRepository filmRepository;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<InventoryWO> findAllFilmInventory(int storeId) {

		List<InventoryWO> inventories = new LinkedList<InventoryWO>();

		Store store = storeRepository.findOne(storeId);

		for (Inventory inventory : inventoryRepository.findByStore(store))

		{
			inventories.add(new InventoryWO(inventory));
			log.debug("Adding " + inventory);
		}

		return inventories;
	}

	@Override
	public InventoryWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Inventory inventory = inventoryRepository.findOne(id);

		if (inventory != null) {
			return new InventoryWO(inventory);
		}
		return null;
	}

	public void saveInventory(InventoryWO inventoryWO, int id) {
		Inventory inventory = new Inventory();
		Film film = filmRepository.findOne(inventoryWO.getFilmId());
		Store store = storeRepository.findOne(id);
		inventory.setFilm(film);
		inventory.setStore(store);
		inventory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		inventoryRepository.save(inventory);
	}

	@Override
	public void deleteInventoryById(int id) {
		
		// Verifier sil n'est pas loué !!! 
		inventoryRepository.delete(id);
	}

}
