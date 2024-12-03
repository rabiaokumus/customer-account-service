package customer.account.application.interceptors;

import customer.account.application.inteceptors.CustomerIdInterceptor;
import customer.account.domain.facades.CustomerFacade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class CustomerIdInterceptorTest {
    @Mock
    private CustomerFacade customerFacade;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private PrintWriter printWriter; // Mocking PrintWriter

    @InjectMocks
    private CustomerIdInterceptor customerIdInterceptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPreHandle_invalidRequestFormat() throws Exception {
        String uri = "/api/customers/123/details/details";
        when(request.getRequestURI()).thenReturn(uri);

        when(response.getWriter()).thenReturn(printWriter);

        boolean result = customerIdInterceptor.preHandle(request, response, new Object());

        assert (!result);
        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        verify(response.getWriter()).write("Invalid request format");
    }
}