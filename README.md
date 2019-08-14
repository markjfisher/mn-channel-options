# Channel Options Bug Illustration

## Works

Run the application with:

    ./gradlew run

And connect to http://localhost:8080/foo

You will see the message "Bar!" in the browser, as the foo client calls the bar endpoint.

## Throws ClassCastException

Run the application with:

    MICRONAUT_HTTP_SERVICES_FOO_CHANNEL_OPTIONS_SO_KEEPALIVE=false ./gradlew run

Connect to http://localhost:8080/foo

Log throws this error:

```text
09:50:58.941 [pool-1-thread-3] WARN  io.netty.bootstrap.Bootstrap - Failed to set channel option 'SO_KEEPALIVE' with value 'false' for channel '[id: 0xb17f9238]'
java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Boolean (java.lang.String and java.lang.Boolean are in module java.base of loader 'bootstrap')
        at io.netty.channel.socket.DefaultSocketChannelConfig.setOption(DefaultSocketChannelConfig.java:112)
        at io.netty.channel.socket.nio.NioSocketChannel$NioSocketChannelConfig.setOption(NioSocketChannel.java:488)
        at io.netty.bootstrap.AbstractBootstrap.setChannelOption(AbstractBootstrap.java:445)
        at io.netty.bootstrap.AbstractBootstrap.setChannelOptions(AbstractBootstrap.java:430)
        at io.netty.bootstrap.Bootstrap.init(Bootstrap.java:265)
        at io.netty.bootstrap.AbstractBootstrap.initAndRegister(AbstractBootstrap.java:310)
        at io.netty.bootstrap.Bootstrap.doResolveAndConnect(Bootstrap.java:159)
        at io.netty.bootstrap.Bootstrap.connect(Bootstrap.java:143)
        at io.netty.bootstrap.Bootstrap.connect(Bootstrap.java:127)
        at io.micronaut.http.client.DefaultHttpClient.doConnect(DefaultHttpClient.java:1247)
        at io.micronaut.http.client.DefaultHttpClient.doConnect(DefaultHttpClient.java:1202)
        at io.micronaut.http.client.DefaultHttpClient.doConnect(DefaultHttpClient.java:1175)
        at io.micronaut.http.client.DefaultHttpClient.lambda$null$27(DefaultHttpClient.java:1020)
        at io.reactivex.internal.operators.flowable.FlowableCreate.subscribeActual(FlowableCreate.java:71)
        ...
```