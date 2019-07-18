import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "AddToWishlist")
    public static Object[][] getDataFromDataProviderCompleteRegister(){
        return new Object[][]
                {
                        {
                                "testing2002@testing.com","Testing$","Digital Storm"

                        },
                        {
                                "testing2002@testing.com","Testing$","Vintage Style Engagement Ring"
                        },
                        {
                                "testing2002@testing.com","Testing$","HP Spectre XT Pro UltraBook"
                        },
                        {
                                "testing2002@testing.com","Testing$","Nike Floral Roshe Customized Running Shoes"
                        },
                        {
                                "testing2002@testing.com","Testing$","Lenovo Thinkpad X1 Carbon Laptop"
                        }



                };

    }

}