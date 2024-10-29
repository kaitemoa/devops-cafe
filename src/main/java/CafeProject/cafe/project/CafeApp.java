package CafeProject.cafe.project;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Arrays;

public final class CafeApp {
    public static final void main(final String[] args) {
        CafeApp cafe = new CafeApp();
        cafe.createServer();
    }

    public boolean createServer() {
        try {
            final HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new CafeHandler());
            server.createContext("/login", new LoginHandler());
            server.createContext("/main", new MainHandler());
            server.createContext("/menu", new MenuHandler());
            server.createContext("/contact", new ContactHandler());
            server.createContext("/reviews", new ReviewHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Cafe can be found here: http://localhost:8080/");
            return true;
        } catch (final IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    static class CafeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Cafe Login</title>
                </head>
                <body>
                    <h1>Login to Cafe</h1>
                    <form method="POST" action="/login">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required><br><br>
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required><br><br>
                        <button type="submit">Login</button>
                    </form>
                </body>
                </html>
            """;

            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }


    static class LoginHandler implements HttpHandler {
        private String validUsername = "Spiderman";
        private String validPassword = "123";

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                Map<String, String> formData = parseFormData(exchange);
                String username = formData.get("username");
                String password = formData.get("password");

                if (validUsername.equals(username) && validPassword.equals(password)) {
                    exchange.getResponseHeaders().set("Location", "/main");
                    exchange.sendResponseHeaders(302, -1);
                } else {
                    String response = "<h1>Invalid username or password.</h1><p><a href='/'>Try again</a></p>";
                    exchange.getResponseHeaders().add("Content-Type", "text/html");
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            }
        }

        private Map<String, String> parseFormData(HttpExchange exchange) throws IOException {
            String body = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> formData = new HashMap<>();
            for (String pair : body.split("&")) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    formData.put(keyValue[0], keyValue[1]);
                }
            }
            return formData;
        }
    }

    static class MainHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = """
                <html>
                <body>
                    <h1>Welcome to the Cafe</h1>
                    <p><a href='/menu'>View Menu</a></p>
                    <p><a href='/contact'>Contact Us</a></p>
                    <p><a href='/reviews'>Customer Reviews</a></p>
                </body>
                </html>
                """;
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class MenuHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Menu menu = new Menu();

            String coffeesHtml = "<h2>Coffees:</h2><ul>" +
                    Arrays.stream(menu.getCoffees()).map(item -> "<li>" + item + "</li>").collect(Collectors.joining()) +
                    "</ul>";
            String bakedGoodsHtml = "<h2>Baked Goods:</h2><ul>" +
                    Arrays.stream(menu.getBakedGoods()).map(item -> "<li>" + item + "</li>").collect(Collectors.joining()) +
                    "</ul>";

            String response = "<html><body><h1>Our Menu</h1>" + coffeesHtml + bakedGoodsHtml + "</body></html>";
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class ContactHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            ContactUs contact = new ContactUs();
            String response = "<html><body><h1>Contact Us</h1><p>" + contact.getContactInfo().replace("\n", "<br>") + "</p></body></html>";
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class ReviewHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Review review = new Review();

            String reviewsHtml = "<h2>Customer Reviews:</h2><ul>" +
                    Arrays.stream(review.getReviews()).map(item -> "<li>" + item + "</li>").collect(Collectors.joining()) +
                    "</ul>";

            String response = "<html><body>" + reviewsHtml + "</body></html>";
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
