import { Component, OnInit } from '@angular/core';
import { ApplicationService } from 'src/app/core/services/Enduser/application.service';
import { Subscription } from 'rxjs';
import { Application } from 'src/app/core/models/Enduser/application.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
	selector: 'app-details-page',
	templateUrl: './details-page.component.html',
	styleUrls: ['./details-page.component.less']
})
export class DetailsPageComponent implements OnInit {

	appid: number;
	subscription: Subscription;
	application: Application;

	constructor(private appSvc: ApplicationService, private route: ActivatedRoute) { }

	ngOnInit() {
		this.subscription = this.appSvc.data.subscribe(x => {
			this.appid = +this.route.snapshot.paramMap.get('id');
			this.application = x[this.appid];
		})
	}

}
