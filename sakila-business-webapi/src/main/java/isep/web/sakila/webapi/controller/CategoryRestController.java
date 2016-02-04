package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.sakila.webapi.model.CategoryWO;
import isep.web.sakila.webapi.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;

	private static final Log log = LogFactory.getLog(CategoryRestController.class);

	@RequestMapping(value = "/category/", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryWO>> listAllcategories() {


		List<CategoryWO> categories = categoryService.findAllCategories();
		if (categories.isEmpty()) {
			return new ResponseEntity<List<CategoryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoryWO>>(categories, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryWO> getCategory(@PathVariable("id") int id) {
		System.out.println("Fetching Category with id " + id);
		CategoryWO categoryWO = categoryService.findById(id);
		if (categoryWO == null) {
			System.out.println("Category with id " + id + " not found");
			return new ResponseEntity<CategoryWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryWO>(categoryWO, HttpStatus.OK);
	}

	// -------------------Create a Category----------------------------------

	@RequestMapping(value = "/category/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCategory(@RequestBody CategoryWO CategoryWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Category " + CategoryWO.getName());

		categoryService.saveCategory(CategoryWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/actor/{id}").buildAndExpand(CategoryWO.getCategoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// -------------------Update a Category----------------------------------
	@RequestMapping(value = "/category/update/", method = RequestMethod.POST)
	public ResponseEntity<CategoryWO> updateCategory(@RequestBody CategoryWO CategoryWO, UriComponentsBuilder ucBuilder) {
		log.error(String.format("Updating Category %s ", CategoryWO.getCategoryId()));
		CategoryWO currentCategory = categoryService.findById(CategoryWO.getCategoryId());

		if (currentCategory == null) {
			System.out.println("Category with id " + CategoryWO.getCategoryId() + " not found");
			return new ResponseEntity<CategoryWO>(HttpStatus.NOT_FOUND);
		}

		currentCategory.setName(CategoryWO.getName());
		categoryService.updateCategory(currentCategory);

		return new ResponseEntity<CategoryWO>(currentCategory, HttpStatus.OK);
	}
	// -------------------Delete a Category----------------------------------
	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoryWO> deleteCategory(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting Category with id " + id);

		CategoryWO staffWO = categoryService.findById(id);
		if (staffWO == null) {
			System.out.println("Unable to delete. Category with id " + id + " not found");
			return new ResponseEntity<CategoryWO>(HttpStatus.NOT_FOUND);
		}

		categoryService.deleteCategoryById(id);
		return new ResponseEntity<CategoryWO>(HttpStatus.NO_CONTENT);
	}
}
