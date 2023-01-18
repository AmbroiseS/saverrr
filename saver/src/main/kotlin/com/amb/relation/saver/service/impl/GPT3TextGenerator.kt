package com.amb.relation.saver.service.impl

import com.amb.relation.saver.service.TextGenerator
import com.theokanning.openai.OpenAiService
import com.theokanning.openai.completion.CompletionRequest
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class GPT3TextGenerator : TextGenerator {

    @Value("\${openai.token}")
    private lateinit var token: String
    private lateinit var service: OpenAiService
    private val models = listOf<String>("ada", "babbage", "curie", "davinci")

    @PostConstruct
    private fun init() {
        service = OpenAiService(token)
    }

    override fun generateMessageForSO(list: List<String>): String {
        return service.createCompletion(createCompletionRequest(list)).choices[0].text
    }

    private fun createCompletionRequest(inputs: List<String>): CompletionRequest {
        return CompletionRequest.builder()
            .prompt("Write a line to compare my girlfriend to the sea.\n")
            .model(models[0])
            .maxTokens(20)
            .temperature(0.2)
            .frequencyPenalty(0.1)
            .echo(true)
            .build()
    }
}