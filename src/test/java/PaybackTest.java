import Pages.PaybackPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.Page;

public class PaybackTest {

    private Page page;

    @BeforeClass
    public void setUp() {
        page = new PaybackPage();
        page.openUrlChrome(PaybackPage.URL);
    }

    @Test(groups = {"smoke"})
    public void getElement_Logo() {



    }

    @AfterClass
    public void tearDown() {
        page.quit();
    }
}
