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
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';
import { FeetypeService } from 'src/app/core/services/feetype.service';
import { FeeType } from 'src/app/core/models/feetype.model';


@Component({
	selector: 'app-voucher-modal',
	templateUrl: './voucher-modal.component.html',
	styleUrls: ['./voucher-modal.component.less']
})
export class VoucherModalComponent implements OnInit, OnDestroy {

	revenueHeads: Array<RevenueHead> = [];
	studentTypes: Array<StudentType> = [];
	departments: Array<Department> = [];
	classes: Array<Class> = [];
	parts: Array<Part> = [];
	feeTypes: Array<FeeType> = [];
	voucherForm: FormGroup;
	private subscriptions: Array<Subscription> = [];
	index: number = 1;
	stepStatus: string = 'wait';
	base64: string;


	constructor(private fb: FormBuilder, private modalRef: NzModalRef<FtaddmodalComponent>, private clsSvc: ClassService, private depSvc: DepartmentService, private ptSvc: PartService, private rhSvc: RevenueheadService, private stTypeSvc: StudenttypeService, private fTSvc: FeetypeService) { }

	ngOnInit() {
		this.subscriptions[0] = this.rhSvc.data.subscribe(x => this.revenueHeads = x)
		this.subscriptions[1] = this.stTypeSvc.data.subscribe(x => this.studentTypes = x)
		this.subscriptions[2] = this.depSvc.data.subscribe(x => this.departments = x)
		this.subscriptions[3] = this.clsSvc.data.subscribe(x => this.classes = x)
		this.subscriptions[4] = this.ptSvc.data.subscribe(x => this.parts = x)
		this.subscriptions[5] = this.fTSvc.data.subscribe(x => this.feeTypes = x)
		this.voucherForm = this.fb.group({
			name: [null, [Validators.required]],
			fatherName: [null, [Validators.required]],
			cnic: [null, [Validators.required]],
			enrolNum: [null, [Validators.required]],
			seatNum: [null, []],
			mobileNum: [null, [Validators.required]],
			shift: [null],
			revenueHead: [null, [Validators.required]],
			studentType: [null, [Validators.required]],
			department: [null, [Validators.required]],
			class: [null, [Validators.required]],
			part: [null, [Validators.required]],

		});

		// this.voucherGenerate({
		// 	revenueHead: "5502",
		// 	department: "Computer Science",
		// 	studentType: "Private",
		// 	clas: "MS",
		// 	part: "Part One",
		// 	name: "asd",
		// 	shift: "asd",
		// 	fatherName: "asd",
		// 	cnic: "134123121222",
		// 	enrolNum: "asd/asd/asd/13412",
		// 	seatNum: "asd",
		// 	mobileNum: "03353435235"
		// })
	}

	move(where: number) {
		if (this.voucherForm.valid) {
			this.stepStatus = 'finished';
			(where) ? this.index += 1 : this.index -= 1;
		}
		else {
			this.stepStatus = 'error';
			(where) ? this.index += 1 : this.index -= 1;
		}
	}

