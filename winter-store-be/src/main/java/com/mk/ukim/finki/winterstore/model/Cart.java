package com.mk.ukim.finki.winterstore.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Enumerated(EnumType.STRING)
//    private CartStatus status = CartStatus.CREATED;

    private LocalDateTime createDate = LocalDateTime.now();

    @OneToOne
    private UserDetailed userDetailed;

    @OneToMany(cascade = CascadeType.ALL)
    Set<CartItem> cartItems = new HashSet<>();

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public UserDetailed getUserDetailed() {
        return userDetailed;
    }

    public void setUserDetailed(UserDetailed userDetailed) {
        this.userDetailed = userDetailed;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItemToCart(CartItem cartItem){
        this.cartItems.add(cartItem);
    }

    public void removeItemFromCart(CartItem cartItem){ this.cartItems.remove(cartItem);}
}
