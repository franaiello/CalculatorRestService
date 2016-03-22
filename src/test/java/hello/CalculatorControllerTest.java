package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class CalculatorControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

//    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Autowired
//    void setConverters(HttpMessageConverter<?>[] converters) {
//
//        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
//                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();
//
//        Assert.assertNotNull("the JSON message converter must not be null",
//                this.mappingJackson2HttpMessageConverter);
//    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    public void readSingleBookmark() throws Exception {
//        mockMvc.perform(get("/" + userName + "/bookmarks/"
//                + this.bookmarkList.get(0).getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$.uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$.description", is("A description")));
//    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(get("/add?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("9")));
    }

    @Test
    public void subtract() throws Exception {
        mockMvc.perform(get("/subtract?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("3")));
    }

    @Test
    public void multiply() throws Exception {
        mockMvc.perform(get("/multiply?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("18")));
    }

    @Test
    public void divide() throws Exception {
        mockMvc.perform(get("/divide?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("2")));
    }

//    @Test
//    public void readBookmarks() throws Exception {
//        mockMvc.perform(get("/" + userName + "/bookmarks"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$[0].description", is("A description")))
//                .andExpect(jsonPath("$[1].id", is(this.bookmarkList.get(1).getId().intValue())))
//                .andExpect(jsonPath("$[1].uri", is("http://bookmark.com/2/" + userName)))
//                .andExpect(jsonPath("$[1].description", is("A description")));
//    }

//    @Test
//    public void createBookmark() throws Exception {
//        String bookmarkJson = json(new Bookmark(
//                this.account, "http://spring.io", "a bookmark to the best resource for Spring news and information"));
//        this.mockMvc.perform(post("/" + userName + "/bookmarks")
//                .contentType(contentType)
//                .content(bookmarkJson))
//                .andExpect(status().isCreated());
//    }

//    protected String json(Object o) throws IOException {
//        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
//        this.mappingJackson2HttpMessageConverter.write(
//                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
//        return mockHttpOutputMessage.getBodyAsString();
//    }
}
