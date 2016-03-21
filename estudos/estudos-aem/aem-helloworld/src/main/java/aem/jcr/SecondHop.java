package aem.jcr;

import aem.Exercise;
import org.apache.jackrabbit.core.TransientRepository;
import org.junit.Test;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class SecondHop implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Repository repository = getPostgreRepository();
        Session session = getPostgreSession(repository);
        try {
            Node root = session.getRootNode();

            //Store content
            Node hello = root.addNode("hello");
            Node world = hello.addNode("world");
            world.setProperty("message","Hello World!");
            session.save();

            //Retrive content
            Node node = root.getNode("hello/world");
            System.out.println(node.getPath());
            System.out.println(node.getProperty("message").getString());

//            Remove content
            root.getNode("hello").remove();
            session.save();
        }finally {
            session.logout();
        }
    }
}
