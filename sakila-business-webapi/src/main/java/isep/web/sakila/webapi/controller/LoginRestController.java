package isep.web.sakila.webapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isep.web.sakila.webapi.model.LoginWO;
import isep.web.sakila.webapi.model.StaffWO;
import isep.web.sakila.webapi.service.LoginService;

@RestController
public class LoginRestController {

	@Autowired
	LoginService loginService;

	private static final Log log = LogFactory.getLog(LoginRestController.class);

	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<StaffWO> connectStaff(@RequestBody LoginWO loginWO, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("" + request.getSession().getCreationTime());
		StaffWO staffWO = loginService.validation(loginWO);
		if (staffWO == null) {
			System.out.println("Staff with email " + loginWO.getEmail() + " not found");
			System.out.println("Staff with email " + loginWO.getPassword() + " not found");
			return new ResponseEntity<StaffWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StaffWO>(staffWO, HttpStatus.OK);
	}

}
