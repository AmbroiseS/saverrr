package com.amb.relation.saver.controller

import com.amb.relation.saver.service.TextGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SaverController {
    @Autowired
    private lateinit var generator: TextGenerator

    @GetMapping("/gen")
    fun getMessage(): Saverrr {
        return Saverrr(message = generator.generateMessageForSO(emptyList()))
    }

}

data class Saverrr(var message: String)