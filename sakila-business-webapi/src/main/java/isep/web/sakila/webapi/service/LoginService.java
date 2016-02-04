package isep.web.sakila.webapi.service;

import isep.web.sakila.webapi.model.LoginWO;
import isep.web.sakila.webapi.model.StaffWO;

public interface LoginService {

	StaffWO validation(LoginWO loginWO);

}
