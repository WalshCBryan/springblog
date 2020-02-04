package com.codeup.springblog;


//Create at least four integration tests for your Spring blog application. We will be focused on CRUD functionality for posts so make sure that:
//        A list of posts can be shown by visiting: /posts.
//        A post page can be shown by visiting: /posts/{id}.
//        A post can be created by submitting all the required params through a HTTP POST request to /posts/create.
//        A test user has a valid HttpSession active before saving the post.

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PostIntegrationTests {

    @Autowired
    private PostRepository postDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder pen;

    @Autowired
    private MockMvc mvc;

    private User testUser;

    private HttpSession session;


    //    setting up test user
    private void setUpTestUser() {
        this.testUser = userDao.findByUsername("testUser");
        if (testUser == null) {
            testUser = new User();
            testUser.setEmail("test@email.com");
            testUser.setPassword(pen.encode("password"));
            testUser.setUsername("testUser");
            this.testUser = userDao.save(testUser);
        }
    }
    //setting up test session
    private void setUpSession() throws Exception {
        this.session = mvc.perform(post(
                "/login").with(csrf())
                .param("username", testUser.getUsername())
                .param("password", "password"))
                .andExpect(status().isFound())
                .andReturn()
                .getRequest()
                .getSession();
    }

    // create and login as test user
//    init session and log in as user
    @Before
    public void setUp() throws Exception {
        setUpTestUser();
        setUpSession();
    }

    // sanity test
    @Test
    public void testContext() {
        assertNotNull(mvc);
        assertNotNull(session);
    }

    @Test
    public void testPostCreation() throws Exception {
        mvc.perform(
                post("/posts/create")
                        .with(csrf())
                        .session((MockHttpSession) session)
                        .param("title", "Test Title")
                        .param("body", "This is a Test Ad")
        )
                .andExpect(status().is3xxRedirection())
                .andDo(print());

        // clean up
        Post p = postDao.findByTitle("Test Title");
        postDao.deleteById(p.getId());
    }

    /**
     * To test entity show, check for OK status and the content matching a given entity
     */
    @Test
    public void testPostShowAll() throws Exception {
        // select first ad to test
        Post postToTestShow = postDao.findAll().get(0);

        // complete and verify request to show it
        mvc.perform(
                get("/posts/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(postToTestShow.getTitle())))
                .andExpect(content().string(containsString(postToTestShow.getBody())));
    }

    @Test
    public void testPostShowOne() throws Exception {
        // select first ad to test
        Post postToTestShow = postDao.findAll().get(0);
        long id = postToTestShow.getId();

        // complete and verify request to show it
        mvc.perform(
                get("/posts/" + id).session((MockHttpSession) session))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(postToTestShow.getTitle())))
                .andExpect(content().string(containsString(postToTestShow.getBody())));
    }

}


