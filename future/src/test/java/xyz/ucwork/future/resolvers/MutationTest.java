package xyz.ucwork.future.resolvers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import xyz.ucwork.future.CsvDataSetLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class MutationTest {

    @Autowired
    private Mutation mutation;

    @Test
    @DatabaseSetup(value = "/xyz/ucwork/future/mutation/")
    @ExpectedDatabase(value = "/xyz/ucwork/future/mutation/expect/", table = "members", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testRegistMember() {
        mutation.registMember("testName");
    }

}
