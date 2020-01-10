import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject(false);
  constructor() { }

  login(){
    this.isLoggedIn.next(true);

  }
}
