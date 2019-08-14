package channel.options

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/foo")
class FooController(private val client: FooClient) {
    @Get("/")
    fun index(): String {
        return client.bar()
    }
}