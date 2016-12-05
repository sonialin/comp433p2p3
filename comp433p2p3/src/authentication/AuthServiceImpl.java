package authentication;

import javax.jws.WebService;

import model.customer.Customer;
import dal.CustomerDAO;

@WebService(endpointInterface = "com.company.auth.service.AuthService", serviceName = "corporateAuthService")
public class AuthServiceImpl implements AuthService {

//                public Employee getEmployee(String gid) throws EmployeeNotFoundException {
//                                EmployeeDAO dao = new EmployeeDAO();
//                                return dao.getEmployee(gid);
//                }
//
//                public boolean isEmployee(Employee emp) {
//                                EmployeeDAO dao = new EmployeeDAO();
//                                Employee emp2 = new Employee();
//                               
//                                try {
//                                                emp2 = dao.getEmployee(emp.getGid());
//                                                if (emp2.getFirstName() == emp.getFirstName())
//                                                                return true;
//
//                                } catch (EmployeeNotFoundException e) {
//                                                // TODO Auto-generated catch block
//                                                e.printStackTrace();
//                                }
//                                                               
//                                return false;
//                }

}