import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "SearchProduct")
    public static Object[][] getDataFromDataProviderCompleteRegister(){
        return new Object[][]
                {
                        {
                            "testing2002@testing.com","Testing$","digital storm","235","Test","Testing apto 001",
                                "12345","12345678","Testing Tester","0000000000000000","12","2022","1234"

                        },
                        {
                                "testing2002@testing.com","Testing$","vintage style","235","Test","Testing apto 001",
                                "12345","12345678","Testing Tester","0000000000000000","12","2022","1234"
                        }

                };

    }

}
