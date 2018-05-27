package pers.laineyc.blackdream.framework.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.framework.model.Auth;

/**
 * @author LaineyC
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback
@Transactional
public abstract class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    private Auth auth;

    public BaseServiceTest(){

    }

    @Before
    public void before(){

    }

    @After
    public void after(){

    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}