package YearUp.pluralsight.NorthwindTradersAPI.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String home(@RequestParam(value = "country", defaultValue = "World") String country)
    {
        return "Hello " + country;
    }
}