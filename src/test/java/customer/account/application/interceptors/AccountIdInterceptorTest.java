package customer.account.application.interceptors;

import customer.account.application.inteceptors.AccountIdInterceptor;
import customer.account.domain.facades.AccountFacade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class AccountIdInterceptorTest {

    @Mock
    private AccountFacade accountFacade;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private PrintWriter printWriter;

    @InjectMocks
    private AccountIdInterceptor accountIdInterceptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreHandle_invalidAccountId_format() throws Exception {
        String invalidAccountId = "invalidAccountId";
        String uri = "/api/accounts/invalidAccountId/details";
        when(request.getRequestURI()).thenReturn(uri);

        when(response.getWriter()).thenReturn(printWriter);

        boolean result = accountIdInterceptor.preHandle(request, response, new Object());

        assert (!result);
        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        verify(response.getWriter()).write("Invalid request format");
    }
}
