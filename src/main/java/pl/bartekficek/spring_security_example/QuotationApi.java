package pl.bartekficek.spring_security_example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("The greatest glory in living lies not in never falling, but in rising every time we fall","Nelson Mandela"));
        quotations.add(new Quotation("The way to get started is to quit talking and begin doing.","Walt Disney"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotationList() {
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public Quotation deleteQuotation(@RequestParam int id){
        return quotations.remove(id);
    }
}
