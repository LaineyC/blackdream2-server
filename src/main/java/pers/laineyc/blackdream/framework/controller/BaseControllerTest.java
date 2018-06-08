package pers.laineyc.blackdream.framework.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.exception.ErrorCode;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.util.JsonObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * BaseControllerTest
 * @author LaineyC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Rollback
//@Transactional
public abstract class BaseControllerTest {

    private static String ACTION_NAME = "action";

    private static String VERSION_NAME = "version";

    private String serverUri = "/";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession mockHttpSession;

    private Auth auth;

    public BaseControllerTest(){

    }

    @Before
    public void before() {
        mockMvc = webAppContextSetup(webApplicationContext).build();

        mockHttpSession = new MockHttpSession();
    }

    @After
    public void after() {

    }

    protected <E> Response<E> execute(Request request, Class<E> bodyClass, String action) throws Exception {
        Assert.assertNotNull(request);
        Assert.assertNotNull(bodyClass);
        Assert.assertNotNull(action);
        if(action.contains(".")){
            String [] values = action.split("\\.");
            action = "/" + values[0] + "/" + values[1];
        }

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post(serverUri + action)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(request));

        if(mockHttpSession != null){
            Auth auth = request.getAuth();
            if(auth != null){
                this.auth = auth;
                mockHttpSession.setAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY, auth);
            }
            mockHttpServletRequestBuilder.session(mockHttpSession);
        }

        MvcResult mvcResult = mockMvc
                .perform(mockHttpServletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();

        JSONObject jsonObject = JSON.parseObject(responseContent);

        JSONObject error = jsonObject.getJSONObject("error");

        JSONObject body = jsonObject.getJSONObject("body");

        Response<E> response = new Response<>();
        if(error != null){
            response.setError(JSON.toJavaObject(body, ErrorCode.class));
        }
        if(body != null){
            response.setBody(JSON.toJavaObject(body, bodyClass));
        }

        return response;
    }

    public static String getActionName() {
        return ACTION_NAME;
    }

    public static void setActionName(String actionName) {
        ACTION_NAME = actionName;
    }

    public static String getVersionName() {
        return VERSION_NAME;
    }

    public static void setVersionName(String versionName) {
        VERSION_NAME = versionName;
    }

    public String getServerUri() {
        return serverUri;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    public WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }

    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public MockHttpSession getMockHttpSession() {
        return mockHttpSession;
    }

    public void setMockHttpSession(MockHttpSession mockHttpSession) {
        this.mockHttpSession = mockHttpSession;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}