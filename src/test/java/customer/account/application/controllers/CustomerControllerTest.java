package customer.account.application.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import customer.account.domain.facades.CustomerFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerFacade customerFacade;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSaveCustomer_invalidInput() throws Exception {
        String invalidRequest = """
                    {
                        "surname": "Doe",
                        "identityNo": "123456789",
                        "birthDate": "1990-01-01"
                    }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                        .contentType(MediaType.APPLICATION_JSON) // Content-Type belirtildi
                        .content(invalidRequest)) // İstek gövdesi burada ayarlanıyor
                .andExpect(status().isBadRequest()) // 400 Bad Request bekleniyor
                .andExpect(jsonPath("$.errors[0].defaultMessage").value("Name cannot be blank"));
    }
}
