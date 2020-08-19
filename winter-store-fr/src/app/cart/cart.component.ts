import {ChangeDetectorRef, Component, ElementRef, Inject, OnInit, ViewChild} from '@angular/core';
import {CartService} from '../services/CartService';
import {MatTableDataSource} from '@angular/material/table';
import {CartItem} from '../model/cart-item';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {StripePaymentComponent} from '../stripe-payment/stripe-payment.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  dataSource;
  displayedColumns: string[];
  totalPrice = 0;

  constructor(private cartService: CartService,
              private http: HttpClient,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.displayedColumns = ['position', 'tutor', 'subject', 'price', 'action'];
    this.getCartItemsForSignedInUser();
  }

  getCartItemsForSignedInUser() {
    this.cartService.getCartItemsForSignedInUser()
      .subscribe((response: CartItem[]) => {
        this.totalPrice = 0;
        this.dataSource = new MatTableDataSource(response);
        for (let item of response) {
          this.totalPrice += item.price;
        }
      });
  }

  deleteCartItem(cartItem: CartItem) {
    this.cartService.deleteCartItem(cartItem)
      .subscribe(response => {
        this.getCartItemsForSignedInUser();
      });
  }

  checkout() {
    const dialogRef = this.dialog.open(StripePaymentComponent, {
      // opening dialog here which will give us back stripeToken
      data: {totalAmount: this.totalPrice},
    });
    dialogRef.afterClosed()
      // waiting for stripe token that will be given back
      .subscribe((result: any) => {
        if (result) {
          this.createOrder(result.token.id);
        }
      });
  }

  createOrder(token: number){

  }
}
