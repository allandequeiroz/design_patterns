package dev4.fun.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.PageResult;
import br.com.caelum.vraptor.view.Results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

@Resource
public class ResumeController {

    private HttpServletRequest request;
    private Result result;

    public ResumeController(HttpServletRequest request, Result result) {
        this.request = request;
        this.result = result;
    }

    @Get @Path("/en")
    public void en() {
        configLanguage("en");
    }

    @Get @Path("/pt")
    public void pt() {
        configLanguage("pt");
    }

    private void configLanguage(String language) {
        Locale locale = new Locale(language);
        Config.set(request.getSession(), "javax.servlet.jsp.jstl.fmt.locale", locale);
        Config.set(request.getSession(), "javax.servlet.jsp.jstl.fmt.fallbackLocale", locale);
        ((PageResult)result.use(Results.page())).forwardTo("WEB-INF/jsp/resume/resume.jsp");
    }


}
