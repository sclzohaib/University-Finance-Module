import { University } from './../../../core/models/Purchase/university';
import { UniversityService } from './../../../core/services/Purchase/university.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { UniAddModalComponent } from './components/uni-add-modal/uni-add-modal.component';
import { UniEditModalComponent } from './components/uni-edit-modal/uni-edit-modal.component';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.less']
})
export class UniversityComponent implements OnInit {

	universities: any = [];
	loading: boolean;
	constructor(private modalSvc: NzModalService, private uniService: UniversityService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllUniversity();
  }
  onModalCancel() {
		this.getAllUniversity();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add University",
			nzContent: UniAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(university: University) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit University",
			nzContent: UniEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				uni: university
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getAllUniversity(){
		this.uniService.getAllUniversity().subscribe(
				data => {
						this.universities = data;
						// console.log(data)


				},
				error => {
					// console.log(error);
					if(error['status']=='404'){
						this.universities = [];
					}
						else if(error.error){
						this.universities = error.error;
				}

					else{
						this.loading = true;
					}
						// console.log(this.universities);
				}
		);
	}

	public deleteUniversity(id: number){
		this.uniService.deleteUniversity(id).subscribe(
			data =>{
				this.message.create('success', `University Deleted Successfully!`);
				this.getAllUniversity();
			},
			error=> {
				this.message.create('error', `University Not Deleted!`);
				this.getAllUniversity();
			}
		);

	}
}
