package com.example.first.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public Customer addCustomer( @RequestParam(value = "id") Integer id,@RequestParam(value = "first") String first, @RequestParam(value = "last") String last)
    {
        Customer customer = new Customer(id, first, last);
//        customer.setFirstName(first);
//        customer.setLastName(last);
        customerRepository.save(customer);
        return customerRepository.save(customer);

    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomer()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id)
    {
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id)
    {
        customerRepository.deleteById(id);
        return "Customer Deleted!!";
    }

}
