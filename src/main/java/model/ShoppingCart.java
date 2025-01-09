/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import observer.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import observer.*;
/**
 *
 * @author brunomnsilva
 */
public class ShoppingCart extends Subject {
    
    private String name;
    private List<Product> products;

    public ShoppingCart(String name) {
        this.name = name;
        products = new ArrayList<>();
    }
    
    public void addProduct(Product p) {
        products.add(p);
        notifyObservers(this);
    }

    public void addProduct(int id) throws ShoppingCartException{
        Product p= ProductListFactory.createProduct(id);
        addProduct(p);
    }
    
    public void removerProduct(Product p) throws ShoppingCartException{
        if(p==null) throw new ShoppingCartException("Nenhum produto selecionado");
        products.remove(p);
        this.notifyObservers(this);
    }
    public Product lastProductAdded(){
          return products.get(products.size()-1);

    }
    public String getName() {
        return name;
    }
    
    public Collection<Product> getProducts() {
        return products;
    }

    public float getTotal() {
        float total=0.0f;
        for(Product p: products)
            total+=p.getCost();
        return total;
    }

    public void checkShopCarPrice(double maxPrice) {
        if (this.getTotal() > maxPrice)
            throw new ShoppingCartException("Valor total do carrinho ultrapassa o limite de preço permitido");
    }
}
