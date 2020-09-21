import org.testng.annotations.*;
import pageObject.CategoriasPage;

import java.lang.reflect.Method;
import static org.testng.Assert.*;

public class MercadoLibre extends BaseTest {


    @Test
    public void seleccionCategorias(Method method)
    {

        categorias.SeleccionCategoria();
        categorias.OrdenarPorMenorPrecio();


    }


}



