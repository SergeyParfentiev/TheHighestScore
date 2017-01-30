package action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import table.Employee;

import java.util.Map;

public class AuthenticationInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        String employeeValue = "employee";
        Employee employee = (Employee) session.get(employeeValue);
        if(employee == null) {
            return ActionSupport.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
