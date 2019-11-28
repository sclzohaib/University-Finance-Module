import { Component, OnInit, OnDestroy } from '@angular/core';
import { RevenueHead } from 'src/app/core/models/revenuehead.model';
import { StudentType } from 'src/app/core/models/student.model';
import { Class } from 'src/app/core/models/class.model';
import { Part } from 'src/app/core/models/part.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { NzModalRef } from 'ng-zorro-antd';
import { FtaddmodalComponent } from 'src/app/modules/admin/control/fee-page/components/ftaddmodal/ftaddmodal.component';
import { ClassService } from 'src/app/core/services/class.service';
import { PartService } from 'src/app/core/services/part.service';
import { RevenueheadService } from 'src/app/core/services/revenuehead.service';
import { StudenttypeService } from 'src/app/core/services/studenttype.service';
import { Department } from 'src/app/core/models/department.model';
import { DepartmentService } from 'src/app/core/services/department.service';


@Component({
  selector: 'app-voucher-modal',
  templateUrl: './voucher-modal.component.html',
  styleUrls: ['./voucher-modal.component.less']
})
export class VoucherModalComponent implements OnInit,OnDestroy {

	revenueHeads: Array<RevenueHead> = [];
	studentTypes: Array<StudentType> = [];
  departments:Array<Department>=[];
  classes: Array<Class> = [];
	parts: Array<Part> = [];
	voucherForm: FormGroup;
	private subscriptions: Array<Subscription> = [];
  name:string;
  fatherName:string;
  cnic:string;
  seatNum:string;
  enrolNum:string;
  mobileNum:string;

	index: number = 1;


  
  constructor(private fb: FormBuilder, private modalRef: NzModalRef<FtaddmodalComponent>, private clsSvc: ClassService,private depSvc: DepartmentService, private ptSvc: PartService, private rhSvc: RevenueheadService, private stTypeSvc: StudenttypeService) { }

  ngOnInit() {
    this.subscriptions[0] = this.rhSvc.data.subscribe(x => this.revenueHeads = x)
		this.subscriptions[1] = this.stTypeSvc.data.subscribe(x => this.studentTypes = x)
    this.subscriptions[2] = this.depSvc.data.subscribe(x => this.departments = x)
		this.subscriptions[3] = this.clsSvc.data.subscribe(x => this.classes = x)
		this.subscriptions[4] = this.ptSvc.data.subscribe(x => this.parts = x)
    this.voucherForm = this.fb.group({
			name: ['', [Validators.required]],
      fatherName: ['', [Validators.required]],
      cnic: ['', [Validators.required]],
      enrolNum: ['', [Validators.required]],
      seatNum: ['', [Validators.required]],
      mobileNum: ['', [Validators.required]],
      
      revenueHead: [null, [Validators.required]],
			studentType: [[], [Validators.required]],
      department:[[], [Validators.required]],
      class:[[], [Validators.required]],
			part: [[], [Validators.required]],
			
    })
  }


	pre(): void {
		this.index -= 1;
	}

	next(): void {
		this.index += 1;
	}

	done(): void {
		
		if (this.voucherForm.valid)
			this.modalRef.close({
				revenueHead: this.voucherForm.controls['revenueHead'].value,
        departments:this.voucherForm.controls['departments'].value,
        studentTypes: this.voucherForm.controls['studentTypes'].value,
				classes: this.voucherForm.controls['classes'].value,
				parts: this.voucherForm.controls['parts'].value,
        name: this.voucherForm.controls['name'].value,
        fatherName: this.voucherForm.controls['fatherName'].value,
        cnic: this.voucherForm.controls['cnic'].value,
        enrolNum: this.voucherForm.controls['enrolNum'].value,
        seatNum: this.voucherForm.controls['seatNum'].value,
        mobileNum: this.voucherForm.controls['mobileNum'].value,
        
			});
	}

  onCancel() {
		this.modalRef.triggerCancel();
	}

	ngOnDestroy() {
		this.subscriptions.forEach(x => x.unsubscribe());
	}

}
