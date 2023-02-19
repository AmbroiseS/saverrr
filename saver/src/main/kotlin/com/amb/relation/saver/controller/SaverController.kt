package com.amb.relation.saver.controller

import com.amb.relation.saver.service.TextGenerator
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class SaverController {
    var logger = LoggerFactory.getLogger(SaverController::class.java)

    @Autowired
    private lateinit var generator: TextGenerator


    @GetMapping("/health")
    @ResponseBody
    fun greeting(): String? {
        logger.info("health")
        return "Hello, World"
    }

    @GetMapping("/gen")
    fun getMessage(): Saverrr {
        return Saverrr(message = generator.generateMessageForSO(emptyList()))
    }

}

data class Saverrr(var message: String)