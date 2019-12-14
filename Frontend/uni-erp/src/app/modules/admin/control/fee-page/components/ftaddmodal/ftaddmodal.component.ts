import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { FeeType } from 'src/app/core/models/feetype.model';
import { NzModalRef } from 'ng-zorro-antd';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
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
	selector: 'app-ftaddmodal',
	templateUrl: './ftaddmodal.component.html',
	styleUrls: ['./ftaddmodal.component.less']
})
export class FtaddmodalComponent implements OnInit, OnDestroy {

	revenueHeads: Array<RevenueHead> = [];
	studentTypes: Array<StudentType> = [];
	classes: Array<Class> = [];
	parts: Array<Part> = [];
	addForm: FormGroup;
	private subscriptions: Array<Subscription> = [];

	@Input() feeTypes: Array<FeeType>;

	constructor(private fb: FormBuilder, private modalRef: NzModalRef<FtaddmodalComponent>, private clsSvc: ClassService, private ptSvc: PartService, private rhSvc: RevenueheadService, private stTypeSvc: StudenttypeService) { }

	ngOnInit() {
		this.subscriptions[0] = this.rhSvc.data.subscribe(x => this.revenueHeads = x)
		this.subscriptions[1] = this.stTypeSvc.data.subscribe(x => this.studentTypes = x)
		this.subscriptions[2] = this.clsSvc.data.subscribe(x => this.classes = x)
		this.subscriptions[3] = this.ptSvc.data.subscribe(x => this.parts = x)
		this.addForm = this.fb.group({
			name: ['', [Validators.required, duplicateValidator(this.feeTypes.map(x => x.feetype))]],
			revenueHead: [null, [Validators.required]],
			studentTypes: [[], [Validators.required]],
			classes: [[]],
			parts: [[]],
			amount: [null, [Validators.required]]
		})
	}

	onOk() {
		if (this.addForm.valid)
			this.modalRef.close({
				feetype: this.addForm.controls['name'].value,
				revenueHead: this.addForm.controls['revenueHead'].value,
				studentTypes: this.addForm.controls['studentTypes'].value,
				classes: this.addForm.controls['classes'].value,
				parts: this.addForm.controls['parts'].value,
				amount: this.addForm.controls['amount'].value
			});
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	ngOnDestroy() {
		this.subscriptions.forEach(x => x.unsubscribe());
	}

}
