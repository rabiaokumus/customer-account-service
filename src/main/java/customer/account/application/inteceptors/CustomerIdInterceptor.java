package customer.account.application.inteceptors;

import customer.account.domain.facades.CustomerFacade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

public class CustomerIdInterceptor implements HandlerInterceptor {

    final private CustomerFacade customerFacade;


    @Autowired
    public CustomerIdInterceptor(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String[] uriParts = uri.split("/");

        if (uriParts.length <= 4) {
            String customerId = uriParts[3] == null ? uriParts[2] : uriParts[3];

            if (!isValidUserId(customerId)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("customerId parameter is invalid or missing parameter");
                return false;
            }

            if (!customerFacade.isExist(customerId)) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Customer not found");
                return false;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid request format");
            return false;
        }

        return true;
    }

    private boolean isValidUserId(String userId) {
        try {
            UUID.fromString(userId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
