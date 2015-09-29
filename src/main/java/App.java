import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/landing.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/form", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/pictures", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/pictures.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/greeting_card", (request, response) -> {
      HashMap model = new HashMap();
      String recipient = request.queryParams("recipient");
      String sender = request.queryParams("sender");
      model.put("recipient", recipient);
      model.put("sender", sender);
      model.put("template", "templates/greeting_card.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
