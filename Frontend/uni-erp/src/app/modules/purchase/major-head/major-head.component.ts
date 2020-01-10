import { MajorHead } from './../../../core/models/Purchase/major-head';
import { MajorHeadService } from './../../../core/services/Purchase/major-head.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { MajorHeadAddModalComponent } from './components/major-head-add-modal/major-head-add-modal.component';
import { MajorHeadEditModalComponent } from './components/major-head-edit-modal/major-head-edit-modal.component';

@Component({
  selector: 'app-major-head',
  templateUrl: './major-head.component.html',
  styleUrls: ['./major-head.component.less']
})
export class MajorHeadComponent implements OnInit {

	majorHeads: any = [];
	loading: boolean = false;
  constructor(private modalSvc: NzModalService, private majorHeadService: MajorHeadService,private message: NzMessageService) { }

  ngOnInit() {
		this.getAllMajorHead();
  }
  onModalCancel() {
			this.getAllMajorHead();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Major Head",
			nzContent: MajorHeadAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(majorHead: MajorHead) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Major Head",
			nzContent: MajorHeadEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				majorHd: majorHead
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getAllMajorHead(){
		this.majorHeadService.getAllMajorHead().subscribe(
				data => {
						this.majorHeads = data;
						// console.log("data")


				},
				error => {
					// console.log("error")
					if(error['status']=='404'){
						this.majorHeads = [];
					}
						else if(error.error){
						this.majorHeads = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteMajorHead(id: number){
		this.majorHeadService.deleteMajorHead(id).subscribe(
			data =>{
				this.message.create('success', `Major Head Deleted Successfully!`);
				this.getAllMajorHead();
			},
			error=> {
				this.message.create('error', `Major Head Not Deleted!`);
				this.getAllMajorHead();
			}
		);

	}
}
