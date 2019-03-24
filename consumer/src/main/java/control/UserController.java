package control;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    /**
     * 第一种配置方式
     *
     * @return
     */
    @RequestMapping("/showname")
    @ResponseBody
    public String showName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvc.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        return userService.getName();
    }

    /**
     * 第二种配置方式
     * @return
     */
    @RequestMapping("/showname1")
    @ResponseBody
    public String showName1() {
        return userService.getName();
    }


    @RequestMapping("/t")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.jsp");
        return mav;
    }

    @RequestMapping("/hello")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "WEB-INF/hello/hello.jsp";
    }
}
