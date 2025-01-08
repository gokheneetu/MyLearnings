import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.auto.service.DemoTestGet;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageTest {
    DemoTestGet demoTestGet;

    @BeforeClass
    public void checkPageCountSetup() {
        demoTestGet = new DemoTestGet();
    }

    @Test
    public void checkPageCountTest(){
        CloseableHttpResponse closeableHttpResponse = demoTestGet.checkPageCount();
        Assert.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(closeableHttpResponse.getEntity());
        Assert.assertEquals(demoTestGet.checkPageResponse(),2);
    }


}
