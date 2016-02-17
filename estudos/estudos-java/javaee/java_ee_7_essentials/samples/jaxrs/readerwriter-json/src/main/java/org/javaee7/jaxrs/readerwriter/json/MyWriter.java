package org.javaee7.jaxrs.readerwriter.json;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * @author Arun Gupta
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MyWriter implements MessageBodyWriter<MyObject> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return MyObject.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(MyObject t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        // As of JAX-RS 2.0, the method has been deprecated and the 
        // value returned by the method is ignored by a JAX-RS runtime. 
        // All MessageBodyWriter implementations are advised to return -1 from 
        // the method.
        
        return -1;
    }

    @Override
    public void writeTo(MyObject t, 
                Class<?> type, 
                Type type1, 
                Annotation[] antns, 
                MediaType mt, 
                MultivaluedMap<String, Object> mm, 
                OutputStream out) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(out);
        gen.writeStartObject()
                .write("name", t.getName())
                .write("age", t.getAge())
                .writeEnd();
        gen.flush();
    }
}