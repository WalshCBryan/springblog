package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse(@PathVariable String string) {
        String rev = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            rev += string.charAt(i);
        }
        return rev;
    }

    @GetMapping("/string/uppercase/{string}")
    @ResponseBody
    public String uppercase(@PathVariable String string) {
        String upper = "";
        upper = string.toUpperCase();
        return upper;
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String bothReversedAndUppercase(@PathVariable String string) {
        String rev = reverse(string);
        String revUpper = uppercase(rev);
        return revUpper;
    }



// (for example... "/string/steve?reverse=true&caps=false" should return "evets")

    @RequestMapping(value = "string/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String stringManipulation(
            @PathVariable String string,
            @RequestParam(value = "reverse", required = false) boolean reverse,
            @RequestParam(value = "caps", required = false) boolean caps) {
        if (caps && reverse) {
            return bothReversedAndUppercase(string);
        } else if (caps) {
            return uppercase(string);
        } else if (reverse) {
            return reverse(string);
        } else {
            return string;
        }
    }

    @RequestMapping(value="**")
    @ResponseBody
    public String respondToAllOther() {
        return "this URI is not supported.";
    }

    @RequestMapping(value="/wildcard/" + "**")
    @ResponseBody
    public String respondToAllOtherWildcards() {
        return "this wildcard URI is not supported.";
    }

}
