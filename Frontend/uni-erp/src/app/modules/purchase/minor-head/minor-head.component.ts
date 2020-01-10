import { MinorHeadService } from './../../../core/services/Purchase/minor-head.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { MinorHeadAddModalComponent } from './components/minor-head-add-modal/minor-head-add-modal.component';
import { MinorHeadEditModalComponent } from './components/minor-head-edit-modal/minor-head-edit-modal.component';
import { MinorHead } from 'src/app/core/models/Purchase/minor-head';

@Component({
  selector: 'app-minor-head',
  templateUrl: './minor-head.component.html',
  styleUrls: ['./minor-head.component.less']
})
export class MinorHeadComponent implements OnInit {

	minorHeads: any = [];
	loading: boolean = false;
  constructor(private modalSvc: NzModalService,
		private minorHeadService: MinorHeadService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getMinorHeads();
  }
  onModalCancel() {
			this.getMinorHeads();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Minor Head",
			nzContent: MinorHeadAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(minorHead: MinorHead) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Minor Head",
			nzContent: MinorHeadEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				minorHd: minorHead
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getMinorHeads(){
		this.minorHeadService.getAllMinorHead().subscribe(
				data => {
						this.minorHeads = data;


				},
				error => {
					if(error['status']=='404'){
						this.minorHeads = [];
					}
						else if(error.error){
						this.minorHeads = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteMinorHead(id: number){
		this.minorHeadService.deleteMinorHead(id).subscribe(
			data =>{
				this.message.create('success', `Minor Head Deleted Successfully!`);
				this.getMinorHeads();
			},
			error=> {
				this.message.create('error', `Minor Head Not Deleted!`);
				this.getMinorHeads();
			}
		);

	}
}
