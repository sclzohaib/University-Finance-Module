import { Gst } from './../../../core/models/Purchase/gst';
import { GstService } from './../../../core/services/Purchase/gst.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { GstAddModalComponent } from './components/gst-add-modal/gst-add-modal.component';
import { GstEditModalComponent } from './components/gst-edit-modal/gst-edit-modal.component';

@Component({
  selector: 'app-gst',
  templateUrl: './gst.component.html',
  styleUrls: ['./gst.component.less']
})
export class GstComponent implements OnInit {

	gsts: any = [];
	addFlag: boolean = true;
	loading: boolean = false;
  constructor(private modalSvc: NzModalService, private gstService: GstService,private message: NzMessageService) { }

  ngOnInit() {
		this.getAllGst();
  }


	onModalCancel() {
		// this.ngOnInit();
			this.getAllGst();
			// console.log("hi")
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Gst",
			nzContent: GstAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
		//	nzOnCancel: ()=> this.onModalCancel,
			nzComponentParams: {

			},

			nzFooter: null
		});


	}

	onEdit(gst: Gst) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Gst",
			nzContent: GstEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {

					gstt: gst

			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);

	}

	public getAllGst(){
		this.gstService.getAllGst().subscribe(
				data => {
						this.gsts = data;
						// console.log("data")


				},
				error => {
					if(error['status']=='404'){
						this.addFlag = true;
						this.gsts = [];
					}
						else if(error.error){
							this.addFlag = false;
						this.gsts = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteGst(id: number){
		this.gstService.deleteGst(id).subscribe(
			data =>{
				this.message.create('success', `GST Deleted Successfully!`);
				this.getAllGst();
			},
			error=> {
				this.message.create('error', `GST Not Deleted!`);
				this.getAllGst();
			}
		);

	}
}
