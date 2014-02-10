package org.jboss.examples.springmvc.stack.hibernateorm.web;

import org.jboss.examples.springmvc.stack.api.SuperWebController;
import org.jboss.examples.springmvc.stack.api.ContactService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by ecervena on 1/31/14.
 */
@Controller
@RequestMapping(value = "hibernate")
public class HibernateServiceController extends SuperWebController {

    @Inject
    @Qualifier(value = "hbnContactServiceImpl")
    private ContactService service;
}
