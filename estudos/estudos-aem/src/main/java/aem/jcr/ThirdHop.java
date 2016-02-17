package aem.jcr;

import aem.Exercise;
import org.apache.jackrabbit.core.TransientRepository;
import org.junit.Test;

import javax.jcr.*;
import java.io.FileInputStream;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class ThirdHop implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Repository repository = new TransientRepository();
        Session session = repository.login(defaultCredentials());
        try {
            Node root = session.getRootNode();

            //import xml unless already imported
            if(!root.hasNode("importxml")){
                System.out.println("Importing xml...");

                //Create an unstructured node under which to import the XML
                Node node = root.addNode("importxml","nt:unstructured");

                //Import the file "test.xml" under the above node
                FileInputStream xml = new FileInputStream(absolutePathToFile("test.xml"));
                session.importXML(node.getPath(), xml, ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
                xml.close();
                session.save();
                System.out.println("done");
            }

            dump(root);
        }finally {
            session.logout();
        }
    }

    private void dump(Node node) throws RepositoryException {
        System.out.println(node.getPath());
        if(node.getName().equals("jcr:system")){
            return;
        }

        PropertyIterator properties = node.getProperties();
        while (properties.hasNext()){
            Property property = properties.nextProperty();
            if(property.getDefinition().isMultiple()){
                Value[] values = property.getValues();
                for(int i = 0 ; i < values.length ; i++){
                    System.out.println(property.getPath() + " = " + values[i].getString());
                }
            }else{
                System.out.println(property.getPath() + " = " + property.getString());
            }
        }

        NodeIterator nodes = node.getNodes();
        while (nodes.hasNext()){
            dump(nodes.nextNode());
        }
    }
}
