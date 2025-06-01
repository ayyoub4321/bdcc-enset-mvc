package net.ayyoub.bdccensetmvc.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import net.ayyoub.bdccensetmvc.entities.Product;
import net.ayyoub.bdccensetmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository prosuctRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/user/index")
    public String index(Model model) {
        List<Product> products=prosuctRepository.findAll();
        model.addAttribute("productList", products);
        return "products";
    }
    @GetMapping("/")
    public String home(Model model) {

        return "redirect:/user/index";
    }
    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { return "newProduct"; }
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }
    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "/notAuthorized";
    }
    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
@GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
