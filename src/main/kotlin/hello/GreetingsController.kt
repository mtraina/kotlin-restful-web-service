package hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

    @GetMapping("/")
    fun hello() = "hello!"

    @GetMapping("/{name}")
    fun hello(@PathVariable name:String) = "hello $name!"
}