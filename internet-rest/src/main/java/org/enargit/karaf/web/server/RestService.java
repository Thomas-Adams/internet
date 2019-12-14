package org.enargit.karaf.web.server;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl;
import org.apache.cxf.transport.http.HttpDestinationFactory;
import org.apache.cxf.transport.servlet.ServletDestinationFactory;
import org.enargit.karaf.web.rest.api.BlogRestService;
import org.enargit.karaf.web.rest.api.MapBlogTagsRestService;
import org.enargit.karaf.web.rest.api.TagRestService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.ext.RuntimeDelegate;

@Component(immediate = true, service = RestService.class)
public class RestService {

    private JAXRSServerFactoryBean serverFactory;

    @Reference
    volatile TagRestService tagRestService;

    @Reference
    volatile BlogRestService blogRestService;

    @Reference
    volatile MapBlogTagsRestService mapBlogTagsRestService;

    @Activate
    public void activate() throws Exception {
        serverFactory = new JAXRSServerFactoryBean();
        RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
        serverFactory.setAddress("/api");
        serverFactory.setServiceBeanObjects(tagRestService, mapBlogTagsRestService, blogRestService);
        serverFactory.setProvider(new JacksonJsonProvider());

        final ServletDestinationFactory destinationFactory = new ServletDestinationFactory();
        final Bus bus = serverFactory.getBus();
        bus.setExtension(destinationFactory, HttpDestinationFactory.class);

        final JAXRSBindingFactory factory = new JAXRSBindingFactory();
        factory.setBus(bus);

        final BindingFactoryManager manager = bus.getExtension(BindingFactoryManager.class);
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
        serverFactory.create();
    }

    @Deactivate
    public void deactivate() throws Exception {
        if (serverFactory != null) {
            serverFactory.getServer().destroy();
        }
    }

}
