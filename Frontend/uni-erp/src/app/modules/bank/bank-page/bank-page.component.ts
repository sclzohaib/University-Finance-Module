import { Component, OnInit, OnDestroy } from '@angular/core';
import { Revenue } from 'src/app/core/models/revenue.model';
import { RevenueService } from 'src/app/core/services/revenue.service';
import { Subscription } from 'rxjs';

@Component({
	selector: 'app-bank-page',
	templateUrl: './bank-page.component.html',
	styleUrls: ['./bank-page.component.less']
})
export class BankPageComponent implements OnInit, OnDestroy {

	revenueData: Array<Revenue> = [];
	private _revenueData: Array<Revenue> = [];

	criteria: string = null;
	subscriptions: Array<Subscription> = [];

	constructor(private revSvc: RevenueService) { }

	ngOnInit() {
		this.subscriptions[0] = this.revSvc.data.subscribe(x => {
			this._revenueData = x;
			this.revenueData = this._revenueData;
		});
	}
  pay(){
console.log("abc");
  }

	search() {
		if(this.criteria)
		this.revenueData = this._revenueData.filter(x => x.studentCnic === this.criteria);
		else this.revenueData = this._revenueData.map(x => x);
	}

	ngOnDestroy() {
		this.subscriptions.forEach(x => x.unsubscribe());
	}


}