	done() {
		if (this.voucherForm.valid) {
			this.voucherGenerate({
				revenueHead: this.voucherForm.controls['revenueHead'].value,
				department: this.voucherForm.controls['department'].value,
				studentType: this.voucherForm.controls['studentType'].value,
				clas: this.voucherForm.controls['class'].value,
				part: this.voucherForm.controls['part'].value,
				name: this.voucherForm.controls['name'].value,
				shift: this.voucherForm.controls['shift'].value,
				fatherName: this.voucherForm.controls['fatherName'].value,
				cnic: this.voucherForm.controls['cnic'].value,
				enrolNum: this.voucherForm.controls['enrolNum'].value,
				seatNum: this.voucherForm.controls['seatNum'].value,
				mobileNum: this.voucherForm.controls['mobileNum'].value
			});
			this.modalRef.close();
		}
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	inWords(num: number): string {
		let a = ['', 'One ', 'Two ', 'Three ', 'Four ', 'Five ', 'Six ', 'Seven ', 'Eight ', 'Nine ', 'Ten ', 'Eleven ', 'Twelve ', 'Thirteen ', 'Fourteen ', 'Fifteen ', 'Sixteen ', 'Seventeen ', 'Eighteen ', 'Nineteen '];
		let b = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'];

		if ((num.toString()).length > 9) return 'overflow';
		let n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
		if (!n) return; var str = '';
		str += (+n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
		str += (+n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'Lac' : '';
		str += (+n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'Thousand ' : '';
		str += (+n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'Hundred ' : '';
		str += (+n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) : '';
		str += 'rupees only'
		return str;
	}



	voucherGenerate(value: {
		revenueHead,
		department,
		studentType,
		clas,
		part,
		name,
		shift,
		fatherName,
		cnic,
		enrolNum,
		seatNum,
		mobileNum
	}) {

		let feeType = this.feeTypes.find(x => {
			if (x.revenueHead === value.revenueHead)
				if (x.studentTypes.includes(value.studentType)) {
					if (x.classes.includes(value.clas) || x.classes.length === 0)
						if (x.parts.includes(value.part) || x.parts.length === 0) {
							return true;

						}
				}
		})

		var columns = this.generateRow("UNIVERSITY OF KARACHI");
		var rows = [
			this.generateRow("Bank Branch & Code  ___________________", { halign: 'center' }),
			this.generateRow(`Voucher #  233942                      Generated On:  ${new Date().toDateString()}`, { fontStyle: 'bold' }),
			this.generateRowEach("Department Copy", "Depositor Copy", "Finance Copy", "Bank Copy", { halign: 'center', fontStyle: 'bold' }),
			this.generateRow(`${this.revenueHeads.find(x => x.code === value.revenueHead).name} (${value.revenueHead})`),
			this.generateRow(`${value.studentType} Student`, { halign: 'center' }),
			this.generateRow(`${value.shift ? value.shift : ''}`),
			this.generateRow("Payment Date:  ____________________", { halign: 'right' }),
			this.generateRow(`Name:  ${value.name}`),
			this.generateRow(`Father's Name:  ${value.fatherName}`),
			this.generateRow(`Student's CNIC #:  ${value.cnic}`),
			this.generateRow(`Enrollment #:  ${value.enrolNum}`),
			this.generateRow(`Seat #:  ${value.seatNum}`),
			this.generateRow(`Mobile/Contact #:  ${value.mobileNum}`),
			this.generateRow(`Department/Institute:  ${value.department}`),
			this.generateRow(`Fee + Rs.100/= (Processing Fee) Amount:  Rs. ${feeType.amount}/=`),
			this.generateRow(`Fee in words: ${this.inWords(feeType.amount)}`),
			this.generateRow("Note:  Fee is Not Refundable", { halign: 'center', fontSize: 8, fontStyle: 'bold' }),
			this.generateRow("	HBL 00427991786203", { fontStyle: 'bold' }),
			this.generateRow("	MCB 0699158531002556", { fontStyle: 'bold' }),
			this.generateRow("	NBP 4150404421", { fontStyle: 'bold' }),
			this.generateRow("	UBL 254658541", { fontStyle: 'bold' }),
			this.generateRow("	Sindh Bank 37348682000", { fontStyle: 'bold' }),
			this.generateRow("Selected Mode of Payment: "),
			this.generateRow("		Cash", { fontStyle: 'bold' }),
			this.generateRow(""),
			this.generateRow("Depositor's Signature ____________________"),
			this.generateRow("Authorized Signature____________________", { halign: 'right' })
		];

		var doc = new jsPDF('landscape', 'mm', 'a4');
		// doc.text(20, 20, 'New Fees Challan For Students');

		//@ts-ignore
		doc.autoTable(columns, rows, {
			theme: 'grid',
			styles: {
				lineWidth: 0.3
			},
			headStyles: {
				// lineWidth: 1,
				fillColor: 255,
				textColor: 0,
				fontSize: 14,
				halign: 'center',
				valign: 'middle'
			},
			bodyStyles: {
				fontSize: 6,
				textColor: 10
			},
			columnStyles: {
				0: { cellWidth: 67 },
				1: { cellWidth: 67 },
				2: { cellWidth: 67 },
				3: { cellWidth: 67 }
			}
		})
		// doc.save('Voucher.pdf');
		doc.output('dataurlnewwindow');
	}

	generateRow(value: string, styles?: {}): Array<string> | Array<{ content: string, styles: {} }> {
		return (styles) ? [
			{ content: value, styles },
			{ content: value, styles },
			{ content: value, styles },
			{ content: value, styles }
		] : [value, value, value, value];
	}

	generateRowEach(value: string, value1?: string, value2?: string, value3?: string, styles?: {}): Array<string> | Array<{ content: string, styles: {} }> {
		return (styles) ? [
			{ content: value, styles },
			{ content: value1 || value, styles },
			{ content: value2 || value, styles },
			{ content: value3 || value, styles }
		] : [value, value1 || value, value2 || value, value3 || value];
	}

	ngOnDestroy() {
		this.subscriptions.forEach(x => x.unsubscribe());
	}
}
