import { Component, OnInit } from '@angular/core';

@Component({
	selector: 'app-dues-page',
	templateUrl: './dues-page.component.html',
	styleUrls: ['./dues-page.component.less']
})
export class DuesPageComponent implements OnInit {
	isVisible = false;
	isOkLoading = false;
	value = 1;
	actualFee = 1000;
	waiveAmount = this.actualFee * (this.value / 100);
	sliderMove() {
		this.waiveAmount = this.actualFee * (this.value / 100);

	}
	inputValueChange() {
		this.value = (this.waiveAmount * 100) / this.actualFee;
	}
	finalFee = this.actualFee - this.waiveAmount;
	marks: any = {
		0: '0%',
		25: '25%',
		50: '50%',
		75: '75%',
		100: {
			style: {
				color: '#66b3ff'
			},
			label: '<strong>100%</strong>'
		}
	};
	listOfData = [
		{

			CNIC: '42201-7899029-7',
			parName: 'particular',
			Amount: '0'
		},
	];

	constructor() { }

	ngOnInit() {
	}
	showModal(): void {
		this.isVisible = true;
	}

	handleOk(): void {
		this.isOkLoading = true;
		setTimeout(() => {
			this.isVisible = false;
			this.isOkLoading = false;
		}, 1500);
	}

	handleCancel(): void {
		this.isVisible = false;
	}

}
