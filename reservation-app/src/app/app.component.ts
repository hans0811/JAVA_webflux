import { Component } from '@angular/core';
import { FormControl, FormGroup} from "@angular/forms";
import {ReservationService} from "./reservation.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private reservationService: ReservationService) {

  }

  rooms: Room[] | undefined;
  roomSearchForm: FormGroup| undefined;

  currentCheckInVal: string | undefined;
  currentCheckOutVal: string | undefined;
  currentPrice: number = 0;
  currentRoomNumber: number = 0;

  ngOnInit() {

    this.roomSearchForm = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl(''),
      roomNumber: new FormControl('')
    });

    this.roomSearchForm.valueChanges.subscribe(
      form => {
        this.currentCheckInVal = form.checkinl;
        this.currentCheckOutVal = form.checkout;

        if(form.roomNumber){
          let roomValues: string[] = form.roomNumber.split('|');
          this.currentRoomNumber = Number(roomValues[0]);
          this.currentPrice = Number(roomValues[1]);
        }

      })

    this.rooms = [ new Room("127", "127", "150"),
      new Room("127", "138", "180"),
      new Room("254", "254", "200")
    ]
  }
}

export class Room {
  id: string;
  roomNumber: string;
  price: string;

  constructor(id:string, roomNumber: string, price: string) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }
}
