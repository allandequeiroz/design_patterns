import model.Model;
import model.Product;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import rest.ApplicationConfig;
import service.GenericService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by allanqueiroz on 1/10/16.
 *
 * mvn clean test -Parquillian
 */
@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductEndPointTest {

    private static WebTarget target;
    private URL baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment(){
        WebArchive war = ShrinkWrap.create(WebArchive.class,"restful.war")
                .addPackage(Model.class.getPackage())
                .addPackage(ApplicationConfig.class.getPackage())
                .addPackage(GenericService.class.getPackage())
                .addAsResource("META-INF/persistence.xml");

        System.out.print(war.toString(true));
        return war;
    }

    @Before
    public void setupClass() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        baseURL = new URL("http://localhost:8080/restful/");
        target = client.target(URI.create(new URL(baseURL, "rest/product").toExternalForm()));
    }

    @Test
    public void test1Post() {
        Product product = giveMeAProduct();
        Response response = target.request().post(Entity.entity(product, MediaType.APPLICATION_JSON_TYPE));
        assertEquals("Saved sucessfully",response.readEntity(String.class));
    }

    @Test
    public void test3GetAll() {
        List<Product> products = target.request().get(new GenericType<List<Product>>(){});
        System.out.print("###"+products.get(0).getDescription()+"###");
        assertTrue(!products.isEmpty());
    }

    @Test
    public void test2Get() {
        List<Product> products = target.request().get(new GenericType<List<Product>>(){});
        Product anyProduct = products.get(0);
        Product product = target.path("/"+anyProduct.getId()).request().get(Product.class);
        Product defaultProduct = giveMeAProduct();
        assertTrue(product.equals(defaultProduct));
    }

    @Test
    public void test4Put(){
        List<Product> products = target.request().get(new GenericType<List<Product>>(){});
        Product product = products.get(0);
        product.setQuantity(50);
        Response response = target.request().put(Entity.entity(product,MediaType.APPLICATION_JSON_TYPE));
        assertEquals("Updated successfully",response.readEntity(String.class));
    }

    @Test
    public void test5Delete() {
        List<Product> products = target.request().get(new GenericType<List<Product>>(){});
        Product product = products.get(0);
        Response response = target.path("/"+product.getId()).request().delete();
        assertEquals("Removed sucessfully",response.readEntity(String.class));
    }

    private Product giveMeAProduct(){
        return new Product("Skinny Pants",50.0,100);
    }
}
