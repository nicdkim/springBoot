package com.ohgiraffers.chap08securitysession.user.controller;

import com.ohgiraffers.chap08securitysession.user.dto.SignUpDTO;
import com.ohgiraffers.chap08securitysession.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public ModelAndView signup(ModelAndView mv) {
        mv.setViewName("user/signup");
        return mv;
    }

    @PostMapping("signup")
    public String signup(SignUpDTO signUpDTO, RedirectAttributes redirectAttributes) {
        int result = userService.regist(signUpDTO);
        String message;

        if(result > 0) {
            message = "회원 가입이 완료 되었습니다.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/auth/login";
        } else {
            message = "회원 가입에 실패 하였습니다.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/user/signup";
        }
    }
}
