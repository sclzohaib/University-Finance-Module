import { Component, OnInit, OnDestroy } from '@angular/core';
import { Revenue } from 'src/app/core/models/revenue.model';
import { RevenueService } from 'src/app/core/services/revenue.service';
import { Subscription } from 'rxjs';
import { RevenueheadService } from 'src/app/core/services/revenuehead.service';
import { DepartmentService } from 'src/app/core/services/department.service';
import { StudenttypeService } from 'src/app/core/services/studenttype.service';

@Component({
	selector: 'app-revenue-page',
	templateUrl: './revenue-page.component.html',
	styleUrls: ['./revenue-page.component.less']
})
export class RevenuePageComponent implements OnInit, OnDestroy {

	revenueData: Array<Revenue> = [];
	private _revenueData: Array<Revenue> = [];
	selectedDate: Date = null;

	criteria: string = null;
	showByType: number = null;
	selection: string = null;

	showByData = [
		{
			name: 'Month',
			placeholder: 'Select Month'
		},
		{
			name: 'Department',
			placeholder: 'Select Department'
		},
		{
			name: 'Head',
			placeholder: 'Select Revenue Head'
		},
		{
			name: 'Student Type',
			placeholder: 'Select Student Type'
		},
		{
			name: 'Shift',
			placeholder: 'Select Shift'
		}
	]

	selectionData: { [key: string]: string[] } = {
		Month: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
			'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
		],
		Department: [],
		Head: [],
		'Student Type': [],
		Shift: ['Morning', 'Evening']
	};

	subscriptions: Array<Subscription> = [];

	constructor(private revSvc: RevenueService, private rhSvc: RevenueheadService, private deptSvc: DepartmentService, private stTypeSvc: StudenttypeService) { }

	ngOnInit() {
		this.subscriptions[0] = this.deptSvc.data.subscribe(x => this.selectionData['Department'] = x.map(y => y.name));
		this.subscriptions[1] = this.rhSvc.data.subscribe(x => this.selectionData['Head'] = x.map(y => y.name + ` (${y.code})`));
		this.subscriptions[2] = this.stTypeSvc.data.subscribe(x => this.selectionData['Student Type'] = x.map(y => y.name));
		this.subscriptions[3] = this.revSvc.data.subscribe(x => {
			this._revenueData = x;
			this.revenueData = this._revenueData;
		});
	}

	clearFilters() {
		this.showByType = null;
		this.selection = null;
		this.selectionChange(null);
	}

	monthChange(value: Date) {
		this.revenueData = this._revenueData.filter(x => {
			if (value) {
				value.setDate(1);
				return new Date(x.monthYearPaid).toDateString() === value.toDateString();
			}
			else return true;
		});
	}

	selectionChange(value: string) {
		this.revenueData = this._revenueData.filter(x => {
			switch (this.showByType) {
				case 1: {
					return value === x.department;
				}
				case 2: {
					return value === x.revenueHead;
				}
				case 3: {
					return value === x.studentType;
				}
				case 4: {
					return value === x.shift;
				}
				default: {
					return true;
				}
			}
		});
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
