package  com.ko.groovy

import org.vertx.java.platform.Verticle

class HelloMongo  extends Verticle{

    @Override
    def void start(){
        def log = container.logger();
        def server = vertx.createHttpServer()
        def hello = new  HelloRouter()

        server.requestHandler(hello)
        server.listen(8877, "0.0.0.0")
        log.info("Start 0.0.0.0 @8877")
    }
}