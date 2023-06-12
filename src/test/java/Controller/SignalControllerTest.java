package Controller;

import SignalHandlers.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SignalController.class)
@AutoConfigureMockMvc
public class SignalControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Application application;

    @Test
    public void verifyHandleSignalCall() throws Exception {
        MvcResult result = mockMvc.perform(post("/main/2")).andReturn();
        verify(application).handleSignal(2);
        Assert.assertEquals(result.getResponse().getContentAsString(), "OK");

        result = mockMvc.perform(post("/main/2222222222222222222222222222")).andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "Invalid integer");
    }
}