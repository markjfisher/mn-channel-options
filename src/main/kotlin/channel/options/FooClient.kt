package channel.options

import io.micronaut.http.client.annotation.Client
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Client("foo")
interface FooClient {
    @Get("/bar")
    fun bar(): String
}

