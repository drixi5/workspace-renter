package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.InventoryWO;

public interface InventoryService {

	List<InventoryWO> findAllFilmInventory(int storeId);

	InventoryWO findById(int id);

	void saveInventory(InventoryWO inventoryWO, int id);

	void deleteInventoryById(int id);

}
