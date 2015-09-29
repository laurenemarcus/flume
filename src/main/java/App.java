import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/landing.vtl");
    }, new VelocityTemplateEngine());

    get("/pictures", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/pictures.vtl");
    }, new VelocityTemplateEngine());
  }
}
