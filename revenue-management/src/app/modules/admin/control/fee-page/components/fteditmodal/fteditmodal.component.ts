import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { FeeType } from 'src/app/core/models/feetype.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzModalRef } from 'ng-zorro-antd';
import { ClassService } from 'src/app/core/services/class.service';
import { PartService } from 'src/app/core/services/part.service';
import { RevenueheadService } from 'src/app/core/services/revenuehead.service';
import { StudenttypeService } from 'src/app/core/services/studenttype.service';
import { RevenueHead } from 'src/app/core/models/revenuehead.model';
import { StudentType } from 'src/app/core/models/student.model';
import { Class } from 'src/app/core/models/class.model';
import { Part } from 'src/app/core/models/part.model';
import { Subscription } from 'rxjs';

@Component({
	selector: 'app-fteditmodal',
	templateUrl: './fteditmodal.component.html',
	styleUrls: ['./fteditmodal.component.less']
})
export class FteditmodalComponent implements OnInit, OnDestroy {

	@Input() id: number;
	@Input() feeType: FeeType;

	editForm: FormGroup;
	revenueHeads: Array<RevenueHead> = [];
	studentTypes: Array<StudentType> = [];
	classes: Array<Class> = [];
	parts: Array<Part> = [];
	private subscriptions: Array<Subscription> = [];

	constructor(private fb: FormBuilder, private modalRef: NzModalRef<FteditmodalComponent>, private clsSvc: ClassService, private ptSvc: PartService, private rhSvc: RevenueheadService, private stTypeSvc: StudenttypeService) { }


	ngOnInit() {
		this.subscriptions[0] = this.rhSvc.data.subscribe(x => this.revenueHeads = x)
		this.subscriptions[1] = this.stTypeSvc.data.subscribe(x => this.studentTypes = x)
		this.subscriptions[2] = this.clsSvc.data.subscribe(x => this.classes = x)
		this.subscriptions[3] = this.ptSvc.data.subscribe(x => this.parts = x)
		this.editForm = this.fb.group({
			name: [{ value: this.feeType.feetype, disabled: true }, [Validators.required]],
			revenueHead: [this.feeType.revenueHead, [Validators.required]],
			studentTypes: [[...this.feeType.studentTypes], [Validators.required]],
			classes: [[...this.feeType.classes]],
			parts: [[...this.feeType.parts]],
			amount: [this.feeType.amount, [Validators.required]]
		});
	}

	onOk() {
		if (this.editForm.valid)
			this.modalRef.close({
				id: this.id,
				feetype: this.feeType.feetype,
				revenueHead: this.editForm.controls['revenueHead'].value,
				studentType: this.editForm.controls['studentTypes'].value,
				classes: this.editForm.controls['classes'].value,
				parts: this.editForm.controls['parts'].value,
				amount: this.editForm.controls['amount'].value
			});
	}

	onCancel() {
		this.modalRef.triggerCancel();
		this.subscriptions.forEach(x => x.unsubscribe());
	}

	ngOnDestroy() {
	}
}
