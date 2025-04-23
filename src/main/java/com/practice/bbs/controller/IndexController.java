package com.practice.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * トップ画面の表示を担当するコントローラクラス
 */
@Controller
public class IndexController {

    /**
     * トップ画面を表示する
     * 
     * @return index.html
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
