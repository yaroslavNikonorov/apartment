package apartment.support;

import apartment.annotation.CookieAsObject;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yar on 6/18/14.
 */
@Component
public class CookieAsObjectArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ListableBeanFactory listableBeanFactory;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CookieAsObject.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        CookieAsObject annotation = methodParameter.getParameterAnnotation(CookieAsObject.class);
        if (annotation != null) {
            HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(annotation.value())) {
                    Repositories repositories = new Repositories(listableBeanFactory);
                    CrudRepository repository = (CrudRepository) repositories.getRepositoryFor(methodParameter.getParameterType());
                    return repository.findOne(Long.parseLong(cookie.getValue()));
                }
            }
        }
        return null;
    }
}
