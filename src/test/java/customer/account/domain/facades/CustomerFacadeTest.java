package customer.account.domain.facades;

import customer.account.domain.facades.components.CustomerComponent;
import customer.account.domain.models.CustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerFacadeTest {

    @Mock
    private CustomerComponent customerComponent;

    @InjectMocks
    private CustomerFacade customerFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        String id = "f7bd7f4a-0982-46d4-b00d-14f2464e1d61";
        CustomerModel expectedCustomer = new CustomerModel() {
            @Override
            public String getId() {
                return null;
            }
        };
        when(customerComponent.findById(id)).thenReturn(expectedCustomer);

        CustomerModel result = customerFacade.findById(id);

        assertEquals(expectedCustomer, result);
        verify(customerComponent, times(1)).findById(id);
    }

    @Test
    void testIsExist() {
        String id = "f7bd7f4a-0982-46d4-b00d-14f2464e1d61";
        when(customerComponent.isCustomerExist(id)).thenReturn(true);

        boolean result = customerFacade.isExist(id);

        assertTrue(result);
        verify(customerComponent, times(1)).isCustomerExist(id);
    }

    @Test
    void testSave() {
    }
}
