import { Component, OnInit } from '@angular/core';
import {CartService} from '../services/CartService';
import {MatTableDataSource} from '@angular/material/table';
import {CartItem} from '../model/cart-item';
import {Timeslot} from '../model/timeslot';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  dataSource;
  displayedColumns: string[];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.displayedColumns = ['position', 'tutor', 'subject', 'price', 'action'];
    this.getCartItemsForSignedInUser()
  }

  getCartItemsForSignedInUser(){
    this.cartService.getCartItemsForSignedInUser()
      .subscribe((response: CartItem[]) => {
        this.dataSource = new MatTableDataSource(response);
      })
  }

  deleteCartItem(cartItem: CartItem){
    this.cartService.deleteCartItem(cartItem)
      .subscribe(response => {
        this.getCartItemsForSignedInUser();
      })
  }

}
