package search;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;

public class SearchTest extends BaseTest {
    public SearchTest() {
    }
    @Test
    public void test(){
        homePage.clickDesiredRoute();
        homePage.selectDate();
        ResultPage resultPage = homePage.search();
        resultPage.selectSeat();
        resultPage.selectBoardingPoint();
        resultPage.selectDroppingPoint();
        resultPage.setCustomerDetails("6789125987");
        resultPage.clickPayment();
    }
}
