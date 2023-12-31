package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/*")
public class ResolverController {

    @GetMapping("string") //요청 리소스는 소문자로 한다 글자간의 연결은-처리를 함
    public String stirngReturing(Model model){
        model.addAttribute("forwardMessage","문자열로 뷰 이름 반환함.");
        /* 문자열로 뷰 이름을 반환한다는 것은 반환 후
        * thymeleaftviewResolver에게 Resources/template/를 prefix로 .html을 suffix로 설정 하여
        * resources/template/result.html 파일로 응답 뷰로 설정하라는 의미가 된다.
        * */
        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(){
        /* 접두사로 redirect:를 하면 forward가 아닌 redirect 시킨다.*/
        return "redirect:/";
    }

    /* 기본적으로 redirect시에는 재요청이 발생하므로 request scope는 소멸된다
    * 하지만 스프링에서는 RedirectAttributes 타입을 통해 redirect 시 속성 값을 저장할 수 있도록 하는 기능을 제공한다.*/

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr){
        /* 리타이렉트 시 flash 영역에 담아서 redirect 할 수 있다.
        * 자동으로 모델에 추가되기 때문에 requestScope에서 값을 꺼내면 된다.
        * 세션에 임시로 값을 담고 소멸하는 방식이기 때문에 session에 동일한 키 값이 존재하지 않아야 한다.
        * */
        rttr.addFlashAttribute("flashMessage1","redirect attr 사용하여 redirect");
        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndView(ModelAndView mv){
        mv.addObject("forwardMessage", "modelAndView를 이용한 모델과 뷰 반환");
        mv.setViewName("result");
        return mv;
    }


    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr){
        rttr.addFlashAttribute("flashMessage2", "ModelAndView를 이용한 attr");
        mv.setViewName("redirect:/");
        return mv;
    }
}
