package com.bong.test;


import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/web11-servlet.xml")
public class HelloWorldControllerTest {

    private static String REQ_NEW_BOARDN;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        Resource res = new ClassPathResource("board.json");

        REQ_NEW_BOARDN = FileUtils.readFileToString(res.getFile());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("-------------------------------------------------------11111 after");
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void helloWorld() throws Exception {

        //System.out.println(response.getResponse().getContentAsString());
        //System.out.println(response.getResponse().getContentType());


        /*
        this.mockMvc.perform(get("/accounts/1").accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Lee");
                */
    }

    @Test
    public void list() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        printJsonMvcResult(mvcResult);
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(
                post("/save")
                        .content(REQ_NEW_BOARDN)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.result").value(true));


    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void saveAll() throws Exception {
    }

    private void printJsonMvcResult(MvcResult mvcResult) throws Exception {

        JsonNode jsonNode = objectMapper.readTree(mvcResult.getResponse().getContentAsString());

        String formatJson = objectWriter.writeValueAsString(jsonNode);

        System.out.println(formatJson);
        System.out.println(mvcResult.getResponse().getContentType());
    }



}