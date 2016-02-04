package isep.web.sakila.webapi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.LoginRepository;
import isep.web.sakila.jpa.entities.Staff;
import isep.web.sakila.webapi.model.LoginWO;
import isep.web.sakila.webapi.model.StaffWO;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);

	@Override
	public StaffWO validation(LoginWO loginWO) {
		if (loginWO.getEmail() != null) {
			Staff staff = loginRepository.findByEmailAndPassword(loginWO.getEmail(), loginWO.getPassword());
			if (staff != null) {
				return new StaffWO(staff);
			}
		}
		return null;
	}

}
