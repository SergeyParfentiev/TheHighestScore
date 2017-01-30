package action;

import com.opensymphony.xwork2.ActionSupport;
import database.MySQLConnector;
import hash.Encryptor;
import org.apache.struts2.interceptor.SessionAware;
import table.Employee;

import java.util.Map;

public class Login extends ActionSupport implements SessionAware {

    private String login;
    private String passwordHash;
    private Map<String, Object> session;
    private Encryptor encryptor = new Encryptor();
    private MySQLConnector mySQLConnector = MySQLConnector.getInstance();

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    private boolean isValidEmployee() {
        boolean result = false;
        String password = mySQLConnector.getEmployeePassword(login);
        if (password != null && password.equals(encryptor.shaStrong(passwordHash))) {
            result = true;
        }
        return result;
    }

    public String checkLogin() {
        String result;
        clearFieldErrors();
        String employeeValue = "employee";
        Employee employee = (Employee) session.get(employeeValue);
        if (employee != null) {
            result = "success";
        } else {
            if (isValidEmployee()) {
                Employee emp = new Employee(login, passwordHash);
                session.put(employeeValue, emp);
                result = "success";
            } else {
                addFieldError("invalid", "Invalid login or password");
                result = "login";
            }
        }
        return result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
