package com.amb.relation.saver.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SaverController {

    @GetMapping("/gen")
    fun getMessage(): String {

        return "First Iteration"
    }


}