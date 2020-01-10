import { AuthLvlEditModalComponent } from './components/auth-lvl-edit-modal/auth-lvl-edit-modal.component';
import { AuthLvlAddModalComponent } from './components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { AuthorizeLvlService } from 'src/app/core/services/Purchase/authorize-lvl.service';
import { AuthorizeLvl } from 'src/app/core/models/Purchase/authorizelvl';

@Component({
  selector: 'app-authorize-lvl',
  templateUrl: './authorize-lvl.component.html',
  styleUrls: ['./authorize-lvl.component.less']
})
export class AuthorizeLvlComponent implements OnInit {

	authLvls: any = [];
	loading: boolean = false;

	constructor(private modalSvc: NzModalService,
		private authLvlService: AuthorizeLvlService,
		private message: NzMessageService) { }



  ngOnInit() {

		this.getAllAuthLvl();

	}

	onModalCancel() {
		// this.ngOnInit();
			this.getAllAuthLvl();
			// console.log("hi")
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Authorize Level",
			nzContent: AuthLvlAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
		//	nzOnCancel: ()=> this.onModalCancel,
			nzComponentParams: {

			},

			nzFooter: null
		});


	}

	onEdit(authorizeLvl: AuthorizeLvl) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Authorize Level",
			nzContent: AuthLvlEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {

					authLvl: authorizeLvl

			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);

	}

	public getAllAuthLvl(){
		this.authLvlService.getAllAuthLvl().subscribe(
				data => {
						this.authLvls = data;
						// console.log("data")


				},
				error => {
					if(error['status']=='404'){
						this.authLvls = [];
					}
						else if(error.error){
						this.authLvls = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteAuthLvl(id: number){
		this.authLvlService.deleteAuthLvl(id).subscribe(
			data =>{
				this.message.create('success', `Authorize Level Deleted Successfully!`);
				this.getAllAuthLvl();
			},
			error=> {
				this.message.create('error', `Authorize Level Not Deleted!`);
				this.getAllAuthLvl();
			}
		);

	}

}
