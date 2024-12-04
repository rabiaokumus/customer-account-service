package customer.account.application.inteceptors;

import customer.account.domain.facades.AccountFacade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

public class AccountIdInterceptor implements HandlerInterceptor {

    final private AccountFacade accountFacade;


    @Autowired
    public AccountIdInterceptor(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String[] uriParts = uri.split("/");

        if (uriParts.length <= 4) {
            String accountId = uriParts[uriParts.length - 1] ;

            if (!isValidAccountId(accountId)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("accountId parameter is invalid or missing parameter");
                return false;
            }

            if (!accountFacade.isExist(accountId)) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Account not found");
                return false;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid request format");
            return false;
        }

        return true;
    }

    private boolean isValidAccountId(String userId) {
        try {
            UUID.fromString(userId);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
