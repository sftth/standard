package com.summit.springboot.standard.thymeleaf;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ThymeleafController.class)
public class ThymeleafControllerTest {
    @Autowired
    MockMvc mocMvc;

    @Autowired
    WebClient webClient;

    @Test
    public void thymeleaf() throws Exception{
        //요청 "/thymeleaf"
        //응답
        // - 모델 name : jacob
        // - 뷰 이름 : thymeleaf

        mocMvc.perform(get("/thymeleaf"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("thymeleaf"))
                .andExpect(model().attribute("name", is("jacob")))
                .andExpect(content().string(containsString("jacob")));
    }

    @Test
    public  void htmlunit() throws Exception {
        HtmlPage page = webClient.getPage("/thymeleaf");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("jacob");
    }
}